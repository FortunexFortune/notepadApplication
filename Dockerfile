FROM openjdk:8-jdk-alpine
EXPOSE 8080
CMD ["java","-jar","notepadApplication-0.0.1-SNAPSHOT.jar"]