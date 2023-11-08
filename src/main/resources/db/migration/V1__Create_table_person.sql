-- db_helloAws.person definition

CREATE TABLE `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `insert_date` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
);