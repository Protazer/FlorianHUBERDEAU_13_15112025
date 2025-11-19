DROP TABLE IF EXISTS public.message CASCADE;
DROP TABLE IF EXISTS public.session CASCADE;

CREATE TABLE public.session (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    status VARCHAR(20) NOT NULL ,
    created_at TIMESTAMP NOT NULL,
    closed_at TIMESTAMP
);

CREATE TABLE public.message (
    id BIGSERIAL PRIMARY KEY,
    session_id BIGINT REFERENCES public.session(id),
    sender VARCHAR(20) NOT NULL,
    content VARCHAR(255),
    sent_at TIMESTAMP NOT NULL
);