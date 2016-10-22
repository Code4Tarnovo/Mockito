package code4tarnovo.mockito.http.servlet;

/**
 * Created by zumba on 22.10.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class InfoPageServlet extends javax.servlet.http.HttpServlet {
    private final String html;

    public InfoPageServlet(String html) {
        this.html = html;
    }


}
