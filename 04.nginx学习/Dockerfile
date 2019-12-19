FROM  s-repo.ttyuyin.com/library/openjdk8-openj9:alpine-slim

MAINTAINER suveng

ENV spring.profiles.active="dev"


ADD ./target/*.jar app.jar

EXPOSE 40404

ENTRYPOINT java -server -Dfile.encoding=UTF-8 -jar /app.jar
