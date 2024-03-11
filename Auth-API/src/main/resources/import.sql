INSERT INTO tb_user (name, email, phone, password, birth_date) VALUES ('Maria Brown', 'maria@gmail.com', '988888888', '$2a$10$4vet6vWuI78kQf9HcbTMYeuN1eM6yKeBwcpa7dsYdc0ARQypKbVhm', '2001-07-25');
INSERT INTO tb_user (name, email, phone, password, birth_date) VALUES ('Alex Green', 'alex@gmail.com', '977777777', '$2a$10$4vet6vWuI78kQf9HcbTMYeuN1eM6yKeBwcpa7dsYdc0ARQypKbVhm', '1987-12-13');

INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);