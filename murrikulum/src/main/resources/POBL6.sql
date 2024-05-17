CREATE TABLE `user` (
  `id` integer PRIMARY KEY,
  `erabiltzailea` varchar(255),
  `pasahitza` varchar(255),
  `rola` varchar(255)
);

CREATE TABLE `enpresa` (
  `idUser` integer,
  `enpresa_izena` varchar(255),
  `lokalidadea` varchar(255),
  `NIF` varchar(255),
  `helburua` varchar(255)
);

CREATE TABLE `lan_bila` (
  `idUser` integer,
  `izena` varchar(255),
  `abizena` varchar(255),
  `lokalidadea` varchar(255),
  `adina` integer
);

CREATE TABLE `dokumentuak` (
  `idLanBila` integer,
  `NAN` varchar(255),
  `hizkuntzak` varchar(255),
  `kurrikulum` varchar(255),
  `beste` varchar(255)
);

ALTER TABLE `enpresa` ADD FOREIGN KEY (`idUser`) REFERENCES `user` (`id`);

ALTER TABLE `lan_bila` ADD FOREIGN KEY (`idUser`) REFERENCES `user` (`id`);

ALTER TABLE `dokumentuak` ADD FOREIGN KEY (`idLanBila`) REFERENCES `lan_bila` (`idUser`);
