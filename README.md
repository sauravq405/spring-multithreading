# Spring Multithreading Project

Welcome to the Spring Multithreading Project. This project demonstrates multi-threading concepts within a Spring Boot application.

## Important Notice: Lombok Dependency Issue

When setting up this project, you might encounter an issue related to Lombok, where methods generated by Lombok annotations (like `@Getter`, `@Setter`) are not recognized during compilation or when starting the server. This can lead to errors like `java: cannot find symbol` even though the code seems correct in your IDE.

### Solution

To resolve this issue, ensure that you include the Lombok dependency in your `pom.xml` before building the project for the first time or before starting the server. Here is the dependency you should add:

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.20</version> <!-- Use the latest version -->
    <scope>provided</scope>
</dependency>
```
**Resolving Bean Validation Warning**
During the setup or runtime, you might see a warning like:
```
o.s.v.b.OptionalValidatorFactoryBean     : Failed to set up a Bean Validation provider: jakarta.validation.NoProviderFoundException: Unable to create a Configuration, because no [Jakarta Bean Validation provider] could be found. Add a provider like [Hibernate Validator] (RI) to your classpath.
```
**Solution**
To get rid of this warning, you need to add the Spring Boot Starter Validation dependency to your pom.xml. This dependency includes Hibernate Validator, which is a Jakarta Bean Validation provider, resolving the issue. Here's how you should add it:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

**Note**: This dependency was added to this project from the very beginning to avoid such issues. If you're creating a new project, make sure to include this dependency right after project creation.

**Additional Steps:**
IDE Configuration: If you're using an IDE like IntelliJ IDEA, ensure that annotation processing is enabled:
Go to Preferences > Build, Execution, Deployment > Compiler > Annotation Processors and check "Enable annotation processing".
Lombok Plugin: Install the Lombok plugin if your IDE supports it to improve Lombok annotation recognition.

**Project Setup:**
To set up this project:

Clone the repository.
Ensure Maven is installed and configured.
Run mvn clean install to build the project.
Start the application with ``` mvn spring-boot:run ``` or through your IDE.

**Swagger Documentation**
For API documentation, you can access Swagger UI at:
```
http://localhost:8090/swagger-ui/index.html#/
```

This URL will provide you with interactive documentation of the RESTful services in this project.