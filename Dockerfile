# FROM openjdk:8-jdk-alpine
FROM docker.io/rowanto/docker-java8-mvn-nodejs-npm

WORKDIR /usr/src/app
COPY / /usr/src/app
EXPOSE 8080
# CMD ["java","-jar","notepadApplication-0.0.1-SNAPSHOT.jar"]
CMD ["mvn","spring-boot:run"]