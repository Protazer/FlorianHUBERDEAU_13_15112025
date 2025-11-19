DROP TABLE IF EXISTS public.vehicle CASCADE;

CREATE TABLE public.vehicle (
    id BIGSERIAL PRIMARY KEY,
    agency_id BIGINT,
    acriss_code VARCHAR(4),
    brand VARCHAR(100),
    model VARCHAR(100),
    "year" INT,
    daily_price DOUBLE PRECISION NOT NULL,
    available BOOLEAN NOT NULL
);