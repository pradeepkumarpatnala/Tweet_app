-- MySQL Script generated by MySQL Workbench
-- Thu Mar 11 16:39:29 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tweetdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tweetdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tweetdb` DEFAULT CHARACTER SET utf8 ;
USE `tweetdb` ;

-- -----------------------------------------------------
-- Table `tweetdb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tweetdb`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `isloggedin` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tweetdb`.`tweet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tweetdb`.`tweet` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tweet` VARCHAR(45) NOT NULL,
  `userid` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;