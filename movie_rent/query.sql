create DATABASE movie_rent;

CREATE TABLE `user` (
  `userid` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  `created_at` date,
  PRIMARY KEY (`userid`)
); 

CREATE TABLE `movie` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_title` varchar(50) NOT NULL,
  `movie_genre` varchar(25) NOT NULL,
  PRIMARY KEY (`movie_id`)
);

CREATE TABLE `rent` (
  `rent_id` int(11) NOT NULL AUTO_INCREMENT,
  `rent_date` date NOT NULL,
  `return_date` date ,
  `movie_id` int(11) NOT NULL,
  `userid` varchar(20) NOT NULL,
  PRIMARY KEY (`rent_id`),
  KEY `rent_FK_mv` (`movie_id`),
  KEY `rent_FK_usr` (`userid`),
  CONSTRAINT `rent_FK_mv` FOREIGN KEY (`movie_id`) REFERENCES `movie`(`movie_id`),
  CONSTRAINT `rent_FK_usr` FOREIGN KEY (`userid`) REFERENCES `user`(`userid`)
);

INSERT INTO user (`userid`, `password`, created_at) VALUES
('ikhsan', '123', now());