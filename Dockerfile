FROM docker.io/maven
WORKDIR /usr/src/app
EXPOSE 8080
CMD ["mvn","spring-boot:run"]