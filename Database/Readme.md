# Création du base de donnés
```sql
-- DROP DATABASE IF EXISTS "foracademy";
CREATE DATABASE "foracademy"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
```
# Creation des tableaux
- Users:
```sql
CREATE TABLE IF NOT EXISTS users
(
    id_user INT NOT NULL,
    first_name VARCHAR(45),
    last_name VARCHAR(45),
    address_id int ,
    phone VARCHAR(14),
    email VARCHAR(145) UNIQUE,
    password TEXT,
	CONSTRAINT id_user PRIMARY KEY (id_user)
);
```
- Address:
```sql
CREATE TABLE IF NOT EXISTS address
(
    id_adress INT NOT NULL,
    postal_code VARCHAR(45),
    city VARCHAR(45),
    street VARCHAR(150),
    id_user INT ,
	CONSTRAINT id_adress PRIMARY KEY (id_adress),
    FOREIGN KEY (id_user) REFERENCES users(id_user)
);
```
- Event:
```sql
CREATE TABLE IF NOT EXISTS event
(
    id_event INT NOT NULL,
    name VARCHAR(45),
    date DATE,
    description TEXT,
    status int,
	id_user INT,
	CONSTRAINT id_event PRIMARY KEY (id_event),
    FOREIGN KEY (id_user) REFERENCES users(id_user)    
)
```
- Attendance:
```sql
CREATE TABLE IF NOT EXISTS attendance
(
    id_attendance INT NOT NULL,
    date DATE,
    arrival_hour TIME,
    departure_hour TIME,
	id_user INT,
	CONSTRAINT id_attendance PRIMARY KEY (id_attendance),
    FOREIGN KEY (id_user) REFERENCES users(id_user)
)
```
- Role:
```sql
CREATE TABLE IF NOT EXISTS role
(
    id_role INT NOT NULL,
    name VARCHAR(45),
    privileges JSON,
	id_user INT,
	CONSTRAINT id_role PRIMARY KEY (id_role),
    FOREIGN KEY (id_user) REFERENCES users(id_user)
)
```
- Admin:
```sql
CREATE TABLE IF NOT EXISTS admin
(
    id_admin INT NOT NULL,
	CONSTRAINT id_admin PRIMARY KEY (id_admin)
) INHERITS (users);
```
- Promotion:
```sql
DROP TABLE IF EXISTS promotion;
CREATE TABLE IF NOT EXISTS promotion(
    id_promotion NOT NULL AUTO_INCREMENT,
    name VARCHAR(45),
    year INT(4),
    start_date DATE,
    end_date DATE
)
ALTER TABLE IF EXISTS promotion OWNER to postgres;
```
- Speciality:
```sql
DROP TABLE IF EXISTS speciality;
CREATE TABLE IF NOT EXISTS speciality(
    id_speciality NOT NULL AUTO_INCREMENT,
    name VARCHAR(45)
)
ALTER TABLE IF EXISTS speciality OWNER to postgres;
```
- ClassRoom:
```sql
DROP TABLE IF EXISTS classRoom;
CREATE TABLE IF NOT EXISTS classRoom(
    id_classRoom NOT NULL AUTO_INCREMENT,
    name VARCHER(45),
    day_start_hour TIME,
    day_end_hour TIME,
)
ALTER TABLE IF EXISTS classRoom OWNER to postgres;
```
- Student:
```sql
DROP TABLE IF EXISTS student;
CREATE TABLE IF NOT EXISTS student(
    id_student NOT NULL AUTO_INCREMENT,
)
ALTER TABLE IF EXISTS student OWNER to postgres;
```
- Manager
```sql
DROP TABLE IF EXISTS manager;
CREATE TABLE IF NOT EXISTS manager (
    id_manager NOT NULL AUTO_INCREMENT
    enrty_date DATE
)
ALTER TABLE IF EXISTS manager OWNER to postgres;
```
- Secretary
```sql
DROP TABLE IF EXISTS secretary;
CREATE TABLE IF NOT EXISTS secretary (
    id_secretary NOT NULL AUTO_INCREMENT
    enrty_date DATE
)
ALTER TABLE IF EXISTS secretary OWNER to postgres;
```
- Teacher
```sql
DROP TABLE IF EXISTS teacher;
CREATE TABLE IF NOT EXISTS teacher (
    id_teacher NOT NULL AUTO_INCREMENT
)
ALTER TABLE IF EXISTS teacher OWNER to postgres;
```