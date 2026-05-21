INSERT INTO crew (name, ship_name, origin_sea) VALUES ('Chapeus de Palha', 'Thousand Sunny', 'East Blue');
INSERT INTO crew (name, ship_name, origin_sea) VALUES ('Piratas do Ruivo', 'Red Force', 'West Blue');
INSERT INTO crew (name, ship_name, origin_sea) VALUES ('Piratas Heart', 'Polar Tang', 'North Blue');

INSERT INTO devil_fruit (name, type, power_description) VALUES ('Gomu Gomu no Mi', 'Paramecia', 'Corpo de borracha.');
INSERT INTO devil_fruit (name, type, power_description) VALUES ('Ope Ope no Mi', 'Paramecia', 'Cria uma area de controle cirurgico.');
INSERT INTO devil_fruit (name, type, power_description) VALUES ('Mera Mera no Mi', 'Logia', 'Controla e se transforma em fogo.');

INSERT INTO characters (name, role, bounty, status, crew_id, devil_fruit_id) VALUES ('Monkey D. Luffy', 'Capitao', '3.000.000.000', 'Ativo', 1, 1);
INSERT INTO characters (name, role, bounty, status, crew_id, devil_fruit_id) VALUES ('Trafalgar Law', 'Capitao/Medico', '3.000.000.000', 'Ativo', 3, 2);
INSERT INTO characters (name, role, bounty, status, crew_id, devil_fruit_id) VALUES ('Portgas D. Ace', 'Comandante', '550.000.000', 'Falecido', 1, 3);