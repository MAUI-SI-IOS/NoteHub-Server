FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts ./

RUN tr -d '\r' < gradlew > gradlew.unix && mv gradlew.unix gradlew

RUN chmod +x ./gradlew && ./gradlew --version

RUN ./gradlew buildEnvironment --no-daemon

COPY src ./src

RUN ./gradlew bootJar --no-daemon -x test

FROM eclipse-temurin:21-jre-alpine

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

WORKDIR /

COPY --from=builder /app/build/ build

COPY --from=builder /app/build/libs/*.jar build/libs/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/app.jar"]