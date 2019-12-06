--
-- PostgreSQL database dump
--

-- Dumped from database version 10.10
-- Dumped by pg_dump version 12.0

-- Started on 2019-12-03 00:16:09

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2848 (class 1262 OID 24039)
-- Name: TbDivisadb; Type: DATABASE; Schema: -; Owner: TbDivisadb
--

CREATE DATABASE TbDivisadb WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Colombia.1252' LC_CTYPE = 'Spanish_Colombia.1252';


ALTER DATABASE TbDivisadb OWNER TO TbDivisadb;

\connect TbDivisadb

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 24042)
-- Name: TbDivisadb; Type: SCHEMA; Schema: -; Owner: TbDivisadb
--

CREATE SCHEMA TbDivisadb;


ALTER SCHEMA TbDivisadb OWNER TO TbDivisadb;

--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA TbDivisadb; Type: COMMENT; Schema: -; Owner: TbDivisadb
--

COMMENT ON SCHEMA TbDivisadb IS 'esquema para las tablas de TbDivisas';


SET default_tablespace = '';

--
-- TOC entry 201 (class 1259 OID 24068)
-- Name: tb_cotizacion; Type: TABLE; Schema: TbDivisadb; Owner: TbDivisadb
--

CREATE TABLE TbDivisadb.tb_cotizacion (
    id_cotizacion integer NOT NULL,
    id_valortasacambio integer NOT NULL,
    fecha_registro timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    valor double precision NOT NULL
);


ALTER TABLE TbDivisadb.tb_cotizacion OWNER TO TbDivisadb;

--
-- TOC entry 2850 (class 0 OID 0)
-- Dependencies: 201
-- Name: TABLE tb_cotizacion; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON TABLE TbDivisadb.tb_cotizacion IS 'tabla para guardar las cotizaciones que realizan los usuarios';


--
-- TOC entry 2851 (class 0 OID 0)
-- Dependencies: 201
-- Name: COLUMN tb_cotizacion.id_cotizacion; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_cotizacion.id_cotizacion IS 'id de la cotización realizada';


--
-- TOC entry 2852 (class 0 OID 0)
-- Dependencies: 201
-- Name: COLUMN tb_cotizacion.id_valortasacambio; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_cotizacion.id_valortasacambio IS 'id del valor de la tasa de cambio para la cotización';


--
-- TOC entry 2853 (class 0 OID 0)
-- Dependencies: 201
-- Name: COLUMN tb_cotizacion.fecha_registro; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_cotizacion.fecha_registro IS 'Fecha registro de la cotización';


--
-- TOC entry 2854 (class 0 OID 0)
-- Dependencies: 201
-- Name: COLUMN tb_cotizacion.valor; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_cotizacion.valor IS 'valor a cotizar';


--
-- TOC entry 202 (class 1259 OID 24071)
-- Name: tb_cotizacion_id_cotizacion_seq; Type: SEQUENCE; Schema: TbDivisadb; Owner: TbDivisadb
--

CREATE SEQUENCE TbDivisadb.tb_cotizacion_id_cotizacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE TbDivisadb.tb_cotizacion_id_cotizacion_seq OWNER TO TbDivisadb;

--
-- TOC entry 2855 (class 0 OID 0)
-- Dependencies: 202
-- Name: tb_cotizacion_id_cotizacion_seq; Type: SEQUENCE OWNED BY; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER SEQUENCE TbDivisadb.tb_cotizacion_id_cotizacion_seq OWNED BY TbDivisadb.tb_cotizacion.id_cotizacion;


--
-- TOC entry 198 (class 1259 OID 24045)
-- Name: tb_TbDivisa; Type: TABLE; Schema: TbDivisadb; Owner: TbDivisadb
--

