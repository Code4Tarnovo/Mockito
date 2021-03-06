package code4tarnovo.mockito.http.server;

import javax.servlet.http.HttpServlet;
import java.util.Map;

import org.eclipse.jetty.plus.servlet.ServletHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;

import static sun.net.www.protocol.http.AuthCacheValue.Type.Server;

/**
 * @author MartinMilev
 *         <martinmariusmilev@gmail.com>
 */
public class JettyServer {
    private final Map<String, HttpServlet> servlets;
    private final int port;

    public JettyServer(int port, Map<String, HttpServlet> servlets) {
        this.servlets = servlets;
        this.port = port;
    }

    public void start() {
        Server server = new Server(port);
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        try {
            for (String key : servlets.keySet()) {
                handler.addServletWithMapping(new ServletHolder(servlets.get(key)), key);
            }
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}