USE db_lexcom_negocio;

DROP TABLE IF EXISTS expediente;
DROP TABLE IF EXISTS estado_estatus_judicial;
DROP TABLE IF EXISTS estado_estatus_extrajudicial;
DROP TABLE IF EXISTS estatus_judicial;
DROP TABLE IF EXISTS estado_judicial;
DROP TABLE IF EXISTS estatus_extrajudicial;
DROP TABLE IF EXISTS estado_extrajudicial;
DROP TABLE IF EXISTS garantia;
DROP TABLE IF EXISTS actor;
DROP TABLE IF EXISTS corporacion;
DROP TABLE IF EXISTS libreta_correo;
DROP TABLE IF EXISTS libreta_telefonica;
DROP TABLE IF EXISTS deudor;
DROP TABLE IF EXISTS tipo_telefono;
DROP TABLE IF EXISTS moneda;
DROP TABLE IF EXISTS municipio;
DROP TABLE IF EXISTS departamento;
DROP TABLE IF EXISTS pais;
DROP TABLE IF EXISTS estado_civil;
DROP TABLE IF EXISTS genero;

CREATE TABLE genero (
	id_genero BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_genero PRIMARY KEY (id_genero)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE estado_civil (
	id_estado_civil BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_estado_civil PRIMARY KEY (id_estado_civil)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE pais (
	id_pais BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    CONSTRAINT pk_pais PRIMARY KEY (id_pais)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE departamento (
	id_departamento BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    CONSTRAINT pk_departamento PRIMARY KEY (id_departamento)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE municipio (
	id_municipio BIGINT NOT NULL,
    id_departamento BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    CONSTRAINT pk_municipio PRIMARY KEY (id_municipio, id_departamento),
    CONSTRAINT fk_municipio_1 FOREIGN KEY (id_departamento) REFERENCES departamento (id_departamento)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE moneda (
	id_moneda BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    CONSTRAINT pk_moneda PRIMARY KEY (id_moneda)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE tipo_telefono (
	id_tipo_telefono BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    CONSTRAINT pk_tipo_telefono PRIMARY KEY (id_tipo_telefono)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE deudor (
	id_deudor BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    dpi VARCHAR(50) NOT NULL,
    nit VARCHAR(50) NOT NULL,
    id_genero BIGINT,
    fecha_nacimiento DATE,
    id_estado_civil BIGINT,
    profesion VARCHAR(500),
    nacionalidad VARCHAR(200),
    id_pais BIGINT,
    id_municipio BIGINT,
    id_departamento BIGINT,
    zona INTEGER,
    direccion VARCHAR(500),
    activo INTEGER NOT NULL DEFAULT 1,
    CONSTRAINT pk_deudor PRIMARY KEY (id_deudor),
    CONSTRAINT fk_deudor_1 FOREIGN KEY (id_genero) REFERENCES genero (id_genero),
    CONSTRAINT fk_deudor_2 FOREIGN KEY (id_estado_civil) REFERENCES estado_civil (id_estado_civil),
    CONSTRAINT fk_deudor_3 FOREIGN KEY (id_pais) REFERENCES pais (id_pais),
    CONSTRAINT fk_deudor_4 FOREIGN KEY (id_municipio, id_departamento) REFERENCES municipio (id_municipio, id_departamento)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE libreta_telefonica (
	id_libreta_telefonica BIGINT NOT NULL,
	id_deudor BIGINT NOT NULL,
    id_tipo_telefono BIGINT NOT NULL,
    codigo_area INTEGER,
    numero_telefonico BIGINT NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_libreta_telefonica PRIMARY KEY (id_libreta_telefonica, id_deudor),
    CONSTRAINT fk_libreta_telefonica_1 FOREIGN KEY (id_deudor) REFERENCES deudor (id_deudor),
    CONSTRAINT fk_libreta_telefonica_2 FOREIGN KEY (id_tipo_telefono) REFERENCES tipo_telefono (id_tipo_telefono)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE libreta_correo (
	id_libreta_correo BIGINT NOT NULL,
	id_deudor BIGINT NOT NULL,
    correo_electronico VARCHAR(200) NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_libreta_correo PRIMARY KEY (id_libreta_correo, id_deudor),
    CONSTRAINT fk_libreta_correo_1 FOREIGN KEY (id_deudor) REFERENCES deudor (id_deudor)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE corporacion (
	id_corporacion BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    descripcion TEXT,
    activo INTEGER NOT NULL DEFAULT 1,
    CONSTRAINT pk_corporacion PRIMARY KEY (id_corporacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE actor (
	id_actor BIGINT NOT NULL,
    id_corporacion BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    nit VARCHAR(50) NOT NULL,
    telefono BIGINT,
    descripcion TEXT,
    path_doc_digital VARCHAR(200),
    activo INTEGER NOT NULL DEFAULT 1,
    CONSTRAINT pk_actor PRIMARY KEY (id_actor, id_corporacion),
    CONSTRAINT fk_actor_1 FOREIGN KEY (id_corporacion) REFERENCES corporacion (id_corporacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE garantia (
	id_garantia BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    descripcion TEXT,
    activo INTEGER NOT NULL DEFAULT 1,
    CONSTRAINT pk_garantia PRIMARY KEY (id_garantia)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE estado_extrajudicial (
	id_estado_extrajudicial BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    descripcion TEXT,
    activo INTEGER NOT NULL DEFAULT 1,
    CONSTRAINT pk_estado_extrajudicial PRIMARY KEY (id_estado_extrajudicial)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE estatus_extrajudicial (
	id_estatus_extrajudicial BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    descripcion TEXT,
    activo INTEGER NOT NULL DEFAULT 1,
    CONSTRAINT pk_estatus_extrajudicial PRIMARY KEY (id_estatus_extrajudicial)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE estado_judicial (
	id_estado_judicial BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    descripcion TEXT,
    activo INTEGER NOT NULL DEFAULT 1,
    CONSTRAINT pk_estado_judicial PRIMARY KEY (id_estado_judicial)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE estatus_judicial (
	id_estatus_judicial BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    descripcion TEXT,
    activo INTEGER NOT NULL DEFAULT 1,
    CONSTRAINT pk_estatus_judicial PRIMARY KEY (id_estatus_judicial)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE estado_estatus_extrajudicial (
	id_estado_extrajudicial BIGINT NOT NULL,
    id_estatus_extrajudicial BIGINT NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_estado_estatus_extrajudicial PRIMARY KEY (id_estado_extrajudicial, id_estatus_extrajudicial),
    CONSTRAINT fk_estado_estatus_extrajudicial_1 FOREIGN KEY (id_estado_extrajudicial) REFERENCES estado_extrajudicial (id_estado_extrajudicial),
    CONSTRAINT fk_estado_estatus_extrajudicial_2 FOREIGN KEY (id_estatus_extrajudicial) REFERENCES estatus_extrajudicial (id_estatus_extrajudicial)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE estado_estatus_judicial (
	id_estado_judicial BIGINT NOT NULL,
    id_estatus_judicial BIGINT NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_estado_estatus_judicial PRIMARY KEY (id_estado_judicial, id_estatus_judicial),
    CONSTRAINT fk_estado_estatus_judicial_1 FOREIGN KEY (id_estado_judicial) REFERENCES estado_judicial (id_estado_judicial),
    CONSTRAINT fk_estado_estatus_judicial_2 FOREIGN KEY (id_estatus_judicial) REFERENCES estatus_judicial (id_estatus_judicial)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE expediente (
	id_actor BIGINT NOT NULL,
    id_corporacion BIGINT NOT NULL,
    id_deudor BIGINT NOT NULL,
    caso INTEGER NOT NULL,
    numero_cuenta VARCHAR(50),
    otro_numero_cuenta VARCHAR(50),
    id_moneda BIGINT NOT NULL,
    id_garantia BIGINT NOT NULL,
    id_estado_extrajudicial BIGINT NOT NULL,
    id_estatus_extrajudicial BIGINT NOT NULL,
    id_estado_judicial BIGINT NOT NULL,
    id_estatus_judicial BIGINT NOT NULL,
    saldo_inicial DOUBLE NOT NULL,
    CONSTRAINT pk_expediente PRIMARY KEY (id_actor, id_corporacion, id_deudor, caso),
    CONSTRAINT fk_expediente_1 FOREIGN KEY (id_actor, id_corporacion) REFERENCES actor (id_actor, id_corporacion),
    CONSTRAINT fk_expediente_2 FOREIGN KEY (id_deudor) REFERENCES deudor (id_deudor),
    CONSTRAINT fk_expediente_3 FOREIGN KEY (id_moneda) REFERENCES moneda (id_moneda),
    CONSTRAINT fk_expediente_4 FOREIGN KEY (id_garantia) REFERENCES garantia (id_garantia),
    CONSTRAINT fk_expediente_5 FOREIGN KEY (id_estado_extrajudicial, id_estatus_extrajudicial) REFERENCES estado_estatus_extrajudicial (id_estado_extrajudicial, id_estatus_extrajudicial),
    CONSTRAINT fk_expediente_6 FOREIGN KEY (id_estado_judicial, id_estatus_judicial) REFERENCES estado_estatus_judicial (id_estado_judicial, id_estatus_judicial)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

SELECT g.* FROM genero g;
SELECT ec.* FROM estado_civil ec;
SELECT p.* FROM pais p;
SELECT d.* FROM departamento d;
SELECT m.* FROM municipio m;
SELECT m.* FROM moneda m;
SELECT tt.* FROM tipo_telefono tt;
SELECT d.* FROM deudor d;
SELECT lt.* FROM libreta_telefonica lt;
SELECT lc.* FROM libreta_correo lc;
SELECT c.* FROM corporacion c;
SELECT a.* FROM actor a;
SELECT g.* FROM garantia g;
SELECT ee.* FROM estado_extrajudicial ee;
SELECT ee.* FROM estatus_extrajudicial ee;
SELECT ej.* FROM estado_judicial ej;
SELECT ej.* FROM estatus_judicial ej;
SELECT ese.* FROM estado_estatus_extrajudicial ese;
SELECT eej.* FROM estado_estatus_judicial eej;
SELECT e.* FROM expediente e;

COMMIT;