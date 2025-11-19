DROP TABLE IF EXISTS public.message CASCADE;
DROP TABLE IF EXISTS public.session CASCADE;

CREATE TABLE public.session (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    status VARCHAR(20),
    created_at TIMESTAMP,
    closed_at TIMESTAMP
);

CREATE TABLE public.message (
    id BIGSERIAL PRIMARY KEY,
    session_id BIGINT REFERENCES public.session(id),
    sender VARCHAR(20),
    content VARCHAR(255),
    sent_at TIMESTAMP
);