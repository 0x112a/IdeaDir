package com.intoan.note.service;

import com.intoan.note.po.User;
import com.intoan.note.vo.ResultInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

    public ResultInfo<User> userLogin(String name, String pwd);

    public Integer checkNick(String name, Integer userId);

    public ResultInfo<User> updateUser(HttpServletRequest request, HttpServletResponse response);

}
