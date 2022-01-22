# school-edbs
For both projects you need to have access to a MySQL instance running.
You can use other databases as well but you need to add the corresponding jdbc driver to the `build.gradle`.
(For the jpa-hibernate project you also need to set change the hibernate dialect.)

Adapt the connection information for your MySQL instance:
 - jpa-hibernate in the `src/main/resources/application.properties`
```properties
spring.datasource.url=jdbc:<database type>://<IP-Adress>:<Port>/<Database>
spring.datasource.username=user
spring.datasource.password=password

#validate validates db schema
#update creates or updates db schema
#create creates db and deletes previous data
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
```

 - plain-jdbc in `ch.fhnw.edbs.ConnectionProp.class`

```java
DriverManager.getConnection(
                "jdbc:mysql://<IP-Adress>:<Port>/<Database>",
                "user", "password");
```

In the plain-jdbc project you need to first run `JDBCCreateTable.class` first, to add the table.
In the jpa-hibernate project you just need to make sure that the `spring.jpa.hibernate.ddl-auto` property in `application.properties` is set properly.

For an example on how liquibase can be used take a look at [Sh4tterh4nd/lydbook](https://github.com/Sh4tterh4nd/lydbook/), located in [Sh4tterh4nd/lydbook/src/main/resources/db/changelog](https://github.com/Sh4tterh4nd/lydbook/tree/master/src/main/resources/db/changelog)