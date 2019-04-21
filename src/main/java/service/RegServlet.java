package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registerServlet",urlPatterns = "/user/register")
public class RegServlet extends HttpServlet {
    //service.UserStorageImpl US = service.UserStorageImpl.getInstance();
    @Autowired
    private UserStorageImpl US;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());

    }

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter pw = resp.getWriter();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        //pw.println("<body>");
        if(US.registration(login, password, 0))
            pw.println("<h1> service.User successfully added.</h1>");
        else
            pw.println("<h1> This user already exists.</h1>");
        //pw.println("</body>");
    }
}
