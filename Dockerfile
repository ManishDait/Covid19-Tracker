FROM openjdk:17-alpine
EXPOSE 8080
ADD target/spring-cov-docker.jar spring-cov-docker.jar
ENTRYPOINT ["java","-jar","/spring-cov-docker.jar"]