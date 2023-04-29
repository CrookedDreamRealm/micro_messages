FROM eclipse-temurin:17-jre-jammy
EXPOSE 8080
#ARG JAR_FILE=app/target/*.jar
COPY /app/target/*.jar messages.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/messages.jar"]