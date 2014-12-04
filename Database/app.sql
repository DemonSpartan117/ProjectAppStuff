CREATE TABLE apps (name varchar(60), developer varchar(60), description varchar(140),
	platforms varchar(12), version varchar(12), link varchar(140), forum varchar(140),
	rating double(1,1), is_accepted varchar(1));

INSERT INTO apps VALUES ('Amazing App', 'Damon Duckett', 'this is awesome', 'platforms',
	NULL, 'http://www.awesome.com', NULL, NULL, 'Y');

INSERT INTO apps VALUES ('Trble App', 'Christopher Scavongelli', 'who cares', 'platforms',
	NULL, 'non_exist', NULL, NULL, 'Y');
