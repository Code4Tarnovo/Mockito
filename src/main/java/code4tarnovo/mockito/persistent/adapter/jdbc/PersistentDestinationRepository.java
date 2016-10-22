package code4tarnovo.mockito.persistent.adapter.jdbc;

import code4tarnovo.mockito.core.Destination;
import code4tarnovo.mockito.core.DestinationRepository;
import code4tarnovo.mockito.core.Provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by alroy on 22.10.16.
 */
public class PersistentDestinationRepository implements DestinationRepository {
    private Provider<Connection> provider;

    public PersistentDestinationRepository(Provider<Connection> provider) {
        this.provider = provider;
    }

    @Override
    public void register(Destination destination) {
        Connection connection = provider.get();
        String query = "INSERT INTO DESTINATION VALUES (?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, destination.name);
            preparedStatement.setString(2,destination.type);
            preparedStatement.setString(3,destination.adress);
            preparedStatement.setString(4,destination.info);
            preparedStatement.setDouble(5,destination.rating);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Destination getByName(String name) {
        return null;
    }

    @Override
    public List<Destination> getByType(String type) {
        return null;
    }

    @Override
    public List<Destination> getByRatingOrdered() {
        return null;
    }
}
