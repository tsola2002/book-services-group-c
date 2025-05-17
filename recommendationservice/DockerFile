# Stage 1: Build with Gradle and JDK 17
FROM gradle:8.13-jdk17 AS build

USER gradle
WORKDIR /home/gradle/project

COPY --chown=gradle:gradle . .

RUN gradle clean bootJar --no-daemon

# Stage 2: Minimal runtime image
FROM eclipse-temurin:17

WORKDIR /app

EXPOSE 8000

COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
