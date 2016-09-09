-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema schema
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema schema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `schema` DEFAULT CHARACTER SET utf8 ;
USE `schema` ;

-- -----------------------------------------------------
-- Table `schema`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schema`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `house_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schema`.`transport_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schema`.`transport_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schema`.`depos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schema`.`depos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address_id` INT NOT NULL,
  `transport_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_depos_address1_idx` (`address_id` ASC),
  INDEX `fk_depos_transport_type1_idx` (`transport_type_id` ASC),
  CONSTRAINT `fk_depos_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `schema`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_depos_transport_type1`
    FOREIGN KEY (`transport_type_id`)
    REFERENCES `schema`.`transport_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schema`.`route`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schema`.`route` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `station_from` INT NOT NULL,
  `station_to` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_route_address1_idx` (`station_from` ASC),
  INDEX `fk_route_address2_idx` (`station_to` ASC),
  CONSTRAINT `fk_route_address1`
    FOREIGN KEY (`station_from`)
    REFERENCES `schema`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_route_address2`
    FOREIGN KEY (`station_to`)
    REFERENCES `schema`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schema`.`drivers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schema`.`drivers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_drivers_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_drivers_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `schema`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schema`.`transport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schema`.`transport` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(45) NOT NULL,
  `transport_type_id` INT NOT NULL,
  `drivers_id` INT NOT NULL,
  `route_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_transport_transport_type_idx` (`transport_type_id` ASC),
  INDEX `fk_transport_drivers1_idx` (`drivers_id` ASC),
  INDEX `fk_transport_route1_idx` (`route_id` ASC),
  CONSTRAINT `fk_transport_transport_type`
    FOREIGN KEY (`transport_type_id`)
    REFERENCES `schema`.`transport_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transport_drivers1`
    FOREIGN KEY (`drivers_id`)
    REFERENCES `schema`.`drivers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transport_route1`
    FOREIGN KEY (`route_id`)
    REFERENCES `schema`.`route` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `schema`.`address`
-- -----------------------------------------------------
START TRANSACTION;
USE `schema`;
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (1, 'Rokossovskogo', '26');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (2, 'Kalinina', '25');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (3, 'Nezavisimosty', '24');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (4, 'Yakubova', '23');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (5, 'Rokossovskogo', '22');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (6, 'Prityckogo', '21');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (7, 'Mazurova', '20');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (8, 'Nemanskaya', '19');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (9, 'Popova', '18');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (10, 'Serova', '17');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (11, 'Plehanova', '16');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (12, 'Semashko', '15');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (13, 'Petrovshina', '14');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (14, 'Popova', '13');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (15, 'Serova', '12');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (16, 'Plehanova', '11');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (17, 'Semashko', '10');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (18, 'Nemanskaya', '9');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (19, 'Nemiga', '8');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (20, 'Rokossovskogo', '7');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (21, 'Avenue', '6');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (22, 'Orlovskaya', '5');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (23, 'Surganova', '4');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (24, 'Semashko', '3');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (25, 'Kalinina', '2');
INSERT INTO `schema`.`address` (`id`, `street`, `house_number`) VALUES (26, 'Rokossovskogo', '1');

COMMIT;


-- -----------------------------------------------------
-- Data for table `schema`.`transport_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `schema`;
INSERT INTO `schema`.`transport_type` (`id`, `type`) VALUES (1, 'bus');
INSERT INTO `schema`.`transport_type` (`id`, `type`) VALUES (2, 'trolleybus');
INSERT INTO `schema`.`transport_type` (`id`, `type`) VALUES (3, 'tram');
INSERT INTO `schema`.`transport_type` (`id`, `type`) VALUES (4, 'train');
INSERT INTO `schema`.`transport_type` (`id`, `type`) VALUES (5, 'taxi');

COMMIT;


