FROM openjdk:8-jdk-alpine
WORKDIR /usr/src/app
COPY /target/notepadApplication-0.0.1-SNAPSHOT.jar /usr/src/app
CMD ["java","-jar","notepadApplication-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
