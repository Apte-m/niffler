create table friends
(
id                      UUID unique        not null default uuid_generate_v1(),
username                varchar(50) unique not null,
primary key (id)
);

-- ALTER TABLE users ADD CONSTRAINT fr_id FOREIGN KEY (fr_id) REFERENCES friends (id)