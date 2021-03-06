-- MySQL Script generated by MySQL Workbench
-- Sun Feb 27 18:37:12 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`LOGIN_INFO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`LOGIN_INFO` ;

CREATE TABLE IF NOT EXISTS `mydb`.`LOGIN_INFO` (
  `ID` VARCHAR(15) CHARACTER SET 'utf8' NOT NULL,
  `PASSWORD` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `PASSWORD_ERROR_COUNT` INT NULL DEFAULT 0,
  `PASSWORD_ERROR_DATE` DATETIME NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`USER_INFO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`USER_INFO` ;

CREATE TABLE IF NOT EXISTS `mydb`.`USER_INFO` (
  `ID` VARCHAR(15) CHARACTER SET 'utf8' NOT NULL,
  `NAME` VARCHAR(45) NOT NULL,
  `ENG_NAME` VARCHAR(45) NULL,
  `GENDER` NCHAR(1) NOT NULL,
  `BIRTH_DATE` NCHAR(8) NOT NULL,
  `REAL_NUMBER` VARCHAR(300) NOT NULL,
  `ZIP_CODE` INT(6) NOT NULL,
  `ADDRESS` VARCHAR(200) NOT NULL,
  `ADDRESS_DTL` VARCHAR(150) NULL,
  `EMAIL` VARCHAR(15) NOT NULL,
  `EMAIL_ADDRESS` VARCHAR(30) NOT NULL,
  `PHONE_NUMBER` VARCHAR(22) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_USER_INFO_LOGIN_INFO_idx` (`ID` ASC),
  CONSTRAINT `fk_USER_INFO_LOGIN_INFO`
    FOREIGN KEY (`ID`)
    REFERENCES `mydb`.`LOGIN_INFO` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PROFESSOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`PROFESSOR` ;

CREATE TABLE IF NOT EXISTS `mydb`.`PROFESSOR` (
  `PROFESSOR_CODE` VARCHAR(10) NOT NULL,
  `ID` VARCHAR(15) CHARACTER SET 'utf8' NOT NULL,
  `SALARY` INT NOT NULL,
  `ENT_DATE` NCHAR(8) NOT NULL COMMENT '?????????',
  `RET_DATE` NCHAR(8) NULL COMMENT '?????????',
  `USE_YN` NCHAR(1) NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`PROFESSOR_CODE`),
  INDEX `fk_PROFESSOR_USER_INFO1_idx` (`ID` ASC),
  CONSTRAINT `fk_PROFESSOR_USER_INFO1`
    FOREIGN KEY (`ID`)
    REFERENCES `mydb`.`USER_INFO` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`STUDENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`STUDENT` ;

CREATE TABLE IF NOT EXISTS `mydb`.`STUDENT` (
  `STUDENT_CODE` VARCHAR(10) NOT NULL,
  `ID` VARCHAR(15) CHARACTER SET 'utf8' NOT NULL,
  `ENT_DATE` NCHAR(8) NOT NULL COMMENT '?????????',
  `RET_DATE` NCHAR(8) COMMENT '?????????',
  `GRADE` NCHAR(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`STUDENT_CODE`),
  INDEX `fk_STUDENT_USER_INFO1_idx` (`ID` ASC),
  CONSTRAINT `fk_STUDENT_USER_INFO1`
    FOREIGN KEY (`ID`)
    REFERENCES `mydb`.`USER_INFO` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MAJOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`MAJOR` ;

CREATE TABLE IF NOT EXISTS `mydb`.`MAJOR` (
  `MAJOR_CODE` NCHAR(2) NOT NULL COMMENT '??????_??????',
  `PROFESSOR_HEAD_USER_CODE` VARCHAR(10) NOT NULL COMMENT '??????_????????????',
  `MAJOR_NAME` VARCHAR(45) NOT NULL COMMENT '??????_???',
  `MAJOR_PHONE_NUMBER` VARCHAR(20) NOT NULL COMMENT '??????_?????????',
  `USE_YN` NVARCHAR(1) NOT NULL DEFAULT 'Y' COMMENT '????????????_YN',
  PRIMARY KEY (`MAJOR_CODE`),
  INDEX `fk_MAJOR_PROFESSOR1_idx` (`PROFESSOR_HEAD_USER_CODE` ASC),
  CONSTRAINT `fk_MAJOR_PROFESSOR1`
    FOREIGN KEY (`PROFESSOR_HEAD_USER_CODE`)
    REFERENCES `mydb`.`PROFESSOR` (`PROFESSOR_CODE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MINOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`MINOR` ;

CREATE TABLE IF NOT EXISTS `mydb`.`MINOR` (
  `MINOR_CODE` NCHAR(4) NOT NULL COMMENT '??????_??????',
  `MAJOR_CODE` NCHAR(2) NOT NULL COMMENT '??????_??????',
  `PROFESSOR_USER_CODE` VARCHAR(10) NOT NULL COMMENT '??????_????????????',
  `MINOR_NAME` VARCHAR(45) NOT NULL COMMENT '??????_???',
  `MINOR_SCORE` INT NOT NULL COMMENT '??????_??????',
  `USE_YN` NVARCHAR(1) NOT NULL DEFAULT 'Y' COMMENT '????????????_YN',
  INDEX `fk_MINOR_MAJOR1_idx` (`MAJOR_CODE` ASC),
  PRIMARY KEY (`MINOR_CODE`),
  INDEX `fk_MINOR_PROFESSOR1_idx` (`PROFESSOR_USER_CODE` ASC),
  CONSTRAINT `fk_MINOR_MAJOR1`
    FOREIGN KEY (`MAJOR_CODE`)
    REFERENCES `mydb`.`MAJOR` (`MAJOR_CODE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MINOR_PROFESSOR1`
    FOREIGN KEY (`PROFESSOR_USER_CODE`)
    REFERENCES `mydb`.`PROFESSOR` (`PROFESSOR_CODE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`STUDENT_GRADE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`STUDENT_GRADE` ;

CREATE TABLE IF NOT EXISTS `mydb`.`STUDENT_GRADE` (
  `GRADE` NCHAR(1) NOT NULL,
  `STUDENT_CODE` VARCHAR(10) NOT NULL,
  `MAJOR_CODE` NCHAR(2) NOT NULL,
  INDEX `fk_STUDENT_MAJOR_MAJOR1_idx` (`MAJOR_CODE` ASC),
  INDEX `fk_STUDENT_MAJOR_STUDENT1_idx` (`STUDENT_CODE` ASC),
  PRIMARY KEY (`GRADE`, `STUDENT_CODE`),
  CONSTRAINT `fk_STUDENT_MAJOR_MAJOR1`
    FOREIGN KEY (`MAJOR_CODE`)
    REFERENCES `mydb`.`MAJOR` (`MAJOR_CODE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_STUDENT_MAJOR_STUDENT1`
    FOREIGN KEY (`STUDENT_CODE`)
    REFERENCES `mydb`.`STUDENT` (`STUDENT_CODE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `mydb`.`STUDENT_SEMESTER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`STUDENT_SEMESTER` ;

CREATE TABLE IF NOT EXISTS `mydb`.`STUDENT_SEMESTER` (
  `SEMESTER` NCHAR(1) NOT NULL,
  `GRADE` NCHAR(1) NOT NULL,
  `STUDENT_CODE` VARCHAR(10) NOT NULL,
  `MINOR_CODE` NCHAR(4) NOT NULL,
  `MID_SCORE` INT(3),
  `FINAL_SCORE` INT(3),
  PRIMARY KEY (`SEMESTER`, `GRADE`, `STUDENT_CODE`, `MINOR_CODE`),
  INDEX `fk_STUDENT_SEMESTER_MINOR1_idx` (`MINOR_CODE` ASC),
  CONSTRAINT `fk_STUDENT_SEMESTER_STUDENT_GRADE1`
    FOREIGN KEY (`GRADE` , `STUDENT_CODE`)
    REFERENCES `mydb`.`STUDENT_GRADE` (`GRADE` , `STUDENT_CODE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_STUDENT_SEMESTER_MINOR1`
    FOREIGN KEY (`MINOR_CODE`)
    REFERENCES `mydb`.`MINOR` (`MINOR_CODE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
