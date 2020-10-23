<h1 align="center">OSWorks</h1>

<p align="center">
   <img alt="Spring" title="Spring" width="100" height="80" src=".github/logoSpring.png" />
   <img alt="Jakarta" title="Jakarta" width="100" height="80" src=".github/logoJakarta.png" />
   <img alt="MySQL" title="MySQL" width="100" height="80" src=".github/logoMySQL.png" />
   <img alt="Flyway" title="Flyway" width="100" height="80" src=".github/logoFlyway.png" />
</p>

<p> API type : service Web </p>
<p> Modèle architectural : REST </p>

<p align="center">
  <a href="#-technologies">Technologies</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projet">Projet</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-environnement">Environnement</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
</p>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=PRs&message=welcome&color=15C3D6&labelColor=000000" alt="PRs welcome!" />
 <img alt="License" src="https://img.shields.io/static/v1?label=license&message=MIT&color=15C3D6&labelColor=000000">
</p>

<br>

## 🚀 Technologies

Ce projet a été développé avec les technologies suivantes:

- [Spring](https://spring.io/)
  - [Spring Framework](https://spring.io/projects/spring-framework/)
  - [Spring Data JPA](https://spring.io/projects/spring-data-jpa/)
  - [Spring Boot](https://spring.io/projects/spring-boot/)

- [Jakarta Persistence](https://jakarta.ee/projects/)
- [Flyway](https://flywaydb.org/)
- [Insomnia](https://insomnia.rest/download/)
- [MySQL](https://www.mysql.com/)
  

## 💻 Projet

<p align="center">
   <img alt="UML" title="UML" width="200" height="120" src=".github/CaptureUML.PNG" />
   <img alt="MySQL" title="MySQL" width="200" height="120" src=".github/CaptureMySQLOSWorks.PNG" />
   <img alt="Insominia" title="Insomnia" width="200" height="120" src=".github/CaptureInsomniaOSWorks.PNG" />
   <img alt="Eclipse" title="Eclipse" width="200" height="120" src=".github/Capture_Osworks.PNG" />
</p>

---

## ⚡ Environnement

Pour développer des applications serveur avec Java, vous avez besoin d'installer le [JDK](jdk.java.net/).

Pour le développement d'API:  [Spring Tool Suite](https://spring.io/tools/) ou IDE de votre choix, l'importation du fichier généré par le service [Spring initializr](https://start.spring.io/).

Pour tester les requêtes / réponses générées par l'API: [Postman](https://www.postman.com/downloads/) ou [Insominia](https://insomnia.rest/download/).

Pour la persistance des données: [MySQL Server](https://dev.mysql.com/downloads/mysql/).
Pour l'administration du serveur MySQL: e [MySQL Workbench](https://dev.mysql.com/downloads/workbench/).

D'abord, il faut configurer la connexion avec la base de données. Properties se trouve dans le fichier : /src/main/resources/application.properties.
Par default cette application utilise database(name: osworks, user: root, password: root).


Projet développé au cours de la semaine "Curso de Spring REST pour les débutants" promu par Algaworks, Brésil.
