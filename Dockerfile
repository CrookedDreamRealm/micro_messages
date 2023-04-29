FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} messages.jar
ENTRYPOINT ["java","-jar","/messages.jar"]