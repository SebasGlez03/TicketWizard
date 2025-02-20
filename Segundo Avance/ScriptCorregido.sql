
create database Ticketwizard;
use Ticketwizard;

create table dirreciones(
	codigoDireccion int auto_increment primary key,
    calle varchar(40) not null,
    colonia varchar(80) not null,
    numero varchar (6) not null
);

create table personas(
	codigoPersona int auto_increment primary key,
    nombre varchar(30) not null,
	apellidoMaterno varchar(30) not null,
    apellidoPaterno  varchar(30) not null,
    nombreCompleto varchar(90) generated always as(concat(nombre, " ", apellidoPaterno, " ", apellidoMaterno)) stored not null,
    correoElectronico varchar(100) not null,
    saldo decimal(10, 2) not null,
    fechaNacimiento date not null,
    edad int not null,
    codigoDireccion int not null,
    foreign key(codigoDireccion) references dirreciones(codigoDireccion)
	
);

create table recintos(
	codigoRecinto int auto_increment primary key ,
    nombre varchar(50) not null,
    estado varchar(50) not null,
    ciudad varchar(50) not null,
    cantidadAsientos int not null
);

create table eventos(
	codigoEvento int auto_increment primary key,
    nombre varchar(50) not null,
    descripcion varchar(200) not null,
    fechaHora datetime not null,
    codigoRecinto int not null,
    foreign key (codigoRecinto) references recintos(codigoRecinto) 
);

create table boletos(
	codigoBoleto int auto_increment primary key,
    fila varchar(4) not null,
    asiento varchar(8) not null,
    numeroInterno varchar(50) not null,
    codigoUsuario int not null,
    numeroSerie varchar(8),
    foreign key(codigoUsuario) references personas(codigoPersona)
);

create table transaciones(
	codigoTransaccion int auto_increment primary key,
    fechaHora datetime not null,
    tipoAdquision enum ("Venta","Reventa") not null,
    costo decimal(10,2) not null,
    codigoComprador int not null,
    foreign key(codigoComprador) references personas(codigoPersona)
);

create table compras(
	codigoCompra int auto_increment primary key,
    codigoBoleto int not null,
    codigoTransaccion int not null,
    codigoVendedor int not null,
    costo decimal(10,2) not null,
    foreign key(codigoVendedor) references personas(codigoPersona),
    foreign key(codigoTransaccion) references transaciones(codigoTransaccion),
    foreign key(CodigoBoleto) references boletos(codigoBoleto)
)

