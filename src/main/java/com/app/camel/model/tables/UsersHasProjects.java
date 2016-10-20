/**
 * This class is generated by jOOQ
 */
package com.app.camel.model.tables;


import com.app.camel.model.Keys;
import com.app.camel.model.Library;
import com.app.camel.model.tables.records.UsersHasProjectsRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class UsersHasProjects extends TableImpl<UsersHasProjectsRecord> {

    private static final long serialVersionUID = -1272943039;

    /**
     * The reference instance of <code>library.users_has_projects</code>
     */
    public static final UsersHasProjects USERS_HAS_PROJECTS = new UsersHasProjects();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsersHasProjectsRecord> getRecordType() {
        return UsersHasProjectsRecord.class;
    }

    /**
     * The column <code>library.users_has_projects.Users_id</code>.
     */
    public final TableField<UsersHasProjectsRecord, Integer> USERS_ID = createField("Users_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>library.users_has_projects.Projects_id</code>.
     */
    public final TableField<UsersHasProjectsRecord, Integer> PROJECTS_ID = createField("Projects_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>library.users_has_projects.project_start_date</code>.
     */
    public final TableField<UsersHasProjectsRecord, Timestamp> PROJECT_START_DATE = createField("project_start_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>library.users_has_projects.project_end_date</code>.
     */
    public final TableField<UsersHasProjectsRecord, Timestamp> PROJECT_END_DATE = createField("project_end_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * Create a <code>library.users_has_projects</code> table reference
     */
    public UsersHasProjects() {
        this("users_has_projects", null);
    }

    /**
     * Create an aliased <code>library.users_has_projects</code> table reference
     */
    public UsersHasProjects(String alias) {
        this(alias, USERS_HAS_PROJECTS);
    }

    private UsersHasProjects(String alias, Table<UsersHasProjectsRecord> aliased) {
        this(alias, aliased, null);
    }

    private UsersHasProjects(String alias, Table<UsersHasProjectsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Library.LIBRARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UsersHasProjectsRecord> getPrimaryKey() {
        return Keys.KEY_USERS_HAS_PROJECTS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UsersHasProjectsRecord>> getKeys() {
        return Arrays.<UniqueKey<UsersHasProjectsRecord>>asList(Keys.KEY_USERS_HAS_PROJECTS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<UsersHasProjectsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UsersHasProjectsRecord, ?>>asList(Keys.FK_USERS_HAS_PROJECTS_USERS, Keys.FK_USERS_HAS_PROJECTS_PROJECTS1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersHasProjects as(String alias) {
        return new UsersHasProjects(alias, this);
    }

    /**
     * Rename this table
     */
    public UsersHasProjects rename(String name) {
        return new UsersHasProjects(name, null);
    }
}