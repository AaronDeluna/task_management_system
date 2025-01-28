CREATE TABLE users (
    id serial primary key,
    name varchar(50),
    email varchar(50) unique,
    password varchar(100)
);


insert into users (name, email, password) values ('ivan', 'aa@mail.ru', '1234');

select *
from users;

