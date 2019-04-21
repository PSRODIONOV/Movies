package service;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/movie")
public class MovieFilterDto implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = null;

        session = req.getSession(false);
        System.out.println(session + " Here");
        if(session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
            else throw new ServletException("You shall not pass!");
        }
        else throw new ServletException("You shall not pass!");
    }

    @Override
    public void destroy(){

    }
}
