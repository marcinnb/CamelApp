package com.app.camel;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.app.camel.model.Tables.USERS;

/**
 * Created by britenet on 2016-10-20.
 */
public class JooqClass {




    public String select() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        String user = Config.USER;
        String password = Config.PASSWORD;
        String url = Config.URL;
        String driver = Config.DRIVER;

        Class.forName(driver).newInstance();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            DSLContext dslContext = DSL.using(connection, SQLDialect.MYSQL);

            Result<Record> result = dslContext.select().from(USERS).fetch();

            for (Record r : result) {
                Integer id = r.getValue(USERS.ID);
                String firstName = r.getValue(USERS.FIRST_NAME);
                String lastName = r.getValue(USERS.LAST_NAME);

                System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
            }
            String rest= result.toString();
            return rest;

        } catch (Exception e) {
            e.printStackTrace();
        }




        return null;

    }




}
