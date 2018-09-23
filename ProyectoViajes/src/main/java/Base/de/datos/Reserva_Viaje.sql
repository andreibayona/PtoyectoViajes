-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Reserva_Viaje
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Reserva_Viaje` ;

-- -----------------------------------------------------
-- Schema Reserva_Viaje
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Reserva_Viaje` DEFAULT CHARACTER SET utf8 ;
USE `Reserva_Viaje` ;

-- -----------------------------------------------------
-- Table `Reserva_Viaje`.`pasajero`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Reserva_Viaje`.`pasajero` ;

CREATE TABLE IF NOT EXISTS `Reserva_Viaje`.`pasajero` (
  `idconductor` INT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `edad` VARCHAR(45) NULL,
  `ciudad` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`idconductor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Reserva_Viaje`.`conductor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Reserva_Viaje`.`conductor` ;

CREATE TABLE IF NOT EXISTS `Reserva_Viaje`.`conductor` (
  `idconductor` INT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `edad` VARCHAR(45) NULL,
  `ciudad` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`idconductor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Reserva_Viaje`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Reserva_Viaje`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `Reserva_Viaje`.`usuarios` (
  `idusuario` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `sesion_idUsuario` INT NOT NULL,
  `ciudad_idciudad` INT NOT NULL,
  `pasajero_idconductor` INT NOT NULL,
  `conductor_idconductor` INT NOT NULL,
  PRIMARY KEY (`idusuario`),
  INDEX `fk_usuarios_pasajero_idx` (`pasajero_idconductor` ASC),
  INDEX `fk_usuarios_conductor1_idx` (`conductor_idconductor` ASC),
  CONSTRAINT `fk_usuarios_pasajero`
    FOREIGN KEY (`pasajero_idconductor`)
    REFERENCES `Reserva_Viaje`.`pasajero` (`idconductor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_conductor1`
    FOREIGN KEY (`conductor_idconductor`)
    REFERENCES `Reserva_Viaje`.`conductor` (`idconductor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Reserva_Viaje`.`reserva`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Reserva_Viaje`.`reserva` ;

CREATE TABLE IF NOT EXISTS `Reserva_Viaje`.`reserva` (
  `usuario` VARCHAR(45) NOT NULL,
  `puestosReservados` VARCHAR(45) NOT NULL,
  `destino` VARCHAR(45) NOT NULL,
  `horaLlegadaOrigen` DATE NOT NULL,
  `horaLlegadaDestino` DATE NOT NULL,
  `reserva_viajecol` DATE NOT NULL,
  `fechaReserva` DATE NOT NULL,
  `horaReserva` VARCHAR(45) NOT NULL,
  `idreserva` VARCHAR(45) NOT NULL,
  `ciudad_idciudad` INT NOT NULL,
  `publicar_viaje_caracteristicasCarro` VARCHAR(45) NOT NULL,
  `pasajero_idconductor` INT NOT NULL,
  PRIMARY KEY (`idreserva`),
  INDEX `idreserva` (`idreserva` ASC),
  INDEX `fk_reserva_viaje_pasajero1_idx` (`pasajero_idconductor` ASC),
  CONSTRAINT `fk_reserva_viaje_pasajero1`
    FOREIGN KEY (`pasajero_idconductor`)
    REFERENCES `Reserva_Viaje`.`pasajero` (`idconductor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Reserva_Viaje`.`viaje`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Reserva_Viaje`.`viaje` ;

CREATE TABLE IF NOT EXISTS `Reserva_Viaje`.`viaje` (
  `idviaje` INT NOT NULL,
  `inicioViaje` VARCHAR(45) NOT NULL,
  `destino` VARCHAR(45) NOT NULL,
  `cantidadPuestos` VARCHAR(45) NOT NULL,
  `precioPuesto` VARCHAR(45) NOT NULL,
  `fecha` VARCHAR(45) NOT NULL,
  `hora` VARCHAR(45) NOT NULL,
  `ciudad_idciudad` INT NOT NULL,
  `conductor_idconductor` INT NOT NULL,
  PRIMARY KEY (`idviaje`),
  INDEX `fk_publicar_viaje_conductor1_idx` (`conductor_idconductor` ASC),
  CONSTRAINT `fk_publicar_viaje_conductor1`
    FOREIGN KEY (`conductor_idconductor`)
    REFERENCES `Reserva_Viaje`.`conductor` (`idconductor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;