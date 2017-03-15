-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema university
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema university
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `university` DEFAULT CHARACTER SET utf8 ;
USE `university` ;

-- -----------------------------------------------------
-- Table `university`.`courses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `university`.`courses` (
  `idCourses` INT(11) NOT NULL,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `Teacher` VARCHAR(45) NULL DEFAULT NULL,
  `Year` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idCourses`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `university`.`students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `university`.`students` (
  `idStudents` INT(11) NOT NULL,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `BirthDate` VARCHAR(45) NULL DEFAULT NULL,
  `Address` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idStudents`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `university`.`application`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `university`.`application` (
  `idApplication` INT(11) NOT NULL,
  `Students_idStudents` INT(11) NOT NULL,
  `Courses_idCourses` INT(11) NOT NULL,
  PRIMARY KEY (`idApplication`, `Students_idStudents`, `Courses_idCourses`),
  INDEX `fk_Application_Students_idx` (`Students_idStudents` ASC),
  INDEX `fk_Application_Courses1_idx` (`Courses_idCourses` ASC),
  CONSTRAINT `fk_Application_Courses1`
    FOREIGN KEY (`Courses_idCourses`)
    REFERENCES `university`.`courses` (`idCourses`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Application_Students`
    FOREIGN KEY (`Students_idStudents`)
    REFERENCES `university`.`students` (`idStudents`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
