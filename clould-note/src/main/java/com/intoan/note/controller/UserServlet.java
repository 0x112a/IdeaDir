package com.intoan.note.controller;

import cn.hutool.core.io.FileUtil;
import com.intoan.note.po.User;
import com.intoan.note.service.UserService;
import com.intoan.note.service.impl.UserServiceImpl;
import com.intoan.note.vo.ResultInfo;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.spi.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@WebServlet("/user")
@MultipartConfig
public class UserServlet extends HttpServlet {

    private UserService userService =  new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("menu_page","user");

        String actionName = req.getParameter("actionName");

        if ("login".equals(actionName)){
            userLogin(req,resp);
        }else if("logout".equals(actionName)){
            userLogout(req,resp);
        }else if ("userCenter".equals(actionName)){
            userCenter(req,resp);
        }else if ("userHead".equals(actionName)){
            userHead(req,resp);
        }else if("checkNick".equals(actionName)){
            checkNick(req,resp);
        }else if ("updateUser".equals(actionName)){
            updateUser(req,resp);
        }else if ("list".equals(actionName)){
            list(req,resp);
        }

    }


    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("changePage","note/list.jsp");

        req.getRequestDispatcher("index.jsp").forward(req,resp);

        return;
    }

    /**
     * 修改个人信息
     * @param req
     * @param resp
     */
    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultInfo<User> resultInfo = userService.updateUser(req,resp);

        //设置请求域
        req.setAttribute("resultInfo",resultInfo);

        req.getRequestDispatcher("user?actionName=userCenter").forward(req,resp);

        return;
    }

    /**
     * Ajax异步通信检查nick是否重复
     * @param request
     * @param response
     * @throws IOException
     */
    private void checkNick(HttpServletRequest request,HttpServletResponse response) throws IOException {

        String nick = request.getParameter("nick");

        User user =(User) request.getSession().getAttribute("user");

        Integer integer = userService.checkNick(nick, user.getUserId());

        response.getWriter().write(integer+ "");

        response.getWriter().close();
    }

    /**
     * 显示头像
     * @param req
     * @param resp
     * @throws IOException
     */
    private void userHead(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String imageName = req.getParameter("imageName");

        //得到图片的存放路径（得到项目的真实路径）
        String realPath = req.getServletContext().getRealPath("WEB-INF/upload/");
//        String realPath = "/home/monica/IdeaProjects/clould-note/src/main/webapp/WEB-INF/upload";

        File file = new File(realPath + "/" + imageName);

        String pic = imageName.substring(imageName.lastIndexOf(".") + 1);

        if ("PNG".equalsIgnoreCase(pic)){
            resp.setContentType("image/png");
        }else if ("JPG".equalsIgnoreCase(pic) || "JPEG".equalsIgnoreCase(pic)){
            resp.setContentType("image/jpeg");
        }else if("GIF".equalsIgnoreCase(pic)){
            resp.setContentType("image/gif");
        }

        FileUtils.copyFile(file,resp.getOutputStream());
        return;
    }

    /**
     * 个人中心
     * @param req
     * @param resp
     */
    private void userCenter(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        req.setAttribute("changePage","user/info.jsp");

        req.getRequestDispatcher("index.jsp").forward(req,resp);

        return;
    }

    /**
     * 退出
     */

    private void userLogout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().invalidate();

        Cookie cookie = new Cookie("user",null);
        //set 0 delete cookie
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        response.sendRedirect("login.jsp");

        return;
    }

    /**
     * 登录操作
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1.获取用户名，和密码
        String name = req.getParameter("userName");
        String pwd = req.getParameter("userPwd");


        ResultInfo<User> userResultInfo = userService.userLogin(name, pwd);

        if (userResultInfo.getCode() == 1){
            //成功
            req.getSession().setAttribute("user",userResultInfo.getResult());
            //
            String rem = req.getParameter("rem");
            if ("1".equals(rem)){
                Cookie cookie = new Cookie("user",name+"-"+pwd);

                cookie.setMaxAge(3*24*60*60);

                resp.addCookie(cookie);
            }else {
                Cookie cookie = new Cookie("user", null);
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }

            resp.sendRedirect("index");
        }else {
            //失败
            req.setAttribute("resultInfo",userResultInfo);

            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }
}
