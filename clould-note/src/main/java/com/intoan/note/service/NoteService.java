package com.intoan.note.service;

import com.intoan.note.po.Note;
import com.intoan.note.util.PageUtil;
import com.intoan.note.vo.NoteVo;
import com.intoan.note.vo.ResultInfo;

import java.util.List;
import java.util.Map;

public interface NoteService {
    ResultInfo<Note> addOrUpdate(String typeId, String title, String content, String noteId, String lon, String lat);

    PageUtil<Note> findNoteListByPage(String pageNum, String pageSize, Integer userId, String title, String date, String typeId);

    Note findNoteByNoteId(String noteId);

    Integer deleteNoteByNoteId(String noteId);

    List<NoteVo> findNoteCountDateByUserId(Integer userId);

    List<NoteVo> findNoteCountTypeByUserId(Integer userId);

    ResultInfo<Map<String, Object>> queryNoteCountBymonth(Integer userId);

    ResultInfo<List<Note>> findNoteLonAndLatByUserId(Integer userId);
}
