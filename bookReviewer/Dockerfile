#Code compilation
FROM maven:3.9.5-eclipse-temurin-17-focal AS build
WORKDIR /app
#Copying Maven files
COPY pom.xml .
RUN mvn dependency:go-offline
#Copying all source code
COPY src ./src
#Packing application to jar file
RUN mvn clean package -DskipTests

#Easier looklike
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
#copying builded jar file
COPY --from=build /app/target/*.jar app.jar
#running spring boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
