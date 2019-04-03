FROM openjdk:8-jdk-alpine
WORKDIR /usr/src/app
COPY /target/notepad-application-0.0.1-SNAPSHOT.jar /usr/src/app
EXPOSE 8080
CMD ["java","-jar","notepadApplication-0.0.1-SNAPSHOT.jar"]