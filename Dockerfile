FROM openjdk:8-jdk-alpine
WORKDIR /usr/src/app
COPY / /usr/src/app
EXPOSE 8080
# CMD ["java","-jar","notepadApplication-0.0.1-SNAPSHOT.jar"]
CMD ["mvn","spring-boot:run"]