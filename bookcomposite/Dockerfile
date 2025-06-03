# 1) Build stage: compile & package your composite
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# copy POM & fetch dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# copy sources & build
COPY src ./src
RUN mvn clean package -DskipTests -B

# 2) Runtime stage: slim JRE image
FROM eclipse-temurin:17-jre

WORKDIR /app

# copy the fat-jar (CHANGE this if your artifactId / version differs)
COPY --from=build /app/target/bookcomposite-0.0.1-SNAPSHOT.jar app.jar

# expose the port your Spring Boot app runs on
EXPOSE 8080

# run the jar
ENTRYPOINT ["java","-jar","app.jar"]
