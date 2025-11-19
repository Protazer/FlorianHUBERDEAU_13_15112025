DROP TABLE IF EXISTS public.agency CASCADE;

CREATE TABLE public.agency (
    id BIGSERIAL PRIMARY KEY,
    address VARCHAR(100) NOT NULL ,
    city VARCHAR(100) NOT NULL ,
    country VARCHAR(100) NOT NULL ,
    name VARCHAR(255) NOT NULL
);


