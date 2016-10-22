package code4tarnovo.mockito.persistent.adapter.jdbc;

import code4tarnovo.mockito.core.Provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by alroy on 22.10.16.
 */
public class ConnectionProvider implements Provider<Connection> {
    private final String database;


    public ConnectionProvider(String database) {
        this.database = database;
    }

    @Override
    public Connection get() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + database + "?user=root&password=Alroy93102339640");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("The MySQL JDBC driver wasn't configured");
        }
        if (connection == null) {
            try {
                throw new SQLException("There was an error with your connection.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}

