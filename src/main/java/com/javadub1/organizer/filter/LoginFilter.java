package com.javadub1.organizer.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

//   / *
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession httpSession = req.getSession(false);
        String loginPage = "/login";

        boolean isLoginRequest = req.getRequestURI().equals(loginPage);
        boolean isLoggedIn = Objects.nonNull(httpSession)
                && Objects.nonNull(httpSession.getAttribute("user"));

        if(isLoggedIn || isLoginRequest){
            filterChain.doFilter(req, resp);
        } else {
            resp.sendRedirect(loginPage);
        }

    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
