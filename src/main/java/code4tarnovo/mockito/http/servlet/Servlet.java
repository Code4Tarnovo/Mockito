package code4tarnovo.mockito.http.servlet;

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
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        String indexPage = Files.toString(new File("src/main/java/code4tarnovo/mockito/resources/index.html"), Charsets.UTF_8);
        PrintWriter writer = resp.getWriter();
        writer.print(indexPage);
        writer.flush();
    }
}
