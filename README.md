# API Repository for Karto

## Contributors

- Owen Kemp
- Joshua Quaintance
- Blake Payne
- Joshua Wise

## API Usage

TODO: Merge all API Usages

## Prepartions

### Dependencies

- Java 17
- Docker Desktop
  - Comes with docker desktop:
  - Docker Engine
  - Docker Compose

### Recommended Apps

- Bruno - https://userbruno.com

## How to run

To run the API application, firstly we need to run the mariadb database. Luckily it is containeraized using docker.

### Database

To start mariadb, go into the `docker/` directory. Then inside run:

```bash
docker compose up -d
```

This will start docker compose using the config file inside the directory. It will start installing docker images and packages needed to start up the docker compose image. Wait for it to finish...

Output should look similar to this:

```
[+] Running 9/9
 ✔ mariadb Pulled                                                                                                                                                                                            65.2s
   ✔ 4b3ffd8ccb52 Pull complete                                                                                                                                                                              47.1s
   ✔ 7854007237e1 Pull complete                                                                                                                                                                              47.1s
   ✔ 8ed1b5271813 Pull complete                                                                                                                                                                              47.4s
   ✔ 402f4c7dd065 Pull complete                                                                                                                                                                              47.4s
   ✔ 2295facceabc Pull complete                                                                                                                                                                              47.4s
   ✔ eece26ecda4b Pull complete                                                                                                                                                                              63.4s
   ✔ 4c2e197f6cb0 Pull complete                                                                                                                                                                              63.5s
   ✔ 6499e85d8558 Pull complete                                                                                                                                                                              63.5s
[+] Running 2/2
 ✔ Network docker_default     Created                                                                                                                                                                         0.1s
 ✔ Container Karto-DB-Design  Started                                                                                                                                                                         0.4s
```

Once that's started, we can now start the application

### Boot Spring Java

To start it, go back to the root directory, and run:

Linux/Mac

```bash
./gradlew bootRun
```

Windows

```
./gradlew.bat bootRun
```

There should be a `gradlew` executable. This will now start up the application using spring boot. Let it start up.  
When it runs succesfully, it should look like:

```
2025-10-30T10:44:09.719-04:00  INFO 24169 --- [karto-service] [           main] c.karto.service.KartoServiceApplication  : Started KartoServiceApplication in 2.266 seconds (process running for 2.441)
```
