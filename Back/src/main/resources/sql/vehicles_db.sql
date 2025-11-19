DROP TABLE IF EXISTS public.vehicle CASCADE;

CREATE TABLE public.vehicle (
    id BIGSERIAL PRIMARY KEY,
    agency_id BIGINT NOT NULL,
    acriss_code VARCHAR(4) NOT NULL,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    year INT NOT NULL,
    daily_price DOUBLE PRECISION NOT NULL,
    available BOOLEAN NOT NULL
);