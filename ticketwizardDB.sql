drop database ticketwizard;
create database Ticketwizard;
use Ticketwizard;

create table personas(
	codigoPersona int auto_increment primary key,
    nombre varchar(30) not null,
	apellidoMaterno varchar(30) not null,
    apellidoPaterno  varchar(30) not null,
    nombreCompleto varchar(90) generated always as(concat(nombre, " ", apellidoPaterno, " ", apellidoMaterno)) stored not null,
    calle varchar(40) not null,
    colonia varchar(80) not null,
    numero varchar (6) not null,
    direccion varchar(126)  generated always as(concat(calle, " ", colonia, " ", numero)) stored not null,
    contrasenia varchar(64) not null,
    correoElectronico varchar(100) not null unique,
    saldo decimal(10, 2) not null default 0.00,
    fechaNacimiento date not null,
    edad int not null 	
);

create table eventos(
	codigoEvento int auto_increment primary key,
    nombre varchar(50) not null,
    descripcion varchar(200) not null,
    fechaHora datetime not null,
     estado varchar(50) not null,
    ciudad varchar(50) not null,
    cantidadAsientos int not null
);

create table boletos(
	codigoBoleto int auto_increment primary key,
    fila varchar(4) not null,
    asiento varchar(8) not null,
    numeroInterno varchar(50) not null,
    codigoUsuario int not null,
    codigoEvento int not null,
    numeroSerie varchar(8),
    costoOriginal decimal(10,2) not null,
    costo decimal(10,2) not null,
    estado enum("En espera", "En venta","Con dueño") not null,
    foreign key(codigoEvento) references eventos(codigoEvento),
    foreign key(codigoUsuario) references personas(codigoPersona)
);

create table transaciones(
	codigoTransaccion int auto_increment primary key,
    fechaHora datetime not null,
    tipoAdquision enum ("Venta","Reventa") not null,
    costo decimal(10,2) not null,
    codigoComprador int not null,
    codigoBoleto int not null,
    codigoVendedor int not null,
    foreign key(codigoVendedor) references personas(codigoPersona),
    foreign key(CodigoBoleto) references boletos(codigoBoleto),
    foreign key(codigoComprador) references personas(codigoPersona)
);

create table historial(
	codigoHistorial int auto_increment primary key,
	fechaHora datetime not null,
	accion enum("Compra", "Venta"),
    codigoBoleto int not null,
    codigoUsuario int not null,
    foreign key(codigoUsuario) references personas(codigoPersona),
    foreign key(CodigoBoleto) references boletos(codigoBoleto)
);

Delimiter // 
create trigger Ins_edad
before insert on personas
for each row 
begin 
	SET NEW.edad = TIMESTAMPDIFF(YEAR, NEW.FechaNacimiento, NOW());
end;
//

Delimiter // 
create trigger Up_edad 
before update on personas
for each row 
begin 
	SET NEW.edad = TIMESTAMPDIFF(YEAR, NEW.FechaNacimiento, NOW());
end;
//

Delimiter // 
create trigger Ins_numSerie
before insert on boletos
for each row 
begin 
	SET NEW.numeroSerie = 
    (select concat(subString(ps.nombre,1,2),subString(ps.apellidoPaterno,1,1),subString(ps.apellidoMaterno,1,1)
					,day(ps.fechaNacimiento), (day(ps.fechaNacimiento)*2 + 10)
    )
    from personas as ps 
    where ps.codigoPersona =  new.codigoUsuario limit 1) ;
end;
//

Delimiter // 
create trigger Up_numSerie
before update on boletos
for each row 
begin 
	SET NEW.numeroSerie = 
    (select concat(subString(ps.nombre,1,2),subString(ps.apellidoPaterno,1,1),subString(ps.apellidoMaterno,1,1)
					,day(ps.fechaNacimiento), (day(ps.fechaNacimiento)*2 + 10)
    )
    from personas as ps 
    where ps.codigoPersona =  new.codigoUsuario limit 1) ;
end;
//

