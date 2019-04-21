package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet",urlPatterns = "/user/login")
public class LoginServlet extends HttpServlet {
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
    protected void doGet( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter pw = resp.getWriter();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        //pw.println("<body>");
        HttpSession session = req.getSession(true);
        if(US.login(login, password)) {
            User currentUser = (User) session.getAttribute("user");
            try {
                if (currentUser == null) {
                    pw.println("<h1> You have successfully logged in.</h1>");
                    currentUser = US.currentUser;
                    session.setAttribute("user", currentUser);
                }
                else {
                    session.removeAttribute("user");
                    throw new ServletException("You shall not pass!");
                }

            }
            finally {

            }
        }
        else
            pw.println("<h1> Invalid login or password.</h1>");
        //pw.println("</body>");
        System.out.println(session.getAttribute("user"));
    }
}
