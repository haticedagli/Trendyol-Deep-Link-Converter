# Trendyol Backend Developer Hiring Case

##### Addittional Info: This task was completed on September 12, 2021. It is not current time. 

### Task 1 (Initialize a web service)
- Start a new web service project and initialize it. It should be ready to be run.

### Task 2 (Web URL to Deeplink)
Write an endpoint that converts web URLs to deeplinks.
- The endpoint should get a web URL and return a converted deeplink.
- You must store each request and response in persistent storage.
- You should design your table columns/document fields

## Running 

- Setting PostgreSQL

```
docker run --name postgresqldb -e POSTGRES_USER=haticeetoglu -e POSTGRES_PASSWORD=123456789 -p 5432:5432 -d postgres
  ```

- Running app

```
mvn clean install
mvn spring-boot:run
  ```

# Details
- Spring Boot is used as application framework
- Main data source is PostgreSql


# API

- /api/convert/to-url     (POST)                
-# Converts deeplink to url

- /api/convert/to-deeplink      (POST)               
-# Converts url to deeplink


-You can use swagger from address below:

```
 http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/
  ```