Delimiter // 
create trigger Ins_Compra
after insert on transaciones
for each row 
begin 
	insert into historial(fechaHora, accion, codigoBoleto, codigoUsuario)
    values(now(), "Compra", new.codigoBoleto, new.codigoComprador);
end;
//

delimiter // 
create procedure ComprarBoletos(
in id_usuario int, in id_boleto int)
begin
 	Set @PrecioBoleto = (select costo from boletos where codigoBoleto = id_boleto limit 1);
    Set @CodigoVendedor = (select codigoUsuario from boletos where codigoBoleto = id_boleto limit 1);
    start transaction;
    if @CodigoVendedor = 1 then
		update personas 
		set saldo = saldo - @PrecioBoleto
		where codigoPersona = id_usuario and  saldo>= @PrecioBoleto;
		
		update personas set saldo = saldo + @PrecioBoleto
		where codigoPersona = 1;
		
		update boletos set codigoUsuario = id_usuario
		where codigoBoleto = id_boleto;
		
		update boletos set estado = "Con dueño"
		where codigoBoleto = id_boleto;
		
		 insert into transaciones(fechaHora,tipoAdquision,costo,codigoComprador,codigoBoleto,codigoVendedor)
		 values(now(), "Venta", @PrecioBoleto,id_usuario,id_boleto,1);
     else 
		update personas 
		set saldo = saldo - @PrecioBoleto
		where codigoPersona = id_usuario and  saldo>= @PrecioBoleto;
		
		update personas set saldo = saldo + @PrecioBoleto
		where codigoPersona = @CodigoVendedor;
		
		update boletos set codigoUsuario = id_usuario
		where codigoBoleto = id_boleto;
		
		update boletos set estado = "Con dueño"
		where codigoBoleto = id_boleto;
		
		 insert into transaciones(fechaHora,tipoAdquision,costo,codigoComprador,codigoBoleto,codigoVendedor)
		 values(now(), "ReVenta", @PrecioBoleto,id_usuario,id_boleto,@CodigoVendedor);
    end if;
    commit;
end;
//
Delimiter ;

Delimiter // 
create procedure venderBoleto(
in id_boleto int, in precioBoleto  decimal(10,2)
)
begin 
	update boletos set estado = "En venta"
		where codigoBoleto = id_boleto;
	update boletos set costo = precioBoleto
		where codigoBoleto = id_boleto;
	insert into historial(fechaHora, accion, codigoBoleto, codigoUsuario)
    values(now(), "Venta", id_boleto,(select codigoUsuario from boletos where codigoBoleto = id_boleto limit 1));
end;
//

Delimiter // 
create procedure AgregarSaldo(
in id_usuario int, in saldoAgregado  decimal(10,2)
)
begin 
	update personas set saldo = saldo + saldoAgredado
		where codigoPersona = id_usuario;
end;
//

Delimiter // 
create procedure Consulta_boleto_transferencia(
in id_evento int, in id_Usuario int
)
begin 
	Select 
    bl.codigoBoleto, bl.fila, bl.asiento, bl.numeroInterno, costoOriginal, bl.estado,
	tr.codigoTransaccion,tr.fechaHora, tr.tipoAdquision 
    from boletos as bl 
	inner join transaciones as tr
	on bl.codigoBoleto = tr.codigoBoleto
	where (bl.codigoEvento = id_evento) and (bl.codigoUsuario = id_Usuario);
end;
//
	
