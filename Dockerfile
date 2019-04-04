FROM openjdk:8-jdk-alpine
WORKDIR /usr/src/app
COPY /target/notepadApplication-0.0.1-SNAPSHOT.jar /usr/src/app
EXPOSE 8081
CMD ["java","-jar","notepadApplication-0.0.1-SNAPSHOT.jar"]