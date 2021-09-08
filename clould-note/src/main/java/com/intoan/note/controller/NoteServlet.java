package com.intoan.note.controller;

import com.intoan.note.po.Note;
import com.intoan.note.po.Type;
import com.intoan.note.po.User;
import com.intoan.note.service.NoteService;
import com.intoan.note.service.TypeService;
import com.intoan.note.service.impl.NoteServiceImpl;
import com.intoan.note.service.impl.TypeServiceImpl;
import com.intoan.note.vo.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/note")
public class NoteServlet extends HttpServlet {

    private NoteService noteService = new NoteServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("menu_page","note");

        String actionName = req.getParameter("actionName");

        if ("view".equals(actionName)){
            intoNote(req,resp);
        }else if ("addOrUpdate".equals(actionName)){
            addOrUpdate(req,resp);
        }else if ("detail".equals(actionName)){
            detial(req,resp);
        }else if ("delete".equals(actionName)){
            delete(req,resp);
        }

    }

    /**
     * 删除笔记
     * @param req
     * @param resp
     */
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String noteId = req.getParameter("noteId");

        Integer code = noteService.deleteNoteByNoteId(noteId);

        resp.getWriter().write(code + "");

        resp.getWriter().close();
    }

    /**
     * 查看详情
     * @param req
     * @param resp
     */
    private void detial(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String noteId = req.getParameter("noteId");

        Note note = noteService.findNoteByNoteId(noteId);

        req.setAttribute("note",note);

        req.setAttribute("changePage","note/detail.jsp");

        req.getRequestDispatcher("index.jsp").forward(req,resp);

        return;
    }

    /**
     * 添加或修改云记内容
     * @param req
     * @param resp
     */
    private void addOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String typeId = req.getParameter("typeId");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        String noteId = req.getParameter("noteId");
        String lon = req.getParameter("lon");
        String lat = req.getParameter("lat");

        ResultInfo<Note> resultInfo = noteService.addOrUpdate(typeId,title,content,noteId,lon,lat);

        if (resultInfo.getCode() == 1){

            resp.sendRedirect("index");

        }else {

            req.setAttribute("resultInfo",resultInfo);

            req.getRequestDispatcher("note&actionName=view").forward(req,resp);
        }

        return;

    }

    /**
     * 进入云记发布页面
     * @param req
     * @param resp
     */
    private void intoNote(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String noteId = req.getParameter("noteId");

        Note noteByNoteId = noteService.findNoteByNoteId(noteId);

        req.setAttribute("noteInfo",noteByNoteId);

        req.setAttribute("changePage","note/view.jsp");


        User user = (User) req.getSession().getAttribute("user");

        TypeService typeService = new TypeServiceImpl();

        List<Type> typeList = typeService.findTypeList(user.getUserId());

        req.setAttribute("typeList",typeList);

        req.getRequestDispatcher("index.jsp").forward(req,resp);

        return;
    }
}
