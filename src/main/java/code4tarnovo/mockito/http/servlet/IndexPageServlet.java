package code4tarnovo.mockito.http.servlet;

import code4tarnovo.mockito.core.HtmlHelper;
import code4tarnovo.mockito.persistent.adapter.jdbc.PersistentDestinationRepository;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author MartinMilev
 *         <martinmariusmilev@gmail.com>
 */
public class IndexPageServlet extends HttpServlet {
    private final String html;

    public IndexPageServlet(String html) {
        this.html = html;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = resp.getWriter();
        writer.print(html);
        writer.flush();
    }
}
