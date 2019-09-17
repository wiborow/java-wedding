package com.javadub1.organizer.filter;

import com.javadub1.organizer.model.authorization.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.Function;

@WebFilter("/admin/*")
public class RoleResolverFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession httpSession = req.getSession(false);
        if(Objects.nonNull(httpSession) && Objects.nonNull(httpSession.getAttribute("user"))){
//            "ADMIN".equals(
//                  (
//                      (User) httpSession.getAttribute("user")
//                  ).getRole()
//            )

            //(User)httpSession.getAttribute("user").getRole()
            // bedzie probowal rzutowac .getRole() na User
            if("ADMIN".equals(((User) httpSession.getAttribute("user")).getRole())){
                chain.doFilter(req, resp);
                return;
            }
        }
        resp.sendRedirect("/no-access.jsp");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}
