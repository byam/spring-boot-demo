INSERT INTO MY_USER (id, name)
VALUES (101, 'user101'),
       (102, 'user102');

INSERT INTO POST (id, title, content, author, user_id)
VALUES (101, 'title1', 'content1', 'author1', 101),
       (102, 'title2', 'content2', 'author2', 101),
       (103, 'title3', 'content3', 'author3', 102);
