INSERT INTO MY_USER (id, name)
VALUES (11, 'user101'),
       (12, 'user102');

INSERT INTO POST (id, title, content, author, user_id)
VALUES (101, 'title1', 'content1', 'author1', 11),
       (102, 'title2', 'content2', 'author2', 11),
       (103, 'title3', 'content3', 'author3', 12),
       (104, 'title3', 'content4', 'author4', 12);

INSERT INTO COMMENT (id, name, post_id)
VALUES (1001, 'comment1', 101),
       (1002, 'comment2', 101),
       (1003, 'comment3', 102),
       (1004, 'comment4', 103),
       (1005, 'comment5', 103);