CREATE TABLE TbDivisadb.tb_TbDivisa (
    id_TbDivisa integer NOT NULL,
    nombre_TbDivisa character varying(12) NOT NULL,
    abreviatura_TbDivisa character varying(5) NOT NULL,
    activa boolean DEFAULT true NOT NULL,
    fecha_registro timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


ALTER TABLE TbDivisadb.tb_TbDivisa OWNER TO TbDivisadb;

--
-- TOC entry 2856 (class 0 OID 0)
-- Dependencies: 198
-- Name: TABLE tb_TbDivisa; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON TABLE TbDivisadb.tb_TbDivisa IS 'tabla para guardar las TbDivisas del mercado';


--
-- TOC entry 2857 (class 0 OID 0)
-- Dependencies: 198
-- Name: COLUMN tb_TbDivisa.id_TbDivisa; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_TbDivisa.id_TbDivisa IS 'identificador único de la TbDivisa';


--
-- TOC entry 2858 (class 0 OID 0)
-- Dependencies: 198
-- Name: COLUMN tb_TbDivisa.nombre_TbDivisa; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_TbDivisa.nombre_TbDivisa IS 'nombre de la TbDivisa';


--
-- TOC entry 2859 (class 0 OID 0)
-- Dependencies: 198
-- Name: COLUMN tb_TbDivisa.abreviatura_TbDivisa; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_TbDivisa.abreviatura_TbDivisa IS 'abreviatura de la TbDivisa';


--
-- TOC entry 2860 (class 0 OID 0)
-- Dependencies: 198
-- Name: COLUMN tb_TbDivisa.activa; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_TbDivisa.activa IS 'estado de la TbDivisa';


--
-- TOC entry 2861 (class 0 OID 0)
-- Dependencies: 198
-- Name: COLUMN tb_TbDivisa.fecha_registro; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_TbDivisa.fecha_registro IS 'fecha de registro de la TbDivisa';


--
-- TOC entry 197 (class 1259 OID 24043)
-- Name: tb_TbDivisa_id_TbDivisa_seq; Type: SEQUENCE; Schema: TbDivisadb; Owner: TbDivisadb
--

CREATE SEQUENCE TbDivisadb.tb_TbDivisa_id_TbDivisa_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE TbDivisadb.tb_TbDivisa_id_TbDivisa_seq OWNER TO TbDivisadb;

--
-- TOC entry 2862 (class 0 OID 0)
-- Dependencies: 197
-- Name: tb_TbDivisa_id_TbDivisa_seq; Type: SEQUENCE OWNED BY; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER SEQUENCE TbDivisadb.tb_TbDivisa_id_TbDivisa_seq OWNED BY TbDivisadb.tb_TbDivisa.id_TbDivisa;


--
-- TOC entry 199 (class 1259 OID 24051)
-- Name: tb_tasacambio; Type: TABLE; Schema: TbDivisadb; Owner: TbDivisadb
--

CREATE TABLE TbDivisadb.tb_tasacambio (
    id_tasacambio integer NOT NULL,
    fecha_registro timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    id_TbDivisa1 integer NOT NULL,
    id_TbDivisa2 integer NOT NULL
);


ALTER TABLE TbDivisadb.tb_tasacambio OWNER TO TbDivisadb;

--
-- TOC entry 2863 (class 0 OID 0)
-- Dependencies: 199
-- Name: TABLE tb_tasacambio; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON TABLE TbDivisadb.tb_tasacambio IS 'tabla para representar las tasas de cambio de las TbDivisas';


--
-- TOC entry 2864 (class 0 OID 0)
-- Dependencies: 199
-- Name: COLUMN tb_tasacambio.id_tasacambio; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_tasacambio.id_tasacambio IS 'Para identificar cada una de las tasas de cambio';


--
-- TOC entry 2865 (class 0 OID 0)
-- Dependencies: 199
-- Name: COLUMN tb_tasacambio.fecha_registro; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_tasacambio.fecha_registro IS 'fecha de registro de la tasa de cambio';


--
-- TOC entry 2866 (class 0 OID 0)
-- Dependencies: 199
-- Name: COLUMN tb_tasacambio.id_TbDivisa1; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_tasacambio.id_TbDivisa1 IS 'llave foránea de la TbDivisa primaria';


--
-- TOC entry 2867 (class 0 OID 0)
-- Dependencies: 199
-- Name: COLUMN tb_tasacambio.id_TbDivisa2; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_tasacambio.id_TbDivisa2 IS 'llave foránea de la TbDivisa secundaria
';


--
-- TOC entry 200 (class 1259 OID 24054)
-- Name: tb_tasacambio_id_tasacambio_seq; Type: SEQUENCE; Schema: TbDivisadb; Owner: TbDivisadb
--

CREATE SEQUENCE TbDivisadb.tb_tasacambio_id_tasacambio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE TbDivisadb.tb_tasacambio_id_tasacambio_seq OWNER TO TbDivisadb;

--
-- TOC entry 2868 (class 0 OID 0)
-- Dependencies: 200
-- Name: tb_tasacambio_id_tasacambio_seq; Type: SEQUENCE OWNED BY; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER SEQUENCE TbDivisadb.tb_tasacambio_id_tasacambio_seq OWNED BY TbDivisadb.tb_tasacambio.id_tasacambio;


--
-- TOC entry 203 (class 1259 OID 24087)
-- Name: tb_valortasacambio; Type: TABLE; Schema: TbDivisadb; Owner: TbDivisadb
--

CREATE TABLE TbDivisadb.tb_valortasacambio (
    id_valortasacambio integer NOT NULL,
    id_tasacambio integer NOT NULL,
    valortasacambio double precision NOT NULL,
    fecha_valortasacambio timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


ALTER TABLE TbDivisadb.tb_valortasacambio OWNER TO TbDivisadb;

--
-- TOC entry 2869 (class 0 OID 0)
-- Dependencies: 203
-- Name: TABLE tb_valortasacambio; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON TABLE TbDivisadb.tb_valortasacambio IS 'Establece el valor de la tasa de cambio en un tiempo  especifico.';


--
-- TOC entry 2870 (class 0 OID 0)
-- Dependencies: 203
-- Name: COLUMN tb_valortasacambio.id_valortasacambio; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_valortasacambio.id_valortasacambio IS 'identificador único del valor de la tasa de cambio';


--
-- TOC entry 2871 (class 0 OID 0)
-- Dependencies: 203
-- Name: COLUMN tb_valortasacambio.id_tasacambio; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_valortasacambio.id_tasacambio IS 'id de la tasa de cambio a la cual se le va asignar valor';


--
-- TOC entry 2872 (class 0 OID 0)
-- Dependencies: 203
-- Name: COLUMN tb_valortasacambio.valortasacambio; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_valortasacambio.valortasacambio IS 'Establece el valor de la tasa de cambio';


--
-- TOC entry 2873 (class 0 OID 0)
-- Dependencies: 203
-- Name: COLUMN tb_valortasacambio.fecha_valortasacambio; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON COLUMN TbDivisadb.tb_valortasacambio.fecha_valortasacambio IS 'Fecha del registro del valor de la tasa de cambio';


--
-- TOC entry 204 (class 1259 OID 24090)
-- Name: tb_valortasacambio_id_valortasacambio_seq; Type: SEQUENCE; Schema: TbDivisadb; Owner: TbDivisadb
--

CREATE SEQUENCE TbDivisadb.tb_valortasacambio_id_valortasacambio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE TbDivisadb.tb_valortasacambio_id_valortasacambio_seq OWNER TO TbDivisadb;

--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 204
-- Name: tb_valortasacambio_id_valortasacambio_seq; Type: SEQUENCE OWNED BY; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER SEQUENCE TbDivisadb.tb_valortasacambio_id_valortasacambio_seq OWNED BY TbDivisadb.tb_valortasacambio.id_valortasacambio;


--
-- TOC entry 2694 (class 2604 OID 24073)
-- Name: tb_cotizacion id_cotizacion; Type: DEFAULT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_cotizacion ALTER COLUMN id_cotizacion SET DEFAULT nextval('TbDivisadb.tb_cotizacion_id_cotizacion_seq'::regclass);


--
-- TOC entry 2689 (class 2604 OID 24048)
-- Name: tb_TbDivisa id_TbDivisa; Type: DEFAULT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_TbDivisa ALTER COLUMN id_TbDivisa SET DEFAULT nextval('TbDivisadb.tb_TbDivisa_id_TbDivisa_seq'::regclass);


--
-- TOC entry 2692 (class 2604 OID 24056)
-- Name: tb_tasacambio id_tasacambio; Type: DEFAULT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_tasacambio ALTER COLUMN id_tasacambio SET DEFAULT nextval('TbDivisadb.tb_tasacambio_id_tasacambio_seq'::regclass);


--
-- TOC entry 2696 (class 2604 OID 24092)
-- Name: tb_valortasacambio id_valortasacambio; Type: DEFAULT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_valortasacambio ALTER COLUMN id_valortasacambio SET DEFAULT nextval('TbDivisadb.tb_valortasacambio_id_valortasacambio_seq'::regclass);


--
-- TOC entry 2699 (class 2606 OID 24050)
-- Name: tb_TbDivisa id_TbDivisa_pk; Type: CONSTRAINT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_TbDivisa
    ADD CONSTRAINT id_TbDivisa_pk PRIMARY KEY (id_TbDivisa);


--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 2699
-- Name: CONSTRAINT id_TbDivisa_pk ON tb_TbDivisa; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON CONSTRAINT id_TbDivisa_pk ON TbDivisadb.tb_TbDivisa IS 'LLAVE PRIMARIA';


--
-- TOC entry 2711 (class 2606 OID 24078)
-- Name: tb_cotizacion pk_id_cotizacion; Type: CONSTRAINT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_cotizacion
    ADD CONSTRAINT pk_id_cotizacion PRIMARY KEY (id_cotizacion);


--
-- TOC entry 2876 (class 0 OID 0)
-- Dependencies: 2711
-- Name: CONSTRAINT pk_id_cotizacion ON tb_cotizacion; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON CONSTRAINT pk_id_cotizacion ON TbDivisadb.tb_cotizacion IS 'llave primaria';


--
-- TOC entry 2706 (class 2606 OID 24061)
-- Name: tb_tasacambio pk_id_tasacambio; Type: CONSTRAINT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_tasacambio
    ADD CONSTRAINT pk_id_tasacambio PRIMARY KEY (id_tasacambio);


--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 2706
-- Name: CONSTRAINT pk_id_tasacambio ON tb_tasacambio; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON CONSTRAINT pk_id_tasacambio ON TbDivisadb.tb_tasacambio IS 'llave primaria';


--
-- TOC entry 2701 (class 2606 OID 24152)
-- Name: tb_TbDivisa tb_TbDivisa_abreviatura_un; Type: CONSTRAINT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_TbDivisa
    ADD CONSTRAINT tb_TbDivisa_abreviatura_un UNIQUE (abreviatura_TbDivisa);


--
-- TOC entry 2703 (class 2606 OID 24150)
-- Name: tb_TbDivisa tb_TbDivisa_nombre_un; Type: CONSTRAINT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_TbDivisa
    ADD CONSTRAINT tb_TbDivisa_nombre_un UNIQUE (nombre_TbDivisa);


--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 2703
-- Name: CONSTRAINT tb_TbDivisa_nombre_un ON tb_TbDivisa; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON CONSTRAINT tb_TbDivisa_nombre_un ON TbDivisadb.tb_TbDivisa IS 'Nombre único';


--
-- TOC entry 2708 (class 2606 OID 24154)
-- Name: tb_tasacambio tb_tasacambio_un; Type: CONSTRAINT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_tasacambio
    ADD CONSTRAINT tb_tasacambio_un UNIQUE (id_TbDivisa1, id_TbDivisa2);


--
-- TOC entry 2713 (class 2606 OID 24161)
-- Name: tb_valortasacambio tb_valortasacambio_fecha_un; Type: CONSTRAINT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_valortasacambio
    ADD CONSTRAINT tb_valortasacambio_fecha_un UNIQUE (id_tasacambio, fecha_valortasacambio);


--
-- TOC entry 2715 (class 2606 OID 24135)
-- Name: tb_valortasacambio tb_valortasacambio_pk; Type: CONSTRAINT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_valortasacambio
    ADD CONSTRAINT tb_valortasacambio_pk PRIMARY KEY (id_valortasacambio);


--
-- TOC entry 2717 (class 2606 OID 24163)
-- Name: tb_valortasacambio tb_valortasacambio_un; Type: CONSTRAINT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_valortasacambio
    ADD CONSTRAINT tb_valortasacambio_un UNIQUE (valortasacambio, fecha_valortasacambio, id_tasacambio);


--
-- TOC entry 2704 (class 1259 OID 24067)
-- Name: fki_fk_id_TbDivisa1; Type: INDEX; Schema: TbDivisadb; Owner: TbDivisadb
--

CREATE INDEX fki_fk_id_TbDivisa1 ON TbDivisadb.tb_tasacambio USING btree (id_TbDivisa1);


--
-- TOC entry 2709 (class 1259 OID 24084)
-- Name: fki_fk_id_tasacambio; Type: INDEX; Schema: TbDivisadb; Owner: TbDivisadb
--

CREATE INDEX fki_fk_id_tasacambio ON TbDivisadb.tb_cotizacion USING btree (id_valortasacambio);


--
-- TOC entry 2718 (class 2606 OID 24062)
-- Name: tb_tasacambio fk_id_TbDivisa1; Type: FK CONSTRAINT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_tasacambio
    ADD CONSTRAINT fk_id_TbDivisa1 FOREIGN KEY (id_TbDivisa1) REFERENCES TbDivisadb.tb_TbDivisa(id_TbDivisa) NOT VALID;


--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 2718
-- Name: CONSTRAINT fk_id_TbDivisa1 ON tb_tasacambio; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON CONSTRAINT fk_id_TbDivisa1 ON TbDivisadb.tb_tasacambio IS 'llave foránea con TbDivisa';


--
-- TOC entry 2719 (class 2606 OID 24196)
-- Name: tb_tasacambio fk_id_TbDivisa2; Type: FK CONSTRAINT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_tasacambio
    ADD CONSTRAINT fk_id_TbDivisa2 FOREIGN KEY (id_TbDivisa2) REFERENCES TbDivisadb.tb_TbDivisa(id_TbDivisa);


--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 2719
-- Name: CONSTRAINT fk_id_TbDivisa2 ON tb_tasacambio; Type: COMMENT; Schema: TbDivisadb; Owner: TbDivisadb
--

COMMENT ON CONSTRAINT fk_id_TbDivisa2 ON TbDivisadb.tb_tasacambio IS 'llave foránea con TbDivisa';


--
-- TOC entry 2720 (class 2606 OID 24170)
-- Name: tb_cotizacion tb_cotizacion_fk; Type: FK CONSTRAINT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_cotizacion
    ADD CONSTRAINT tb_cotizacion_fk FOREIGN KEY (id_valortasacambio) REFERENCES TbDivisadb.tb_valortasacambio(id_valortasacambio);


--
-- TOC entry 2721 (class 2606 OID 24136)
-- Name: tb_valortasacambio tb_valortasacambio_fk; Type: FK CONSTRAINT; Schema: TbDivisadb; Owner: TbDivisadb
--

ALTER TABLE ONLY TbDivisadb.tb_valortasacambio
    ADD CONSTRAINT tb_valortasacambio_fk FOREIGN KEY (id_tasacambio) REFERENCES TbDivisadb.tb_tasacambio(id_tasacambio);


-- Completed on 2019-12-03 00:16:10

--
-- PostgreSQL database dump complete
--

