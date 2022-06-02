CREATE DATABASE `espm.ms.booking`;

CREATE TABLE `espm.ms.booking`.`booking` (
  `id` char(36) NOT NULL,
  `id_cabin` char(36) NOT NULL,
  `id_user` char(36) NOT NULL,
  `reserved_date` DATE NOT NULL,
  `total_travelers` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
