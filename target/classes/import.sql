INSERT INTO regiones(nombre) VALUES ('Sudamerica');
INSERT INTO regiones(nombre) VALUES ('Europa');
INSERT INTO regiones(nombre) VALUES ('Asia');
INSERT INTO regiones(nombre) VALUES ('África');
INSERT INTO regiones(nombre) VALUES ('Oceanía');
INSERT INTO regiones(nombre) VALUES ('América del Norte');
INSERT INTO regiones(nombre) VALUES ('América Central');

INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Alejandro', 'Sierro', 'a.sierro@gmail.com', '2023-06-16', 1);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Ewa', 'Wolak', 'e.wolak@gmail.com', '2023-06-16', 2);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Pepe', 'Camorro', 'p.camorro@gmail.com', '2023-06-16', 1);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Maria', 'Losada', 'm.losada@gmail.com', '2023-06-16', 3);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Eva', 'Martinez', 'eva.martinez@example.com', '2023-06-16', 1);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Lucas', 'Sanchez', 'lucas.sanchez@gmail.com', '2023-06-16', 2);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Sofia', 'Lopez', 'sofia.lopez@example.com', '2023-06-16', 1);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Diego', 'Gonzalez', 'diego.gonzalez@gmail.com', '2023-06-16', 4);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Valentina', 'Hernandez', 'valentina.hernandez@example.com', '2023-06-16', 1);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Mateo', 'Rodriguez', 'mateo.rodriguez@gmail.com', '2023-06-16', 5);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Isabella', 'Garcia', 'isabella.garcia@example.com', '2023-06-16', 1);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Liam', 'Perez', 'liam.perez@gmail.com', '2023-06-16', 2);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Mia', 'Torres', 'mia.torres@example.com', '2023-06-16', 3);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Sebastian', 'Flores', 'sebastian.flores@gmail.com', '2023-06-16', 4);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Camila', 'Rivera', 'camila.rivera@example.com', '2023-06-16', 2);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Daniel', 'Cruz', 'daniel.cruz@gmail.com', '2023-06-16', 1);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Valeria', 'Gomez', 'valeria.gomez@example.com', '2023-06-16', 3);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Benjamin', 'Ortega', 'benjamin.ortega@gmail.com', '2023-06-16', 5);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Emily', 'Jimenez', 'emily.jimenez@example.com', '2023-06-16', 1);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Lucas', 'Vargas', 'lucas.vargas@gmail.com', '2023-06-16', 2);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Victoria', 'Rojas', 'victoria.rojas@example.com', '2023-06-16', 1);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Matias', 'Mendoza', 'matias.mendoza@gmail.com', '2023-06-16', 4);
INSERT INTO clientes(nombre, apellido, email, create_at, region_id) VALUES('Emma', 'Silva', 'emma.silva@example.com', '2023-06-16', 2);

INSERT INTO usuarios(username, nombre, apellido, email, password, enabled) VALUES ('SuperUser', 'Alejandro', 'Sierro', 'a.sierro@gmail.com', '$2a$10$vFnQdBXeeWf24JatitN98OacYs1GGCeFHIVEbHg3BaCvTJhSGXknG', 1);
INSERT INTO usuarios(username, nombre, apellido, email, password, enabled) VALUES ('admin', 'Ewa', 'Wolak', 'e.wolak@gmail.com', '$2a$10$CoTFxtLRTNpj60Sn34i6YeNY0NG8MwpdRAZSmJJugjfTR0swXNyAG', 1);

INSERT INTO roles(nombre) VALUES ('ROLE_USER');
INSERT INTO roles(nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles(usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES (2, 1);

INSERT INTO productos(nombre, precio, create_at) VALUES ('Tercio Mahou', 3.50, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Cerveza Corona', 2.99, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Stella Artois', 4.25, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Heineken', 3.75, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Guinness Stout', 5.50, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Budweiser', 2.95, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Corona Extra', 3.25, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Pilsner Urquell', 4.50, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Becks', 3.80, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Samuel Adams', 4.75, NOW());

INSERT INTO facturas(descripcion, observacion, cliente_id, create_at) VALUES ('Factura terraza', null, 1, NOW());
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES(3, 1, 2);
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES(6, 1, 3);
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES(2, 1, 4);

INSERT INTO facturas(descripcion, observacion, cliente_id, create_at) VALUES ('Factura terraza', 'pesados', 1, NOW());

INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES(3, 2, 6);
