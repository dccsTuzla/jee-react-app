# Example REST application.

This is the Java (backend) part of the application. The JavaScript (frontend) is located
inside `src/main/tsx` directory. Follow the `README.md` file in that directory for
information on how to set up the client.

### Requirements

- Java 8+ JDK https://www.oracle.com/technetwork/java/javase/downloads/index.html
- Maven 3.3+ https://maven.apache.org/

Maven and Java binaries must be in User's PATH, see https://maven.apache.org/install.html

### DBMS requirements

Application is pre-configured to work out of the box with PostgreSQL, MySQL and HSQLDB. PostgreSQL
version 10 and MySQL version 5.7 have been tested.

### Technologies

Application is written using Java SE 8 and Java EE 7 technologies:

- Enterprise Java Beans (EJB) https://docs.oracle.com/javaee/6/tutorial/doc/gijsz.html
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


|         |            |
| ---      | --- |
| createdb | Enables synchronisation of the entity changes to database at first login.|
| mysql    | Enables MySQL connector rather than default PostgreSQL |
| hsqldb   | Enables HSQLDB connector and creates an in-memory DB in the "hsqldb" directory of the project root. Also enables the `createdb` profile |

To enable a profile, pass a `-P<profile>` parameter to maven invocation, for example
`mvn clean install -Pcreatedb`. Specifying several profiles is also possible, i.e.
`mvn clean install -Pmysql -Pcreatedb`

### Starting the application

Apache TomEE 7.1.0 is preconfigured to serve single web application produced by maven build process.

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

For database profiles other than HSQL (default PostgreSQL and MySQL), table synchronisation must be
enabled with `createdb` maven profile (see above). It can also be used when creating new or updating
existing entities (see UserEntity), unless the database tables are created manually in which case
this should not be used. Preconfigured behaviour for synchronising JPA entities with database is
`create-or-extend-tables` described in [EclipseLink Wiki](https://www.eclipse.org/eclipselink/documentation/2.4/jpa/extensions/p_ddl_generation.htm).

### Meta model

JPA meta model generation is generated in the build process and can be used when creating
database queries with JPA criteria builder. For additional information, see the [following
blog post](https://www.baeldung.com/hibernate-criteria-queries-metamodel).

### Useful links

- https://www.tutorialspoint.com/ejb/
- https://www.tutorialspoint.com/jpa/
- https://github.com/vojtechhabarta/typescript-generator/
