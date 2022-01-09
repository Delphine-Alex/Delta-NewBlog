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
	(1,'Informatique'), 
	(2,'Sport');


CREATE TABLE users (
 	id  INT NOT NULL AUTO_INCREMENT,
 	author_name VARCHAR(50) NOT NULL,
    mail VARCHAR(50) NOT NULL,
 	password VARCHAR(250) NOT NULL,
    CONSTRAINT PK_USER PRIMARY KEY (`id`)
);

INSERT INTO users (id, author_name, mail, password) VALUES
   (1, 'Viktor', 'viktor@gmail.com', '$2a$12$QYo9lk0vVQy8T1vjIbqzS.QUX9lf3dFVJi7ujqivCY.sGCDNyGeSa'),
   (2, 'Jinx', 'jinx@gmail.com', '$2a$12$QYo9lk0vVQy8T1vjIbqzS.QUX9lf3dFVJi7ujqivCY.sGCDNyGeSa'),
   (3, 'Pierre', 'pierre@gmail.com', '$2a$12$QYo9lk0vVQy8T1vjIbqzS.QUX9lf3dFVJi7ujqivCY.sGCDNyGeSa' ),
   (4, 'Alexandre', 'alexandre@gmail.com', '$2a$12$QYo9lk0vVQy8T1vjIbqzS.QUX9lf3dFVJi7ujqivCY.sGCDNyGeSa'),
   (5, 'Alexandra', 'alexandra@gmail.com', '$2a$12$QYo9lk0vVQy8T1vjIbqzS.QUX9lf3dFVJi7ujqivCY.sGCDNyGeSa');


CREATE TABLE articles (
   id  INT NOT NULL AUTO_INCREMENT,
   title VARCHAR(150),
   author_name VARCHAR(50) NOT NULL,
   date DATE NOT NULL,
   content VARCHAR(250) NOT NULL,
   category_id INT,
   user_id INT, 
   CONSTRAINT PK_ARTICLE PRIMARY KEY (`id`),
   CONSTRAINT FK_ARTICLE_CATEGORY FOREIGN KEY (`category_id`) REFERENCES categories (`id`),
   CONSTRAINT FK_ARTICLE_USER FOREIGN KEY (`user_id`) REFERENCES users (`id`)
);

INSERT INTO articles (id, title, author_name, date, content, category_id, user_id) VALUES 
   (1,'JAVA - Spring Boot', 'Pierre', '2021-11-01', 'Bonjour, je rencontre actuellement un problème avec les dépendences cycliques... Need help', 1, 3),
   (2, 'SLF4J','Alexandre', '2021-09-20', 'Serais-ce la faille du siècle ?', 1, 4), 
   (3, 'VTT chez les ourses', 'Alexandra', '2020-04-23', 'Connaissez vous des montagnes praticable en VTT habité par des animaux sauvage ?', 2, 5);


CREATE TABLE comments (
   id  INT NOT NULL AUTO_INCREMENT,
   author_name VARCHAR(50) NOT NULL,
   date DATE NOT NULL,
   comment VARCHAR(150) NOT NULL,
   article_id INT,
   user_id INT, 
   CONSTRAINT PK_COMMENT PRIMARY KEY (`id`),
   CONSTRAINT FK_COMMENT_ARTICLE FOREIGN KEY (`article_id`) REFERENCES articles (`id`),
   CONSTRAINT FK_COMMENT_USER FOREIGN KEY (`user_id`) REFERENCES users (`id`)
 );

 INSERT INTO comments (id, author_name, date, comment, article_id, user_id) VALUES
   (1, 'Viktor', '2021-11-01', 'Je vous conseille le cours suivant : https://openclassrooms.com/fr/courses/6982461-utilisez-spring-data-pour-interagir-avec-vos-bases-de-donnees', 1 , 1),
   (2, 'Jinx', '2020-04-23', '42', 2 , 2),
   (3, 'Jinx', '2020-04-23', 'La montagne aux ourses ;-)', 3 , 2);