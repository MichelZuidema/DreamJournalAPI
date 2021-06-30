<div align="center">

# DreamJournal API

#### Backend application for [DreamJournal](https://github.com/MichelZuidema/DreamJournal)

<br>

***

[![BCH compliance](https://bettercodehub.com/edge/badge/MichelZuidema/DreamJournalAPI?branch=master&token=6b52994b2d5b405dad0a85740b9e444dd6497abb)](https://bettercodehub.com/)

</div>

<br>

### Requirements
1. Local Apache and MySQL server.
2. Java 14.

### Setup
1. Clone or download this repository (DreamJournalAPI)
2. Insert "dreamjournal_db.sql" in your local MySQL server.
3. Open this project in IntelliJ.
4. Wait for Maven to install / index the dependencies.
5. Open src/main/resources/application.properties, add your MySQL username to: "spring.datasource.username=" and add your MySQL password to: "spring.datasource.password=". 
5. Open the "Maven" menu on the right of the screen.
6. Click on "DreamJournal API" -> "Lifecycle" -> "package"
7. Run target/backendapi-0.0.1-SNAPSHOT.jar

### Made by:

- [Michel Zuidema](https://github.com/MichelZuidema)