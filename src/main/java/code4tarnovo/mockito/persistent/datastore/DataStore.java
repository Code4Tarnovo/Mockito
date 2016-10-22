package code4tarnovo.mockito.persistent.datastore;

import code4tarnovo.mockito.core.Provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alroy on 22.10.16.
 */
public class DataStore {
    private Provider<Connection> provider;

    public DataStore(Provider<Connection> provider) {
        this.provider = provider;
    }

    public void update(String query, Object... objects) {
        Connection connection = provider.get();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            fillStatement(statement, objects);
            statement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException("Connection to the database wasn't established");
        } finally {
            close(connection);
        }
    }

    public <T> List<T> fetchRows(String query, RowFetcher<T> rowFetcher) {
        List<T> list = new LinkedList<>();
        Connection connection = provider.get();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                T row = rowFetcher.fetchRow(resultSet);
                list.add(row);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Connection to the database wasn't established");
        } finally {
            close(connection);
        }
        return list;
    }

    private void fillStatement(PreparedStatement statement, Object... objects) throws SQLException {
        for (int i = 0; i < objects.length; i++) {
            statement.setObject(i + 1, objects[i]);
        }
    }

    private void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}