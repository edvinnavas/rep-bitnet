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
INSERT INTO aplicacion (id_aplicacion, nombre, descripcion) VALUES (1, 'DATOS-GENERALES', 'Aplicación creado por el sistema.');
INSERT INTO aplicacion (id_aplicacion, nombre, descripcion) VALUES (2, 'CASO-EXPEDIENTE', 'Aplicación creado por el sistema.');
INSERT INTO aplicacion (id_aplicacion, nombre, descripcion) VALUES (3, 'BITACORA-COBROS', 'Aplicación creado por el sistema.');
INSERT INTO aplicacion (id_aplicacion, nombre, descripcion) VALUES (4, 'BITACORA-JURIDICO', 'Aplicación creado por el sistema.');
INSERT INTO aplicacion (id_aplicacion, nombre, descripcion) VALUES (5, 'BITACORA-ADMINISTRATIVO', 'Aplicación creado por el sistema.');
INSERT INTO aplicacion (id_aplicacion, nombre, descripcion) VALUES (6, 'JUICIO', 'Aplicación creado por el sistema.');
INSERT INTO aplicacion (id_aplicacion, nombre, descripcion) VALUES (7, 'JUICIO-MEDIDAS', 'Aplicación creado por el sistema.');
INSERT INTO aplicacion (id_aplicacion, nombre, descripcion) VALUES (8, 'CONVENIO-PAGO', 'Aplicación creado por el sistema.');
INSERT INTO aplicacion (id_aplicacion, nombre, descripcion) VALUES (9, 'PAGOS-BANCARIOS', 'Aplicación creado por el sistema.');

INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (1, 1, 'CONTROL-1', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (2, 1, 'CONTROL-2', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (3, 1, 'CONTROL-3', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (1, 2, 'CONTROL-1', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (2, 2, 'CONTROL-2', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (3, 2, 'CONTROL-3', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (1, 3, 'CONTROL-1', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (2, 3, 'CONTROL-2', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (3, 3, 'CONTROL-3', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (1, 4, 'CONTROL-1', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (2, 4, 'CONTROL-2', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (3, 4, 'CONTROL-3', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (1, 5, 'CONTROL-1', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (2, 5, 'CONTROL-2', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (3, 5, 'CONTROL-3', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (1, 6, 'CONTROL-1', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (2, 6, 'CONTROL-2', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (3, 6, 'CONTROL-3', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (1, 7, 'CONTROL-1', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (2, 7, 'CONTROL-2', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (3, 7, 'CONTROL-3', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (1, 8, 'CONTROL-1', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (2, 8, 'CONTROL-2', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (3, 8, 'CONTROL-3', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (1, 9, 'CONTROL-1', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (2, 9, 'CONTROL-2', 'Control creado por el sistema.');
INSERT INTO control (id_control, id_aplicacion, nombre, descripcion) VALUES (3, 9, 'CONTROL-3', 'Control creado por el sistema.');

INSERT INTO rol (id_rol, nombre, descripcion) VALUES (1, 'ROL-ADMINISTRADOR', 'Rol creado por el sistema.');

INSERT INTO usuario (id_usuario, nombre_completo, nombre_usuario, contrasena, correo_electronico, descripcion, id_rol) 
VALUES (1, 'Edvin Francisco Navas Mejía.', 'enavas', SHA2('Edfr@2021', 512), 'edvin.navas@gmail.com', 'Prueba registro de usuario con contraseña SHA-2.', 1);

COMMIT;
-- *******************************************************************************
--  CONSULTA DE TABLAS DEL ESQUEMA: db_lexcom_seguridad.                         *
-- *******************************************************************************
SELECT a.* FROM aplicacion a;
SELECT c.* FROM control c;
SELECT r.* FROM rol r;
SELECT u.* FROM usuario u;

-- SELECT u.*
-- FROM usuario u
-- WHERE u.nombre_usuario = 'enavas' AND TRIM(CONVERT( u.contrasena USING UTF8MB4)) = TRIM(SHA2('Edfr@2021', 512));
-- SELECT CONVERT(COMPRESS('Edfr@2021') USING utf8mb4) TEXTO_COMPRESS;
-- SELECT CONVERT(UNCOMPRESS(COMPRESS('Edfr@2021')) USING utf8mb4) TEXTO_COMPRESS;
