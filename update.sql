-- SELECT address
-- FROM house
-- WHERE id = 3;
--
-- SELECT address
-- FROM house
-- WHERE id = 11;

/*
  lat, lng update sql
  lat 위도
  lng 경도
 */

-- ALTER TABLE house
-- ADD lat VARCHAR (50);
--
-- ALTER TABLE house
-- ADD lng VARCHAR (50);

-- ALTER TABLE food
-- ADD lat VARCHAR (50);
--
-- ALTER TABLE food
-- ADD lng VARCHAR (50);
--

-- UPDATE TABLE_NAME
-- SET COLUMN_NAME = VALUE , COLUMN_NAME = VALUE , ...
-- WHERE CONDITION_NUMBER ;

-- ALTER TABLE 테이블명 ALTER COLUMN 컬럼명 SET DEFAULT '바꿀 값';
-- 출처: http://houki.tistory.com/85 [아이고 어렵다]
--
-- DROP TABLE IF EXISTS `place`;
-- CREATE TABLE `place` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `name` varchar(100) NOT NULL,
--   `phone_number` varchar(20) DEFAULT NULL,
--   `address` varchar(255) NOT NULL,
--   `point` float DEFAULT 0,
--   `photo_url` varchar(255) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=MyISAM AUTO_INCREMENT=529 DEFAULT CHARSET=utf8;
