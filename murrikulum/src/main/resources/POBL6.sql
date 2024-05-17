CREATE DATABASE IF NOT EXISTS users_murrikulum;

USE users_murrikulum;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
  `erabiltzailea` VARCHAR(255),
  `pasahitza` VARCHAR(255),
  `rola` VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS `enpresa` (
  `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
  `idUser` INTEGER,
  `enpresa_izena` VARCHAR(255),
  `lokalidadea` VARCHAR(255),
  `NIF` VARCHAR(255),
  `email` VARCHAR(255),
  `helburua` INTEGER, -- 1 --> lana eskaini, 2 --> kurtsoak eskaini, 3 --> dana eskaini
  FOREIGN KEY (`idUser`) REFERENCES `user` (`id`)
);

CREATE TABLE IF NOT EXISTS `lan_bila` (
  `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
  `idUser` INTEGER,
  `izena` VARCHAR(255),
  `abizena` VARCHAR(255),
  `lokalidadea` VARCHAR(255),
  `adina` INTEGER,
  `email` VARCHAR(255),
  FOREIGN KEY (`idUser`) REFERENCES `user` (`id`)
);

CREATE TABLE IF NOT EXISTS `dokumentuak` (
  `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
  `idLanBila` INTEGER,
  `NAN` VARCHAR(255),
  `hizkuntzak` VARCHAR(255),
  `kurrikulum` VARCHAR(255),
  `beste` VARCHAR(255),
  FOREIGN KEY (`idLanBila`) REFERENCES `lan_bila` (`id`)
);

INSERT INTO `user` (`erabiltzailea`, `pasahitza`, `rola`) VALUES 
('usuario1', 'contraseña1', 'arrunta'),
('usuario2', 'contraseña2', 'enpresa'),
('usuario3', 'contraseña3', 'enpresa');


INSERT INTO `enpresa` (`idUser`, `enpresa_izena`, `lokalidadea`, `NIF`, `email`, `helburua`) VALUES 
(1, 'Empresa 1', 'Lokalitatea 1', '12345678A', 'a@a.com', '1'),
(2, 'Empresa 2', 'Lokalitatea 2', '87654321B', 'a@a.com', '2'),
(3, 'Empresa 3', 'Lokalitatea 3', '54321678C', 'a@a.com','3');


INSERT INTO `lan_bila` (`idUser`, `izena`, `abizena`, `lokalidadea`, `adina`, `email`) VALUES 
(1, 'Izena1', 'Abizena1', 'Lokalitatea 1', 25, 'a@a.com'),
(2, 'Izena2', 'Abizena2', 'Lokalitatea 2', 30, 'a@a.com'),
(3, 'Izena3', 'Abizena3', 'Lokalitatea 3', 35, 'a@a.com');


INSERT INTO `dokumentuak` (`idLanBila`, `NAN`, `hizkuntzak`, `kurrikulum`, `beste`) VALUES 
(1, '12345678A', 'Euskera', 'Kurrikuluma testua 1', 'Beste informazioa 1'),
(2, '87654321B', 'Gaztelania', 'Kurrikuluma testua 2', 'Beste informazioa 2'),
(3, '54321678C', 'Ingelesa', 'Kurrikuluma testua 3', 'Beste informazioa 3');

