 1  Создать таблицу друзья

create table friends
(name varchar(50),
friends_id uuid primary key not null default '8f16e9ed-0489-4709-ada2-56d92660a3ca');

2 Добавить колонку в  user


-- ALTER TABLE users ADD COLUMN friends_id uuid not null default  '8f16e9ed-0489-4709-ada2-56d92660a3ca';

-- ALTER TABLE users ADD CONSTRAINT friends_id FOREIGN KEY (friends_id) REFERENCES users (id)


 

3
 добавить друга
insert into  friendsEntity ( name, friends_id)

VALUES ('lo','8f16e9ed-0489-4709-ada2-56d92660a3ca')


TABLE friends ADD COLUMN id bigint not null   primary key
-- ALTER TABLE users ADD COLUMN friends_id bigint
ALTER TABLE users ADD CONSTRAINT friends_id bigint FOREIGN KEY (friends_id) REFERENCES users (id);









