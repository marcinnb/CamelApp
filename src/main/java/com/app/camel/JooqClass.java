package com.app.camel;

import com.google.gson.Gson;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import static com.app.camel.model.Tables.USERS;

public class JooqClass {

    private String user = null;
    private String password = null;
    private String url = null;
    private String driver = null;

    public JooqClass() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        this.user = Config.USER;
        this.password = Config.PASSWORD;
        this.url = Config.URL;
        this.driver = Config.DRIVER;

        Class.forName(driver).newInstance();
    }

    public String getAllUsers() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        List<User> users = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            DSLContext dslContext = DSL.using(connection, SQLDialect.MYSQL);

            Result<Record> result = dslContext.select().from(USERS).fetch();

            for (Record r : result) {
                User user = new User(r.getValue(USERS.ID), r.getValue(USERS.FIRST_NAME), r.getValue(USERS.LAST_NAME), r.getValue(USERS.EMAIL), r.getValue(USERS.IS_ACTIVE));

                users.add(user);
            }

            return new Gson().toJson(users);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
