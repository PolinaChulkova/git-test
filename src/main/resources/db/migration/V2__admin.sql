alter table public.users
alter column password type character varying(128);

insert into public.users (login, password)
VALUES ('admin', '$2a$12$jvpQ9h4D0ocYxpNnrsAuve2gnbg/4EKry2stlgrGfoZoG0p8Z4.Ea');