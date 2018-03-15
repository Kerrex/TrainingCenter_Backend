INSERT INTO training_center_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO training_center_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO training_center_user (id, first_name, last_name, password, username, email) VALUES (1, 'John', 'Doe', '0e2f5410fbdeb9066b89217bf431bc38c72ba4bfefe4a0acc984ff9ec2a1601fa72a54aa7bdf5e0a', 'john.doe', 'test@test.pl');
INSERT INTO training_center_user (id, first_name, last_name, password, username, email) VALUES (2, 'Admin', 'Admin', '0e2f5410fbdeb9066b89217bf431bc38c72ba4bfefe4a0acc984ff9ec2a1601fa72a54aa7bdf5e0a', 'admin.admin', 'test2@test.pl');
INSERT INTO training_center_user (id, first_name, last_name, password, username, email) VALUES (3, 'Tomek', 'Morawski', '0e2f5410fbdeb9066b89217bf431bc38c72ba4bfefe4a0acc984ff9ec2a1601fa72a54aa7bdf5e0a', 'tomek', 'test3@test.pl');

INSERT INTO user_data (user_id, gender, height) VALUES (3, 1, 186);

INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);
INSERT INTO user_role(user_id, role_id) VALUES(3,1);
INSERT INTO user_role(user_id, role_id) VALUES(3,2);

INSERT INTO user_measurement (id, user_id, waist, weight, biceps, thigh, hips, chest, neck, date_added) VALUES (1, 3, 880, 850, 345, 620, 1050, 1015, 385, now() - INTERVAL '2' DAY );
INSERT INTO user_measurement (id, user_id, waist, weight, biceps, thigh, hips, chest, neck, date_added) VALUES (2, 3, 1006, 700, 100, 1020, 1010, 1030, 1040, now() - INTERVAL '1' DAY );
INSERT INTO user_measurement (id, user_id, waist, weight, biceps, thigh, hips, chest, neck, date_added) VALUES (3, 3, 1000, 700, 100, 900, 900, 1070, 1050, now());

INSERT INTO language_version (name, code) VALUES ('Polski', 'pl');

INSERT INTO exercise (id, default_name, youtube_link) VALUES (1, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (2, 'Przysiad2', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (3, 'Przysiad3', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (4, 'Przysiad4', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (5, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (6, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (7, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (8, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (9, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (10, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (11, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (12, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (13, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (14, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (15, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (16, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (17, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (18, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (19, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (20, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (21, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (22, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (23, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (24, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (25, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (26, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (27, 'Przysiad', 'http://google.pl');
INSERT INTO exercise (id, default_name, youtube_link) VALUES (28, 'Przysiad', 'http://google.pl');

INSERT INTO exercise_language_version (exercise_id, language_version_code, name) VALUES (1, 'pl', 'Przysiad pl');
INSERT INTO exercise_language_version (exercise_id, language_version_code, name) VALUES (2, 'pl', 'Przysiad pl2');
INSERT INTO exercise_language_version (exercise_id, language_version_code, name) VALUES (3, 'pl', 'Przysiad pl3');

INSERT INTO training_plan (id, name, user_id) VALUES (1, 'Pierwszy', 3);
INSERT INTO training_plan (id, name, user_id) VALUES (2, 'Drugi', 3);
INSERT INTO training_plan (id, name, user_id) VALUES (3, 'Trzeci', 3);
INSERT INTO training_plan (id, name, user_id) VALUES (4, 'Czwarty', 3);
INSERT INTO training_plan (id, name, user_id) VALUES (5, 'Piąty', 3);

INSERT INTO measure (id, name) VALUES (1, 'kg');
INSERT INTO measure (id, name) VALUES (2, 'powt.');

INSERT INTO exercise_training_plan (training_plan_id, exercise_id, series_count, intensivity, measure_id)
  VALUES (1, 1, 10, 12, 2);

INSERT INTO exercise_training_plan (training_plan_id, exercise_id, series_count, intensivity, measure_id)
  VALUES (1, 2, 11, 13, 2);

INSERT INTO exercise_training_plan (training_plan_id, exercise_id, series_count, intensivity, measure_id)
  VALUES (1, 3, 12, 12, 1);

INSERT INTO exercise_training_plan (training_plan_id, exercise_id, series_count, intensivity, measure_id)
  VALUES (2, 1, 10, 12, 1);
-- CREATE TABLE exercise_language_version (
--   exercise_id INT NOT NULL,
--   language_version_code VARCHAR(5) NOT NULL,
--   name varchar(255) NOT NULL,
--   CONSTRAINT FK_EXERCISE_LV_EXERCISE FOREIGN KEY (exercise_id) REFERENCES exercise (id),
--   CONSTRAINT FK_EXERVICE_LV_LANGUAGE_VERSION FOREIGN KEY (language_version_code) REFERENCES language_version (code),
--   CONSTRAINT PK_EXERCISE_LANGUAGE_VERSION PRIMARY KEY (exercise_id, language_version_code)
-- );
--   CREATE TABLE exercise (
-- id INT NOT NULL IDENTITY,
-- default_name varchar(255) NOT NULL,
-- youtube_link varchar(255) NOT NULL,
-- PRIMARY KEY (id)
-- );
-- CREATE TABLE user_measurement (
--   user_id INT NOT NULL IDENTITY,
--   waist INT NOT NULL, /* w milimetrach */
--   weight INT NOT NULL, /* w hektagramach */
--   biceps INT  NULL, /* w milimetrach */
--   thigh INT  NULL, /* w milimetrach */
--   hips INT NOT NULL, /* w milimetrach */
--   chest INT NULL, /* w milimetrach */
--   neck INT NOT NULL, /* w milimetrach */
--   date_added TIMESTAMP NOT NULL,
--   CONSTRAINT FKa68196081fvovjhkek5m97n3z FOREIGN KEY (user_id) REFERENCES training_center_user (id)
-- );