-- -----------------------------------------------------
-- Data for table `schema`.`depos`
-- -----------------------------------------------------
START TRANSACTION;
USE `schema`;
INSERT INTO `schema`.`depos` (`id`, `name`, `address_id`, `transport_type_id`) VALUES (1, 'Bus Depo', 1, 1);
INSERT INTO `schema`.`depos` (`id`, `name`, `address_id`, `transport_type_id`) VALUES (2, 'Trolleybus Depo', 2, 2);
INSERT INTO `schema`.`depos` (`id`, `name`, `address_id`, `transport_type_id`) VALUES (3, 'Tram Depo', 3, 3);
INSERT INTO `schema`.`depos` (`id`, `name`, `address_id`, `transport_type_id`) VALUES (4, 'Train Depo', 4, 4);
INSERT INTO `schema`.`depos` (`id`, `name`, `address_id`, `transport_type_id`) VALUES (5, 'Taxi Station', 5, 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `schema`.`route`
-- -----------------------------------------------------
START TRANSACTION;
USE `schema`;
INSERT INTO `schema`.`route` (`id`, `station_from`, `station_to`) VALUES (1, 1, 2);
INSERT INTO `schema`.`route` (`id`, `station_from`, `station_to`) VALUES (2, 3, 4);
INSERT INTO `schema`.`route` (`id`, `station_from`, `station_to`) VALUES (3, 5, 6);
INSERT INTO `schema`.`route` (`id`, `station_from`, `station_to`) VALUES (4, 7, 8);
INSERT INTO `schema`.`route` (`id`, `station_from`, `station_to`) VALUES (5, 9, 10);
INSERT INTO `schema`.`route` (`id`, `station_from`, `station_to`) VALUES (6, 11, 12);
INSERT INTO `schema`.`route` (`id`, `station_from`, `station_to`) VALUES (7, 13, 14);
INSERT INTO `schema`.`route` (`id`, `station_from`, `station_to`) VALUES (8, 15, 16);
INSERT INTO `schema`.`route` (`id`, `station_from`, `station_to`) VALUES (9, 17, 18);
INSERT INTO `schema`.`route` (`id`, `station_from`, `station_to`) VALUES (10, 19, 20);
INSERT INTO `schema`.`route` (`id`, `station_from`, `station_to`) VALUES (11, 21, 22);
INSERT INTO `schema`.`route` (`id`, `station_from`, `station_to`) VALUES (12, 23, 24);
INSERT INTO `schema`.`route` (`id`, `station_from`, `station_to`) VALUES (13, 25, 26);

COMMIT;


-- -----------------------------------------------------
-- Data for table `schema`.`drivers`
-- -----------------------------------------------------
START TRANSACTION;
USE `schema`;
INSERT INTO `schema`.`drivers` (`id`, `first_name`, `last_name`, `address_id`) VALUES (1, 'Alexey', 'Starov', 6);
INSERT INTO `schema`.`drivers` (`id`, `first_name`, `last_name`, `address_id`) VALUES (2, 'Vladislav', 'Petrovich', 7);
INSERT INTO `schema`.`drivers` (`id`, `first_name`, `last_name`, `address_id`) VALUES (3, 'Mihail', 'Petrov', 8);
INSERT INTO `schema`.`drivers` (`id`, `first_name`, `last_name`, `address_id`) VALUES (4, 'Konstantin', 'Ivanov', 9);
INSERT INTO `schema`.`drivers` (`id`, `first_name`, `last_name`, `address_id`) VALUES (5, 'Filipp', 'Karavaev', 10);
INSERT INTO `schema`.`drivers` (`id`, `first_name`, `last_name`, `address_id`) VALUES (6, 'Roman', 'Krug', 11);
INSERT INTO `schema`.`drivers` (`id`, `first_name`, `last_name`, `address_id`) VALUES (7, 'Dmitry', 'Ignatov', 12);
INSERT INTO `schema`.`drivers` (`id`, `first_name`, `last_name`, `address_id`) VALUES (8, 'Artyom', 'Petrochenkov', 13);
INSERT INTO `schema`.`drivers` (`id`, `first_name`, `last_name`, `address_id`) VALUES (9, 'Oleg', 'Pikta', 14);
INSERT INTO `schema`.`drivers` (`id`, `first_name`, `last_name`, `address_id`) VALUES (10, 'Vasily', 'Susanin', 15);
INSERT INTO `schema`.`drivers` (`id`, `first_name`, `last_name`, `address_id`) VALUES (11, 'Maxim', 'Sverdlov', 16);
INSERT INTO `schema`.`drivers` (`id`, `first_name`, `last_name`, `address_id`) VALUES (12, 'Alexander', 'Novitsky', 17);
INSERT INTO `schema`.`drivers` (`id`, `first_name`, `last_name`, `address_id`) VALUES (13, 'Vladimir', 'Berezucky', 18);

COMMIT;


-- -----------------------------------------------------
-- Data for table `schema`.`transport`
-- -----------------------------------------------------
START TRANSACTION;
USE `schema`;
INSERT INTO `schema`.`transport` (`id`, `number`, `transport_type_id`, `drivers_id`, `route_id`) VALUES (1, '1', 1, 1, 1);
INSERT INTO `schema`.`transport` (`id`, `number`, `transport_type_id`, `drivers_id`, `route_id`) VALUES (2, '2', 1, 2, 2);
INSERT INTO `schema`.`transport` (`id`, `number`, `transport_type_id`, `drivers_id`, `route_id`) VALUES (3, '3', 1, 3, 3);
INSERT INTO `schema`.`transport` (`id`, `number`, `transport_type_id`, `drivers_id`, `route_id`) VALUES (4, '7', 2, 4, 4);
INSERT INTO `schema`.`transport` (`id`, `number`, `transport_type_id`, `drivers_id`, `route_id`) VALUES (5, '8', 2, 5, 5);
INSERT INTO `schema`.`transport` (`id`, `number`, `transport_type_id`, `drivers_id`, `route_id`) VALUES (6, '9', 2, 6, 6);
INSERT INTO `schema`.`transport` (`id`, `number`, `transport_type_id`, `drivers_id`, `route_id`) VALUES (7, '1', 3, 7, 7);
INSERT INTO `schema`.`transport` (`id`, `number`, `transport_type_id`, `drivers_id`, `route_id`) VALUES (8, '6', 3, 8, 8);
INSERT INTO `schema`.`transport` (`id`, `number`, `transport_type_id`, `drivers_id`, `route_id`) VALUES (9, '1', 4, 9, 9);
INSERT INTO `schema`.`transport` (`id`, `number`, `transport_type_id`, `drivers_id`, `route_id`) VALUES (10, '2', 4, 10, 10);
INSERT INTO `schema`.`transport` (`id`, `number`, `transport_type_id`, `drivers_id`, `route_id`) VALUES (11, '3', 4, 11, 11);
INSERT INTO `schema`.`transport` (`id`, `number`, `transport_type_id`, `drivers_id`, `route_id`) VALUES (12, '135', 5, 12, 12);
INSERT INTO `schema`.`transport` (`id`, `number`, `transport_type_id`, `drivers_id`, `route_id`) VALUES (13, '7788', 5, 13, 13);

COMMIT;

