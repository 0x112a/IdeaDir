package com.intoan.note.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.intoan.note.dao.UserDao;
import com.intoan.note.po.User;
import com.intoan.note.service.UserService;
import com.intoan.note.vo.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

public class UserServiceImpl implements UserService {

    private UserDao userDao  = new UserDao();

    @Override
    public ResultInfo<User> userLogin(String name, String pwd) {
        ResultInfo<User> userResultInfo = new ResultInfo<>();

        User user = new User();
        user.setUname(name);
        user.setUpwd(pwd);

        userResultInfo.setResult(user);

        if (StrUtil.isBlank(name) || StrUtil.isBlank(pwd)){
            userResultInfo.setCode(0);
            userResultInfo.setMsg("用户姓名或密码不能为空！");
            return userResultInfo;
        }

        User user1 = userDao.queryUserByName(name);

        if (user1 == null){
            userResultInfo.setCode(0);
            userResultInfo.setMsg("用户不存在！请先注册");
            return userResultInfo;
        }

        pwd = DigestUtil.md5Hex(pwd);

        if (!user1.getUpwd().equals(pwd)){
            userResultInfo.setCode(0);
            userResultInfo.setMsg("密码错误，请检查后重试");
            return userResultInfo;
        }

        userResultInfo.setCode(1);
        userResultInfo.setMsg("登录成功！");
        userResultInfo.setResult(user1);
        return userResultInfo;
    }

    @Override
    public Integer checkNick(String nick, Integer userId) {

        if (StrUtil.isBlank(nick)){
            return 0;
        }

        User user = userDao.queryUserByNickAndUserId(nick, userId);

        if(user != null){
            return 0;
        }

        return 1;
    }

    @Override
    public ResultInfo<User> updateUser(HttpServletRequest request, HttpServletResponse response) {

        ResultInfo<User> userResultInfo = new ResultInfo<>();

        String nick = request.getParameter("nick");
        String mood = request.getParameter("mood");

        if (StrUtil.isBlank(nick)){
            userResultInfo.setCode(0);
            userResultInfo.setMsg("用户昵称不能为空！");
            return userResultInfo;
        }

        User user = (User)request.getSession().getAttribute("user");

        user.setNick(nick);
        user.setMood(mood);

        //获取post的文件上传
        try {
            //获取上传文件域的name为img的文件
            Part img = request.getPart("img");

            String header = img.getHeader("content-Disposition");

            String substring = header.substring(header.lastIndexOf("=") + 2);

            String fileName = substring.substring(0, substring.length() - 1);

            if (!StrUtil.isBlank(fileName)){
                user.setHead(fileName);

                String realPath = request.getServletContext().getRealPath("/WEB-INF/upload/");
//                String realPath = "/home/monica/IdeaProjects/clould-note/src/main/webapp/WEB-INF/upload";

                img.write(realPath+"/"+fileName);
            }

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int row = userDao.updateUser(user);

        if (row > 0){
            userResultInfo.setCode(1);
            userResultInfo.setMsg("更新成功！");
            request.getSession().setAttribute("user",user);
        }else {
            userResultInfo.setCode(0);
            userResultInfo.setMsg("更新失败！");
        }


        return userResultInfo;
    }
}
