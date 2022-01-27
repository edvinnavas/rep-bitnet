-- CREATE USER 'user_db_bitnet'@'localhost' IDENTIFIED BY 'p$41!jWaqt0Q';
-- GRANT ALL PRIVILEGES ON db_lexcom_negocio.* TO 'user_db_bitnet'@'localhost';
-- FLUSH PRIVILEGES;
-- *******************************************************************************
--  CREAMOS LA BASE DE DATOS: db_lexcom_negocio.                                 *
--  INDICAMOS A MYSQL QUE UTILIZAREMOS LA BASE DE DATOS: db_lexcom_negocio.      *
-- *******************************************************************************
DROP DATABASE IF EXISTS db_lexcom_negocio;
CREATE DATABASE db_lexcom_negocio CHARACTER SET utf8mb4;

USE db_lexcom_negocio;

-- *******************************************************************************
--  DROP Y CREATE tablas del esquema: db_lexcom_negocio.                         *
-- *******************************************************************************
DROP TABLE IF EXISTS genero;
CREATE TABLE genero (
	id_genero BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_genero PRIMARY KEY (id_genero)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS estado_civil;
CREATE TABLE estado_civil (
	id_estado_civil BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_estado_civil PRIMARY KEY (id_estado_civil)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS nacionalidad;
CREATE TABLE nacionalidad (
	id_nacionalidad BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_nacionalidad PRIMARY KEY (id_nacionalidad)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS area_codigo_resultado;
CREATE TABLE area_codigo_resultado (
	id_area_codigo_resultado BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_area_codigo_resultado PRIMARY KEY (id_area_codigo_resultado)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS registro_codigo_resultado;
CREATE TABLE registro_codigo_resultado (
	id_registro_codigo_resultado BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_registro_codigo_resultado PRIMARY KEY (id_registro_codigo_resultado)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS tipo_telefono;
CREATE TABLE tipo_telefono (
	id_tipo_telefono BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    descripcion TEXT,
    CONSTRAINT pk_tipo_telefono PRIMARY KEY (id_tipo_telefono)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS pais;
CREATE TABLE pais (
	id_pais BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    CONSTRAINT pk_pais PRIMARY KEY (id_pais)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS departamento;
CREATE TABLE departamento (
	id_departamento BIGINT NOT NULL,
    id_pais BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    CONSTRAINT pk_departamento PRIMARY KEY (id_departamento),
    CONSTRAINT fk_departamento_1 FOREIGN KEY (id_pais) REFERENCES pais (id_pais)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS municipio;
CREATE TABLE municipio (
	id_municipio BIGINT NOT NULL,
    id_departamento BIGINT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    CONSTRAINT pk_municipio PRIMARY KEY (id_municipio),
    CONSTRAINT fk_municipio_1 FOREIGN KEY (id_departamento) REFERENCES departamento (id_departamento)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS profesion;
CREATE TABLE profesion (
	id_profesion BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_profesion PRIMARY KEY (id_profesion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS deudor;
CREATE TABLE deudor (
	id_deudor BIGINT NOT NULL,
    nombre_completo VARCHAR(1000) NOT NULL,
    primer_nombre VARCHAR(50) NOT NULL,
    segundo_nombre VARCHAR(50),
    tercer_nombre VARCHAR(50),
    primer_apellido VARCHAR(50) NOT NULL,
    segundo_apellido VARCHAR(50),
    dpi BIGINT,
    nit BIGINT,
    id_genero BIGINT NOT NULL,
    fecha_nacimiento DATE,
    id_estado_civil BIGINT NOT NULL,
    id_profesion BIGINT NOT NULL,
    id_nacionalidad BIGINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_deudor PRIMARY KEY (id_deudor),
    CONSTRAINT fk_deudor_1 FOREIGN KEY (id_genero) REFERENCES genero (id_genero),
    CONSTRAINT fk_deudor_2 FOREIGN KEY (id_estado_civil) REFERENCES estado_civil (id_estado_civil),
    CONSTRAINT fk_deudor_3 FOREIGN KEY (id_profesion) REFERENCES profesion (id_profesion),
    CONSTRAINT fk_deudor_4 FOREIGN KEY (id_nacionalidad) REFERENCES nacionalidad (id_nacionalidad)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS directorio_telefonico_deudor;
CREATE TABLE directorio_telefonico_deudor (
	id_directorio_telefonico_deudor BIGINT NOT NULL,
	id_deudor BIGINT NOT NULL,
    id_tipo_telefono BIGINT NOT NULL,
    codigo_area INTEGER,
    numero_telefonico BIGINT NOT NULL,
    principal SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_directorio_telefonico_deudor PRIMARY KEY (id_directorio_telefonico_deudor),
    CONSTRAINT fk_directorio_telefonico_deudor_1 FOREIGN KEY (id_deudor) REFERENCES deudor (id_deudor),
    CONSTRAINT fk_directorio_telefonico_deudor_2 FOREIGN KEY (id_tipo_telefono) REFERENCES tipo_telefono (id_tipo_telefono)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS libreta_correo_electronico_deudor;
CREATE TABLE libreta_correo_electronico_deudor (
	id_libreta_correo_electronico_deudor BIGINT NOT NULL,
	id_deudor BIGINT NOT NULL,
    correo_electronico VARCHAR(200) NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_libreta_correo_electronico_deudor PRIMARY KEY (id_libreta_correo_electronico_deudor),
    CONSTRAINT fk_libreta_correo_electronico_deudor_1 FOREIGN KEY (id_deudor) REFERENCES deudor (id_deudor)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS libreta_direcciones_deudor;
CREATE TABLE libreta_direcciones_deudor (
	id_libreta_direcciones_deudor BIGINT NOT NULL,
	id_deudor BIGINT NOT NULL,
    id_municipio BIGINT NOT NULL,
    zona SMALLINT NOT NULL,
    direccion TEXT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_libreta_direcciones_deudor PRIMARY KEY (id_libreta_direcciones_deudor),
    CONSTRAINT fk_libreta_direcciones_deudor_1 FOREIGN KEY (id_deudor) REFERENCES deudor (id_deudor),
    CONSTRAINT fk_libreta_direcciones_deudor_2 FOREIGN KEY (id_municipio) REFERENCES municipio (id_municipio)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS corporacion;
CREATE TABLE corporacion (
	id_corporacion BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_corporacion PRIMARY KEY (id_corporacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS actor;
CREATE TABLE actor (
	id_actor BIGINT NOT NULL,
    id_corporacion BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_actor PRIMARY KEY (id_actor),
    CONSTRAINT fk_actor_1 FOREIGN KEY (id_corporacion) REFERENCES corporacion (id_corporacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS estado_extrajudicial;
CREATE TABLE estado_extrajudicial (
	id_estado_extrajudicial BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_estado_extrajudicial PRIMARY KEY (id_estado_extrajudicial)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS estatus_extrajudicial;
CREATE TABLE estatus_extrajudicial (
	id_estatus_extrajudicial BIGINT NOT NULL,
    id_estado_extrajudicial BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    permite_estado_judicial SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_estatus_extrajudicial PRIMARY KEY (id_estatus_extrajudicial),
    CONSTRAINT fk_estatus_extrajudicial_1 FOREIGN KEY (id_estado_extrajudicial) REFERENCES estado_extrajudicial (id_estado_extrajudicial)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS estado_judicial;
CREATE TABLE estado_judicial (
	id_estado_judicial BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_estado_judicial PRIMARY KEY (id_estado_judicial)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS estatus_judicial;
CREATE TABLE estatus_judicial (
	id_estatus_judicial BIGINT NOT NULL,
    id_estado_judicial BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_estatus_judicial PRIMARY KEY (id_estatus_judicial),
    CONSTRAINT fk_estatus_judicial_1 FOREIGN KEY (id_estado_judicial) REFERENCES estado_judicial (id_estado_judicial)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS garantia;
CREATE TABLE garantia (
	id_garantia BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_garantia PRIMARY KEY (id_garantia)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS moneda;
CREATE TABLE moneda (
	id_moneda BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_moneda PRIMARY KEY (id_moneda)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS tipo_codigo_resultado;
CREATE TABLE tipo_codigo_resultado (
	id_tipo_codigo_resultado BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_tipo_codigo_resultado PRIMARY KEY (id_tipo_codigo_resultado)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS codigo_resultado;
CREATE TABLE codigo_resultado (
	id_codigo_resultado BIGINT NOT NULL,
    id_area_codigo_resultado BIGINT NOT NULL,
    id_registro_codigo_resultado BIGINT NOT NULL,
    id_tipo_codigo_resultado BIGINT NOT NULL,
    es_contacto SMALLINT NOT NULL,
    codigo VARCHAR(20) NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_codigo_resultado PRIMARY KEY (id_codigo_resultado),
    CONSTRAINT fk_codigo_resultado_1 FOREIGN KEY (id_area_codigo_resultado) REFERENCES area_codigo_resultado (id_area_codigo_resultado),
    CONSTRAINT fk_codigo_resultado_2 FOREIGN KEY (id_registro_codigo_resultado) REFERENCES registro_codigo_resultado (id_registro_codigo_resultado),
    CONSTRAINT fk_codigo_resultado_3 FOREIGN KEY (id_tipo_codigo_resultado) REFERENCES tipo_codigo_resultado (id_tipo_codigo_resultado)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS cosecha;
CREATE TABLE cosecha (
	id_cosecha BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_cosecha PRIMARY KEY (id_cosecha)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS antiguedad;
CREATE TABLE antiguedad (
	id_antiguedad BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_antiguedad PRIMARY KEY (id_antiguedad)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS intencion_pago;
CREATE TABLE intencion_pago (
	id_intencion_pago BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_intencion_pago PRIMARY KEY (id_intencion_pago)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS razon_deuda;
CREATE TABLE razon_deuda (
	id_razon_deuda BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_razon_deuda PRIMARY KEY (id_razon_deuda)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS expediente;
CREATE TABLE expediente (
	id_expediente BIGINT NOT NULL,
    id_actor BIGINT NOT NULL,
    id_deudor BIGINT NOT NULL,
    numero_caso INTEGER NOT NULL,
    id_estatus_extrajudicial BIGINT NOT NULL,
    id_estatus_judicial BIGINT NOT NULL,
    id_garantia BIGINT NOT NULL,
    id_moneda BIGINT NOT NULL,
    id_codigo_resultado BIGINT NOT NULL,
    id_cosecha BIGINT NOT NULL,
    id_antiguedad BIGINT NOT NULL,
    id_intencion_pago BIGINT NOT NULL,
    id_razon_deuda BIGINT NOT NULL,
    fecha_ingreso DATE NOT NULL,
    fecha_recepcion DATE NOT NULL,
    monto_inicial DOUBLE NOT NULL,
    saldo DOUBLE NOT NULL,
    numero_cuenta VARCHAR(100) NOT NULL,
    numero_cuenta_otro VARCHAR(100),
    gestor_extrajudicial VARCHAR(100),
    gestor_judicial VARCHAR(100),
    estado SMALLINT NOT NULL,
    pdf SMALLINT NOT NULL,
	inv SMALLINT NOT NULL,
	maycom SMALLINT NOT NULL,
	nit SMALLINT NOT NULL,
    anticipo SMALLINT NOT NULL,
    descripcion TEXT,
    descripcion_adicional TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_expediente PRIMARY KEY (id_expediente),
    CONSTRAINT fk_expediente_1 FOREIGN KEY (id_actor) REFERENCES actor (id_actor),
    CONSTRAINT fk_expediente_2 FOREIGN KEY (id_deudor) REFERENCES deudor (id_deudor),
    CONSTRAINT fk_expediente_3 FOREIGN KEY (id_estatus_extrajudicial) REFERENCES estatus_extrajudicial (id_estatus_extrajudicial),
    CONSTRAINT fk_expediente_4 FOREIGN KEY (id_estatus_judicial) REFERENCES estatus_judicial (id_estatus_judicial),
    CONSTRAINT fk_expediente_5 FOREIGN KEY (id_garantia) REFERENCES garantia (id_garantia),
    CONSTRAINT fk_expediente_6 FOREIGN KEY (id_moneda) REFERENCES moneda (id_moneda),
    CONSTRAINT fk_expediente_7 FOREIGN KEY (id_codigo_resultado) REFERENCES codigo_resultado (id_codigo_resultado),
    CONSTRAINT fk_expediente_8 FOREIGN KEY (id_cosecha) REFERENCES cosecha (id_cosecha),
    CONSTRAINT fk_expediente_9 FOREIGN KEY (id_antiguedad) REFERENCES antiguedad (id_antiguedad),
    CONSTRAINT fk_expediente_10 FOREIGN KEY (id_intencion_pago) REFERENCES intencion_pago (id_intencion_pago),
    CONSTRAINT fk_expediente_11 FOREIGN KEY (id_razon_deuda) REFERENCES razon_deuda (id_razon_deuda)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS bitacora_gestion_cobros;
CREATE TABLE bitacora_gestion_cobros (
    id_bitacora_gestion_cobros BIGINT NOT NULL,
    id_expediente BIGINT NOT NULL,
	id_codigo_resultado BIGINT NOT NULL,
    fecha_hora TIMESTAMP NOT NULL,
	usuario_gestion VARCHAR(100) NOT NULL,
    descripcion_gestion TEXT NOT NULL,
	fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_bitacora_gestion_cobros PRIMARY KEY (id_bitacora_gestion_cobros),
    CONSTRAINT fk_bitacora_gestion_cobros_1 FOREIGN KEY (id_expediente) REFERENCES expediente (id_expediente),
    CONSTRAINT fk_bitacora_gestion_cobros_2 FOREIGN KEY (id_codigo_resultado) REFERENCES codigo_resultado (id_codigo_resultado)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS bitacora_gestion_juridico;
CREATE TABLE bitacora_gestion_juridico (
	id_bitacora_gestion_juridico BIGINT NOT NULL,
    id_expediente BIGINT NOT NULL,
	id_codigo_resultado BIGINT NOT NULL,
    fecha_hora TIMESTAMP NOT NULL,
	usuario_gestion VARCHAR(100) NOT NULL,
    descripcion_gestion TEXT NOT NULL,
	fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_bitacora_gestion_juridico PRIMARY KEY (id_bitacora_gestion_juridico),
    CONSTRAINT fk_bitacora_gestion_juridico_1 FOREIGN KEY (id_expediente) REFERENCES expediente (id_expediente),
    CONSTRAINT fk_bitacora_gestion_juridico_2 FOREIGN KEY (id_codigo_resultado) REFERENCES codigo_resultado (id_codigo_resultado)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS tipo_convenio;
CREATE TABLE tipo_convenio (
	id_tipo_convenio BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_tipo_convenio PRIMARY KEY (id_tipo_convenio)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS estado_convenio;
CREATE TABLE estado_convenio (
	id_estado_convenio BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_estado_convenio PRIMARY KEY (id_estado_convenio)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS frecuencia_convenio;
CREATE TABLE frecuencia_convenio (
	id_frecuencia_convenio BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_frecuencia_convenio PRIMARY KEY (id_frecuencia_convenio)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS convenio;
CREATE TABLE convenio (
	id_convenio BIGINT NOT NULL,
    id_expediente BIGINT NOT NULL,
    id_tipo_convenio BIGINT NOT NULL,
    id_estado_convenio BIGINT NOT NULL,
    saldo_actual DOUBLE NOT NULL,
    interes DOUBLE NOT NULL,
    mora DOUBLE NOT NULL,
    gasto_otros DOUBLE NOT NULL,
    rebaja_interes DOUBLE NOT NULL,
    subtotal_pagar DOUBLE NOT NULL,
    costas DOUBLE NOT NULL,
    monto_costas DOUBLE NOT NULL,
    total DOUBLE NOT NULL,
    cuota_inicial DOUBLE NOT NULL,
    total_pagar DOUBLE NOT NULL,
    fecha_pago_inicial DATE NOT NULL,
    numero_cuotas INTEGER NOT NULL,
    id_frecuencia_convenio BIGINT NOT NULL,
    monto_cuota DOUBLE NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    fecha_activacion TIMESTAMP,
    fecha_terminacion TIMESTAMP,
    descripcion TEXT,
	fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_convenio PRIMARY KEY (id_convenio),
    CONSTRAINT fk_convenio_1 FOREIGN KEY (id_expediente) REFERENCES expediente (id_expediente),
    CONSTRAINT fk_convenio_2 FOREIGN KEY (id_tipo_convenio) REFERENCES tipo_convenio (id_tipo_convenio),
    CONSTRAINT fk_convenio_3 FOREIGN KEY (id_estado_convenio) REFERENCES estado_convenio (id_estado_convenio),
    CONSTRAINT fk_convenio_4 FOREIGN KEY (id_frecuencia_convenio) REFERENCES frecuencia_convenio (id_frecuencia_convenio)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS convenio_historial;
CREATE TABLE convenio_historial (
	id_convenio_historial BIGINT NOT NULL,
    id_convenio BIGINT NOT NULL,
    id_estado_convenio_anterior BIGINT,
    id_estado_convenio_actual BIGINT NOT NULL,
	fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_convenio_historial PRIMARY KEY (id_convenio_historial),
    CONSTRAINT fk_convenio_historial_1 FOREIGN KEY (id_convenio) REFERENCES convenio (id_convenio),
    CONSTRAINT fk_convenio_historial_2 FOREIGN KEY (id_estado_convenio_anterior) REFERENCES estado_convenio (id_estado_convenio),
    CONSTRAINT fk_convenio_historial_3 FOREIGN KEY (id_estado_convenio_actual) REFERENCES estado_convenio (id_estado_convenio)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS estado_promesa_pago;
CREATE TABLE estado_promesa_pago (
	id_estado_promesa_pago BIGINT NOT NULL,
    nombre VARCHAR(500) NOT NULL,
    activo SMALLINT NOT NULL,
    descripcion TEXT,
    fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_estado_promesa_pago PRIMARY KEY (id_estado_promesa_pago)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS promesa_pago;
CREATE TABLE promesa_pago (
	id_promesa_pago BIGINT NOT NULL,
    id_convenio BIGINT NOT NULL,
    id_estado_promesa_pago BIGINT NOT NULL,
    fecha_pago DATE NOT NULL,
    monto_pago DOUBLE NOT NULL,
    descripcion TEXT NOT NULL,
	fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_promesa_pago PRIMARY KEY (id_promesa_pago),
    CONSTRAINT fk_promesa_pago_1 FOREIGN KEY (id_convenio) REFERENCES convenio (id_convenio),
    CONSTRAINT fk_promesa_pago_2 FOREIGN KEY (id_estado_promesa_pago) REFERENCES estado_promesa_pago (id_estado_promesa_pago)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS promesa_pago_historial;
CREATE TABLE promesa_pago_historial (
	id_promesa_pago_historial BIGINT NOT NULL,
    id_promesa_pago BIGINT NOT NULL,
    id_estado_promesa_pago_anterior BIGINT,
    id_estado_promesa_pago_actual BIGINT NOT NULL,
	fecha_hora_modificacion TIMESTAMP NOT NULL,
    usuario_modificacion VARCHAR(100) NOT NULL,
    CONSTRAINT pk_promesa_pago_historial PRIMARY KEY (id_promesa_pago_historial),
    CONSTRAINT fk_promesa_pago_historial_1 FOREIGN KEY (id_promesa_pago) REFERENCES promesa_pago (id_promesa_pago),
    CONSTRAINT fk_promesa_pago_historial_2 FOREIGN KEY (id_estado_promesa_pago_anterior) REFERENCES estado_promesa_pago (id_estado_promesa_pago),
    CONSTRAINT fk_promesa_pago_historial_3 FOREIGN KEY (id_estado_promesa_pago_actual) REFERENCES estado_promesa_pago (id_estado_promesa_pago)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- *******************************************************************************
--  INSERT tablas de catálogos básicos en el esquema : db_lexcom_negocio.        *
-- *******************************************************************************
INSERT INTO genero (id_genero, nombre, descripcion) VALUES (1, 'MASCULINO', 'Genero creado por el sistema.');
INSERT INTO genero (id_genero, nombre, descripcion) VALUES (2, 'FEMENINO', 'Genero creado por el sistema.');
INSERT INTO genero (id_genero, nombre, descripcion) VALUES (3, 'NO DEFINIDO', 'Genero creado por el sistema.');

INSERT INTO estado_civil (id_estado_civil, nombre, descripcion) VALUES (1, 'SOLTER@', 'Estado Civil creado por el sistema.');
INSERT INTO estado_civil (id_estado_civil, nombre, descripcion) VALUES (2, 'CASAD@', 'Estado Civil creado por el sistema.');
INSERT INTO estado_civil (id_estado_civil, nombre, descripcion) VALUES (3, 'NO DEFINIDO', 'Estado Civil creado por el sistema.');

INSERT INTO nacionalidad (id_nacionalidad, nombre, descripcion) VALUES (1, 'GUATEMALTEC@', 'Nacionalidad creado por el sistema.');

INSERT INTO area_codigo_resultado (id_area_codigo_resultado, nombre, descripcion) VALUES (1, 'EXTRAJUDICIAL', 'Area Código de Resultado creado por el sistema.');
INSERT INTO area_codigo_resultado (id_area_codigo_resultado, nombre, descripcion) VALUES (2, 'JUDICIAL', 'Area Código de Resultado creado por el sistema.');

INSERT INTO registro_codigo_resultado (id_registro_codigo_resultado, nombre, descripcion) VALUES (1, 'MASIVO', 'Registro Código de Resultado creado por el sistema.');
INSERT INTO registro_codigo_resultado (id_registro_codigo_resultado, nombre, descripcion) VALUES (2, 'MANUAL', 'Registro Código de Resultado creado por el sistema.');

INSERT INTO tipo_telefono (id_tipo_telefono, nombre, descripcion) VALUES (1, 'CASA', 'Tipo de Teléfono creado por el sistema.');
INSERT INTO tipo_telefono (id_tipo_telefono, nombre, descripcion) VALUES (2, 'CELULAR', 'Tipo de Teléfono creado por el sistema.');

INSERT INTO pais (id_pais, nombre) VALUES (1, 'GUATEMALA');

INSERT INTO departamento (id_departamento, id_pais, nombre) VALUES (1, 1, 'GUATEMALA');
INSERT INTO departamento (id_departamento, id_pais, nombre) VALUES (2, 1, 'ESCUINTLA');

INSERT INTO municipio (id_municipio, id_departamento, nombre) VALUES (1, 1, 'GUATEMALA');
INSERT INTO municipio (id_municipio, id_departamento, nombre) VALUES (2, 2, 'LA DEMOCRACIA');
INSERT INTO municipio (id_municipio, id_departamento, nombre) VALUES (3, 1, 'MIXCO');

INSERT INTO profesion (id_profesion, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'NO DEFINIDO', 1, 'Profesión creada por el sistema.', NOW(), 'SYSTEM');

INSERT INTO deudor (id_deudor, nombre_completo, primer_nombre, segundo_nombre, tercer_nombre, primer_apellido, segundo_apellido, dpi, nit, id_genero, fecha_nacimiento, id_estado_civil, id_profesion, id_nacionalidad, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'Edvin Francisco Navas Mejía', 'Edvin', 'Francisco', null, 'Navas', 'Mejía', 1683946850101, 46514155, 1, '1982-04-04', 1, 1, 1, 'Deudor inicial creado para pruebas.', NOW(), 'SYSTEM');

INSERT INTO directorio_telefonico_deudor (id_directorio_telefonico_deudor, id_deudor, id_tipo_telefono, codigo_area, numero_telefonico, principal, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 1, 1, 502, 22125511, 0, 'Teléfono de casa si contesta.', NOW(), 'SYSTEM');
INSERT INTO directorio_telefonico_deudor (id_directorio_telefonico_deudor, id_deudor, id_tipo_telefono, codigo_area, numero_telefonico, principal, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (2, 1, 2, 502, 53448752, 1, 'Teléfono celular personal.', NOW(), 'SYSTEM');
INSERT INTO directorio_telefonico_deudor (id_directorio_telefonico_deudor, id_deudor, id_tipo_telefono, codigo_area, numero_telefonico, principal, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (3, 1, 2, 502, 58795242, 0, 'Teléfono celular de trabajo.', NOW(), 'SYSTEM');

INSERT INTO libreta_correo_electronico_deudor (id_libreta_correo_electronico_deudor, id_deudor, correo_electronico, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 1, 'edvin.navas@gmail.com', 'Correo electrónico personal', NOW(), 'SYSTEM');
INSERT INTO libreta_correo_electronico_deudor (id_libreta_correo_electronico_deudor, id_deudor, correo_electronico, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (2, 1, 'sied_namo@hotmail.com', 'Correo electrónico personal', NOW(), 'SYSTEM');
INSERT INTO libreta_correo_electronico_deudor (id_libreta_correo_electronico_deudor, id_deudor, correo_electronico, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (3, 1, 'edvin_navas@yahoo.com.mx', 'Correo electrónico personal', NOW(), 'SYSTEM');
INSERT INTO libreta_correo_electronico_deudor (id_libreta_correo_electronico_deudor, id_deudor, correo_electronico, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (4, 1, 'bitnetgt@yahoo.com', 'Correo electrónico personal', NOW(), 'SYSTEM');
INSERT INTO libreta_correo_electronico_deudor (id_libreta_correo_electronico_deudor, id_deudor, correo_electronico, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (5, 1, 'sied_namo@yahoo.com', 'Correo electrónico personal', NOW(), 'SYSTEM');
INSERT INTO libreta_correo_electronico_deudor (id_libreta_correo_electronico_deudor, id_deudor, correo_electronico, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (6, 1, 'enavas@corporaciongrupoterra.com', 'Correo electrónico personal', NOW(), 'SYSTEM');

INSERT INTO libreta_direcciones_deudor (id_libreta_direcciones_deudor, id_deudor, id_municipio, zona, direccion, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 1, 1, 11, '2 calle 37-83 zona 11 colonia Toledo', 'Antigua dirección.', NOW(), 'SYSTEM');
INSERT INTO libreta_direcciones_deudor (id_libreta_direcciones_deudor, id_deudor, id_municipio, zona, direccion, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (2, 1, 3, 3, 'Calzada Mateo Flores 3-47 zona 3 de Mixco colonia Kajabal', 'Dirección actual.', NOW(), 'SYSTEM');

INSERT INTO corporacion (id_corporacion, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'Corporación Banco Agromercantil', 1, 'Corporación creada por el sistema.', NOW(), 'SYSTEM');

INSERT INTO actor (id_actor, id_corporacion, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 1, 'Banco Agromercantil', 1, 'Actor creado por el sistema.', NOW(), 'SYSTEM');

INSERT INTO estado_extrajudicial (id_estado_extrajudicial, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'Cobro Extrajudicial', 1, 'Estado Extrajudicial creado por el sistema.', NOW(), 'SYSTEM');

INSERT INTO estatus_extrajudicial (id_estatus_extrajudicial, id_estado_extrajudicial, nombre, activo, permite_estado_judicial, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 1, 'Investigación', 1, 0, 'Estatus Extrajudicial creado por el sistema.', NOW(), 'SYSTEM');

INSERT INTO estado_judicial (id_estado_judicial, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'Tramite', 1, 'Estado Judicial creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO estado_judicial (id_estado_judicial, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (2, 'Sin proceso judicial', 1, 'Estado Judicial creado por el sistema.', NOW(), 'SYSTEM');

INSERT INTO estatus_judicial (id_estatus_judicial, id_estado_judicial, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 2, 'Sólo Cobro Extrajudicial', 1, 'Estatus Judicial creado por el sistema.', NOW(), 'SYSTEM');

INSERT INTO garantia (id_garantia, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'Tarjeta', 1, 'Garantía creada por el sistema.', NOW(), 'SYSTEM');

INSERT INTO moneda (id_moneda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'QUETZAL', 1, 'Moneda creada por el sistema.', NOW(), 'SYSTEM');
INSERT INTO moneda (id_moneda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (2, 'DOLLAR', 1, 'Moneda creada por el sistema.', NOW(), 'SYSTEM');

INSERT INTO tipo_codigo_resultado (id_tipo_codigo_resultado, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'SEGUIMIENTO DE PROMESA', 1, 'Tipo Código de Resutado creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO tipo_codigo_resultado (id_tipo_codigo_resultado, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (2, 'CONTACTAR', 1, 'Tipo Código de Resutado creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO tipo_codigo_resultado (id_tipo_codigo_resultado, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (3, 'INVESTIGACION', 1, 'Tipo Código de Resutado creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO tipo_codigo_resultado (id_tipo_codigo_resultado, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (4, 'CONVENIO DE PAGO', 1, 'Tipo Código de Resutado creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO tipo_codigo_resultado (id_tipo_codigo_resultado, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (5, 'GESTION MASIVA', 1, 'Tipo Código de Resutado creado por el sistema.', NOW(), 'SYSTEM');

INSERT INTO codigo_resultado (id_codigo_resultado, id_area_codigo_resultado, id_registro_codigo_resultado, id_tipo_codigo_resultado, es_contacto, codigo, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 1, 1, 5, 0, 'INI', 'INICIAL', 1, 'Moneda creada por el sistema.', NOW(), 'SYSTEM');

INSERT INTO cosecha (id_cosecha, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, '0 antes 31 dic 2008', 1, 'Cosecha creada por el sistema.', NOW(), 'SYSTEM');

INSERT INTO antiguedad (id_antiguedad, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'ORO', 1, 'Antigüedad creada por el sistema.', NOW(), 'SYSTEM');
INSERT INTO antiguedad (id_antiguedad, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (2, 'PLATA', 1, 'Antigüedad creada por el sistema.', NOW(), 'SYSTEM');
INSERT INTO antiguedad (id_antiguedad, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (3, 'BRONCE', 1, 'Antigüedad creada por el sistema.', NOW(), 'SYSTEM');

INSERT INTO intencion_pago (id_intencion_pago, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'Desea pagar', 1, 'Intencion Pago creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO intencion_pago (id_intencion_pago, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (2, 'Se niega a pagar', 1, 'Intencion Pago creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO intencion_pago (id_intencion_pago, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (3, 'No puede pagar', 1, 'Intencion Pago creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO intencion_pago (id_intencion_pago, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (4, 'No determinado', 1, 'Intencion Pago creado por el sistema.', NOW(), 'SYSTEM');

INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'NO ESPECIFÍCA', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (2, 'DESEMPLEO', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (3, 'SOBREENDEUDAMIENTO', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (4, 'REDUCCIÓN DE INGRESOS / JUBILACIÓN', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (5, 'CIERRE DE NEGOCIO', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (6, 'BANCARROTA', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (7, 'ENFERMEDAD / TRATAMIENTOS MÉDICOS', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (8, 'CALAMIDAD FAMILIAR', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (9, 'REDUCCIÓN DE VENTAS - INDEPENDIENTES', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (10, 'CLIENTE FALLECIDO', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (11, 'OLVIDO DE PAGO / SIN TIEMPO PARA PAGAR', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (12, 'DIVORCIO / PROBLEMAS CONYUGALES', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (13, 'OTROS', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (14, 'DESASTRE NATURAL', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (15, 'ESTUDIO DE FRAUDE', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (16, 'ROBO DE IDENTIDAD / CLONACIÓN DE TARJETA', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (17, 'NO RECIBE ESTADOS DE CUENTA', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO razon_deuda (id_razon_deuda, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (18, 'RECLAMO - ERROR OPERATIVO', 1, 'Razon Deuda creado por el sistema.', NOW(), 'SYSTEM');

INSERT INTO expediente (id_expediente, id_actor, id_deudor, numero_caso, id_estatus_extrajudicial, id_estatus_judicial, id_garantia, id_moneda, id_codigo_resultado, id_cosecha, id_antiguedad, id_intencion_pago, id_razon_deuda, fecha_ingreso, fecha_recepcion, monto_inicial, saldo, numero_cuenta, numero_cuenta_otro, gestor_extrajudicial, gestor_judicial, estado, pdf, inv, maycom, nit, anticipo, descripcion, descripcion_adicional, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 1, 1, 1001, 1, 1, 1, 1, 1, 1, 1, 1, 1, '2021-10-23', '2021-10-23', 12345.67, 12345.67, 'CUE-001002', 'OTRO-CUE-001002', 'GESTOR-1', 'GESTOR-2', 1, 0, 0, 0, 0, 1, 'descripcion', 'descripcion_adicional', NOW(), 'SYSTEM');

INSERT INTO bitacora_gestion_cobros (id_bitacora_gestion_cobros, id_expediente, id_codigo_resultado, fecha_hora, usuario_gestion, descripcion_gestion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 1, 1, NOW(), 'GESTOR-1', 'Ejemplo texto de la descripcion de la gestion.', NOW(), 'SYSTEM');

INSERT INTO bitacora_gestion_juridico (id_bitacora_gestion_juridico, id_expediente, id_codigo_resultado, fecha_hora, usuario_gestion, descripcion_gestion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 1, 1, NOW(), 'GESTOR-1', 'Ejemplo texto de la descripcion de la gestion juridica.', NOW(), 'SYSTEM');

INSERT INTO tipo_convenio (id_tipo_convenio, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'NORMAL', 1, 'Tipo Convenio creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO tipo_convenio (id_tipo_convenio, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (2, 'CANCELACION TOTAL', 1, 'Tipo Convenio creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO tipo_convenio (id_tipo_convenio, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (3, 'TEMPORAL', 1, 'Tipo Convenio creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO tipo_convenio (id_tipo_convenio, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (4, 'TRANSACCION', 1, 'Tipo Convenio creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO tipo_convenio (id_tipo_convenio, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (5, 'PAGOS SIN CONVENIO', 1, 'Tipo Convenio creado por el sistema.', NOW(), 'SYSTEM');

INSERT INTO estado_convenio (id_estado_convenio, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'NEGOCIACION', 1, 'Estado Convenio creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO estado_convenio (id_estado_convenio, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (2, 'ACTIVO', 1, 'Estado Convenio creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO estado_convenio (id_estado_convenio, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (3, 'ANULADO', 1, 'Estado Convenio creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO estado_convenio (id_estado_convenio, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (4, 'TERMINADO', 1, 'Estado Convenio creado por el sistema.', NOW(), 'SYSTEM');

INSERT INTO frecuencia_convenio (id_frecuencia_convenio, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'MENSUAL', 1, 'Frecuencia Convenio creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO frecuencia_convenio (id_frecuencia_convenio, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (2, 'QUINCENAL', 1, 'Frecuencia Convenio creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO frecuencia_convenio (id_frecuencia_convenio, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (3, 'SEMANAL', 1, 'Frecuencia Convenio creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO frecuencia_convenio (id_frecuencia_convenio, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (4, 'DIARIO', 1, 'Frecuencia Convenio creado por el sistema.', NOW(), 'SYSTEM');

INSERT INTO convenio (id_convenio, id_expediente, id_tipo_convenio, id_estado_convenio, id_frecuencia_convenio, saldo_actual, interes, mora, gasto_otros, rebaja_interes, subtotal_pagar, costas, monto_costas, total, cuota_inicial, total_pagar, fecha_pago_inicial, numero_cuotas, monto_cuota, fecha_creacion, fecha_activacion, fecha_terminacion, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 1, 1, 1, 1, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, CURDATE(), 0.00, 10, NOW(), NULL, NULL, 'Creación de primer convenio de pago de ejemplo.', NOW(), 'SYSTEM');

INSERT INTO convenio_historial (id_convenio_historial, id_convenio, id_estado_convenio_anterior, id_estado_convenio_actual, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 1, null, 1, NOW(), 'SYSTEM');

INSERT INTO estado_promesa_pago (id_estado_promesa_pago, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'PENDIENTE', 1, 'Estado Promesa de Pago creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO estado_promesa_pago (id_estado_promesa_pago, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (2, 'CUMPLIDO', 1, 'Estado Promesa de Pago creado por el sistema.', NOW(), 'SYSTEM');
INSERT INTO estado_promesa_pago (id_estado_promesa_pago, nombre, activo, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 'INCUMPLIDO', 1, 'Estado Promesa de Pago creado por el sistema.', NOW(), 'SYSTEM');

INSERT INTO promesa_pago (id_promesa_pago, id_convenio, id_estado_promesa_pago, fecha_pago, monto_pago, descripcion, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 1, 1, CURDATE(), 23456.78, 'Promesa de Pago creada de prueba.', NOW(), 'SYSTEM');

INSERT INTO promesa_pago_historial (id_promesa_pago_historial, id_promesa_pago, id_estado_promesa_pago_anterior, id_estado_promesa_pago_actual, fecha_hora_modificacion, usuario_modificacion) VALUES (1, 1, null, 1, NOW(), 'SYSTEM');

SHOW TABLES;

SELECT g.* FROM genero g;
SELECT ec.* FROM estado_civil ec;
SELECT n.* FROM nacionalidad n;
SELECT acr.* FROM area_codigo_resultado acr;
SELECT rcr.* FROM registro_codigo_resultado rcr;
SELECT tt.* FROM tipo_telefono tt;
SELECT p.* FROM pais p;
SELECT d.* FROM departamento d;
SELECT m.* FROM municipio m;
SELECT p.* FROM profesion p;

SELECT d.* FROM deudor d;
SELECT dtd.* FROM directorio_telefonico_deudor dtd;
SELECT lced.* FROM libreta_correo_electronico_deudor lced;
SELECT ldd.* FROM libreta_direcciones_deudor ldd;

SELECT c.* FROM corporacion c;
SELECT a.* FROM actor a;
SELECT ee.* FROM estado_extrajudicial ee;
SELECT ee.* FROM estatus_extrajudicial ee;
SELECT ee.* FROM estado_judicial ee;
SELECT ee.* FROM estatus_judicial ee;
SELECT g.* FROM garantia g;
SELECT m.* FROM moneda m;
SELECT tcr.* FROM tipo_codigo_resultado tcr;
SELECT cr.* FROM codigo_resultado cr;
SELECT c.* FROM cosecha c;
SELECT a.* FROM antiguedad a;
SELECT ip.* FROM intencion_pago ip;
SELECT rd.* FROM razon_deuda rd;

SELECT e.* FROM expediente e;
SELECT bgc.* FROM bitacora_gestion_cobros bgc;
SELECT bgj.* FROM bitacora_gestion_juridico bgj;

SELECT tc.* FROM tipo_convenio tc;
SELECT ec.* FROM estado_convenio ec;
SELECT fc.* FROM frecuencia_convenio fc;
SELECT c.* FROM convenio c;
SELECT ch.* FROM convenio_historial ch;
SELECT epp.* FROM estado_promesa_pago epp;
SELECT pp.* FROM promesa_pago pp;
SELECT pph.* FROM promesa_pago_historial pph;

commit;

