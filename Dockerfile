FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts ./
# Fix line endings for Windows users and make executable
RUN tr -d '\r' < gradlew > gradlew.unix && mv gradlew.unix gradlew
RUN chmod +x ./gradlew

# Pre-download dependencies
RUN ./gradlew buildEnvironment --no-daemon

COPY src ./src
RUN ./gradlew bootJar --no-daemon -x test

FROM eclipse-temurin:21-jre-alpine
# Create a system group and user
RUN addgroup -S spring && adduser -S spring -G spring

# Create the directory for the mounted model and give 'spring' ownership
WORKDIR /app
RUN mkdir -p /app/models && chown -R spring:spring /app

# Switch to the non-root user
USER spring:spring

# Copy the JAR from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
