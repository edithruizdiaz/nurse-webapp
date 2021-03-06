PGDMP     $                    x           nursery    10.11    10.11     �
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �
           1262    24585    nursery    DATABASE     �   CREATE DATABASE nursery WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE nursery;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �
           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �
           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    24588    patient    TABLE     �   CREATE TABLE public.patient (
    id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    age integer,
    gender character varying,
    date_added timestamp without time zone
);
    DROP TABLE public.patient;
       public         postgres    false    3            �            1259    24586    patient_id_seq    SEQUENCE     �   CREATE SEQUENCE public.patient_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.patient_id_seq;
       public       postgres    false    3    197            �
           0    0    patient_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.patient_id_seq OWNED BY public.patient.id;
            public       postgres    false    196            o
           2604    24591 
   patient id    DEFAULT     h   ALTER TABLE ONLY public.patient ALTER COLUMN id SET DEFAULT nextval('public.patient_id_seq'::regclass);
 9   ALTER TABLE public.patient ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    196    197    197            �
          0    24588    patient 
   TABLE DATA               U   COPY public.patient (id, first_name, last_name, age, gender, date_added) FROM stdin;
    public       postgres    false    197   �       �
           0    0    patient_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.patient_id_seq', 1, false);
            public       postgres    false    196            q
           2606    24596    patient patient_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.patient
    ADD CONSTRAINT patient_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.patient DROP CONSTRAINT patient_pkey;
       public         postgres    false    197            �
      x������ � �     