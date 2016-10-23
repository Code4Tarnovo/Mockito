package code4tarnovo.mockito;

import code4tarnovo.mockito.core.Destination;
<<<<<<< HEAD
import code4tarnovo.mockito.http.server.JettyServer;
import code4tarnovo.mockito.http.servlet.Servlet;
import code4tarnovo.mockito.persistent.adapter.jdbc.ConnectionProvider;
import code4tarnovo.mockito.persistent.adapter.jdbc.PersistentDestinationRepository;
import code4tarnovo.mockito.persistent.datastore.DataStore;
=======
import code4tarnovo.mockito.core.HtmlReplacer;
import code4tarnovo.mockito.http.server.JettyServer;
import code4tarnovo.mockito.http.servlet.IndexPageServlet;
import code4tarnovo.mockito.persistent.adapter.jdbc.ConnectionProvider;
import code4tarnovo.mockito.persistent.adapter.jdbc.PersistentDestinationRepository;
import code4tarnovo.mockito.persistent.datastore.DataStore;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
>>>>>>> e9c850a1a5f746c45e6e7285841e98efb38d8ad9

import javax.servlet.http.HttpServlet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author MartinMilev
 *         <martinmariusmilev@gmail.com>
 */
public class App {
    public static void main(String[] args) throws IOException {
        DataStore dataStore = new DataStore(new ConnectionProvider("TARNOVOINF"));
        PersistentDestinationRepository repo = new PersistentDestinationRepository(dataStore);
        String content = "Architectural museum preserve Tsarevets is one of the most visited tourist sites Bulgaria. Located on Tsarevets Hill, which is located in the old town of Veliko Tarnovo. The fortress has three entrances that are seen today.";
        String indexPage = Files.toString(new File("resources/index.html"), Charsets.UTF_8);
        repo.register(new Destination("b","b","d",content, (double) 4));

        Destination destination = repo.getByName("b").get(0);
        HtmlReplacer helper = new HtmlReplacer(indexPage);
        String finalIndexPage = indexPage;
        Map<String, HttpServlet> servlets = new LinkedHashMap<String, HttpServlet>() {{
            put("/", new IndexPageServlet(repo,helper));
            put("/info", new IndexPageServlet(repo,helper));
        }};

        JettyServer server = new JettyServer(8080, servlets);
        server.start();


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
}
