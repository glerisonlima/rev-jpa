-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema rev-jpa-db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema rev-jpa-db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rev-jpa-db` DEFAULT CHARACTER SET utf8 ;
USE `rev-jpa-db` ;

-- -----------------------------------------------------
-- Table `rev-jpa-db`.`documents`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rev-jpa-db`.`documents` (
  `ID_DOCUMENT` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `CPF` VARCHAR(14) NOT NULL,
  `RG` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_DOCUMENT`),
  UNIQUE INDEX `UK_11p7jhgg585ys25v3j5eq1jns` (`CPF` ASC),
  UNIQUE INDEX `UK_hc89okli0lmbdw5aqlg4uwg3q` (`RG` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rev-jpa-db`.`persons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rev-jpa-db`.`persons` (
  `ID_PERSON` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `AGE` INT(11) NOT NULL,
  `FIST_NAME` VARCHAR(30) NOT NULL,
  `LAST_NAME` VARCHAR(60) NOT NULL,
  `DOCUMENT_ID` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_PERSON`),
  UNIQUE INDEX `IDX_PERSON_NAME` (`FIST_NAME` ASC, `LAST_NAME` ASC),
  INDEX `FK_o018yksjr4hud9kmujkm47033` (`DOCUMENT_ID` ASC),
  CONSTRAINT `FK_o018yksjr4hud9kmujkm47033`
    FOREIGN KEY (`DOCUMENT_ID`)
    REFERENCES `rev-jpa-db`.`documents` (`ID_DOCUMENT`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rev-jpa-db`.`phones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rev-jpa-db`.`phones` (
  `ID_PHONE` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `NUMBER` VARCHAR(255) NOT NULL,
  `TYPE_PHONE` VARCHAR(255) NOT NULL,
  `PERSON_ID` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_PHONE`),
  INDEX `FK_6a14rveb8u4rbuw1svkl527xi` (`PERSON_ID` ASC),
  CONSTRAINT `FK_6a14rveb8u4rbuw1svkl527xi`
    FOREIGN KEY (`PERSON_ID`)
    REFERENCES `rev-jpa-db`.`persons` (`ID_PERSON`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
