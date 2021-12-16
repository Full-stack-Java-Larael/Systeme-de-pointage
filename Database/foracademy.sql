-- DROP DATABASE IF EXISTS "foracademy";
CREATE DATABASE "foracademy"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

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

CREATE TABLE IF NOT EXISTS role
(
    id_role INT NOT NULL,
    name VARCHAR(45),
    privileges JSON,
	id_user INT,
	CONSTRAINT id_role PRIMARY KEY (id_role),
    FOREIGN KEY (id_user) REFERENCES users(id_user)
)

CREATE TABLE IF NOT EXISTS admin
(
    id_admin INT NOT NULL,
	CONSTRAINT id_admin PRIMARY KEY (id_admin)
) INHERITS (users);

CREATE TABLE IF NOT EXISTS promotion(
    id_promotion INT NOT NULL,
    name VARCHAR(45),
    year INT,
    start_date DATE,
    end_date DATE,
	CONSTRAINT id_promotion PRIMARY KEY (id_promotion)
)

CREATE TABLE IF NOT EXISTS speciality(
    id_speciality INT NOT NULL,
    name VARCHAR(45),
	CONSTRAINT id_speciality PRIMARY KEY (id_speciality)
)

CREATE TABLE IF NOT EXISTS classRoom(
    id_classRoom INT NOT NULL,
    name VARCHAR(45),
    day_start_hour TIME,
    day_end_hour TIME,
	speciality INT,
	id_speciality INT,
	CONSTRAINT id_classRoom PRIMARY KEY (id_classRoom),
    FOREIGN KEY (id_speciality) REFERENCES speciality(id_speciality)
)

CREATE TABLE IF NOT EXISTS student(
    id_student INT NOT NULL,
	CONSTRAINT id_student PRIMARY KEY (id_student)
) INHERITS (users);

CREATE TABLE IF NOT EXISTS manager (
    id_manager INT NOT NULL,
    enrty_date DATE,
	CONSTRAINT id_manager PRIMARY KEY (id_manager)
)INHERITS (users);

CREATE TABLE IF NOT EXISTS secretary (
    id_secretary INT NOT NULL,
    enrty_date DATE,
	CONSTRAINT id_secretary PRIMARY KEY (id_secretary)
) INHERITS (users);

CREATE TABLE IF NOT EXISTS teacher (
    id_teacher INT NOT NULL,
	CONSTRAINT id_teacher PRIMARY KEY (id_teacher)
) INHERITS (users);