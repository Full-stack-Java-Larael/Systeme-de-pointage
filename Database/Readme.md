# Création du base de donnés
```sql
-- DROP DATABASE IF EXISTS "foracademy";

CREATE DATABASE "foracademy"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
```
# Creation des tableaux
- Address:
```sql
DROP TABLE IF EXISTS adress;
CREATE TABLE IF NOT EXISTS address
(
    id NOT NULL AUTO_INCREMENT,
    postal_code VARCHAR(45),
    city VARCHAR(45),
    street VARCHAR(150)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS address OWNER to postgres;
```
- Users:
```sql
DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user
(
    id NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(45),
    last_name VARCHAR(45),
    address_id int 
    phone VARCHAR(14),
    email VARCHAR(145) UNIQUE,
    password TEXT,
    FOREIGN KEY (address_id) REFERENCES adress(id)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS users OWNER to postgres;
```
- Event:
```sql
DROP TABLE IF EXISTS event;
CREATE TABLE IF NOT EXISTS event
(
    id NOT NULL AUTO_INCREMENT,
    name VARCHAR(45),
    date DATE,
    description TEXT,
    status int,
    
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS event OWNER to postgres;
```
- Attendance:
```sql
DROP TABLE IF EXISTS attendance;
CREATE TABLE IF NOT EXISTS attendance
(
    id NOT NULL AUTO_INCREMENT,
    date DATE,
    arrival_hour TIME
    departure_hour TIME
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS attendance OWNER to postgres;
```
- Role:
```sql
DROP TABLE IF EXISTS role;
CREATE TABLE IF NOT EXISTS role
(
    id NOT NULL AUTO_INCREMENT,
    name VARCHAR(45)
    privileges JSON
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS role OWNER to postgres;
```
- Admin:
```sql
DROP TABLE IF EXISTS admin;
CREATE TABLE IF NOT EXISTS admin
(
    id NOT NULL AUTO_INCREMENT,
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS admin OWNER to postgres;
```
- Promotion:
```sql
DROP TABLE IF EXISTS promotion;
CREATE TABLE IF NOT EXISTS promotion(
    id NOT NULL AUTO_INCREMENT,
    name VARCHAR(45),
    year INT(4),
    start_date DATE,
    end_date DATE
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS promotion OWNER to postgres;
```
- Speciality:
```sql
DROP TABLE IF EXISTS speciality;
CREATE TABLE IF NOT EXISTS speciality(
    id NOT NULL AUTO_INCREMENT,
    name VARCHAR(45)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS speciality OWNER to postgres;
```
- ClassRoom:
```sql
DROP TABLE IF EXISTS classRoom;
CREATE TABLE IF NOT EXISTS classRoom(
    id NOT NULL AUTO_INCREMENT,
    name VARCHER(45),
    day_start_hour TIME,
    day_end_hour TIME,
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS classRoom OWNER to postgres;
```
- Student:
```sql
DROP TABLE IF EXISTS student;
CREATE TABLE IF NOT EXISTS student(
    id NOT NULL AUTO_INCREMENT,
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS student OWNER to postgres;
```
- Manager
```sql
DROP TABLE IF EXISTS manager;
CREATE TABLE IF NOT EXISTS manager (
    id NOT NULL AUTO_INCREMENT
    enrty_date DATE
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS manager OWNER to postgres;
```
- Secretary
```sql
DROP TABLE IF EXISTS secretary;
CREATE TABLE IF NOT EXISTS secretary (
    id NOT NULL AUTO_INCREMENT
    enrty_date DATE
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS secretary OWNER to postgres;
```
- Teacher
```sql
DROP TABLE IF EXISTS teacher;
CREATE TABLE IF NOT EXISTS teacher (
    id NOT NULL AUTO_INCREMENT
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS teacher OWNER to postgres;
```