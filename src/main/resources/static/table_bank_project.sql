-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema banking_system
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema banking_system
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `banking_system` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `banking_system` ;

-- -----------------------------------------------------
-- Table `banking_system`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banking_system`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `banking_system`.`account_holder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banking_system`.`account_holder` (
  `date_of_birth` DATETIME(6) NULL DEFAULT NULL,
  `mailing_city` VARCHAR(255) NULL DEFAULT NULL,
  `mailing_country` VARCHAR(255) NULL DEFAULT NULL,
  `mailing_post_code` VARCHAR(255) NULL DEFAULT NULL,
  `mailing_street_address` VARCHAR(255) NULL DEFAULT NULL,
  `city` VARCHAR(255) NULL DEFAULT NULL,
  `country` VARCHAR(255) NULL DEFAULT NULL,
  `post_code` VARCHAR(255) NULL DEFAULT NULL,
  `street_address` VARCHAR(255) NULL DEFAULT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FK209spbfupdxbgcihhfpvguxsx`
    FOREIGN KEY (`user_id`)
    REFERENCES `banking_system`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `banking_system`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banking_system`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `secrec_key` VARCHAR(255) NULL DEFAULT NULL,
  `balance` DECIMAL(19,2) NULL DEFAULT NULL,
  `balance_currency` VARCHAR(255) NULL DEFAULT NULL,
  `creation_date` DATETIME(6) NULL DEFAULT NULL,
  `penalty_fee` DECIMAL(19,2) NULL DEFAULT NULL,
  `status` INT NULL DEFAULT NULL,
  `primary_owner` INT NULL DEFAULT NULL,
  `secondary_owner` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKes6igfxoxfmlttcmscy411td2` (`primary_owner` ASC) VISIBLE,
  INDEX `FK9aif9tys7glwp4aajaloekc37` (`secondary_owner` ASC) VISIBLE,
  CONSTRAINT `FK9aif9tys7glwp4aajaloekc37`
    FOREIGN KEY (`secondary_owner`)
    REFERENCES `banking_system`.`account_holder` (`user_id`),
  CONSTRAINT `FKes6igfxoxfmlttcmscy411td2`
    FOREIGN KEY (`primary_owner`)
    REFERENCES `banking_system`.`account_holder` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `banking_system`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banking_system`.`admin` (
  `user_id` INT NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FK8ahhk8vqegfrt6pd1p9i03aej`
    FOREIGN KEY (`user_id`)
    REFERENCES `banking_system`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `banking_system`.`checking_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banking_system`.`checking_account` (
  `minimum_balance` DECIMAL(19,2) NULL DEFAULT NULL,
  `minimum_balance_currency` VARCHAR(255) NULL DEFAULT NULL,
  `monthly_maintenance_fee` DECIMAL(19,2) NULL DEFAULT NULL,
  `monthly_maintenance_fee_currency` VARCHAR(255) NULL DEFAULT NULL,
  `id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKc7fxiw236f4kvag916rq4udds`
    FOREIGN KEY (`id`)
    REFERENCES `banking_system`.`account` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `banking_system`.`credit_card_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banking_system`.`credit_card_account` (
  `credit_limit` DECIMAL(19,2) NULL DEFAULT NULL,
  `credit_limit_currency` VARCHAR(255) NULL DEFAULT NULL,
  `interest_rate` DECIMAL(19,2) NULL DEFAULT NULL,
  `id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKh7mw2yj702dua631qc7flrgal`
    FOREIGN KEY (`id`)
    REFERENCES `banking_system`.`account` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `banking_system`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banking_system`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `user_user_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKcppkuoqqh417ann4h6gql3luw` (`user_user_id` ASC) VISIBLE,
  CONSTRAINT `FKcppkuoqqh417ann4h6gql3luw`
    FOREIGN KEY (`user_user_id`)
    REFERENCES `banking_system`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `banking_system`.`savings_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banking_system`.`savings_account` (
  `interest_fee` DECIMAL(19,2) NULL DEFAULT NULL,
  `minimum_balance` DECIMAL(19,2) NULL DEFAULT NULL,
  `minimum_balance_currency` VARCHAR(255) NULL DEFAULT NULL,
  `monthly_maintenance_fee` DECIMAL(19,2) NULL DEFAULT NULL,
  `monthly_maintenance_fee_currency` VARCHAR(255) NULL DEFAULT NULL,
  `id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKn36qr72g6ju5ukaxj62g2utbi`
    FOREIGN KEY (`id`)
    REFERENCES `banking_system`.`account` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `banking_system`.`student_checking_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banking_system`.`student_checking_account` (
  `id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKr2neebl49goq1amrx44be8moi`
    FOREIGN KEY (`id`)
    REFERENCES `banking_system`.`account` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `banking_system`.`third_party`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banking_system`.`third_party` (
  `hashed_key` VARCHAR(255) NULL DEFAULT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FKhy115utgqaqy8s41n9t94ra1v`
    FOREIGN KEY (`user_id`)
    REFERENCES `banking_system`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
