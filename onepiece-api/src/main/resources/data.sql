INSERT INTO crews (name, ship_name, origin_sea) VALUES ('Chapéus de Palha', 'Thousand Sunny', 'East Blue');
INSERT INTO crews (name, ship_name, origin_sea) VALUES ('Piratas do Ruivo', 'Red Force', 'West Blue');
INSERT INTO crews (name, ship_name, origin_sea) VALUES ('Piratas Heart', 'Polar Tang', 'North Blue');

INSERT INTO devil_fruits (name, type, power_description) VALUES ('Gomu Gomu no Mi', 'Paramecia', 'Permite ao usuário ter um corpo de borracha.');
INSERT INTO devil_fruits (name, type, power_description) VALUES ('Ope Ope no Mi', 'Paramecia', 'Permite criar uma área de controle cirúrgico.');
INSERT INTO devil_fruits (name, type, power_description) VALUES ('Mera Mera no Mi', 'Logia', 'Permite criar, controlar e se transformar em fogo.');

INSERT INTO characters (name, role, bounty, status, crew_id, devil_fruit_id) VALUES ('Monkey D. Luffy', 'Capitão', '3.000.000.000', 'Ativo', 1, 1);
INSERT INTO characters (name, role, bounty, status, crew_id, devil_fruit_id) VALUES ('Trafalgar Law', 'Capitão/Médico', '3.000.000.000', 'Ativo', 3, 2);
INSERT INTO characters (name, role, bounty, status, crew_id, devil_fruit_id) VALUES ('Portgas D. Ace', 'Comandante', '550.000.000', 'Falecido', 1, 3);