## CMSC447 Fall 2021 Term Project - Team 10 Backend

---

### Installation
1. Clone this repository into a local directory.

HTTPS:
```
git clone https://github.com/vj36290/CMSC447_Team10_Backend.git
```

SSH:
```
git clone git@github.com:vj36290/CMSC447_Team10_Backend.git
```

2. On Windows, execute `gradlew.bat` to build the Gradle wrapper. On Linux, run:
```
gradle wrapper --gradle-version 7.2
```

3. In the root directory for the project, execute the following:

```
./gradlew build
```

4. Once the Gradle build completes, the REST API server can be run with
```
./gradlew bootrun
```

### Usage

The backend is a REST API that runs on local port 8080. Endpoints can be accessed through a web browser or the `curl` command, or through GET requests issued by other programs.

### Endpoints

### `/`
This returns the index page in a web browser. The index page also lists all endpoints.

### `/states`
Returns a JSON array where each element corresponds to data for a US state or territory.

### `/states/{state}`
Returns a JSON object corresponding to the requested state or territory (case-insensitive).

### `/counties`
Returns a JSON array where each element corresponds to data for a US county.

### `/counties/{fips}`
Returns a JSON object corresponding to the requested county by FIPS code. Please include the leading zero.