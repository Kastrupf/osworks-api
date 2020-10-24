<h1 align="center">OSWorks</h1>

<p align="center">
   <img alt="Java" title="Java" width="90" height="60" src=".github/logoJava.png" />
   <img alt="Maven" title="Maven" width="90" height="60" src=".github/logoMaven.png" />
   <img alt="Spring" title="Spring" width="90" height="60" src=".github/logoSpring.png" />
   <img alt="Jakarta" title="Jakarta" width="90" height="60" src=".github/logoJakarta.png" />
   <img alt="MySQL" title="MySQL" width="90" height="60" src=".github/logoMySQL.png" />
   <img alt="ApacheTomcat" title="ApacheTomcat" width="90" height="60" src=".github/logoApacheTomcat.png" />
   <img alt="Flyway" title="Flyway" width="90" height="60" src=".github/logoFlyway.png" />
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
  - [Spring Boot](https://spring.io/projects/spring-boot/) - v2.3.4

- [Jakarta Persistence](https://jakarta.ee/projects/)
- [Flyway](https://flywaydb.org/)
- [Insomnia](https://insomnia.rest/download/)
- [MySQL](https://www.mysql.com/) - MySQL Community Server v8.0.22
- [Apache Tomcat](https://tomcat.apache.org/) - v9.0
- [ModelMapper](https://modelmapper.org/)
  

## 💻 Projet

<p align="center">
   <img alt="UML" title="UML" width="200" height="120" src=".github/CaptureUML.PNG" />
   <img alt="MySQL" title="MySQL" width="200" height="120" src=".github/CaptureMySQLOSWorks.PNG" />
   <img alt="Insominia" title="Insomnia" width="200" height="120" src=".github/CaptureInsomniaOSWorks.PNG" />
   <img alt="Eclipse" title="Eclipse" width="200" height="120" src=".github/Capture_Osworks.PNG" />
</p>

---

## ⚡ Environnement

Pour développer des applications serveur avec Java, vous avez besoin d'installer le [OpenJDK](https://jdk.java.net/). J'ai utilisé Java version 11.
Pour le développement d'API:  [Spring Tool Suite](https://spring.io/tools/) ou IDE de votre choix, l'importation du fichier généré par le service [Spring initializr](https://start.spring.io/).

Pour tester les requêtes / réponses générées par l'API: [Postman](https://www.postman.com/downloads/) ou [Insominia](https://insomnia.rest/download/).

Pour la persistance des données: [MySQL Server](https://dev.mysql.com/downloads/mysql/). J'ai choisi MySQL Community Server v8.0.22
Pour l'administration du serveur MySQL: e [MySQL Workbench](https://dev.mysql.com/downloads/workbench/).

D'abord, il faut configurer la connexion avec la base de données. Properties se trouve dans le fichier : /src/main/resources/application.properties.
Par default cette application utilise database(name: osworks, user: root, password: root).


Projet développé au cours de la semaine "Curso de Spring REST pour les débutants" promu par Algaworks, Brésil.
