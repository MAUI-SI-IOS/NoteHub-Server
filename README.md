
# NoteHub Server

NoteHub Server is a Kotlin-based backend application providing note synchronization and markdown parsing features. It uses Spring Boot, R2DBC, and PostgreSQL.

## Requirements

To run the application, you will need:
- [Docker](https://www.docker.com/get-started) and [Docker Compose](https://docs.docker.com/compose/install/)
- Gradle (provided via `./gradlew`)

## Running with Docker Compose

The easiest way to run the application is using Docker Compose.

### Using the Pre-built Image

By default, the `compose.yaml` is configured to use the pre-built image from GitHub Container Registry.

1.  Make sure you are in the project root directory.
2.  Start the services:
    ```bash
    docker-compose up -d
    ```
    This will start both the PostgreSQL database and the NoteHub Server.
3.  The server will be accessible at `http://localhost:8080`.

### Building and Running from Local Source

If you want to build the Docker image locally from the current source code:

1.  Build the images using Docker Compose:
    ```bash
    docker-compose build
    ```
    Alternatively, you can force a build and start the services in one command:
    ```bash
    docker-compose up --build -d
    ```

## Environment Variables

The application can be configured using the following environment variables (defined in `compose.yaml`):

| Variable | Description | Default Value |
| :--- | :--- | :--- |
| `POSTGRES_HOST` | Hostname of the PostgreSQL database | `localhost` |
| `POSTGRES_DB` | Name of the database | `notehubDB` |
| `POSTGRES_USER` | Database user | `notehub` |
| `POSTGRES_PASSWORD` | Database password | `notehub_password` |

## Local Development (without Docker for the App)

If you want to run the application locally (e.g., for debugging) while still using a Dockerized database:

1.  Start only the PostgreSQL database:
    ```bash
    docker-compose up -d postgres
    ```
2.  Run the application using Gradle:
    ```bash
    ./gradlew bootRun
    ```
    *Note: Ensure you have JDK 21 installed and your environment variables are set correctly if they differ from the defaults.*

## Running Tests

The project includes unit and integration tests. Integration tests use **Testcontainers** to spin up a PostgreSQL instance, so you need to have Docker running.

### Run All Tests

To run all tests (unit and integration):
```bash
./gradlew test
```

### Run Specific Tests

If you want to run a specific test class:
```bash
./gradlew test --tests "com.mauisiios.notehub_server.unit.*"
```
Or for a single test:
```bash
./gradlew test --tests "com.mauisiios.notehub_server.integration.TestNoteRoutes"
```

### Test Requirements
- **Docker**: Required for integration tests as they use Testcontainers to launch a real PostgreSQL database.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
