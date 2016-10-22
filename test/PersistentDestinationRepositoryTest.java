import code4tarnovo.mockito.core.Destination;
import code4tarnovo.mockito.persistent.adapter.jdbc.ConnectionProvider;
import code4tarnovo.mockito.persistent.adapter.jdbc.PersistentDestinationRepository;
import code4tarnovo.mockito.persistent.datastore.DataStore;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by alroy on 22.10.16.
 */
public class PersistentDestinationRepositoryTest {
    ConnectionProvider connectionProvider = new ConnectionProvider("TARNOVOINF");
    DataStore dataStore = new DataStore(connectionProvider);
    PersistentDestinationRepository destinationRepository = new PersistentDestinationRepository(dataStore);

    Destination destination = new Destination("asd", "asd", "asd", "asd", 1d);
    Destination destination2 = new Destination("asdd", "asdd", "asdd", "asdd", 2d);

    @Before
    public void fillup() {
        deleteTable();
        destinationRepository.register(destination);
        destinationRepository.register(destination2);
    }


    @Test
    public void refisteringDestinationsTest() throws Exception {
        List<Destination> expected=new LinkedList<>();
        expected.add(destination);
        expected.add(destination2);
        List<Destination> actual=destinationRepository.getAll();
        System.out.println(actual);
        assertThat(actual,is(expected));

    }

    private void deleteTable() {
        Connection connection = connectionProvider.get();
        String query = "DELETE FROM DESTINATION";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
