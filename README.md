# calculator
This repository provides APIs to perform basic calulator oprations

This app runs on port:8082

This app provides a service to maintain person records in in-memory H2 database. To login to H2 DB, you need to start the App and access "http://localhost:8082/console/"

pre-requisires: java8,

local machine should have docker installed.

Steps to run this micro-service on local:

./gradlew clean build

-> the above step will create a jar file with name "personhandler-0.0.1-SNAPSHOT.jar" under /build/libs. -> this jar can be used for containerisation of this app on docker.

Running this app:

./gradlew bootRun

once the app is up and running, you can verify it by access with localhost:8082/console.

login to app: username : user and password: it's generated while app starts.

which should redirect you to H2 DB console login page:

JDBC URL: jdbc:h2:mem:tele2

userName: tele2

password: tele2
