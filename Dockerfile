FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} messages.jar
ENTRYPOINT ["java","-jar","/messages.jar"]