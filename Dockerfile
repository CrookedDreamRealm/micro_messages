RUN ./mvnw package

FROM openjdk:17-jdk-alpine
COPY ${target/*.jar} messages.jar
ENTRYPOINT ["java","-jar","/messages.jar"]