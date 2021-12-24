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
    id_user SERIAL NOT NULL,
    first_name VARCHAR(45),
    last_name VARCHAR(45),
    id_address int ,
    id_role int,
    phone VARCHAR(14),
    email VARCHAR(145) UNIQUE,
    password TEXT,
	CONSTRAINT id_user PRIMARY KEY (id_user),
    FOREIGN KEY (id_address) REFERENCES address(id_address),
    FOREIGN KEY (id_role) REFERENCES role(id_role)
);
```
- Address:
```sql
CREATE TABLE IF NOT EXISTS address
(
    id_adress SERIAL NOT NULL,
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
    id_event SERIAL NOT NULL,
    name VARCHAR(45),
    date DATE,
    description TEXT,
    status int,
	id_user INT,
	CONSTRAINT id_event PRIMARY KEY (id_event),
    FOREIGN KEY (id_user) REFERENCES users(id_user)    
);
```
- Attendance:
```sql
CREATE TABLE IF NOT EXISTS attendance
(
    id_attendance SERIAL NOT NULL,
    date DATE,
    arrival_hour TIME,
    departure_hour TIME,
	id_user INT,
	CONSTRAINT id_attendance PRIMARY KEY (id_attendance),
    FOREIGN KEY (id_user) REFERENCES users(id_user)
);
```
- Role:
```sql
CREATE TABLE IF NOT EXISTS role
(
    id_role SERIAL NOT NULL,
    name VARCHAR(45),
    privileges JSON,
	id_user INT,
	CONSTRAINT id_role PRIMARY KEY (id_role),
    FOREIGN KEY (id_user) REFERENCES users(id_user)
);
```
- Promotion:
```sql
CREATE TABLE IF NOT EXISTS promotion(
    id_promotion SERIAL NOT NULL,
    name VARCHAR(45),
    year INT,
    start_date DATE,
    end_date DATE,
	CONSTRAINT id_promotion PRIMARY KEY (id_promotion)
);
```
- Speciality:
```sql
CREATE TABLE IF NOT EXISTS speciality(
    id_speciality SERIAL NOT NULL,
    name VARCHAR(45),
	CONSTRAINT id_speciality PRIMARY KEY (id_speciality)
);
```
- ClassRoom:
```sql
CREATE TABLE IF NOT EXISTS classRoom(
    id_classRoom SERIAL NOT NULL,
    name VARCHAR(45),
    day_start_hour TIME,
    day_end_hour TIME,
	speciality INT,
	id_speciality INT,
	CONSTRAINT id_classRoom PRIMARY KEY (id_classRoom),
    FOREIGN KEY (id_speciality) REFERENCES speciality(id_speciality)
);
```
- Admin:
```sql
CREATE TABLE IF NOT EXISTS admin
(
    PRIMARY KEY (id_user)
) INHERITS (users);
```
- Student:
```sql
CREATE TABLE IF NOT EXISTS student(
    PRIMARY KEY (id_user)
) INHERITS (users);
```
- Manager
```sql
CREATE TABLE IF NOT EXISTS manager (
    enrty_date DATE,
	PRIMARY KEY (id_user)
)INHERITS (users);
```
- Secretary
```sql
CREATE TABLE IF NOT EXISTS secretary (
    enrty_date DATE,
	PRIMARY KEY (id_user)
) INHERITS (users);
```
- Teacher
```sql
CREATE TABLE IF NOT EXISTS teacher (
    PRIMARY KEY (id_user)
) INHERITS (users);
```