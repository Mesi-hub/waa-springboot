-- USERS

INSERT INTO users (id, name)
VALUES (111, 'meseret');

INSERT INTO users (id, name)
VALUES (112, 'Teki');


-- POSTS

INSERT INTO posts (id, title, content, author, user_id)
VALUES (111, 'waa', 'jpa', 'meseret',111);

INSERT INTO posts (id, title, content, author, user_id)
VALUES (112, 'waa', 'spring', 'teki',112);

-- COMMENTS

INSERT INTO comments (id,content,post_id)
VALUES (1,'awesome course',111);


