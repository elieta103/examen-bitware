--DROP schema if exists bitware;

--create schema bitware authorization postgres;

drop sequence if exists bitware.productos_id_pk_seq;

CREATE SEQUENCE bitware.productos_id_pk_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

drop sequence if exists bitware.cajeros_id_pk_seq;

CREATE SEQUENCE bitware.cajeros_id_pk_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

drop sequence if exists bitware.ventas_id_pk_seq;

CREATE SEQUENCE bitware.ventas_id_pk_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

drop sequence if exists bitware.maquinas_registradoras_id_pk_seq;

CREATE SEQUENCE bitware.maquinas_registradoras_id_pk_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

drop table if exists bitware.productos;

CREATE TABLE bitware.productos (
	producto_id_pk serial not NULL,
	nombre varchar(50) NOT NULL,
	precio money NOT NULL,
	CONSTRAINT producto_pk PRIMARY KEY (producto_id_pk));

DROP table if exists bitware.cajeros;

CREATE TABLE bitware.cajeros (
	cajero_id_pk serial NOT NULL,
	nomApels varchar(50) NOT NULL,
	CONSTRAINT cajero_pk PRIMARY KEY (cajero_id_pk));

DROP table if exists bitware.maquinas_registradoras;

CREATE TABLE bitware.maquinas_registradoras (
	maquina_registradora_id_pk serial NOT NULL,
	piso int4 NOT NULL,
	CONSTRAINT maquina_registradora_pk PRIMARY KEY (maquina_registradora_id_pk));

DROP table if exists bitware.ventas;

CREATE TABLE bitware.ventas (
	venta_id_pk serial NOT NULL,
	maquina_registradora_id_fk int4 NOT NULL,
	cajero_id_fk int4 NOT NULL,
	producto_id_fk int4 NOT NULL,
	CONSTRAINT venta_pk PRIMARY KEY (venta_id_pk),
	CONSTRAINT uk_maquina_id_fk FOREIGN KEY (maquina_registradora_id_fk) REFERENCES bitware.maquinas_registradoras(maquina_registradora_id_pk),
	CONSTRAINT uk_cajero_id_fk FOREIGN KEY (cajero_id_fk) REFERENCES bitware.cajeros(cajero_id_pk),
	CONSTRAINT uk_producto_id_fk FOREIGN KEY (producto_id_fk) REFERENCES bitware.productos(producto_id_pk));


INSERT INTO bitware.productos(nombre, precio)VALUES('Laptop Asus', '15000.00');
INSERT INTO bitware.productos(nombre, precio)VALUES('IPhone 5G', '17000.00');
INSERT INTO bitware.productos(nombre, precio)VALUES('Smart watch', '7000.00');
INSERT INTO bitware.productos(nombre, precio)VALUES('Estufa IEM', '10000.00');
INSERT INTO bitware.productos(nombre, precio)VALUES('Refrigerador Whirpool', '20000.00');
INSERT INTO bitware.productos(nombre, precio)VALUES('Horno eléctrico', '10000.00');
INSERT INTO bitware.productos(nombre, precio)VALUES('Set Herramientas de corte', '2000.00');
INSERT INTO bitware.productos(nombre, precio)VALUES('Sierra de banco', '9000.00');
INSERT INTO bitware.productos(nombre, precio)VALUES('Taladro de 1/2', '5000.00');
INSERT INTO bitware.productos(nombre, precio)VALUES('Perfume Carolina Herrera', '2500.00');
INSERT INTO bitware.productos(nombre, precio)VALUES('Tratamiento Facial Lancome', '3000.00');
INSERT INTO bitware.productos(nombre, precio)VALUES('Maquillaje MAC', '900.00');


INSERT INTO bitware.cajeros(nomapels)VALUES('Cajero de depto. de electronica');
INSERT INTO bitware.cajeros(nomapels)VALUES('Cajero de depto. de linea blanca');
INSERT INTO bitware.cajeros(nomapels)VALUES('Cajero de depto. de herramientas');
INSERT INTO bitware.cajeros(nomapels)VALUES('Cajero de depto. de perfumeria');

INSERT INTO bitware.maquinas_registradoras(piso)VALUES(1);
INSERT INTO bitware.maquinas_registradoras(piso)VALUES(2);
INSERT INTO bitware.maquinas_registradoras(piso)VALUES(3);
INSERT INTO bitware.maquinas_registradoras(piso)VALUES(4);


INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(1, 1, 1);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(1, 1, 2);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(1, 1, 2);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(1, 1, 3);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(2, 2, 4);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(2, 2, 4);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(2, 2, 5);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(2, 2, 6);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(2, 2, 6);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(3, 3, 7);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(3, 3, 8);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(3, 3, 8);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(3, 3, 9);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(4, 4, 10);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(4, 4, 10);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(4, 4, 11);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(4, 4, 12);
INSERT INTO bitware.ventas(maquina_registradora_id_fk, cajero_id_fk, producto_id_fk)VALUES(4, 4, 12);
