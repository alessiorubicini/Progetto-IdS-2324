USE ProgettoIDS;

INSERT INTO User (name, surname, username, fiscalCode, email, password)
VALUES
    ('Alessio', 'Rubicini', 'alerubi', 'RSSLSI90M01H501A', 'alessiorubicini16@icloud.com', '$2a$10$TQZUtaP7F66OoyXivNM6reStfAxT0FvDbkR9AVdRykH.z3GrGPJqC'),
    ('Vittoria', 'Forlani', 'vitto', 'FRLVTR85M55H501Z', 'vitto.forla@gmail.com', '$2a$10$cyZGnydVnv7JthlDzoiKz.5A6xzBQTDFwjUV2kFOWqli4EiLTVj1i'),
    ('Simone', 'Morello', 'simone', 'MRLSMN85A15H501Z', 'simone.morello@outlook.com', '$2a$10$gQNK7PWcg9ngAOu.gBzWs.V4AOjpg/RpSzkkCLBVwrYLg317gwftO');

INSERT INTO City (id, cadastralCode, name, region, province, istatCode, longitude, latitude)
VALUES
    (1, 'G920', 'Porto San Giorgio', 'Marche', 'FM', 109033, 43.180144, 13.793122),
    (2, 'B474', 'Camerino', 'Marche', 'MC', 043007, 43.135702, 13.068382),
    (3, 'I608', 'Senigallia', 'Marche', 'AN', 042045, 43.719696, 13.215435);

INSERT INTO Point (id, name, description, imageUrl, cityId)
VALUES
    (1, 'Mobility', 'Unlock seamless urban mobility in our city—effortless travel, efficient transportation, and interconnected pathways for a vibrant city life.', 'https://geospatialmedia.s3.amazonaws.com/wp-content/uploads/2019/05/smart-transportation-smart-city.png', 2),
    (2, 'Gastronomy', 'Savor the city''s culinary delights in the vibrant Gastronomy district – a haven of diverse flavors and gastronomic experiences. Bon appétit!', 'https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/36b45454981539.59714c1191971.png', 2),
    (3, 'Sport', 'Discover the heart of our city''s sports scene – a vibrant hub for enthusiasts, featuring top-notch facilities and exciting events. #CitySports', 'https://img.freepik.com/free-vector/national-sports-day-illustration_23-2148993654.jpg?size=626&ext=jpg&ga=GA1.1.1546980028.1704326400&semt=ais', 2),
    (4, 'History', 'Dive into the past of our city! Uncover its rich history, from ancient origins to modern milestones. Walk the footsteps of time', 'https://media.istockphoto.com/id/1092170968/vector/open-book-with-history-doodles-and-lettering.jpg?s=612x612&w=0&k=20&c=SvXn0O25eHC8ARjwlcn83kahxjMGl2ti_DDFGozBKqg=', 2),
    (5, 'Tourism', 'Explore enchanting landmarks, vibrant culture, and hidden gems in our city''s Tourism hub. Unforgettable experiences await!', 'https://st4.depositphotos.com/16470190/25651/v/450/depositphotos_256510820-stock-illustration-planning-travel-with-online-services.jpg', 2);

INSERT INTO Point (id, name, description, longitude, latitude, altitude, imageUrl, cityId)
VALUES
    (6, 'ChIP', 'The Chemistry Interdisciplinary Project (ChIP) is a new research center at the University of Camerino. The center’s design is inspired by the shape of an integrated circuit chip and is constructed using innovative techniques to ensure safety in the event of an earthquake.', 43.141148, 13.069556, 661, 'https://media.licdn.com/dms/image/C4D1BAQGwCjmEyT3SeQ/company-background_10000/0/1647002794380/chip_unicam_cover?e=2147483647&v=beta&t=zeFwzvOmhAjJhPUMuYTfpuD8YXbbvHQukE5z3aKfxH8', 2)

INSERT INTO Content (id, title, description, publicationDate, status, mediaUrl, authorId, pointId)
VALUES
    (1, 'Convegno di astrofisica', 'A beautiful sunset view', '2023-01-15 18:30:00', 'Published', 'https://www.unicam.it/sites/default/files/eventi/2021/10/loc/scuola_Urbani_10marzo2021.jpeg', 1, 6);

INSERT INTO Contest (id, title, description, publicationDate, closingDate, animatorId, cityId)
VALUES
    (1, 'Christmas Markets', 'Capture the beauty of your city', '2023-12-15 15:00:00', '2023-12-22 00:00:00', 1, 2),
    (2, 'Art Contest', 'Express your creativity', '2023-07-26 11:00:00', '2023-08-14 18:00:00', 1, 3);

INSERT INTO Role (title, description)
VALUES
    ('Tourist', ''),
    ('Contributor', ''),
    ('Authorized Contributor', ''),
    ('Curator', ''),
    ('Animator', ''),
    ('City Manager', '');