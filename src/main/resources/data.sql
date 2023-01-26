INSERT INTO USERS (id, name, email, password)
VALUES (11, 'user11', 'user11@mail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'), -- 123
       (12, 'user12', 'user12@mail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); -- 123

INSERT INTO POST (id, title, content, author, user_id)
VALUES (101, 'title1', 'content1', 'author1', 11),
       (102, 'title2', 'content2', 'author2', 11),
       (103, 'title3', 'content3', 'author3', 11),
       (104, 'title4', 'content4', 'author4', 12);

INSERT INTO COMMENT (id, name, post_id)
VALUES (1001, 'comment1', 101),
       (1002, 'comment2', 101),
       (1003, 'comment3', 102),
       (1004, 'comment4', 103),
       (1005, 'comment5', 104);

INSERT INTO ROLE (id, name)
VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT INTO USERS_ROLES (user_id, roles_id)
VALUES (11, 1),
       (12, 2);
