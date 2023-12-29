USE ProgettoIDS;

INSERT INTO User (name, surname, username, fiscalCode, email, password)
VALUES
  ('Vittoria', 'Forlani', 'vitto', 'ABC123XYZ45678901', 'vitto.forla@gmail.com', '$2a$10$cyZGnydVnv7JthlDzoiKz.5A6xzBQTDFwjUV2kFOWqli4EiLTVj1i'),
  ('Simone', 'Morello', 'simone', 'DEF456UVW12345678', 'simo.morello@outlook.com', '$2a$10$gQNK7PWcg9ngAOu.gBzWs.V4AOjpg/RpSzkkCLBVwrYLg317gwftO');

INSERT INTO City (cadastralCode, name, region, province, istatCode)
VALUES
  ('1234', 'Rome', 'Lazio', 'RM', 5815),
  ('5678', 'Milan', 'Lombardy', 'MI', 1512),
  ('9101', 'Florence', 'Tuscany', 'FI', 4801);

INSERT INTO Role (title, description)
VALUES
  ('Tourist', ''),
  ('Contributor', ''),
  ('Authorized Contributor', ''),
  ('Curator', ''),
  ('Animator', ''),
  ('City Manager', ''),
  ('Administrator', '');

INSERT INTO Point (name, description, longitude, latitude, altitude, imageUrl, cityId)
VALUES
  ('Colosseum', 'Ancient amphitheater', 12.4924, 41.8902, 20.0, '/images/colosseum.jpg', 1),
  ('Duomo di Milano', 'Cathedral in Milan', 9.1916, 45.4641, 105.0, '/images/duomo.jpg', 2),
  ('Ponte Vecchio', 'Historic bridge in Florence', 11.2558, 43.7687, 42.0, '/images/ponte-vecchio.jpg', 3);

INSERT INTO Contest (title, description, publicationDate, closingDate, animatorId, cityId, winnerId)
VALUES
  ('Photo Contest', 'Capture the beauty of your city', '2023-01-01 12:00:00', '2023-02-01 12:00:00', 1, 1, NULL),
  ('Art Contest', 'Express your creativity', '2023-02-01 12:00:00', '2023-03-01 12:00:00', 2, 2, NULL);

INSERT INTO Content (title, description, date, status, authorId, pointId, mediaId, contestId)
VALUES
  ('Sunset at the Colosseum', 'A beautiful sunset view', '2023-01-15 18:30:00', 'Published', 1, 1, 1, 1),
  ('Duomo Sketch', 'Artistic representation of Duomo di Milano', '2023-02-10 15:45:00', 'Draft', 2, 2, NULL, 2);
