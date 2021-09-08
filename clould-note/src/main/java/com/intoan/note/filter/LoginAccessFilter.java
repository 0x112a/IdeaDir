package com.intoan.note.filter;


import com.intoan.note.po.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginAccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;


        String pathInfo = request1.getRequestURI();

        if (pathInfo.contains("/login.jsp")){
            chain.doFilter(request1,response1);
            return;
        }

        if (pathInfo.contains("/statics")){
            chain.doFilter(request1,response1);
            return;
        }

        if(pathInfo.contains("/user")){
            String actionName = request1.getParameter("actionName");

            if ("login".equals(actionName)){
                chain.doFilter(request1,response1);
                return;
            }
        }

        User user = (User) request1.getSession().getAttribute("user");

        if (user != null){
            chain.doFilter(request1,response1);
            return;
        }

        Cookie[] cookies = request1.getCookies();

        if (cookies != null && cookies.length>0 ){
            for (Cookie cookie : cookies) {

                if ("user".equals(cookie.getName())){

                    String[] split = cookie.getValue().split("-");
                    String name = split[0];
                    String pwd = split[1];

                    String url = "user?actionName=login&rem=1&userName=" + name + "&userPwd=" + pwd;

                    request1.getRequestDispatcher(url).forward(request1,response1);

                    return;
                }

            }
        }

        response1.sendRedirect("login.jsp");

    }

    @Override
    public void destroy() {
    }
}
