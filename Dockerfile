FROM openjdk:17
WORKDIR /app
COPY target/threads-clone-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
