-- abc_tech_db.assistances definition

CREATE TABLE `assistances` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `name` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO assistances (name, description) VALUES
('Assistência Técnica Top Electronics', 'Assistência técnica especializada em eletrônicos, com foco em celulares e computadores'),
('Assistência Técnica Eletrônica Master', 'Assistência técnica para equipamentos eletrônicos em geral, incluindo televisores, DVDs, eletrodomésticos, entre outros'),
('Assistência Técnica Cell Center', 'Assistência técnica especializada em smartphones, com destaque para as marcas Apple, Samsung e Motorola'),
('Assistência Técnica Informatec', 'Assistência técnica para computadores e periféricos, com atendimento tanto presencial quanto remoto'),
('Assistência Técnica Vidro Rápido', 'Assistência técnica para smartphones e tablets, com destaque para troca de telas e reparos em vidros quebrados'),
('Assistência Técnica Multimarcas', 'Assistência técnica para diversos tipos de equipamentos eletrônicos, como celulares, tablets, notebooks, câmeras, drones, entre outros'),
('Assistência Técnica Impressoras Express', 'Assistência técnica especializada em impressoras, com serviços de manutenção, limpeza, troca de peças, entre outros'),
('Assistência Técnica Refrigeração Top', 'Assistência técnica para equipamentos de refrigeração, como geladeiras, freezers e ar-condicionados'),
('Assistência Técnica Games Master', 'Assistência técnica para consoles de videogame, com serviços de reparo, atualização, limpeza e substituição de peças'),
('Assistência Técnica Ótica Digital', 'Assistência técnica para equipamentos óticos, como telescópios, binóculos e câmeras fotográficas, com serviços de limpeza, calibração e manutenção'),
('Assistência Técnica Celular Já', 'Assistência técnica especializada em smartphones de diversas marcas, com serviços de troca de tela, reparo de hardware e software'),
('Assistência Técnica Microsul', 'Assistência técnica para equipamentos de informática em geral, com atendimento para computadores, notebooks, impressoras, entre outros'),
('Assistência Técnica Eletrônica Fortaleza', 'Assistência técnica para equipamentos eletrônicos em geral, com serviços de manutenção, reparo, limpeza e troca de peças'),
('Assistência Técnica Automotiva Carro Forte', 'Assistência técnica para sistemas eletrônicos automotivos, incluindo alarmes, rastreadores, som automotivo, entre outros'),
('Assistência Técnica Casa do Notebook', 'Assistência técnica para notebooks, ultrabooks e tablets, com serviços de reparo, atualização e manutenção preventiva');

