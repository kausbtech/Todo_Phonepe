FROM openjdk:8-jre-alpine

WORKDIR /app
COPY target/todo-appl-1.0-SNAPSHOT.jar app.jar
COPY config.yml config.yml

CMD ["java", "-jar", "app.jar", "server", "config.yml"]
