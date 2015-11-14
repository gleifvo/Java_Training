--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.5
-- Dumped by pg_dump version 9.4.5
-- Started on 2015-11-14 16:00:05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 2031 (class 1262 OID 12135)
-- Dependencies: 2030
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 180 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2034 (class 0 OID 0)
-- Dependencies: 180
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 179 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2035 (class 0 OID 0)
-- Dependencies: 179
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 178 (class 1259 OID 16444)
-- Name: route_2transport; Type: TABLE; Schema: public; Owner: user; Tablespace: 
--

CREATE TABLE route_2transport (
    id_route integer,
    id_transport integer
);


ALTER TABLE route_2transport OWNER TO "user";

--
-- TOC entry 172 (class 1259 OID 16397)
-- Name: routes; Type: TABLE; Schema: public; Owner: user; Tablespace: 
--

CREATE TABLE routes (
    id integer NOT NULL,
    "interval" smallint
);


ALTER TABLE routes OWNER TO "user";

--
-- TOC entry 173 (class 1259 OID 16406)
-- Name: routes_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE routes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE routes_id_seq OWNER TO "user";

--
-- TOC entry 2036 (class 0 OID 0)
-- Dependencies: 173
-- Name: routes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE routes_id_seq OWNED BY routes.id;


--
-- TOC entry 176 (class 1259 OID 16425)
-- Name: transport; Type: TABLE; Schema: public; Owner: user; Tablespace: 
--

CREATE TABLE transport (
    id integer NOT NULL,
    registration_number name,
    type_id integer
);


ALTER TABLE transport OWNER TO "user";

--
-- TOC entry 177 (class 1259 OID 16428)
-- Name: transport_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE transport_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE transport_id_seq OWNER TO "user";

--
-- TOC entry 2037 (class 0 OID 0)
-- Dependencies: 177
-- Name: transport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE transport_id_seq OWNED BY transport.id;


--
-- TOC entry 174 (class 1259 OID 16414)
-- Name: transport_type; Type: TABLE; Schema: public; Owner: user; Tablespace: 
--

CREATE TABLE transport_type (
    id integer NOT NULL,
    "transportType" name,
    capacity smallint,
    "maxSpeed" smallint
);


ALTER TABLE transport_type OWNER TO "user";

--
-- TOC entry 175 (class 1259 OID 16417)
-- Name: transport_type_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE transport_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE transport_type_id_seq OWNER TO "user";

--
-- TOC entry 2038 (class 0 OID 0)
-- Dependencies: 175
-- Name: transport_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE transport_type_id_seq OWNED BY transport_type.id;


--
-- TOC entry 1898 (class 2604 OID 16408)
-- Name: id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY routes ALTER COLUMN id SET DEFAULT nextval('routes_id_seq'::regclass);


--
-- TOC entry 1900 (class 2604 OID 16430)
-- Name: id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY transport ALTER COLUMN id SET DEFAULT nextval('transport_id_seq'::regclass);


--
-- TOC entry 1899 (class 2604 OID 16419)
-- Name: id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY transport_type ALTER COLUMN id SET DEFAULT nextval('transport_type_id_seq'::regclass);


--
-- TOC entry 1913 (class 2606 OID 16460)
-- Name: route_2transport_id_route_id_transport_key; Type: CONSTRAINT; Schema: public; Owner: user; Tablespace: 
--

ALTER TABLE ONLY route_2transport
    ADD CONSTRAINT route_2transport_id_route_id_transport_key UNIQUE (id_route, id_transport);


--
-- TOC entry 1902 (class 2606 OID 16413)
-- Name: routes_pkey; Type: CONSTRAINT; Schema: public; Owner: user; Tablespace: 
--

ALTER TABLE ONLY routes
    ADD CONSTRAINT routes_pkey PRIMARY KEY (id);


--
-- TOC entry 1909 (class 2606 OID 16435)
-- Name: transport_pkey; Type: CONSTRAINT; Schema: public; Owner: user; Tablespace: 
--

ALTER TABLE ONLY transport
    ADD CONSTRAINT transport_pkey PRIMARY KEY (id);


--
-- TOC entry 1904 (class 2606 OID 16424)
-- Name: transport_type_pkey; Type: CONSTRAINT; Schema: public; Owner: user; Tablespace: 
--

ALTER TABLE ONLY transport_type
    ADD CONSTRAINT transport_type_pkey PRIMARY KEY (id);


--
-- TOC entry 1906 (class 2606 OID 16443)
-- Name: type; Type: CONSTRAINT; Schema: public; Owner: user; Tablespace: 
--

ALTER TABLE ONLY transport_type
    ADD CONSTRAINT type UNIQUE ("transportType");


--
-- TOC entry 1910 (class 1259 OID 16452)
-- Name: fki_routes_2transport; Type: INDEX; Schema: public; Owner: user; Tablespace: 
--

CREATE INDEX fki_routes_2transport ON route_2transport USING btree (id_route);


--
-- TOC entry 1911 (class 1259 OID 16458)
-- Name: fki_transport_2routes; Type: INDEX; Schema: public; Owner: user; Tablespace: 
--

CREATE INDEX fki_transport_2routes ON route_2transport USING btree (id_transport);


--
-- TOC entry 1907 (class 1259 OID 16441)
-- Name: fki_transport_2type; Type: INDEX; Schema: public; Owner: user; Tablespace: 
--

CREATE INDEX fki_transport_2type ON transport USING btree (type_id);


--
-- TOC entry 1915 (class 2606 OID 16447)
-- Name: routes_2transport; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY route_2transport
    ADD CONSTRAINT routes_2transport FOREIGN KEY (id_route) REFERENCES routes(id);


--
-- TOC entry 1916 (class 2606 OID 16453)
-- Name: transport_2routes; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY route_2transport
    ADD CONSTRAINT transport_2routes FOREIGN KEY (id_transport) REFERENCES transport(id);


--
-- TOC entry 1914 (class 2606 OID 16436)
-- Name: transport_2type; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY transport
    ADD CONSTRAINT transport_2type FOREIGN KEY (type_id) REFERENCES transport_type(id);


--
-- TOC entry 2033 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-11-14 16:00:05

--
-- PostgreSQL database dump complete
--

