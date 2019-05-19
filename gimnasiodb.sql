-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gimnasiodb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gimnasiodb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gimnasiodb` DEFAULT CHARACTER SET utf8 ;
USE `gimnasiodb` ;

-- -----------------------------------------------------
-- Table `gimnasiodb`.`Membresia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gimnasiodb`.`Membresia` (
  `idMembresia` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  `costo` INT NOT NULL,
  PRIMARY KEY (`idMembresia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gimnasiodb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gimnasiodb`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `idMembresia` INT NOT NULL,
  `nombre` VARCHAR(25) NOT NULL,
  `paterno` VARCHAR(30) NOT NULL,
  `materno` VARCHAR(30) NULL,
  `telefono` VARCHAR(10) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `domicilio` VARCHAR(60) NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `fk_Cliente_Membresia1_idx` (`idMembresia` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_Membresia1`
    FOREIGN KEY (`idMembresia`)
    REFERENCES `gimnasiodb`.`Membresia` (`idMembresia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gimnasiodb`.`Servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gimnasiodb`.`Servicio` (
  `idServicio` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `costo` INT NOT NULL,
  `instructor` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`idServicio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gimnasiodb`.`Promocion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gimnasiodb`.`Promocion` (
  `idPromocion` INT NOT NULL AUTO_INCREMENT,
  `idServicio` INT NOT NULL,
  `fechaInicio` DATE NOT NULL,
  `fechaFin` DATE NOT NULL,
  `descuento` FLOAT NOT NULL,
  PRIMARY KEY (`idPromocion`),
  INDEX `idservicio_fk_idx` (`idServicio` ASC) VISIBLE,
  CONSTRAINT `idservicio_fk`
    FOREIGN KEY (`idServicio`)
    REFERENCES `gimnasiodb`.`Servicio` (`idServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gimnasiodb`.`Pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gimnasiodb`.`Pago` (
  `idPago` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `idMembresia` INT NOT NULL,
  `monto` INT NOT NULL,
  `fecha` DATE NOT NULL,
  PRIMARY KEY (`idPago`),
  INDEX `fk_Pago_Cliente1_idx` (`idCliente` ASC) VISIBLE,
  INDEX `fk_Pago_Membresia1_idx` (`idMembresia` ASC) VISIBLE,
  CONSTRAINT `fk_Pago_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `gimnasiodb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pago_Membresia1`
    FOREIGN KEY (`idMembresia`)
    REFERENCES `gimnasiodb`.`Membresia` (`idMembresia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gimnasiodb`.`HorarioServicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gimnasiodb`.`HorarioServicio` (
  `idHorarioServicio` INT NOT NULL AUTO_INCREMENT,
  `idServicio` INT NOT NULL,
  `dia` VARCHAR(10) NOT NULL,
  `horaInicio` DATETIME NOT NULL,
  `horaFin` DATETIME NOT NULL,
  PRIMARY KEY (`idHorarioServicio`),
  INDEX `fk_HorarioServicio_Servicio1_idx` (`idServicio` ASC) VISIBLE,
  CONSTRAINT `fk_HorarioServicio_Servicio1`
    FOREIGN KEY (`idServicio`)
    REFERENCES `gimnasiodb`.`Servicio` (`idServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gimnasiodb`.`Equipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gimnasiodb`.`Equipo` (
  `idEquipo` INT NOT NULL AUTO_INCREMENT,
  `idServicio` INT NOT NULL,
  `nombre` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idEquipo`),
  INDEX `fk_Equipo_Servicio1_idx` (`idServicio` ASC) VISIBLE,
  CONSTRAINT `fk_Equipo_Servicio1`
    FOREIGN KEY (`idServicio`)
    REFERENCES `gimnasiodb`.`Servicio` (`idServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gimnasiodb`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gimnasiodb`.`Empleado` (
  `idEmpleado` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NOT NULL,
  `paterno` VARCHAR(30) NOT NULL,
  `materno` VARCHAR(30) NULL,
  `usuario` VARCHAR(30) NOT NULL,
  `contrasenia` VARCHAR(30) BINARY NOT NULL,
  PRIMARY KEY (`idEmpleado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gimnasiodb`.`Problema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gimnasiodb`.`Problema` (
  `idProblema` INT NOT NULL AUTO_INCREMENT,
  `idEmpleado` INT NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idProblema`),
  INDEX `fk_Problema_Empleado1_idx` (`idEmpleado` ASC) VISIBLE,
  CONSTRAINT `fk_Problema_Empleado1`
    FOREIGN KEY (`idEmpleado`)
    REFERENCES `gimnasiodb`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gimnasiodb`.`Propaganda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gimnasiodb`.`Propaganda` (
  `idPropaganda` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idPropaganda`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gimnasiodb`.`servicioMembresia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gimnasiodb`.`servicioMembresia` (
  `idServicio` INT NOT NULL,
  `idMembresia` INT NOT NULL,
  INDEX `idmembresia_fk_idx` (`idMembresia` ASC) VISIBLE,
  CONSTRAINT `idserviciomem_fk`
    FOREIGN KEY (`idServicio`)
    REFERENCES `gimnasiodb`.`Servicio` (`idServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idmembresia_fk`
    FOREIGN KEY (`idMembresia`)
    REFERENCES `gimnasiodb`.`Membresia` (`idMembresia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
