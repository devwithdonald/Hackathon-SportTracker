--admin == 1
create table sporttracker_users (
	user_id serial primary key,
	username text unique not null,
	password text not null,
	admin_check boolean default false
);

create table sporttracker_teams (
	team_id serial primary key,
	name text unique not null
);

-- user's favorite teams
create table sporttracker_favorite_teams (
	favorite_teams_id serial primary key,
	user_id integer references sporttracker_users (user_id) not null,
	team_id integer references sporttracker_teams (team_id) not null
);

create table sporttracker_games (
	game_id serial primary key,
	team_id_1 integer references sporttracker_teams (team_id) not null,
	team_id_2 integer references sporttracker_teams (team_id) not null,
	team_name_1 text not null,
	team_name_2 text not null,
	team_score_1 integer,
	team_score_2 integer,
	winner text
);

drop table sporttracker_games cascade;


insert into sporttracker_teams (name)
	values ('beavers'), ('rockets'), ('monsters'), ('bruins');


insert into sporttracker_users(username, password, admin_check)
	values ('sportsfan1', '123', false), ('bruinslover', '456', false), ('admin', '789', true);

insert into sporttracker_games(team_id_1, team_id_2, team_name_1, team_name_2, team_score_1, team_score_2, winner)
	values (1,2,'beavers','rockets', 5,4,'beavers');

insert into sporttracker_games(team_id_1, team_id_2, team_name_1, team_name_2, team_score_1, team_score_2, winner)
	values (2,3,'rockets','monsters', 2,4,'monsters');

insert into sporttracker_games(team_id_1, team_id_2, team_name_1, team_name_2, team_score_1, team_score_2, winner)
	values (3,4,'monsters','bruins', 10,4,'monsters');

select * from sporttracker_games;
select * from sporttracker_users;
select * from sporttracker_favorite_teams;

insert into sporttracker_favorite_teams (user_id, team_id)
	values (1,1);

insert into sporttracker_favorite_teams (user_id, team_id)
	values (1,2);

delete from sporttracker_favorite_teams
where favorite_teams_id = 2;

insert into sporttracker_favorite_teams (user_id, team_id)
	values (2,4);


select * from sporttracker_users;
select * from sporttracker_teams;
select * from sporttracker_favorite_teams;
select * from sporttracker_games;


