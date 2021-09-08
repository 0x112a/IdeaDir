package com.intoan.note.controller;

import com.intoan.note.po.Note;
import com.intoan.note.po.User;
import com.intoan.note.service.NoteService;
import com.intoan.note.service.impl.NoteServiceImpl;
import com.intoan.note.util.JsonUtil;
import com.intoan.note.vo.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {

    private NoteService noteService = new NoteServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("menu_page","report");

        String actionName = req.getParameter("actionName");

        if ("info".equals(actionName)){
            reportInfo(req,resp);
        }else if ("month".equals(actionName)){
            queryNoteCountBymonth(req,resp);
        }else if ("localtion".equals(actionName)){
            queryNoteLonAndLat(req,resp);
        }
    }

    private void queryNoteLonAndLat(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User)req.getSession().getAttribute("user");

        ResultInfo<List<Note>> resultInfo = noteService.findNoteLonAndLatByUserId(user.getUserId());

        JsonUtil.toJson(resp,resultInfo);
    }

    private void queryNoteCountBymonth(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User) req.getSession().getAttribute("user");

        ResultInfo<Map<String,Object>> resultInfo = noteService.queryNoteCountBymonth(user.getUserId());

        JsonUtil.toJson(resp,resultInfo);


    }

    private void reportInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("changePage","report/info.jsp");

        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }
}
