CREATE TABLE IF NOT EXISTS department
(
    id          INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1 INCREMENT BY 1) PRIMARY KEY,
    name  VARCHAR(50) UNIQUE,
    Description VARCHAR(50) UNIQUE
);

CREATE TABLE IF NOT EXISTS employees
(
    id           INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1 INCREMENT BY 1) PRIMARY KEY,
    first_name VARCHAR(50) UNIQUE,
    second_name VARCHAR(50) UNIQUE,
    birth_date Date,
    hire_date Date,
    salary numeric(15,5),
    jobtitles_id INTEGER NOT NULL FOREIGN KEY REFERENCES jobtitles (id)
    department_id INTEGER NOT NULL FOREIGN KEY REFERENCES department (id)
);

CREATE TABLE IF NOT EXISTS jobtitles
(
    id          INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1 INCREMENT BY 1) PRIMARY KEY,
    name        VARCHAR(100) UNIQUE
);

