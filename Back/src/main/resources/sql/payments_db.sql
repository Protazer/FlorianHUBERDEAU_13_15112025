DROP TABLE IF EXISTS public.payment CASCADE;
DROP TABLE IF EXISTS public.refund CASCADE;

CREATE TABLE public.payment (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    reservation_id BIGINT,
    amount DOUBLE PRECISION NOT NULL,
    currency VARCHAR(10),
    payment_provider VARCHAR(50),
    status VARCHAR(50),
    provider_payment_id VARCHAR(255),
    created_date DATE
);

CREATE TABLE public.refund (
    id BIGSERIAL PRIMARY KEY,
    payment_id BIGINT,
    refund_amount DOUBLE PRECISION NOT NULL,
    refunded_at DATE
);