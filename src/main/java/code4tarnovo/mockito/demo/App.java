package code4tarnovo.mockito.demo;

import code4tarnovo.mockito.core.Destination;
import code4tarnovo.mockito.core.HtmlReplacer;
import code4tarnovo.mockito.http.server.JettyServer;
import code4tarnovo.mockito.http.servlet.IndexPageServlet;
import code4tarnovo.mockito.persistent.adapter.jdbc.ConnectionProvider;
import code4tarnovo.mockito.persistent.adapter.jdbc.PersistentDestinationRepository;
import code4tarnovo.mockito.persistent.datastore.DataStore;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author MartinMilev
 *         <martinmariusmilev@gmail.com>
 */
public class App {
    public static void main(String[] args) throws IOException {
        DataStore dataStore = new DataStore(new ConnectionProvider("TARNOVOINF"));

        PersistentDestinationRepository destinationRepository = new PersistentDestinationRepository(dataStore);


        String indexPage = Files.toString(new File("resources/index.html"), Charsets.UTF_8);
        String infoPage = Files.toString(new File("resources/info.html"), Charsets.UTF_8);

        Map<String, HttpServlet> servlets = new LinkedHashMap<String, HttpServlet>() {{
            put("/", new IndexPageServlet(destinationRepository, new HtmlReplacer(indexPage)));
            put("/info", new IndexPageServlet(destinationRepository, new HtmlReplacer(infoPage)));
        }};

        JettyServer server = new JettyServer(8080, servlets);
        server.start();
    }
}
