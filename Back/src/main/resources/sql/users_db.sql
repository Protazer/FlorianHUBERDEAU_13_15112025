DROP TABLE IF EXISTS public."user" CASCADE;

CREATE TABLE public."user" (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    date_of_birth DATE,
    zipcode VARCHAR(20),
    phone_number VARCHAR(30),
    city VARCHAR(100),
    country VARCHAR(100),
    address VARCHAR(255),
    created_at VARCHAR(255),
    updated_at VARCHAR(255)
);