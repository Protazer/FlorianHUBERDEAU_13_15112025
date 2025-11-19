DROP TABLE IF EXISTS public.payment CASCADE;
DROP TABLE IF EXISTS public.refund CASCADE;

CREATE TABLE public.payment (
    payment_id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL ,
    reservation_id BIGINT NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    currency VARCHAR(10) NOT NULL,
    payment_provider VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    provider_payment_id VARCHAR(255) NOT NULL,
    created_date DATE NOT NULL
);

CREATE TABLE public.refund (
    refund_id BIGSERIAL PRIMARY KEY,
    payment_id BIGINT REFERENCE public.payment(id),
    refund_amount DOUBLE PRECISION NOT NULL,
    refunded_at DATE NOT NULL
);