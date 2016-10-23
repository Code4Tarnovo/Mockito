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
    Destination destination2 = new Destination("asdd", "asd", "asdd", "asdd", 2d);
    Destination destination3 = new Destination("asdd", "asd", "asdd", "asdd", 2d);
    Destination destination4 = new Destination("asdd", "asdd", "asdd", "asdd", 3d);

    @Before
    public void fillup() {
        deleteTable();
        destinationRepository.register(destination);
        destinationRepository.register(destination2);
        destinationRepository.register(destination3);
        destinationRepository.register(destination4);


        ConnectionProvider connectionProvider = new ConnectionProvider("TARNOVOINF");
        DataStore dataStore = new DataStore(connectionProvider);
        PersistentDestinationRepository destinationRepository = new PersistentDestinationRepository(dataStore);
        String natureLandmarks="Nature landmarks";
        String cultureAndArt="Culture and art";
        String hotelsAndRestaurants="Hotels and restaurants";

        Destination destinationsStStPeterAndPaul=new Destination("St.St. Peter and Paul",cultureAndArt,"St. Mitropolska, 5000 Veliko Tarnovo, Bulgaria","The church is located at the foot of the northern slope of Tsarevets hill. The church was built in the 30s of the XIII century on the initiative of Queen Anna Maria of Hungary to be placed there relics of John Polivotski. Initially around it is built and monastery complex, which today does not exist.\n" +
                "\n" +
                "In murals noticed three pictorial layers of XIII, XV and XVI c., As early have a strong Catholic influence.\n" +
                "\n" +
                "The first walls was made at the beginning of the XIII century. From it have survived in medallions painted images of St. Guri, Samoa and Aviv.\n" +
                "\n" +
                "During the earthquake in 1913 the church was badly damaged. The church \"Saint Peter and Paul\" is completely restored in 1981 based on original photographs and drawings designed by arh.Boyan Kuzupov. Extremely interesting murals and architecture make it one of the prominent Bulgarian medieval monuments.\n" +
                "\n" +
                "The church is named after the holy Apostles Peter and Paul.",6.0);

        Destination destinationLinoBar=new Destination("Lino Bar",hotelsAndRestaurants,"Veliko Tarnovo, Nezavisimost St 3","Having a great view to Asenevci monument, the Bar has great assortiment of breakfast and beverages.",6.7);

        Destination destinationRockaRolla=new Destination("Rocka Rolla",hotelsAndRestaurants,"Nezavisimost St,17","A great rock club with a cozy environment.", 8.9);

        Destination destinationHotelYantra=new Destination("Grand Hotel Yantra",hotelsAndRestaurants,"Opaalchenska, 2","A great 5 star hotel.",7.5);

        Destination destinationHotelPremier=new Destination("Hotel Premier",hotelsAndRestaurants,"A great hotel...","Sava Penev Street, 1",4.6);

        Destination destinationMarnoPole=new Destination("Marno Pole",natureLandmarks,"ul. Marno Pole, 5000 Veliko Tarnovo","Marno Pole park is located near the city center and is one of the most popular places for recreation of Veliko Tarnovo. In the past there was a medieval village, and today the park is most vibrant in the weeks which became a Christmas bazaar and scene of the annual International Folklore Festival in Veliko Tarnovo.\n" +
                "\n" +
                "Here, located on the promenade, is a monument to the hero of the Russo-Turkish War (1877- 1878) Gen. YV Gurko, opened in 1957.",6.7);

        Destination destinationBorisDenev=new Destination("Art Gallery Boris Denev",cultureAndArt," P. O. Box 250","State Art Gallery in Veliko Tarnovo is one of the oldest and richest galleries in the country.\n" +
                "\n" +
                "Opened in 1934, it collects and preserves works of Bulgarian artists and shows the development of Bulgarian art over the years.\n" +
                "In 2003, the gallery is named after the artist Boris Denev Tarnovo on the occasion of 120 years since his birth.\n" +
                "\n" +
                "The three sections - paintings, prints and sculpture are located in an area of ??850 square meters, and museum exhibits collected in them are 5530. Here you can see paintings of Vladimir Dimitrov - the Master, Boris Denev, Nikola Tanev and many other.\n" +
                "\n" +
                "The first floor displays works on \"Veliko Tarnovo through the eyes of the artist\", which is updated periodically. On the second floor gallery displaying art from the fund, as well as works by visiting exhibitions.\n" +
                "\n" +
                "Veliko Turnovo Gallery is located in the heart of the city, located in a beautiful building in the park \"Assen\", which offers gorgeous views of the old Tarnovo. Only a few meters from the gallery is the monument \"Assen\", which was built in 1985 on the occasion of the age of 800 years since the rebellion of the brothers Assen and Peter.\n" +
                "\n" +
                "State Art Gallery \"Boris Denev\" is located in the park \"Assen\" and runs from 10.00 to 18.00., With a day off Monday.",8.9);

        Destination destinationKartalaWaterfalls=new Destination("Kartala Waterfalls",natureLandmarks,"A path after Kartala.","Kartala waterfalls name received from the nearby area Kartala, now occupied by residential buildings and become part of Veliko Tarnovo. Falls have a height of not more than 3-4 meters, and along with them even built trail with a series of steps, bridges and tables with benches.\n" +
                "The path that leads to the Transfiguration Monastery, begins at the end of the city, over one of its landmarks - Samovodska charshia.",5.6);

        destinationRepository.register(destinationBorisDenev);
        destinationRepository.register(destinationHotelPremier);
        destinationRepository.register(destinationHotelYantra);
        destinationRepository.register(destinationKartalaWaterfalls);
        destinationRepository.register(destinationLinoBar);
        destinationRepository.register(destinationMarnoPole);
        destinationRepository.register(destinationRockaRolla);
        destinationRepository.register(destinationsStStPeterAndPaul);

    }


    @Test
    public void registeringDestinationsTest() throws Exception {
        List<Destination> expected = new LinkedList<>();
        expected.add(destination);
        expected.add(destination2);
        expected.add(destination3);
        expected.add(destination4);
        List<Destination> actual = destinationRepository.getAll();;
        assertThat(actual, is(expected));
    }

    @Test
    public void getByNameTest() throws Exception {
        List<Destination> expected = new LinkedList<>();
        expected.add(destination);
        List<Destination> actual = destinationRepository.getByName("asd");
        assertThat(actual, is(expected));
    }

    @Test
    public void getByType() throws Exception {
        List<Destination> expected = new LinkedList<>();
        expected.add(destination);
        expected.add(destination2);
        expected.add(destination2);
        List<Destination> actual=destinationRepository.getByType("asd");
        assertThat(actual,is(expected));
    }

    @Test
    public void getByAscendint() throws Exception {
        List<Destination> expected=new LinkedList<>();
        expected.add(destination4);
        expected.add(destination3);
        expected.add(destination2);
        expected.add(destination);
        List<Destination> actual=destinationRepository.getByRatingOrdered();
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
