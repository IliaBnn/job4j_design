-- Добавляем роли
insert into roles (description) values ('role1');
insert into roles (description) values ('role2');
insert into roles (description) values ('role3');
insert into roles (description) values ('role4');

--Добавляем правила
insert into rules (description) values ('rule1');
insert into rules (description) values ('rule2');
insert into rules (description) values ('rule3');
insert into rules (description) values ('rule4');

--Добавляем зависимости между правилами и ролями
insert into rules_roles (rule_id, role_id) values ('1', '1');
insert into rules_roles (rule_id, role_id) values ('1', '2');
insert into rules_roles (rule_id, role_id) values ('2', '2');
insert into rules_roles (rule_id, role_id) values ('2', '4');
insert into rules_roles (rule_id, role_id) values ('4', '3');

--Добавляем состояния заявок
insert into states (description) values ('state1');
insert into states (description) values ('state2');
insert into states (description) values ('state3');


--Добавляем категории заявок
insert into categories (description) values ('cat1');
insert into categories (description) values ('cat2');
insert into categories (description) values ('cat3');
insert into categories (description) values ('cat4');


--Далее можно заполнять остальные таблицы
--Добавляем пользователей
insert into users (name, role_id) values ('Ilia', '1');
insert into users (name, role_id) values ('Maks', '1');
insert into users (name, role_id) values ('Jenya', '2');
insert into users (name, role_id) values ('Liza', '3');
insert into users (name, role_id) values ('Dima', '3');
insert into users (name, role_id) values ('Katya', '4');


--Добавляем заявки
insert into items (description, category_id, state_id, user_id) values ('item1', '2', '1', '1');
insert into items (description, category_id, state_id, user_id) values ('item2', '1', '1', '3');
insert into items (description, category_id, state_id, user_id) values ('item3', '2', '1', '3');

--Добавляем комментарии к заявкам
insert into comments (text_comment, item_id) values ('comment1', 1);
insert into comments (text_comment, item_id) values ('comment2', 1);
insert into comments (text_comment, item_id) values ('comment3', 1);
insert into comments (text_comment, item_id) values ('comment4', 2);
insert into comments (text_comment, item_id) values ('comment5', 2);


--Добавляем прикрепленные файлы
insert into attachs (description, item_id) values ('attach1', '1');
insert into attachs (description, item_id) values ('attach2', '1');
insert into attachs (description, item_id) values ('attach3', '3');
insert into attachs (description, item_id) values ('attach4', '3');