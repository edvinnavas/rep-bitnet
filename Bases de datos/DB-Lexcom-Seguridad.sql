-- CREATE USER 'user_db_bitnet'@'localhost' IDENTIFIED BY 'p$41!jWaqt0Q';
-- GRANT ALL PRIVILEGES ON db_lexcom_seguridad.* TO 'user_db_bitnet'@'localhost';
-- FLUSH PRIVILEGES;
-- *******************************************************************************
--  CREAMOS LA BASE DE DATOS: db_lexcom_seguridad.                               *
--  INDICAMOS A MYSQL QUE UTILIZAREMOS LA BASE DE DATOS: db_lexcom_seguridad.    *
-- *******************************************************************************
DROP DATABASE IF EXISTS db_lexcom_seguridad;
CREATE DATABASE db_lexcom_seguridad CHARACTER SET utf8mb4;

USE db_lexcom_seguridad;
-- *******************************************************************************
--  CREAMOS TODAS LAS TABLAS DEL ESQUEMA: db_lexcom_seguridad.                   *
-- *******************************************************************************
DROP TABLE IF EXISTS aplicacion;
CREATE TABLE aplicacion (
	id_aplicacion BIGINT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    activo BIGINT NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_aplicacion PRIMARY KEY (id_aplicacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS control;
CREATE TABLE control (
	id_control BIGINT NOT NULL,
	id_aplicacion BIGINT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    activo BIGINT NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_control PRIMARY KEY (id_control, id_aplicacion),
    CONSTRAINT fk_control_1 FOREIGN KEY (id_aplicacion) REFERENCES aplicacion (id_aplicacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS rol;
CREATE TABLE rol (
	id_rol BIGINT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    activo BIGINT NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_rol PRIMARY KEY (id_rol)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS rol_aplicacion_control;
CREATE TABLE rol_aplicacion_control (
    id_rol BIGINT NOT NULL,
    id_control BIGINT NOT NULL,
    id_aplicacion BIGINT NOT NULL,
    CONSTRAINT pk_rol_aplicacion_control PRIMARY KEY (id_rol, id_control, id_aplicacion),
    CONSTRAINT fk_rol_aplicacion_control_1 FOREIGN KEY (id_rol) REFERENCES rol (id_rol),
    CONSTRAINT fk_rol_aplicacion_control_2 FOREIGN KEY (id_control, id_aplicacion) REFERENCES control (id_control, id_aplicacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario (
	id_usuario BIGINT NOT NULL,
    nombre_completo VARCHAR(500) NOT NULL,
    nombre_usuario VARCHAR(50) NOT NULL,
    contrasena BINARY(255) NOT NULL,
    correo_electronico VARCHAR(200),
    activo BIGINT NOT NULL,
    descripcion TEXT,
    id_rol BIGINT NOT NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id_usuario),
    CONSTRAINT fk_usuario_1 FOREIGN KEY (id_rol) REFERENCES rol (id_rol)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- *******************************************************************************
--  SE LLENAN LAS TABLAS CON VALORES INICIALES DE CONFIGURACI??N.                 *
-- *******************************************************************************
INSERT INTO aplicacion (id_aplicacion, nombre, activo, descripcion) VALUES (1, 'APLICACIONES', 1, 'M??dulo para el registro de aplicaciones en el sistema.');
INSERT INTO aplicacion (id_aplicacion, nombre, activo, descripcion) VALUES (2, 'CONTROLES', 1, 'M??dulo para el registro de controles en el sistema.');
INSERT INTO aplicacion (id_aplicacion, nombre, activo, descripcion) VALUES (3, 'ROLES', 1, 'M??dulo para el registro de roles en el sistema.');
INSERT INTO aplicacion (id_aplicacion, nombre, activo, descripcion) VALUES (4, 'USUARIOS', 1, 'M??dulo para el registro de usuarios en el sistema.');
INSERT INTO aplicacion (id_aplicacion, nombre, activo, descripcion) VALUES (5, 'USUARIOS-PERMISOS', 1, 'M??dulo para asignar permisos a los usuarios.');

INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (1, 4, 'btnAgregarUsuario', 1, 'Bot??n para llamar el formulario del registro de usuarios.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (2, 4, 'dblModificarUsuario', 1, 'Acci??n para llamar el formulario del registro de usuarios, modificar.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (3, 4, 'btnInactivarUsuario', 1, 'Bot??n cambiar estado inactivar usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (4, 4, 'btnActivarUsuario', 1, 'Bot??n cambiar estado activar usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (5, 4, 'txtNombreCompleto', 1, 'Campo para registrar el nombre completo del usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (6, 4, 'txtNombreUsuario', 1, 'Campo para registrar el alias usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (7, 4, 'pswConstrasenaUsuario', 1, 'Campo para el registro de la constrase??a.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (8, 4, 'txtCorreoElectronico', 1, 'Campo para registrar el correo electr??nico del usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (9, 4, 'cbxActivo', 1, 'CheckBox para indicar si el usuario esta activo.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (10, 4, 'areDescripcion', 1, 'Caja de texto para registrar una descripci??n del usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (11, 4, 'btnAceptarUsuario', 1, 'Bot??n guardar la informaci??n del usuario.');

INSERT INTO rol (id_rol, nombre, activo, descripcion) VALUES (1, 'ROL-ADMINISTRADOR', 1, 'Rol creado por el sistema para usuarios administrativos.');
INSERT INTO rol (id_rol, nombre, activo, descripcion) VALUES (2, 'ROL-OPERATIVO', 1, 'Rol creado por el sistema para usuarios operativos.');

INSERT INTO rol_aplicacion_control (id_rol, id_control, id_aplicacion) VALUES (1, 1, 4);
INSERT INTO rol_aplicacion_control (id_rol, id_control, id_aplicacion) VALUES (1, 2, 4);
INSERT INTO rol_aplicacion_control (id_rol, id_control, id_aplicacion) VALUES (1, 3, 4);
INSERT INTO rol_aplicacion_control (id_rol, id_control, id_aplicacion) VALUES (1, 4, 4);
INSERT INTO rol_aplicacion_control (id_rol, id_control, id_aplicacion) VALUES (1, 5, 4);
INSERT INTO rol_aplicacion_control (id_rol, id_control, id_aplicacion) VALUES (1, 6, 4);
INSERT INTO rol_aplicacion_control (id_rol, id_control, id_aplicacion) VALUES (1, 7, 4);
INSERT INTO rol_aplicacion_control (id_rol, id_control, id_aplicacion) VALUES (1, 8, 4);
INSERT INTO rol_aplicacion_control (id_rol, id_control, id_aplicacion) VALUES (1, 9, 4);
INSERT INTO rol_aplicacion_control (id_rol, id_control, id_aplicacion) VALUES (1, 10, 4);
INSERT INTO rol_aplicacion_control (id_rol, id_control, id_aplicacion) VALUES (1, 11, 4);

INSERT INTO usuario (id_usuario, nombre_completo, nombre_usuario, contrasena, correo_electronico, activo, descripcion, id_rol) 
VALUES (1, 'ADMINISTRADOR.', 'admin', SHA2('@dm1n', 512), 'edvin.navas@gmail.com', 1, 'Usuario administrador de la aplicaci??n con contrase??a SHA-2.', 1);
INSERT INTO usuario (id_usuario, nombre_completo, nombre_usuario, contrasena, correo_electronico, activo, descripcion, id_rol) 
VALUES (2, 'OPERATIVO.', 'operativo', SHA2('@dm1n', 512), 'edvin.navas@gmail.com', 1, 'Usuario operativo de la aplicaci??n con contrase??a SHA-2.', 2);
COMMIT;
-- *******************************************************************************
--  CONSULTA DE TABLAS DEL ESQUEMA: db_lexcom_seguridad.                         *
-- *******************************************************************************
SELECT a.* FROM aplicacion a;
SELECT c.* FROM control c;
SELECT r.* FROM rol r;
SELECT rac.* FROM rol_aplicacion_control rac;
SELECT u.* FROM usuario u;

-- SELECT u.*
-- FROM usuario u
-- WHERE u.nombre_usuario='admin' AND TRIM(CONVERT(u.contrasena USING UTF8MB4)) = TRIM(SHA2('@dm1n', 512));

-- SELECT CONVERT(COMPRESS('Edfr@2021') USING utf8mb4) TEXTO_COMPRESS;
-- SELECT CONVERT(UNCOMPRESS(COMPRESS('Edfr@2021')) USING utf8mb4) TEXTO_COMPRESS;

SELECT 
	u.id_usuario, 
    u.nombre_completo,
    u.nombre_usuario, 
    '-' contrasena, 
    u.correo_electronico, 
    u.activo, 
    u.descripcion, 
    r.id_rol,
    r.nombre,
    r.activo,
    r.descripcion,
    rac.id_rol,
    c.id_control,
    c.nombre,
    c.activo,
    c.descripcion,
    a.id_aplicacion,
    a.nombre,
    a.activo,
    a.descripcion
FROM 
	usuario u
    LEFT JOIN rol r ON (u.id_rol=r.id_rol)
    LEFT JOIN rol_aplicacion_control rac ON (r.id_rol=rac.id_rol)
    LEFT JOIN control c ON (rac.id_control=c.id_control AND rac.id_aplicacion=c.id_aplicacion)
    LEFT JOIN aplicacion a ON (c.id_aplicacion=a.id_aplicacion);
