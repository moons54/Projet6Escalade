Topo Projet P6 
Creation d’un site communautaire autour de l’escalade.
Commencer
Cette application est crée en 5 sous-modules :
Topo-bussiness
Topo-consummer
Topo-model
Topo-webapp
Topo-Technical

Conditions préalables
l' application se déploie  sur un serveur Apache Tomcat 9.0.10, vous aurez aussi besoin d’une base de donnée dans notre exemple : PostgreSQL version 10


L'installation
Vous trouverez un fichier backup de la base de données dans le répertoire ScriptBD nommé scriptcreationbd.sql
voici comment procéder :
Le serveur PostgreSQL est configuré avec les paramètres par défaut :
Host name/address : localhost
Port : 5432
Username : root
Créer une database sous PostgreSQL :
Nommer la database : topoP6.


Déploiement
Créer une database sous PostgreSQL :
Nommer la database : TopoP6 ( en respectant majuscule minuscule) 
Utiliser le compte par default root.
Importer les fichiers SQL:
scriptcreationbd.sql : met en place la structure de données  : tables, attributs, séquences, clés primaires, étrangères, index uniques et tableau de 
relation.projp6.sql : il s’agit de l’image des enregistrements.
Construit avec
bootstrap- Le framework web utilisé bootstrap
Maven - Gestion de la dépendance
Struts 2- Utilisé pour gérer les Actions de l’applications
Spring- Utilisé pour la gestion des dépendances
Bean-Validation 2.0 Gestion de validations des entrées

Gestion des versions
Nous utilisons Ghitub pour la gestion des versions. 
Auteur
Mimouni Aurelien- 
Remerciements
Remerciement à mon mentor Daouda Sawadogo qui m’a suivi sur ce projet.
