FROM openjdk:11
ADD target/spring-boot-mongodb-docker.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]