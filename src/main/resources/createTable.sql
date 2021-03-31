CREATE TABLE post
id_post INT PRIMARY KEY AUTO_INCREMENT,
title   VARCHAR(100) NOT NULL,
content VARCHAR(1000) NOT NULL,
author_id INT NOT NULL,
moderator_id INT NOT NULL,
rating INT NOT NULL,
status VARCHAR(50) NOT NULL,
FOREIGN KEY (author_id) REFERENCES user (id_user),
FOREIGN KEY (moderator_id) REFERENCES user (id_user)
);

CREATE TABLE saf
id_saf        INT PRIMARY KEY AUTO_INCREMENT,
id_user       INT NOT NULL,
id_subscriber INT NOT NULL,
FOREIGN KEY (id_user) REFERENCES user (id_user),
FOREIGN KEY (id_subscriber) REFERENCES user (id_user)
);

CREATE TABLE user

 id_user      INT PRIMARY KEY AUTO_INCREMENT,
full_name    VARCHAR(100) NOT NULL,
login        VARCHAR(50) NOT NULL UNIQUE,
email        VARCHAR(150) NOT NULL UNIQUE,
age          INT NOT NULL,
is_author    BOOLEAN NOT NULL,
is_moderator BOOLEAN NOT NULL
);