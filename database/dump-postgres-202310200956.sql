--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

-- Started on 2023-10-20 09:56:20

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 266 (class 1259 OID 17526)
-- Name: konsumen; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.konsumen (
    id integer NOT NULL,
    nama character varying,
    alamat text,
    kota bpchar,
    provinsi bpchar,
    tgl_registrasi date,
    status bpchar
);


--
-- TOC entry 3437 (class 0 OID 17526)
-- Dependencies: 266
-- Data for Name: konsumen; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.konsumen VALUES (121523123, 'Aldira', 'Komplek Margaasih', 'Bandung', 'Jawa Barat', '2023-04-17', 'Aktif');
INSERT INTO public.konsumen VALUES (1, 'Fikri', 'Sukajadi', 'Bandung', 'Jawa Barat', '2023-10-19', 'Aktif');
INSERT INTO public.konsumen VALUES (2, 'Raka', 'Margahayu', 'Bandung', 'Jawa Barat', '2023-10-20', 'Aktif');
INSERT INTO public.konsumen VALUES (3, 'Mugi', 'Padalarang', 'Bandung Barat', 'Jawa Barat', '2023-10-20', 'Aktif');
INSERT INTO public.konsumen VALUES (4, 'Alfatt', 'Gegerkalong', 'Bandung', 'Jawa Barat', '2023-10-20', 'Aktif');


--
-- TOC entry 3294 (class 2606 OID 17532)
-- Name: konsumen konsumen_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.konsumen
    ADD CONSTRAINT konsumen_pk PRIMARY KEY (id);


-- Completed on 2023-10-20 09:56:20

--
-- PostgreSQL database dump complete
--

