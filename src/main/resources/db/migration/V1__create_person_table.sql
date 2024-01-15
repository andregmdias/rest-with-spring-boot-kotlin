CREATE TABLE public.tb_persons (
	id bigserial NOT NULL,
	address varchar(255) NULL,
	first_name varchar(255) NULL,
	gender varchar(255) NULL,
	last_name varchar(255) NULL,
	birthday timestamp(6) NULL,
	CONSTRAINT tb_persons_pkey PRIMARY KEY (id)
);