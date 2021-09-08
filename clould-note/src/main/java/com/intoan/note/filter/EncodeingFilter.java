package com.intoan.note.filter;

import cn.hutool.core.util.StrUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebFilter("/*")
public class EncodeingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //convert Type
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // For Post request Tomcat7 and 8 all need
        request.setCharacterEncoding("UTF-8");

        //get request method
        String method = request.getMethod();
        //For GET need according Tomcat Version

        if ("GET".equalsIgnoreCase(method)){
            String serverInfo = request.getServletContext().getServerInfo();//apache tomcat /7.0.0

            String version = serverInfo.substring(serverInfo.lastIndexOf("/")+1, serverInfo.lastIndexOf("/")+2);

            if (version != null && Integer.parseInt(version) < 8){
                Mywapper mywapper = new Mywapper(request);

                filterChain.doFilter(mywapper,response);

                return;
            }
        }

        filterChain.doFilter(request,response);

        return;
    }

    class Mywapper extends HttpServletRequestWrapper{

        private HttpServletRequest request;

        /**
         * Constructs a request object wrapping the given request.
         *
         * @param request the {@link HttpServletRequest} to be wrapped.
         * @throws IllegalArgumentException if the request is null
         */
        public Mywapper(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        @Override
        public String getParameter(String name) {
            String parameter = request.getParameter(name);

            if (StrUtil.isBlank(parameter)){
                return parameter;
            }

            try {
                parameter = new String(parameter.getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            return parameter;
        }
    }
}