insert into personas(nombre, apellidoPaterno, apellidoMaterno, calle, colonia, numero,correoElectronico, contrasenia,saldo, fechaNacimiento) 
values("Admin", "TicketWizard", "Boletera", "No releccion", "Las haciendas", "25390","TicketWizard_Admin@hotmail.com", "eaac3c5f810b358c1a4085d83bf929cf96b59f5ea0ee11e5c5f7d149f4f99d88", 134000.23, "2002-08-19"),
("Enrique", "Gonzales", "Lopez", "miguel aleman", "centro", "2513","Enrique_lo@hotmail.com", "0a2246d9487e4cf1f4f28642f4dd12b80ababedbc0c4923162e0bb8897d796ee", 20350.30, "2002-08-19"),
("Alberto", "beltran", "marquez","monte mayor", "casa blanca", "3540", "Alberto.beltr05@hotmail.com", "6bdb60a9068256f04b890480273007ed674cfaf95afaa5150d551b9355a5488a", 14000.0, "1998-03-08"),
("Carlos", "Gomez", "Perez", "Avenida Libertad", "El Bosque", "2094", "carlos.gomez89@hotmail.com", "dc09e27955826b5d39f68b02fa34c42289ae37cdb05d3b1f8d1b5469b0835e1a", 21500.0, "1995-07-21"),
("Maria", "Lopez", "Martinez", "Calle Real", "Santa Teresa", "5823", "maria.lopez90@gmail.com", "7aced22db86019426e3573bc796310e107a88277299038df9f4cf83941a5adaa", 32000.0, "1990-12-11"),
("Juan", "Rodriguez", "Sanchez", "Calle 16", "Lomas Verdes", "1342", "juan.rodriguez76@yahoo.com", "422e414e04099d79820bb52b8aee1b79e884386ee70a304d63a7ad6b691b4600", 12800.0, "1997-09-03");

insert into eventos(nombre, descripcion, fechaHora, estado, ciudad, cantidadAsientos) 
values("romeo y julieta", "obra de teatro del aclamado shekspear", "2025-05-13", "Sonora" , "Ciudad Obregon", 230),
("The Lion King", "El musical de Broadway basado en la película de Disney", "2025-09-15", "Sonora", "Hermosillo", 600),
("Coldplay", "Concierto de la banda británica Coldplay en su gira mundial", "2025-11-20", "Sonora", "San Luis Río Colorado", 10000);

insert into boletos(fila,asiento,numeroInterno,codigoUsuario,codigoEvento,estado,costoOriginal, costo)
values("4B", 13 , "4b13D", 1, 1, "En venta", 110.00, 110.00)
,("9A", 5 , "9a05g", 1, 1, "En venta" , 110.00, 110.00),
("4G", 12 , "4g12d", 1, 1, "En venta", 110.00, 110.00),
("5C", 14, "5c14E", 1, 1, "En venta", 110.00, 110.00),
("6D", 15, "6d15F", 1, 1, "En venta", 110.00, 110.00),
("7E", 16, "7e16G", 1, 1, "En venta", 110.00, 110.00),
("8F", 17, "8f17H", 1, 1, "En venta", 110.00, 110.00),
("9G", 18, "9g18I", 1, 1, "En venta", 110.00, 110.00),
("10H", 19, "10h19J", 1, 1, "En venta", 110.00, 110.00),
("11I", 20, "11i20K", 1, 1, "En venta", 110.00, 110.00),

("5C", 14, "5c14E", 1, 1, "En venta", 110.00, 110.00),
("6D", 15, "6d15F", 1, 1, "En venta", 110.00, 110.00),
("7E", 16, "7e16G", 1, 1, "En venta", 110.00, 110.00),
("8F", 17, "8f17H", 1, 1, "En venta", 110.00, 110.00),
("9G", 18, "9g18I", 1, 1, "En venta", 110.00, 110.00),
("10H", 19, "10h19J", 1, 1, "En venta", 110.00, 110.00),
("11I", 20, "11i20K", 1, 1, "En venta", 110.00, 110.00),
("12J", 21, "12j21L", 1, 1, "En venta", 110.00, 110.00),
("13K", 22, "13k22M", 1, 1, "En venta", 110.00, 110.00),
("14L", 23, "14l23N", 1, 1, "En venta", 110.00, 110.00),

("3F", 21 , "3f21a", 1, 2, "En venta", 150.00, 150.00),
("5C", 12 , "5c12b", 1, 2, "En venta", 150.00, 150.00),
("8B", 7 , "8b07c", 1, 2, "En venta" , 150.00, 150.00),
("4G", 22, "4g22b", 1, 2, "En venta", 150.00, 150.00),
("5H", 23, "5h23c", 1, 2, "En venta", 150.00, 150.00),
("6I", 24, "6i24d", 1, 2, "En venta", 150.00, 150.00),
("7J", 25, "7j25e", 1, 2, "En venta", 150.00, 150.00),
("8K", 26, "8k26f", 1, 2, "En venta", 150.00, 150.00),
("9L", 27, "9l27g", 1, 2, "En venta", 150.00, 150.00),
("10M", 28, "10m28h", 1, 2, "En venta", 150.00, 150.00),

