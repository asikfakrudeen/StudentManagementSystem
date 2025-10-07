# Crud - Updated

Changes made:
- Replaced `@Data` on entity with safer Lombok annotations and `@EqualsAndHashCode(onlyExplicitlyIncluded = true)`.
- Added Bean Validation annotations to `PersonRequest`.
- Added `ResourceNotFoundException` and a `GlobalExceptionHandler`.
- Controller now validates request bodies (`@Valid`) and returns `201 Created` for create.
- Added H2 in-memory DB for easy local runs and added `spring-boot-starter-validation` and `h2` dependencies in `pom.xml`.
- You can still use PostgreSQL by setting up an `application-postgres.properties` or uncommenting properties.

To run locally:
1. Ensure Java 21 (project is configured for Java 21).
2. Build: `mvn -U clean package`
3. Run: `mvn spring-boot:run` or `java -jar target/Demo-0.0.1-SNAPSHOT.jar`
4. Visit Swagger UI: http://localhost:8080/swagger-ui.html
5. Visit H2 console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:persondb)

