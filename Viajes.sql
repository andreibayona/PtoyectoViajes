-- MySQL Script generated by MySQL Workbench
-- Sun Sep  9 17:13:11 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`ciudad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ciudad` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ciudad` (
  `idciudad` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idciudad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `mydb`.`usuarios` (
  `idusuario` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `usuarioscol` VARCHAR(45) NOT NULL,
  `usuarioscol1` VARCHAR(45) NOT NULL,
  `sesion_idUsuario` INT NOT NULL,
  `ciudad_idciudad` INT NOT NULL,
  PRIMARY KEY (`idusuario`),
  INDEX `fk_usuarios_ciudad1_idx` (`ciudad_idciudad` ASC),
  CONSTRAINT `fk_usuarios_ciudad1`
    FOREIGN KEY (`ciudad_idciudad`)
    REFERENCES `mydb`.`ciudad` (`idciudad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`sesion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`sesion` ;

CREATE TABLE IF NOT EXISTS `mydb`.`sesion` (
  `idUsuario` INT NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `registrarse` VARCHAR(45) NOT NULL,
  `usuarios_idusuario` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_sesion_usuarios1_idx` (`usuarios_idusuario` ASC),
  CONSTRAINT `fk_sesion_usuarios1`
    FOREIGN KEY (`usuarios_idusuario`)
    REFERENCES `mydb`.`usuarios` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tipo_marca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tipo_marca` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tipo_marca` (
  `idmarca` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmarca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`caracteristicas_carro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`caracteristicas_carro` ;

CREATE TABLE IF NOT EXISTS `mydb`.`caracteristicas_carro` (
  `idcarro` INT NOT NULL,
  `color` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `` VARCHAR(45) NOT NULL,
  `` VARCHAR(45) NOT NULL,
  `tipo_marca_idmarca` INT NOT NULL,
  PRIMARY KEY (`idcarro`),
  INDEX `fk_caracteristicas_carro_tipo_marca1_idx` (`tipo_marca_idmarca` ASC) ,
  CONSTRAINT `fk_caracteristicas_carro_tipo_marca1`
    FOREIGN KEY (`tipo_marca_idmarca`)
    REFERENCES `mydb`.`tipo_marca` (`idmarca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`publicar_viaje`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`publicar_viaje` ;

CREATE TABLE IF NOT EXISTS `mydb`.`publicar_viaje` (
  `idviaje` INT NOT NULL,
  `caracteristicasCarro` VARCHAR(45) NOT NULL,
  `inicioViaje` VARCHAR(45) NOT NULL,
  `destino` VARCHAR(45) NOT NULL,
  `cantidadPuestos` VARCHAR(45) NOT NULL,
  `precioPuesto` VARCHAR(45) NOT NULL,
  `fecha` VARCHAR(45) NOT NULL,
  `hora` VARCHAR(45) NOT NULL,
  `ano` VARCHAR(45) NOT NULL,
  `usuarios_idusuario` INT NOT NULL,
  `caracteristicas_carro_idcarro` INT NOT NULL,
  `ciudad_idciudad` INT NOT NULL,
  PRIMARY KEY (`caracteristicasCarro`, `usuarios_idusuario`, `caracteristicas_carro_idcarro`),
  INDEX `fk_publicar_viaje_usuarios1_idx` (`usuarios_idusuario` ASC),
  INDEX `fk_publicar_viaje_caracteristicas_carro1_idx` (`caracteristicas_carro_idcarro` ASC),
  INDEX `fk_publicar_viaje_ciudad1_idx` (`ciudad_idciudad` ASC),
  CONSTRAINT `fk_publicar_viaje_usuarios1`
    FOREIGN KEY (`usuarios_idusuario`)
    REFERENCES `mydb`.`usuarios` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_publicar_viaje_caracteristicas_carro1`
    FOREIGN KEY (`caracteristicas_carro_idcarro`)
    REFERENCES `mydb`.`caracteristicas_carro` (`idcarro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_publicar_viaje_ciudad1`
    FOREIGN KEY (`ciudad_idciudad`)
    REFERENCES `mydb`.`ciudad` (`idciudad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
