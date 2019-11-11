FROM  192.168.0.215:80/library/openjdk:8-jdk-alpine

MAINTAINER suveng

ENV spring.profiles.active="dev"


ADD ./target/*.jar app.jar

EXPOSE 20001

ENTRYPOINT java -server -Dfile.encoding=UTF-8 -jar /app.jar
