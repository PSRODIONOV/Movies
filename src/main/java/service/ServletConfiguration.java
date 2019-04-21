package service;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServletConfiguration{

    @Bean
        public ServletRegistrationBean helloServlet(){
            ServletRegistrationBean bean = new ServletRegistrationBean(new HelloServlet(), "/hello");
            bean.setLoadOnStartup(1);
            return bean;
    }
    @Bean
    public FilterRegistrationBean SecureFilterServlet(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new SecureFilterServlet());
        bean.addUrlPatterns("/hello");
        return bean;
    }
    @Bean
    public FilterRegistrationBean MovieFilterDto(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new MovieFilterDto());
        bean.addUrlPatterns("/movie/*");
        return bean;
    }
    @Bean
    public ServletRegistrationBean regServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new RegServlet(), "/user/register");
        bean.setLoadOnStartup(1);
        return bean;
    }
    @Bean
    public ServletRegistrationBean logServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new LoginServlet(), "/user/login");
        bean.setLoadOnStartup(1);
        return bean;
    }
    @Bean
    public ServletRegistrationBean searchMovieServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new SearchMovieServlet(), "/searchmovie");
        bean.setLoadOnStartup(1);
        return bean;
    }

}
