DROP TABLE IF EXISTS public.notification CASCADE;

CREATE TABLE public.notification (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL ,
    status VARCHAR(20) NOT NULL ,
    type VARCHAR(50) NOT NULL ,
    message VARCHAR(255) NOT NULL ,
    created_date DATE NOT NULL ,
    sent_at DATE NOT NULL
);