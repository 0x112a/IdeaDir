package com.intoan.note.controller;

import com.intoan.note.po.Note;
import com.intoan.note.po.User;
import com.intoan.note.service.NoteService;
import com.intoan.note.service.impl.NoteServiceImpl;
import com.intoan.note.util.PageUtil;
import com.intoan.note.vo.NoteVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    private NoteService noteService = new NoteServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("menu_page","index");

        String actionName = req.getParameter("actionName");

        if ("searchTitle".equals(actionName)){
            String title = req.getParameter("title");

            req.setAttribute("title",title);

            noteList(req,resp,title,null,null);

        }else if("searchDate".equals(actionName)){
            String date = req.getParameter("date");
            req.setAttribute("date",date);
            noteList(req,resp,null,date, null);


        }else if ("searchType".equals(actionName)){
            String typeId = req.getParameter("typeId");
            req.setAttribute("typeId",typeId);
            noteList(req,resp,null,null,typeId);

        }else {

            //调用
            noteList(req, resp, null, null, null);

        }
        req.setAttribute("changePage", "note/list.jsp");

        req.getRequestDispatcher("index.jsp").forward(req, resp);
        return;
    }


    /**
     * 分页查询
     * @param req
     * @param resp
     * @param title
     * @param date
     * @param typeId
     */
    private void noteList(HttpServletRequest req, HttpServletResponse resp, String title, String date, String typeId) {

        String pageNum = req.getParameter("pageNumber");
        String pageSize = req.getParameter("pageSize");

        User user = (User)req.getSession().getAttribute("user");


        PageUtil<Note> note = noteService.findNoteListByPage(pageNum,pageSize,user.getUserId(),title,date,typeId);

        req.setAttribute("page",note);

        List<NoteVo> dateInfo = noteService.findNoteCountDateByUserId(user.getUserId());

        req.getSession().setAttribute("dateInfo",dateInfo);

        List<NoteVo> typeInfo = noteService.findNoteCountTypeByUserId(user.getUserId());

        req.getSession().setAttribute("typeInfo",typeInfo);

        return;

    }
}
