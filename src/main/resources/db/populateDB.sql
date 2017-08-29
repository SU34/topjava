DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES ('User', 'user@yandex.ru', 'password');
INSERT INTO users (name, email, password) VALUES ('Admin', 'admin@gmail.com', 'admin');
-- INSERT INTO users (name, email, password) VALUES ('User2', 'test2@gmail.com', 'tester2');
-- INSERT INTO users (name, email, password) VALUES ('User3', 'test3@gmail.com', 'tester3');
-- INSERT INTO users (name, email, password) VALUES ('User4', 'test4@gmail.com', 'tester4');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);
