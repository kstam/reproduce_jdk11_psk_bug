#!/bin/bash
javac *.java
jar cvfe app.jar NetHttp *.class

docker build -t test-app-tls3 -f Dockerfile_tls3 .

javac *.java
jar cvfe app.jar NetHttp *.class
docker build -t test-app-no-tls3 -f Dockerfile_no_tls3 .
