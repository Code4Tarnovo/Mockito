package code4tarnovo.mockito.persistent.adapter.jdbc;

import code4tarnovo.mockito.core.Destination;
import code4tarnovo.mockito.core.DestinationRepository;
import code4tarnovo.mockito.persistent.datastore.DataStore;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by alroy on 22.10.16.
 */
public class PersistentDestinationRepository implements DestinationRepository {
    private final DataStore dataStore;

    public PersistentDestinationRepository(DataStore dataStore) {
        this.dataStore=dataStore;
    }

    @Override
    public void register(Destination destination) {

        String query = "INSERT INTO DESTINATION VALUES (?,?,?,?,?)";
        dataStore.update(query,destination.name,destination.type,destination.adress,destination.info,destination.rating);

    }

    @Override
    public List<Destination> getAll() {
        String query = "SELECT * FROM DESTINATION";
        return dataStore.fetchRows(query, resultSet -> {
            try {
                return new Destination(resultSet.getString(1),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getDouble(5));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    @Override
    public List<Destination> getByName(String name) {
        String query = "SELECT * FROM DESTINATION WHERE NAME='"+name+"'";
        return dataStore.fetchRows(query, resultSet -> {
            try {
                return new Destination(resultSet.getString(1),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getDouble(5));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    @Override
    public List<Destination> getByType(String type) {
        String query = "SELECT * FROM DESTINATION WHERE TYPE='"+type+"'";
        return dataStore.fetchRows(query, resultSet -> {
            try {
                return new Destination(resultSet.getString(1),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getDouble(5));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    @Override
    public List<Destination> getByRatingOrdered() {
        String query = "SELECT * FROM DESTINATION ORDER BY RATING DESC";
        return dataStore.fetchRows(query, resultSet -> {
            try {
                return new Destination(resultSet.getString(1),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getDouble(5));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }
}
