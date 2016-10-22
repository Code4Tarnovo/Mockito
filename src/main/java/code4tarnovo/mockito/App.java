package code4tarnovo.mockito;

import code4tarnovo.mockito.core.Destination;
import code4tarnovo.mockito.core.HtmlHelper;
import code4tarnovo.mockito.http.server.JettyServer;
import code4tarnovo.mockito.http.servlet.IndexPageServlet;
import code4tarnovo.mockito.http.servlet.InfoPageServlet;
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
        PersistentDestinationRepository repo = new PersistentDestinationRepository(dataStore);
        String content = "Архитектурно-музейният резерват „Царевец” е един от най-посещаваните туристически обекти България. Разположен е на хълма Царевец, който се намира в старата част на град Велико Търново.\n" +
                "    Крепостта е имала три входа, които се виждат и днес.";
        String indexPage = Files.toString(new File("src/main/java/code4tarnovo/mockito/resources/index.html"), Charsets.UTF_8);
//        String infoPage = Files.toString(new File("src/main/java/code4tarnovo/mockito/resources/info.html"), Charsets.UTF_8);
        repo.register(new Destination("b","b","d",content, (double) 4));
        Destination destination = repo.getByName("b").get(0);
        HtmlHelper helper = new HtmlHelper(indexPage);
        helper.setValue("name", destination.name);
        helper.setValue("info", destination.info);
        helper.evaluate();
        Map<String, HttpServlet> servlets = new LinkedHashMap<String, HttpServlet>() {{
            put("/", new IndexPageServlet(indexPage));
//            put("/info", new InfoPageServlet(infoPage));
        }};

        JettyServer server = new JettyServer(8080, servlets);
        server.start();
    }
}
