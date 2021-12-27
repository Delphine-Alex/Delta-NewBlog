DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS articles;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS users;

 
CREATE TABLE categories (
 	id  INT NOT NULL AUTO_INCREMENT,
 	name VARCHAR(50) NOT NULL,
 	CONSTRAINT PK_CATEGORY PRIMARY KEY (`id`)
);
 
INSERT INTO categories (id, name) VALUES 
	(1,'category 1'), 
	(2,'category 2');


CREATE TABLE users (
 	id  INT NOT NULL AUTO_INCREMENT,
 	author_name VARCHAR(50) NOT NULL,
    mail VARCHAR(50) NOT NULL,
 	password VARCHAR(250) NOT NULL,
    CONSTRAINT PK_USER PRIMARY KEY (`id`)
);

INSERT INTO users (id, author_name, mail, password) VALUES
   (1, 'Viktor', 'viktor@gmail.com', '$2a$12$yvrheRklzDeANcdZp5ybW.EtuhqjlJxI8n555vctwSNWrG6x5o2pe'),
   (2, 'Jinx', 'jinx@gmail.com', '$2a$12$yvrheRklzDeANcdZp5ybW.EtuhqjlJxI8n555vctwSNWrG6x5o2pe'),
   (3, 'Pierre', 'pierre@gmail.com', '$2a$12$yvrheRklzDeANcdZp5ybW.EtuhqjlJxI8n555vctwSNWrG6x5o2pe' ),
   (4, 'Alexandre', 'alexandre@gmail.com', '$2a$12$yvrheRklzDeANcdZp5ybW.EtuhqjlJxI8n555vctwSNWrG6x5o2pe'),
   (5, 'Alexandra', 'alexandra@gmail.com', '$2a$12$yvrheRklzDeANcdZp5ybW.EtuhqjlJxI8n555vctwSNWrG6x5o2pe' );
   
   
CREATE TABLE articles (
   id  INT NOT NULL AUTO_INCREMENT,
   title VARCHAR(50),
   author_name VARCHAR(50) NOT NULL,
   date DATE NOT NULL,
   content VARCHAR(250) NOT NULL,
   user_id INT NOT NULL, 
   CONSTRAINT PK_ARTICLE PRIMARY KEY (`id`),
   CONSTRAINT FK_ARTICLE_USER FOREIGN KEY (`user_id`) REFERENCES users (`id`)
);

INSERT INTO articles (id, title, author_name, date, content, user_id) VALUES 
   (1,'test', 'Pierre', '2021-11-01', 'Lorem lorem lorem', 3 ),
   (2, 'test1','Alexandre', '2021-09-20', 'Lorem lorem lorem', 4), 
   (3, 'test2', 'Alexandra', '2020-04-23', 'Lorem lorem lorem', 5);

CREATE TABLE category_article (
  category_id INT NOT NULL,
  article_id INT NOT NULL
);  

INSERT INTO category_article (category_id, article_id) VALUES
  (1,1),
  (2,2);
  
CREATE TABLE comments (
   id  INT NOT NULL AUTO_INCREMENT,
   author_name VARCHAR(50) NOT NULL,
   date DATE NOT NULL,
   comment VARCHAR(150) NOT NULL,
   article_id INT NOT NULL,
   user_id INT NOT NULL, 
   CONSTRAINT PK_COMMENT PRIMARY KEY (`id`),
   CONSTRAINT FK_COMMENT_USER FOREIGN KEY (`user_id`) REFERENCES users (`id`)
 );

 INSERT INTO comments (id, author_name, date, comment, article_id, user_id) VALUES
   (1, 'Viktor', '2021-11-01', 'super', 1 , 1),
   (2, 'Jinx', '2020-04-23', 'good', 2 , 2);