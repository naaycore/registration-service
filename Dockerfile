FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
RUN ping host.docker.internal -c 4
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]