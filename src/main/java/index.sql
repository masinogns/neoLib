SET foreign_key_checks=0;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` char(16) NOT NULL,
  `name` varchar(16) DEFAULT NULL,
  `last_visit` datetime DEFAULT NULL,
  `money` decimal(10,0) DEFAULT NULL,
  `choo` char(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `choo` (`choo`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`choo`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOAD DATA LOCAL INFILE 'data.csv'
	INTO TABLE user
	FIELDS TERMINATED BY ','
	IGNORE 1 LINES;

SELECT COUNT(id) FROM user;
