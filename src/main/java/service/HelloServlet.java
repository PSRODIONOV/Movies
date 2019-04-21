package service;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        String name = req.getParameter("name");
        pw.println("<body>");
        if (name != null) {
            pw.println("<h1>Hello, " + name + "</h1>");
        } else {
            pw.println("<h1>Hello, stranger</h1>");
        }
        pw.println("</body>");
    }
}
