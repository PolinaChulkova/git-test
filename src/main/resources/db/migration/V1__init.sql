CREATE TABLE public.users
(
    user_id bigserial NOT NULL,
    login character varying(40) NOT NULL,
    password character varying(40) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.entities
(
    entity_id bigserial NOT NULL,
    user_id bigint NOT NULL,
    name character varying(128) NOT NULL,
    PRIMARY KEY (entity_id),
    CONSTRAINT fk_users_user_id FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
