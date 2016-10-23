package code4tarnovo.mockito.http.servlet;

import code4tarnovo.mockito.core.Destination;
import code4tarnovo.mockito.core.DestinationRepository;
import code4tarnovo.mockito.core.HtmlReplacer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by zumba on 22.10.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public class InfoPageServlet extends HttpServlet {
    private final DestinationRepository repo;
    private final HtmlReplacer replacer;

    public InfoPageServlet(DestinationRepository repo, HtmlReplacer replacer) {
        this.replacer = replacer;
        this.repo = repo;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = resp.getWriter();

        String param = (req.getParameter("link"));

        if(param != null) {
            if (param.equals("home")) {
                resp.sendRedirect("/");
            }
        }

        Destination destination = repo.getByName(req.getParameter("link")).get(0);
        System.out.println(destination.name);
        replacer.setValue("name", destination.name);
        replacer.setValue("type", destination.type);
        replacer.setValue("address", destination.adress);

        String page = replacer.evaluate();
        writer.print(page);
        writer.flush();
    }
}
