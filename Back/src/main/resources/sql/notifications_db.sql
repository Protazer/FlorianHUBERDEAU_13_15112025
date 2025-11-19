DROP TABLE IF EXISTS public.notification CASCADE;

CREATE TABLE public.notification (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    status VARCHAR(20),
    type VARCHAR(50),
    message VARCHAR(255),
    created_date DATE,
    sent_at DATE
);