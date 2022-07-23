FROM maven:3.8.2-amazoncorretto-17 as build

WORKDIR /build

COPY . .

RUN mvn clean package -Dspring-boot.run.profiles=prod -DskipTests --batch-mode

FROM openjdk:17-alpine

COPY --from=build /build/target/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
