create table roles (
	id serial primary key,
	description varchar(2000)
);
create table categories (
	id serial primary key,
	description varchar(2000)
);
create table rules (
	id serial primary key,
	description varchar(2000)
);

create table states (
	id serial primary key,
	description varchar(100)
);
create table users (
	id serial primary key,
	name varchar(2000),
	role_id integer references roles(id)
);
create table rules_roles (
	id serial primary key,
	rule_id integer references rules(id),
	role_id integer references roles(id)
);
create table items (
	id serial primary key,
	description varchar(2000),
	create_date timestamp not null default now(),
	category_id integer references categories(id),
	state_id integer references states(id),
	user_id integer references users(id)
);
create table comments (
	id serial primary key,
	text_comment text,
	item_id integer,
	foreign key (item_id) references items(id)
);
create table attachs (
	id serial primary key,
	description varchar(2000),
	item_id integer,
	foreign key (item_id) references items(id)
);