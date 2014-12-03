TRUNCATE user;

TRUNCATE admin;

TRUNCATE moderator;

CREATE TABLE accounttype (accounttype VARCHAR(14));

ALTER TABLE accounttype ADD CONSTRAINT PRIMARY KEY (accounttype);

INSERT INTO accounttype VALUES ('Administrator');

INSERT INTO accounttype VALUES ('Moderator');

INSERT INTO accounttype VALUES ('Normal');

ALTER TABLE user ADD CONSTRAINT FOREIGN KEY (accounttype) REFERENCES accounttype (accounttype);