CREATE TABLE  persons (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    birth_date date NOT NULL,
    UNIQUE (first_name, last_name)
);

CREATE TABLE models (
    id SERIAL PRIMARY KEY,
    model VARCHAR (20) UNIQUE NOT NULL
);

CREATE TABLE contacts (
    id SERIAL PRIMARY KEY,
    model_id INT REFERENCES models(id),
    telephone_number VARCHAR (25),
    contact_id INT references persons(id),
    UNIQUE (id, telephone_type)
);