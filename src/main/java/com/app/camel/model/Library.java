/**
 * This class is generated by jOOQ
 */
package com.app.camel.model;


import com.app.camel.model.tables.Project;
import com.app.camel.model.tables.User;
import com.app.camel.model.tables.UserHasProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Library extends SchemaImpl {

    private static final long serialVersionUID = -473692979;

    /**
     * The reference instance of <code>library</code>
     */
    public static final Library LIBRARY = new Library();

    /**
     * The table <code>library.project</code>.
     */
    public final Project PROJECT = com.app.camel.model.tables.Project.PROJECT;

    /**
     * The table <code>library.user</code>.
     */
    public final User USER = com.app.camel.model.tables.User.USER;

    /**
     * The table <code>library.user_has_project</code>.
     */
    public final UserHasProject USER_HAS_PROJECT = com.app.camel.model.tables.UserHasProject.USER_HAS_PROJECT;

    /**
     * No further instances allowed
     */
    private Library() {
        super("library", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Project.PROJECT,
            User.USER,
            UserHasProject.USER_HAS_PROJECT);
    }
}
