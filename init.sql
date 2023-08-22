INSERT INTO `ecommerce_db`.`role`
(`role_type`)
VALUES
("ROLE_CUSTOMER");

INSERT INTO `ecommerce_db`.`role`
(`role_type`)
VALUES
("ROLE_ADMIN");

-- Insert countries
INSERT INTO `ecommerce_db`.`country` (`country_name`) VALUES ("Turkey");
INSERT INTO `ecommerce_db`.`country` (`country_name`) VALUES ("England");
INSERT INTO `ecommerce_db`.`country` (`country_name`) VALUES ("Netherlands");
INSERT INTO `ecommerce_db`.`country` (`country_name`) VALUES ("Switzerland");
INSERT INTO `ecommerce_db`.`country` (`country_name`) VALUES ("Japan");

-- Insert cities for Turkey
INSERT INTO `ecommerce_db`.`city` (`city_name`,`country_id`) VALUES ("Istanbul", 1);
INSERT INTO `ecommerce_db`.`city` (`city_name`,`country_id`) VALUES ("Ankara", 1);
INSERT INTO `ecommerce_db`.`city` (`city_name`,`country_id`) VALUES ("Izmir", 1);
INSERT INTO `ecommerce_db`.`city` (`city_name`,`country_id`) VALUES ("Bursa", 1);
INSERT INTO `ecommerce_db`.`city` (`city_name`,`country_id`) VALUES ("Antalya", 1);
INSERT INTO `ecommerce_db`.`city` (`city_name`,`country_id`) VALUES ("Adana", 1);
INSERT INTO `ecommerce_db`.`city` (`city_name`,`country_id`) VALUES ("Erzurum", 1);
INSERT INTO `ecommerce_db`.`city` (`city_name`,`country_id`) VALUES ("Trabzon", 1);
INSERT INTO `ecommerce_db`.`city` (`city_name`,`country_id`) VALUES ("Gaziantep", 1);
INSERT INTO `ecommerce_db`.`city` (`city_name`,`country_id`) VALUES ("Eskisehir", 1);

-- Insert cities for England
INSERT INTO `ecommerce_db`.`city` (`city_name`,`country_id`) VALUES ("London", 2);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Manchester", 2);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Liverpool", 2);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Birmingham", 2);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Leeds", 2);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Newcastle", 2);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Sheffield", 2);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Bristol", 2);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Edinburgh", 2);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Glasgow", 2);

-- Insert cities for Netherlands
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Amsterdam", 3);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Rotterdam", 3);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Utrecht", 3);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Eindhoven", 3);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Groningen", 3);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("The Hague", 3);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Maastricht", 3);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Nijmegen", 3);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Arnhem", 3);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Tilburg", 3);


-- Insert cities for Switzerland
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Zurich", 4);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Geneva", 4);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Bern", 4);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Lucerne", 4);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Basel", 4);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Lausanne", 4);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Interlaken", 4);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Zermatt", 4);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("St. Moritz", 4);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES ("Lugano", 4);


-- Insert cities for Japan
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES  ("Tokyo", 5);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES  ("Osaka", 5);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES  ("Kyoto", 5);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES  ("Sapporo", 5);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES  ("Nagoya", 5);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES  ("Fukuoka", 5);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES  ("Hiroshima", 5);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES  ("Yokohama", 5);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES  ("Nara", 5);
INSERT INTO `ecommerce_db`.`city` (`city_name`, `country_id`) VALUES  ("Kobe", 5);

