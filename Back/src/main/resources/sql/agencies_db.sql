DROP TABLE IF EXISTS public.agency CASCADE;

CREATE TABLE public.agency (
    id BIGSERIAL PRIMARY KEY,
    address VARCHAR(100),
    city VARCHAR(100),
    country VARCHAR(100),
    name VARCHAR(255)
);