("4H", 11, "4h11i", 1, 2, "En venta", 150.00, 150.00),
("5I", 12, "5i12j", 1, 2, "En venta", 150.00, 150.00),
("6J", 13, "6j13k", 1, 2, "En venta", 150.00, 150.00),
("7K", 14, "7k14l", 1, 2, "En venta", 150.00, 150.00),
("8L", 15, "8l15m", 1, 2, "En venta", 150.00, 150.00),
("9M", 16, "9m16n", 1, 2, "En venta", 150.00, 150.00),
("10N", 17, "10n17o", 1, 2, "En venta", 150.00, 150.00),
("11O", 18, "11o18p", 1, 2, "En venta", 150.00, 150.00),
("12P", 19, "12p19q", 1, 2, "En venta", 150.00, 150.00),
("13Q", 20, "13q20r", 1, 2, "En venta", 150.00, 150.00),

("1A", 1, "1a1b", 1, 3, "En venta", 250.00, 250.00),
("1B", 2, "1b2c", 1, 3, "En venta", 250.00, 250.00),
("1C", 3, "1c3d", 1, 3, "En venta", 250.00, 250.00),
("1D", 4, "1d4e", 1, 3, "En venta", 250.00, 250.00),
("1E", 5, "1e5f", 1, 3, "En venta", 250.00, 250.00),
("1F", 6, "1f6g", 1, 3, "En venta", 250.00, 250.00),
("1G", 7, "1g7h", 1, 3, "En venta", 250.00, 250.00),
("1H", 8, "1h8i", 1, 3, "En venta", 250.00, 250.00),
("1I", 9, "1i9j", 1, 3, "En venta", 250.00, 250.00),
("1J", 10, "1j10k", 1, 3, "En venta", 250.00, 250.00),

("2B", 11, "2b11c", 1, 3, "En venta", 250.00, 250.00),
("2C", 12, "2c12d", 1, 3, "En venta", 250.00, 250.00),
("2D", 13, "2d13e", 1, 3, "En venta", 250.00, 250.00),
("2E", 14, "2e14f", 1, 3, "En venta", 250.00, 250.00),
("2F", 15, "2f15g", 1, 3, "En venta", 250.00, 250.00),
("2G", 16, "2g16h", 1, 3, "En venta", 250.00, 250.00),
("2H", 17, "2h17i", 1, 3, "En venta", 250.00, 250.00),
("2I", 18, "2i18j", 1, 3, "En venta", 250.00, 250.00),
("2J", 19, "2j19k", 1, 3, "En venta", 250.00, 250.00),
("2K", 20, "2k20l", 1, 3, "En venta", 250.00, 250.00);

call ComprarBoletos(2, 11);
call ComprarBoletos(2, 12);
call ComprarBoletos(2, 31);
call ComprarBoletos(2, 32);
call ComprarBoletos(2, 51);
call ComprarBoletos(2, 52);

call ComprarBoletos(3, 13);
call ComprarBoletos(3, 14);
call ComprarBoletos(3, 33);
call ComprarBoletos(3, 34);
call ComprarBoletos(3, 53);
call ComprarBoletos(3, 54);

call ComprarBoletos(4, 15);
call ComprarBoletos(4, 16);
call ComprarBoletos(4, 35);
call ComprarBoletos(4, 36);
call ComprarBoletos(4, 55);
call ComprarBoletos(4, 56);

call ComprarBoletos(5, 17);
call ComprarBoletos(5, 18);
call ComprarBoletos(5, 37);
call ComprarBoletos(5, 38);
call ComprarBoletos(5, 57);
call ComprarBoletos(5, 58);

call ComprarBoletos(6, 19);
call ComprarBoletos(6, 20);
call ComprarBoletos(6, 39);
call ComprarBoletos(6, 40);
call ComprarBoletos(6, 59);
call ComprarBoletos(6, 60);

