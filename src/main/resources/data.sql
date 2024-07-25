-- Database: hibernate

-- DROP DATABASE IF EXISTS hibernate;

CREATE DATABASE hibernate
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;


-- SCHEMA: app

-- DROP SCHEMA IF EXISTS app ;

CREATE SCHEMA IF NOT EXISTS app
    AUTHORIZATION postgres;

CREATE TABLE app.user
(
    username VARCHAR(128) PRIMARY KEY,
    firstname VARCHAR(128),
    lastname VARCHAR(128) ,
    birth_date DATE,
    age INT
);

SELECT * FROM app.user;