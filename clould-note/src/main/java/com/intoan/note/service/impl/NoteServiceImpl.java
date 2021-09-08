package com.intoan.note.service.impl;

import cn.hutool.core.util.StrUtil;
import com.intoan.note.dao.NoteDao;
import com.intoan.note.po.Note;
import com.intoan.note.service.NoteService;
import com.intoan.note.util.PageUtil;
import com.intoan.note.vo.NoteVo;
import com.intoan.note.vo.ResultInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoteServiceImpl implements NoteService {


    private NoteDao noteDao = new NoteDao();

    @Override
    public ResultInfo<Note> addOrUpdate(String typeId, String title, String content, String noteId, String lon, String lat) {

        ResultInfo<Note> noteResultInfo = new ResultInfo<>();

        if (StrUtil.isBlank(typeId)){
            noteResultInfo.setCode(0);
            noteResultInfo.setMsg("请选择类型标记！");
            return noteResultInfo;
        }

        if (StrUtil.isBlank(title)){
            noteResultInfo.setCode(0);
            noteResultInfo.setMsg("请填写标题！");
            return noteResultInfo;
        }

        if (StrUtil.isBlank(content)){
            noteResultInfo.setCode(0);
            noteResultInfo.setMsg("请填写内容！");
            return noteResultInfo;
        }


        Note note = new Note();
        note.setTypeId(Integer.valueOf(typeId));
        note.setTitle(title);
        note.setContent(content);

        if (!StrUtil.isBlank(noteId)){
            note.setNoteId(Integer.parseInt(noteId));
        }else {
            note.setLon(Float.parseFloat(lon));
            note.setLat(Float.parseFloat(lat));
        }

        noteResultInfo.setResult(note);

        int row = noteDao.addOrUpdate(note);

        if (row > 0) {
            noteResultInfo.setCode(1);
        }else {
            noteResultInfo.setCode(0);
            noteResultInfo.setMsg("更新失败！");

        }

        return noteResultInfo;
    }

    /**
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @param title
     * @param date
     * @param typeId
     * @return
     */
    @Override
    public PageUtil<Note> findNoteListByPage(String pageNum, String pageSize, Integer userId, String title, String date, String typeId) {
        Integer pageNumb = 1;
        Integer pageSizes = 10;
        if (!StrUtil.isBlank(pageNum)){
            pageNumb = Integer.parseInt(pageNum);
        }
        if (!(StrUtil.isBlank(pageSize))){
            pageSizes = Integer.parseInt(pageSize);
        }


        long count = noteDao.findNoteCount(userId,title,date,typeId);

        if (count < 1) {
            return null;
        }

        PageUtil<Note> notePageUtil = new PageUtil<Note>(pageNumb,pageSizes,count);

        int startIndex = (pageNumb - 1) * pageSizes;

        List<Note> list = noteDao.findNoteListBypage(userId,startIndex,pageSizes,title,date,typeId);

        notePageUtil.setDataList(list);

        return notePageUtil;
    }

    @Override
    public Note findNoteByNoteId(String noteId) {

        if (StrUtil.isBlank(noteId)){
            return null;
        }

        Note note = new Note();

        note = noteDao.findNoteByNoteId(noteId);

        return note;
    }

    @Override
    public Integer deleteNoteByNoteId(String noteId) {

        if (StrUtil.isBlank(noteId)){
            return 0;
        }

        Integer row = noteDao.deleteNoteByNoteId(noteId);

        if (row < 1){
            return 0;
        }

        return 1;
    }

    @Override
    public List<NoteVo> findNoteCountDateByUserId(Integer userId) {

        return noteDao.findNoteCountDateByUserId(userId);
    }

    @Override
    public List<NoteVo> findNoteCountTypeByUserId(Integer userId) {
        return noteDao.findNoteCountTypeByUserId(userId);
    }

    @Override
    public ResultInfo<Map<String, Object>> queryNoteCountBymonth(Integer userId) {
        //通过用户查该用户的每月云记数量

        List<NoteVo> noteVo = noteDao.findNoteCountDateByNoteId(userId);

        ResultInfo<Map<String, Object>> resultInfo = new ResultInfo<>();

        if (noteVo != null && noteVo.size() > 0){
            List<String> month = new ArrayList<>();
            List<Long> count = new ArrayList<>();

            for (NoteVo vo : noteVo) {
                count.add(vo.getCount());
                month.add(vo.getName());
            }

            Map<String,Object> map = new HashMap<>();

            map.put("dataArray",count);
            map.put("monthArray",month);

            resultInfo.setCode(1);
            resultInfo.setMsg("");
            resultInfo.setResult(map);
        }

        return resultInfo;
    }

    @Override
    public ResultInfo<List<Note>> findNoteLonAndLatByUserId(Integer userId) {
        ResultInfo<List<Note>> resultInfo = new ResultInfo<>();

        List<Note> list = noteDao.findNoteLonAndLatByUserId(userId);

        if (list != null && list.size() > 0){
            resultInfo.setCode(1);
            resultInfo.setResult(list);
        }

        return resultInfo;
    }

}
