INSERT INTO (name, phone_number, address)
VALUES
(),
();

mysqldump -h 183.111.183.101 -u captanp696 -p captanp696 > finish_backup.sql


CREATE TABLE `place` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `point` float DEFAULT '0',
  `photo_url` varchar(255) DEFAULT NULL,
  `lat` varchar(50) DEFAULT NULL,
  `lng` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=532 DEFAULT CHARSET=utf8 |

NULL인것을 검색
1. where 칼럼명 is NULL
2. where 칼럼명 <=> NULL

NULL이 아닌것을 검색

1. where 칼럼명 is not NULL