# calculator (Logging and exception handling couldnt be done due to time constraints). I will add them later.
This repository provides APIs to perform basic calulator oprations

This app runs on port:8082

This app provides a service to maintain calculations done as records in in-memory H2 database. To login to H2 DB, you need to start the App and access "http://localhost:8082/h2-console/"

pre-requisires: java11

Steps to run this micro-service on local:

./gradlew clean build

Running this app:

./gradlew bootRun

once the app is up and running, you can verify it by access with localhost:8082/h2-console.

login to app: username : user and password: it's generated while app starts.

which should redirect you to H2 DB console login page:

JDBC URL: jdbc:h2:mem:tele2

userName: tele2

password: tele2
