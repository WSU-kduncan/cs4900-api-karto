# Karto API Repository

## Contributors

- Owen Kemp
- Joshua Quaintance
- Blake Payne
- Joshua Wise

## Required Tools

- Java SDK 17
- Docker

## Running the Service

1. Run the Database Docker Container

```
docker compose -f docker/docker-compose.yml up -d
```

2. Run the service

```
./gradlew bootRun
```

## Testing the Service

1. Install Bruno
2. Open the collection in the bruno directory.
3. Select the Local Environment in Bruno
4. Open up any of the folders and run the requests.

API Definitions are in [API Definitions.md](<API Definitions.md>)