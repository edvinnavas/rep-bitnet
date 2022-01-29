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
    activo BIGINT NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_aplicacion PRIMARY KEY (id_aplicacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE control (
	id_control BIGINT NOT NULL,
	id_aplicacion BIGINT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    activo BIGINT NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_control PRIMARY KEY (id_control, id_aplicacion),
    CONSTRAINT fk_control_1 FOREIGN KEY (id_aplicacion) REFERENCES aplicacion (id_aplicacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE rol (
	id_rol BIGINT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    activo BIGINT NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_rol PRIMARY KEY (id_rol)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE rol_aplicacion_control (
    id_rol BIGINT NOT NULL,
    id_control BIGINT NOT NULL,
    id_aplicacion BIGINT NOT NULL,
    CONSTRAINT pk_rol_aplicacion_control PRIMARY KEY (id_rol, id_control, id_aplicacion),
    CONSTRAINT fk_rol_aplicacion_control_1 FOREIGN KEY (id_rol) REFERENCES rol (id_rol),
    CONSTRAINT fk_rol_aplicacion_control_2 FOREIGN KEY (id_control, id_aplicacion) REFERENCES control (id_control, id_aplicacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
--  SE LLENAN LAS TABLAS CON VALORES INICIALES DE CONFIGURACIÓN.                 *
-- *******************************************************************************
INSERT INTO aplicacion (id_aplicacion, nombre, activo, descripcion) VALUES (1, 'APLICACIONES', 1, 'Módulo para el registro de aplicaciones en el sistema.');
INSERT INTO aplicacion (id_aplicacion, nombre, activo, descripcion) VALUES (2, 'CONTROLES', 1, 'Módulo para el registro de aplicaciones en el sistema.');
INSERT INTO aplicacion (id_aplicacion, nombre, activo, descripcion) VALUES (3, 'ROLES', 1, 'Módulo para el registro de roles en el sistema.');
INSERT INTO aplicacion (id_aplicacion, nombre, activo, descripcion) VALUES (4, 'USUARIOS', 1, 'Módulo para el registro de usuarios en el sistema.');

INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (1, 4, 'btnAgregarUsuario', 1, 'Botón para llamar el formulario del registro de usuarios.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (2, 4, 'dblModificarUsuario', 1, 'Acción para llamar el formulario del registro de usuarios, modificar.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (3, 4, 'btnInactivarUsuario', 1, 'Botón cambiar estado inactivar usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (4, 4, 'btnActivarUsuario', 1, 'Botón cambiar estado activar usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (5, 4, 'txtNombreCompleto', 1, 'Campo para registrar el nombre completo del usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (6, 4, 'txtNombreUsuario', 1, 'Campo para registrar el alias usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (7, 4, 'pswConstrasenaUsuario', 1, 'Campo para el registro de la constraseña.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (8, 4, 'txtCorreoElectronico', 1, 'Campo para registrar el correo electrónico del usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (9, 4, 'areDescripcion', 1, 'Campo para registrar una descripción del usuario.');
INSERT INTO control (id_control, id_aplicacion, nombre, activo, descripcion) VALUES (10, 4, 'btnAceptarUsuario', 1, 'Botón guardar la información del usuario.');

INSERT INTO rol (id_rol, nombre, activo, descripcion) VALUES (1, 'ROL-ADMINISTRADOR', 1, 'Rol creado por el sistema para el usuario administrador.');

INSERT INTO rol_aplicacion_control (id_rol_aplicacion_control, id_rol, id_control, id_aplicacion) VALUES (1, 1, 1, 4);

INSERT INTO usuario (id_usuario, nombre_completo, nombre_usuario, contrasena, correo_electronico, activo, descripcion, id_rol) 
VALUES (1, 'ADMINISTRADOR.', 'admin', SHA2('@dm1n', 512), 'edvin.navas@gmail.com', 1, 'Usuario administrador de la aplicación con contraseña SHA-2.', 1);

COMMIT;
-- *******************************************************************************
--  CONSULTA DE TABLAS DEL ESQUEMA: db_lexcom_seguridad.                         *
-- *******************************************************************************
SELECT a.* FROM aplicacion a;
SELECT c.* FROM control c;
SELECT r.* FROM rol r;
SELECT rac.* FROM rol_aplicacion_control rac;
SELECT u.* FROM usuario u;

SELECT IFNULL(MAX(a.id_aplicacion), 0) + 1 MAXIMO FROM aplicacion a;
-- SELECT u.*
-- FROM usuario u
-- WHERE u.nombre_usuario='admin' AND TRIM(CONVERT(u.contrasena USING UTF8MB4)) = TRIM(SHA2('@dm1n', 512));

-- SELECT CONVERT(COMPRESS('Edfr@2021') USING utf8mb4) TEXTO_COMPRESS;
-- SELECT CONVERT(UNCOMPRESS(COMPRESS('Edfr@2021')) USING utf8mb4) TEXTO_COMPRESS;
