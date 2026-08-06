#FROM maven:3.9-eclipse-temurin-25 AS builder
#WORKDIR /app
#COPY . .
#RUN mvn clean package -DskipTests

FROM eclipse-temurin:25-jre

WORKDIR /app

#COPY --from=builder /app/target/*.jar app.jar

COPY target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]