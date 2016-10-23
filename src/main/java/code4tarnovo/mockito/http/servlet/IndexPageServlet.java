package code4tarnovo.mockito.http.servlet;

import code4tarnovo.mockito.core.Destination;
import code4tarnovo.mockito.core.DestinationRepository;
import code4tarnovo.mockito.core.HtmlReplacer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author MartinMilev
 *         <martinmariusmilev@gmail.com>
 */
public class IndexPageServlet extends HttpServlet {
    private final DestinationRepository repo;
    private final HtmlReplacer replacer;

    public IndexPageServlet(DestinationRepository repo, HtmlReplacer replacer) {
        this.replacer = replacer;
        this.repo = repo;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = resp.getWriter();

        String param = (req.getParameter("link"));
        List<Destination> destinations = repo.getAll();

        for (Destination each : destinations) {
            String content = "<div class=\"col-sm-4\">\n" +
                    "<p>" + each.name
                    + "</p><p>" + each.type
                    + "</p><p>" + each.adress
                    + "</p><p>" + each.name
                    + "</p><a href=\"/?link="+each.name+"\">"+each.name+"</a></div>";
            replacer.setValue("destintion",content);
        }
        if (param != null) {
            req.setAttribute("info", req.getParameter("link"));
            resp.sendRedirect("/info");
        }

        writer.print(replacer.evaluate());
        writer.flush();
    }
}
