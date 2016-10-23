package code4tarnovo.mockito;

import code4tarnovo.mockito.http.server.JettyServer;
import code4tarnovo.mockito.http.servlet.Servlet;

import javax.servlet.http.HttpServlet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author MartinMilev
 *         <martinmariusmilev@gmail.com>
 */
public class App {
    public static void main(String[] args) {
        Map<String, HttpServlet> servlets = new LinkedHashMap<String, HttpServlet>() {{
            put("/", new Servlet());
        }};
        JettyServer server = new JettyServer(8080, servlets);
        server.start();
    }
}
