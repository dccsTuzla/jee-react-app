# Example REST application.

This is the Java (backend) part of the application. The TypeScript (frontend) is located
inside `src/frontend` directory. Follow the `README.md` file in that directory for
information on how to set up the client.

### Requirements

- Java 11+ JDK https://www.oracle.com/technetwork/java/javase/downloads/index.html
- Maven 3.6+ https://maven.apache.org/

Maven and Java binaries must be in User's PATH, see https://maven.apache.org/install.html

### DBMS requirements

Application is pre-configured to work out of the box with PostgreSQL and HSQLDB. PostgreSQL
version 13 has been tested.

### Technologies

Application is written using Java SE 11 and Java EE 8 technologies:

- Contexts and Dependency injection (CDI) https://docs.oracle.com/javaee/6/tutorial/doc/giwhl.html
- RESTful Web Services (JAX-RS) https://docs.oracle.com/javaee/6/tutorial/doc/giepu.html
- Java Persistence API (JPA) https://docs.oracle.com/javaee/6/tutorial/doc/bnbpz.html

### Build and install

Examine <properties> section of `pom.xml` file to adjust any DB related properties, such as url,
user name and password. The default build procedure is `mvn clean install`, which will build and
install web application.

### Build profiles

Additional build profiles have been preconfigured to adjust the build process to use different
DBMS or to enable synchronisation of the entities to database.


|        |                                                                                                     |
|--------|-----------------------------------------------------------------------------------------------------|
| hsqldb | Enables HSQLDB connector and creates an in-memory DB in the "hsqldb" directory of the project root. |

To enable a profile, pass a `-P<profile>` parameter to maven invocation, for example
`mvn clean install -Phsql`.

### Starting the application

Apache TomEE 8.x is preconfigured to serve single web application produced by maven build process.

To start the application issue `mvn tomee:run` after the build process has been completed. Application
will be served on http://localhost:8080, and the example REST resource that reads the user table can
be accessed from http://localhost:8080/rest/users.

Remote debugging is enabled on port 5005. An IDE with remote debugging capabilities can be used
(such as Eclipse or IntelliJ IDEA).

### Quick start guide

In the root directory, run

```
mvn clean install -Phsql tomee:run
```

This will start TomEE with [HSQLDB](http://hsqldb.org/) as a database backend and synchronize JPA
entities to database. The application has a single REST resource located at
http://localhost:8080/rest/users, which will read all users from the user table and return them as JSON.

### Meta model

JPA meta model generation is generated in the build process and can be used when creating
database queries with JPA criteria builder. For additional information, see the [following
blog post](https://www.baeldung.com/hibernate-criteria-queries-metamodel).

### Useful links

- https://www.tutorialspoint.com/jpa/
- https://github.com/vojtechhabarta/typescript-generator/
