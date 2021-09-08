package com.intoan.note.controller;

import com.intoan.note.po.Type;
import com.intoan.note.po.User;
import com.intoan.note.service.TypeService;
import com.intoan.note.service.impl.TypeServiceImpl;
import com.intoan.note.util.JsonUtil;
import com.intoan.note.vo.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/type")
public class TypeServlet extends HttpServlet {

    TypeService typeService = new TypeServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("menu_page","type");

        String actionName = req.getParameter("actionName");

        if ("list".equals(actionName)){
            list(req,resp);
        }else if ("delete".equals(actionName)){
            delete(req,resp);
        }else if ("addOrUpdate".equals(actionName)){
            addOrUpdate(req,resp);
        }

    }

    private void addOrUpdate(HttpServletRequest req, HttpServletResponse resp) {
        String typeName = req.getParameter("typeName");
        String typeId = req.getParameter("typeId");

        User user = (User)req.getSession().getAttribute("user");

        ResultInfo<Integer> resultInfo = typeService.addOrUpdate(typeName,typeId,user.getUserId());

        JsonUtil.toJson(resp,resultInfo);

    }

    /**
     * 删除类型
     * @param req
     * @param resp
     */
    private void delete(HttpServletRequest req, HttpServletResponse resp) {

        String typeId = req.getParameter("typeId");


        ResultInfo<Type> delete = typeService.delete(typeId);

        JsonUtil.toJson(resp,delete);

        return;
    }

    /**
     * 类别管理
     * @param req
     * @param resp
     */
    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("changePage","type/list.jsp");

        User user = (User)req.getSession().getAttribute("user");

        Integer userId = user.getUserId();

        List<Type> typeList = typeService.findTypeList(userId);

        req.getSession().setAttribute("typeList",typeList);


        req.getRequestDispatcher("index.jsp").forward(req,resp);

        return;
    }
}
