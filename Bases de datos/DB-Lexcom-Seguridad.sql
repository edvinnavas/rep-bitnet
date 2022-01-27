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
--  BORRAMOS TODAS LAS TABLAS DE LA BASE DE DATOS: db_lexcom_seguridad.          *
-- *******************************************************************************
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS rol_aplicacion_control;
DROP TABLE IF EXISTS rol;
DROP TABLE IF EXISTS control;
DROP TABLE IF EXISTS aplicacion;

-- *******************************************************************************
--  CREAMOS TODAS LAS TABLAS DEL ESQUEMA: db_lexcom_seguridad.                   *
-- *******************************************************************************
CREATE TABLE aplicacion (
	id_aplicacion BIGINT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_aplicacion PRIMARY KEY (id_aplicacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE control (
	id_control BIGINT NOT NULL,
	id_aplicacion BIGINT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_control PRIMARY KEY (id_control, id_aplicacion),
    CONSTRAINT fk_control_1 FOREIGN KEY (id_aplicacion) REFERENCES aplicacion (id_aplicacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE rol (
	id_rol BIGINT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_rol PRIMARY KEY (id_rol)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE rol_aplicacion_control (
	id_rol_aplicacion_control BIGINT NOT NULL,
    id_rol BIGINT NOT NULL,
    id_control BIGINT NOT NULL,
    id_aplicacion BIGINT NOT NULL,
    CONSTRAINT pk_rol_aplicacion_control PRIMARY KEY (id_rol_aplicacion_control),
    CONSTRAINT fk_rol_aplicacion_control_1 FOREIGN KEY (id_rol) REFERENCES rol (id_rol),
    CONSTRAINT fk_rol_aplicacion_control_2 FOREIGN KEY (id_control, id_aplicacion) REFERENCES control (id_control, id_aplicacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE usuario (
	id_usuario BIGINT NOT NULL,
    nombre_completo VARCHAR(500) NOT NULL,
    nombre_usuario VARCHAR(50) NOT NULL,
    contrasena BINARY(255) NOT NULL,
    correo_electronico VARCHAR(200),
    descripcion TEXT,
    id_rol BIGINT NOT NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id_usuario),
    CONSTRAINT fk_usuario_1 FOREIGN KEY (id_rol) REFERENCES rol (id_rol)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- *******************************************************************************
--  SE LLENAN LAS TABLAS CON VALORES INICIALES DE CONFIGURACIÓN.                 *
-- *******************************************************************************
INSERT INTO aplicacion (id_aplicacion, nombre, descripcion) VALUES (1, 'USUARIOS', 'Módulo para el registro de usuarios de la aplicación.');
INSERT INTO aplicacion (id_aplicacion, nombre, descripcion) VALUES (2, 'ROLES', 'Módulo para el registro de roles de la aplicación.');

INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (1, 1, 'menuUsuario', 'Opcion de menu.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (2, 1, 'btnAgregarUsuario', 'Botón para llamar el formulario del registro de usuarios.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (3, 1, 'dblModificarUsuario', 'Acción para llamar el formulario del registro de usuarios, modificar.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (4, 1, 'btnInactivarUsuario', 'Botón cambiar estado inactivar usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (5, 1, 'btnActivarUsuario', 'Botón cambiar estado activar usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (6, 1, 'txtNombreCompleto', 'Campo para registrar el nombre completo del usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (7, 1, 'txtNombreUsuario', 'Campo para registrar el alias usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (8, 1, 'pswConstrasenaUsuario', 'Campo para el registro de la constraseña.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (9, 1, 'txtCorreoElectronico', 'Campo para registrar el correo electrónico del usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (10, 1, 'areDescripcion', 'Campo para registrar una descripción del usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (11, 1, 'btnAceptarUsuario', 'Botón guardar la información del usuario.');

INSERT INTO rol (id_rol, nombre, descripcion) VALUES (1, 'ROL-ADMINISTRADOR', 'Rol creado por el sistema para el usuario administrador.');

INSERT INTO rol_aplicacion_control (id_rol_aplicacion_control, id_rol, id_control, id_aplicacion) VALUES (1, 1, 1, 1);

INSERT INTO usuario (id_usuario, nombre_completo, nombre_usuario, contrasena, correo_electronico, descripcion, id_rol) 
VALUES (1, 'ADMINISTRADOR.', 'admin', SHA2('@dm1n', 512), 'edvin.navas@gmail.com', 'Usuario administrador de la aplicación con contraseña SHA-2.', 1);

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
