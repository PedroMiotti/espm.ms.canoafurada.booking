CREATE DATABASE `espm.ms.booking`;

CREATE TABLE `espm.ms.booking`.`booking` (
  `id` char(36) NOT NULL,
  `idCabin` char(36) NOT NULL,
  `reservedDate` DATE NOT NULL,
  `totalTravelers` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
