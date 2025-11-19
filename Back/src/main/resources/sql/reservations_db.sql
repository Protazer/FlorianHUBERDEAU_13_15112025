DROP TABLE IF EXISTS public.reservation CASCADE;

CREATE TABLE public.reservation (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    vehicle_id BIGINT,
    pickup_agency_id BIGINT,
    return_agency_id BIGINT,
    total_price DOUBLE PRECISION NOT NULL,
    status VARCHAR(50),
    created_date DATE,
    pickup_datetime DATE,
    return_datetime DATE
);