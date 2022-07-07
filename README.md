# TrendyolCase-HaticeEtoglu

# Running 

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
