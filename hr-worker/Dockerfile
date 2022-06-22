
FROM gradle:jdk17-alpine as builder

WORKDIR /builder

COPY build.gradle .
COPY gradle.properties .
COPY settings.gradle .
COPY src src

RUN gradle build --no-daemon

FROM eclipse-temurin:17-jre-alpine

COPY --from=builder /builder/build/libs/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "app.jar", "-noverify", "-XX:TieredStopAtLevel=1", "-Dspring.backgroundpreinitializer.ignore=true"]
