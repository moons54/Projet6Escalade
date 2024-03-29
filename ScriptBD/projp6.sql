CREATE TABLE public.message
(
    id integer DEFAULT nextval('message_id_seq'::regclass) PRIMARY KEY NOT NULL,
    reference char(255),
    commentaire varchar(400),
    utilisateurid integer NOT NULL,
    topoid integer NOT NULL,
    note integer,
    date_message date,
    CONSTRAINT fkmessage11222 FOREIGN KEY (utilisateurid) REFERENCES public.utilisateur (id) ON DELETE CASCADE,
    CONSTRAINT "commenter un topo" FOREIGN KEY (topoid) REFERENCES public.topo (id)
);
INSERT INTO public.message (id, reference, commentaire, utilisateurid, topoid, note, date_message) VALUES (1, '12                                                                                                                                                                                                                                                             ', 'jai bcp aime de site a refaire', 1, 1, 2, '2018-01-01');
INSERT INTO public.message (id, reference, commentaire, utilisateurid, topoid, note, date_message) VALUES (2, '21                                                                                                                                                                                                                                                             ', 'pourrait on voir une nvelle voie souvrir prochainement', 2, 4, 6, null);
CREATE TABLE public.reservation
(
    id integer DEFAULT nextval('reservation_id_seq'::regclass) PRIMARY KEY NOT NULL,
    datereservationdebut date,
    datereservationfin date,
    utilisateurid integer NOT NULL,
    topo_reservableid integer NOT NULL,
    CONSTRAINT fkreservatio166371 FOREIGN KEY (utilisateurid) REFERENCES public.utilisateur (id) ON DELETE CASCADE,
    CONSTRAINT fkreservatio254306 FOREIGN KEY (topo_reservableid) REFERENCES public.topo_reservable (id) ON DELETE SET NULL
);
INSERT INTO public.reservation (id, datereservationdebut, datereservationfin, utilisateurid, topo_reservableid) VALUES (1, '2018-12-12', '2018-12-25', 5, 1);
INSERT INTO public.reservation (id, datereservationdebut, datereservationfin, utilisateurid, topo_reservableid) VALUES (2, '2018-12-13', '2018-12-14', 3, 1);
CREATE TABLE public.secteur
(
    id integer DEFAULT nextval('secteur_id_seq'::regclass) PRIMARY KEY NOT NULL,
    nomsecteur varchar(255),
    nombrevoie integer,
    siteid integer NOT NULL,
    difficulte char(255),
    CONSTRAINT fksecteur249374 FOREIGN KEY (siteid) REFERENCES public.site (id) ON DELETE CASCADE
);
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (1, 'secteurouest', 12, 1, 'Facile                                                                                                                                                                                                                                                         ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (2, 'secteurnord', 15, 2, 'Moyen                                                                                                                                                                                                                                                          ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (3, 'secteurouest', 2, 2, 'Facile                                                                                                                                                                                                                                                         ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (4, 'secteurouest', 3, 3, 'Moyen                                                                                                                                                                                                                                                          ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (5, 'secteurnord', 2, 8, 'Facile                                                                                                                                                                                                                                                         ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (6, 'secteurnord', 4, 10, 'Difficile                                                                                                                                                                                                                                                      ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (7, 'secteurnord', 1, 9, 'Facile                                                                                                                                                                                                                                                         ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (8, 'secteurest', 3, 4, 'Difficile                                                                                                                                                                                                                                                      ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (9, 'secteurouest', 3, 8, 'Moyen                                                                                                                                                                                                                                                          ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (10, 'secteurnord', 2, 10, 'Facile                                                                                                                                                                                                                                                         ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (11, 'secteurnord', 3, 5, 'Moyen                                                                                                                                                                                                                                                          ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (12, 'secteurWest', 2, 6, 'Facile                                                                                                                                                                                                                                                         ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (13, 'secteurnordest', 1, 7, 'Difficile                                                                                                                                                                                                                                                      ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (14, 'secteurnordouest', 1, 8, 'Moyen                                                                                                                                                                                                                                                          ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (15, 'secteurnordouest', 4, 1, 'Difficile                                                                                                                                                                                                                                                      ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (16, 'secteurEst', 1, 2, 'Difficile                                                                                                                                                                                                                                                      ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (17, 'sectuerOuest', 3, 3, 'Moyen                                                                                                                                                                                                                                                          ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (18, 'secteurNord', 2, 4, 'Facile                                                                                                                                                                                                                                                         ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (19, 'secteurSud', 4, 5, 'Difficile                                                                                                                                                                                                                                                      ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (20, 'secteurEst', 1, 6, 'Facile                                                                                                                                                                                                                                                         ');
INSERT INTO public.secteur (id, nomsecteur, nombrevoie, siteid, difficulte) VALUES (21, 'secteurNord', 2, 7, 'Moyen                                                                                                                                                                                                                                                          ');
CREATE TABLE public.site
(
    id integer DEFAULT nextval('site_id_seq'::regclass) PRIMARY KEY NOT NULL,
    nom varchar(255),
    coordonnees_gps varchar(255),
    topoid integer NOT NULL,
    CONSTRAINT fksite971681 FOREIGN KEY (topoid) REFERENCES public.topo (id) ON DELETE CASCADE
);
INSERT INTO public.site (id, nom, coordonnees_gps, topoid) VALUES (1, 'colona2000', '12N 12 e 22 E', 2);
INSERT INTO public.site (id, nom, coordonnees_gps, topoid) VALUES (2, 'alonzy13', '23 E 22 N 22deg', 2);
INSERT INTO public.site (id, nom, coordonnees_gps, topoid) VALUES (3, 'calisea', '23EN33E44E', 3);
INSERT INTO public.site (id, nom, coordonnees_gps, topoid) VALUES (4, 'ALIA', '33E55N66W', 4);
INSERT INTO public.site (id, nom, coordonnees_gps, topoid) VALUES (5, 'Cereso', '23EN33E423Z', 5);
INSERT INTO public.site (id, nom, coordonnees_gps, topoid) VALUES (6, 'Planisphere', '23EB33B44', 6);
INSERT INTO public.site (id, nom, coordonnees_gps, topoid) VALUES (7, 'Site d azure', '32EB33S55W54', 1);
INSERT INTO public.site (id, nom, coordonnees_gps, topoid) VALUES (8, 'Site du Rapaille', '12E22N33SW44', 5);
INSERT INTO public.site (id, nom, coordonnees_gps, topoid) VALUES (9, 'Site des alizes', '33E44N33SW33', 5);
INSERT INTO public.site (id, nom, coordonnees_gps, topoid) VALUES (10, 'Site des eperons', '33E44N33SW12', 4);
CREATE TABLE public.topo
(
    id integer DEFAULT nextval('topo_id_seq'::regclass) PRIMARY KEY NOT NULL,
    nom varchar(255),
    description_topo varchar(255),
    historique_topo varchar(255),
    hauteur_global varchar(255),
    type_roche varchar(255),
    nombre_voie integer,
    description_du_retour varchar(255),
    type_equipement varchar(255),
    photo_topo varchar(255),
    niveau integer
);
COMMENT ON COLUMN public.topo.photo_topo IS 'photo du site';
INSERT INTO public.topo (id, nom, description_topo, historique_topo, hauteur_global, type_roche, nombre_voie, description_du_retour, type_equipement, photo_topo, niveau) VALUES (1, 'Topo des Lutins', 'topo situe pres de bressac 10 km en hauteur', 'cree en 2002 par nicolas andre forte frequentation l ete', '400', 'rocheuse', 20, 'prendre sentier balise sur 1km', 'materiel recent', '1', 1);
INSERT INTO public.topo (id, nom, description_topo, historique_topo, hauteur_global, type_roche, nombre_voie, description_du_retour, type_equipement, photo_topo, niveau) VALUES (2, 'Topo Grande traversee', 'proche de besancon entre chalon et dijon', 'cree en 2015 ', '200', 'volcanique', 12, 'redescente par le gr12 ', 'materiel recent ', '2', 3);
INSERT INTO public.topo (id, nom, description_topo, historique_topo, hauteur_global, type_roche, nombre_voie, description_du_retour, type_equipement, photo_topo, niveau) VALUES (3, 'Topo Marcel Pagnol ', 'bien situe et avec bcp de voie', 'crre en 2012', '122', 'gleisse', 22, 'as de retour', 'materiel neuf', '3', 4);
INSERT INTO public.topo (id, nom, description_topo, historique_topo, hauteur_global, type_roche, nombre_voie, description_du_retour, type_equipement, photo_topo, niveau) VALUES (4, 'Topo des alpes du sud', 'proche de la mer vu splendide', 'pas d element a ce sujet', '333', 'gleiss', 32, 'sentier gr12', 'pas d indication', '1', 5);
INSERT INTO public.topo (id, nom, description_topo, historique_topo, hauteur_global, type_roche, nombre_voie, description_du_retour, type_equipement, photo_topo, niveau) VALUES (5, 'Topo des Pyrenees', 'attention en altitude jolie et boisé', 'pas d indication ', '312', 'roche', 2, 'accessible ', 'recent ', '2', 7);
INSERT INTO public.topo (id, nom, description_topo, historique_topo, hauteur_global, type_roche, nombre_voie, description_du_retour, type_equipement, photo_topo, niveau) VALUES (6, 'Topo de la Marmotte', 'topo en altitude ', 'prendre gr20 ', '212', 'roche', 5, 'chemin difficile', 'recent', '5', 8);
CREATE TABLE public.topo_reservable
(
    id integer DEFAULT nextval('topo_reservable_id_seq'::regclass) PRIMARY KEY NOT NULL,
    datedispodebut date,
    datedispofin date,
    topoid integer NOT NULL,
    utilisateurid integer NOT NULL,
    CONSTRAINT fktopo_reser461527 FOREIGN KEY (topoid) REFERENCES public.topo (id) ON DELETE SET NULL,
    CONSTRAINT fktopo_reser466818 FOREIGN KEY (utilisateurid) REFERENCES public.utilisateur (id)
);
INSERT INTO public.topo_reservable (id, datedispodebut, datedispofin, topoid, utilisateurid) VALUES (1, '2018-01-01', '2018-12-31', 1, 2);
INSERT INTO public.topo_reservable (id, datedispodebut, datedispofin, topoid, utilisateurid) VALUES (2, '2018-01-07', '2018-10-21', 2, 4);
CREATE TABLE public.utilisateur
(
    id integer DEFAULT nextval('utilisateur_id_seq'::regclass) PRIMARY KEY NOT NULL,
    identifiant varchar(255),
    nom varchar(255),
    prenom varchar(255),
    email varchar(255),
    langue varchar(255),
    motdepasse varchar(255),
    role varchar(255),
    experience integer
);
INSERT INTO public.utilisateur (id, identifiant, nom, prenom, email, langue, motdepasse, role, experience) VALUES (1, 'admin', 'moons', 'ric', 'Ress@yahoo.fr', 'Francais', '1232', 'Administrateur', null);
INSERT INTO public.utilisateur (id, identifiant, nom, prenom, email, langue, motdepasse, role, experience) VALUES (2, 'bonausoleil', 'lefebur', 'nolan', 'nolnol@google.com', 'Francais', 'lemeilleur', 'Utilisateur', null);
INSERT INTO public.utilisateur (id, identifiant, nom, prenom, email, langue, motdepasse, role, experience) VALUES (3, 'leroidelescalade', 'Dupre', 'Eric', 'ericos@yahoo.fr', 'Francais', '4344', 'Proprietaire', null);
INSERT INTO public.utilisateur (id, identifiant, nom, prenom, email, langue, motdepasse, role, experience) VALUES (4, 'clifhanger', 'Robert', 'Regis', 'roro@yahoo.fr', 'Francais', 'pasvupaspris', 'Utilisateur', null);
INSERT INTO public.utilisateur (id, identifiant, nom, prenom, email, langue, motdepasse, role, experience) VALUES (5, 'bibi32', 'Serra', 'Gerard', 'seess@yahoo.fr', 'Francais', 'Moiaussi', 'Utilisateur', null);
CREATE TABLE public.voie
(
    id integer DEFAULT nextval('voie_id_seq'::regclass) PRIMARY KEY NOT NULL,
    nom varchar(255),
    cotation varchar(255),
    longueur varchar(255),
    secteurid integer NOT NULL,
    CONSTRAINT fkvoie645938 FOREIGN KEY (secteurid) REFERENCES public.secteur (id) ON DELETE CASCADE
);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (1, 'pasassezdetoi', '14', '12', 1);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (2, 'lsd', '12', '32', 2);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (3, 'jereviendrais', '32', '22', 3);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (4, 'pasceluila', '12', '22', 4);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (5, 'mercipourlui', '33', '11', 5);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (6, 'lemem', '21', '33', 6);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (7, 'pourquoitantdehaine', '22', '33', 7);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (8, 'Allezlom', '33', '21', 8);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (9, 'bienvue', '12', '23', 9);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (10, 'paroulasortie', '32', '12', 10);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (11, 'memepaspeur', '23', '2', 11);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (12, 'jaimelesfleurs', '12', '22', 11);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (13, 'ouillecesoir', '54', '32', 12);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (14, 'jevoussaluejulie', '23', '73', 13);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (15, 'ceshautquandmeme', '23', '23', 13);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (16, 'manutudescends', '33', '23', 14);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (17, 'lsd', '21', '21', 1);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (18, 'mercipourleshow', '12', '12', 1);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (19, 'miamdesfrites', '12', '54', 2);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (20, 'toutesbienquifinibien', '21', '54', 15);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (21, 'tuveuxoutuveuxpas', '32', '123', 16);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (22, 'wiplash', '22', '11', 17);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (23, 'altavista', '32', '32', 18);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (24, 'bienvu', '32', '23', 19);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (25, 'onyretourne', '23', '324', 20);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (26, 'jetaime', '12', '323', 21);
INSERT INTO public.voie (id, nom, cotation, longueur, secteurid) VALUES (27, 'pffcestdure', '22', '323', 20);