DROP TABLE IF EXISTS public.reservation CASCADE;

CREATE TABLE public.reservation (
    reservation_id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL ,
    vehicle_id BIGINT NOT NULL ,
    pickup_agency_id BIGINT NOT NULL ,
    return_agency_id BIGINT,
    total_price DOUBLE PRECISION NOT NULL,
    status VARCHAR(50) NOT NULL ,
    created_date TIMESTAMP NOT NULL ,
    pickup_datetime DATE NOT NULL ,
    return_datetime DATE
);