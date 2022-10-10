package com.example.introJOOQ.connection;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.codegen.Files;
//import org.jooq.codegen.GenerationTool;
import org.jooq.codegen.GenerationTool;
import org.jooq.impl.DSL;
import org.jooq.meta.jaxb.*;

import java.io.File;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    //provide user, password, full URL to db
    //using properties to create a Connection object by using Drivermanager and getConnection method of it
    String userName = "postgres";
    String password = "haiconmeo2";
    String url = "jdbc:postgresql://db_host:5432/introJOOQ";
    Connection conn;

    {
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //create instance DSLContext
    //can pass few other ones : H2, MySQL, SQLite
    DSLContext context = DSL.using(conn, SQLDialect.POSTGRES);

//GenerationTool.generate("
//        Files.readString(
//        Path.of("jooq-config.xml")
//        )
//        ");

    Configuration configuration = new Configuration()
            .withJdbc(new Jdbc()
                    .withDriver("org.postgresql.Driver")
                    .withUrl("jdbc:postgresql:postgres")
                    .withUser("postgres")
                    .withPassword("test"))
            .withGenerator(new Generator()
                    .withDatabase(new Database()
                            .withName("org.jooq.meta.postgres.PostgresDatabase")
                            .withIncludes(".*")
                            .withExcludes("")
                            .withInputSchema("public"))
                    .withTarget(new Target()
                            .withPackageName("org.jooq.codegen.maven.example")
                            .withDirectory("target/generated-sources/jooq")));



}
