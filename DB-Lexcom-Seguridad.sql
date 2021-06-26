CREATE DATABASE db_lexcom_seguridad CHARACTER SET utf8mb4;
USE db_lexcom_seguridad;

DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS rol;

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


INSERT INTO rol (id_rol, nombre, descripcion) VALUES (1, 'ROL-ADMINISTRADOR', 'Rol creado por el sistema.');

INSERT INTO usuario (id_usuario, nombre_completo, nombre_usuario, contrasena, correo_electronico, descripcion, id_rol) 
VALUES (1, 'Edvin Francisco Navas Mejía.', 'enavas', SHA2('Edfr@2021', 512), 'edvin.navas@gmail.com', 'Prueba registro de usuario con contraseña SHA-2.', 1);


SELECT u.* FROM usuario u WHERE u.nombre_usuario = 'enavas' AND TRIM(CONVERT(u.contrasena USING utf8mb4)) = TRIM(SHA2('Edfr@2021', 512));

SELECT CONVERT(COMPRESS('Edfr@2021') USING utf8mb4) TEXTO_COMPRESS;
SELECT CONVERT(UNCOMPRESS(COMPRESS('Edfr@2021')) USING utf8mb4) TEXTO_COMPRESS;