package com.intoan.note.dao;

import cn.hutool.core.util.StrUtil;
import com.intoan.note.po.Note;
import com.intoan.note.vo.NoteVo;

import java.util.ArrayList;
import java.util.List;

public class NoteDao {

    /**
     * 更新修改操作
     * @param note
     * @return
     */
    public int addOrUpdate(Note note) {

        ArrayList<Object> objects = new ArrayList<>();

        objects.add(note.getTitle());
        objects.add(note.getContent());
        objects.add(note.getTypeId());

        String sql = "";

        if (note.getNoteId() == null){
            sql = "insert into tb_note(title,content,type_id,public_time,lon,lat) value(?,?,?,now(),?,?)";

            objects.add(note.getLon());

            objects.add(note.getLat());
        }else {
            sql = "update tb_note set title = ?, content = ?,type_id = ? where note_id = ?";
            objects.add(note.getNoteId());
        }

        int i = BaseDao.executeUpdate(sql, objects);

        return i;
    }

    public long findNoteCount(Integer userId, String title, String date, String typeId) {
        String sql = "select count(1) from tb_note n inner join tb_note_type t on n.type_id = t.type_id where user_id = ?";

        List<Object> objects = new ArrayList<>();

        objects.add(userId);

        if (!StrUtil.isBlank(title)){
            sql += " AND title like concat('%',?,'%')";
            objects.add(title);
        }else if (!StrUtil.isBlank(date)){
            sql += " AND DATE_FORMAT(public_time,'%Y年%m月') like ?";
            objects.add(date);
        }else if (!StrUtil.isBlank(typeId)){
            sql += " AND t.type_id = ?";
            objects.add(typeId);
        }

        long singleValue = (long)BaseDao.findSingleValue(sql, objects);

        return singleValue;
    }

    public List<Note> findNoteListBypage(Integer userId, Integer startIndex, Integer pageSize, String title, String date, String typeId) {
        List<Object> objects = new ArrayList<>();

        String sql = "select note_id noteId,title title,public_time publicTime from tb_note n inner join tb_note_type t on n.type_id = t.type_id where user_id = ?";
        objects.add(userId);

        if (!StrUtil.isBlank(title)){
            sql+=" and title like concat('%',?,'%')";
            objects.add(title);
        }else if (!StrUtil.isBlank(date)){
            sql += " AND DATE_FORMAT(public_time,'%Y年%m月') like ?";
            objects.add(date);
        }else if (!StrUtil.isBlank(typeId)){
            sql += " AND t.type_id = ?";
            objects.add(typeId);
        }

        sql += " order by publicTime desc limit ?,?";
        objects.add(startIndex);
        objects.add(pageSize);
        List<Note> list = BaseDao.queryRows(sql, objects, Note.class);

        return list;
    }

    public Note findNoteByNoteId(String noteId) {

        String sql = "select note_id noteId,title title,content content,public_time publicTime, n.type_id typeId, type_name typeName from tb_note n inner join tb_note_type t on n.type_id=t.type_id where note_id = ?";

        List<Object> objects = new ArrayList<>();

        objects.add(noteId);

         Note note = (Note) BaseDao.queryRow(sql, objects, Note.class);

         return note;
    }

    public Integer deleteNoteByNoteId(String noteId) {

        String sql = "delete from tb_note where note_id = ?";

        List<Object> objects = new ArrayList<>();

        objects.add(noteId);

        int i = BaseDao.executeUpdate(sql, objects);

        return i;
    }

    public List<NoteVo> findNoteCountDateByUserId(Integer userId) {
        String s = "SELECT\n" +
                "\tCOUNT(1) 'count',DATE_FORMAT(public_time,\"%Y年%m月\") 'name'\n" +
                "FROM \n" +
                "\ttb_note n\n" +
                "INNER JOIN \n" +
                "\ttb_note_type nt\n" +
                "ON\n" +
                "\tn.type_id = nt.type_id \n" +
                "WHERE \n" +
                "\tuser_id = ?\n" +
                "GROUP BY DATE_FORMAT(public_time,\"%Y年%m月\")\n" +
                "ORDER BY DATE_FORMAT(public_time,\"%Y%m\") DESC ;";

        List<Object> objects = new ArrayList<>();
        objects.add(userId);

        List list = BaseDao.queryRows(s, objects, NoteVo.class);

        return list;

    }

    public List<NoteVo> findNoteCountTypeByUserId(Integer userId) {
        String sql = "SELECT \n" +
                "\tCOUNT(note_id) 'count',tnt.type_id typeId,tnt.type_name name\n" +
                "FROM \n" +
                "\ttb_note tn\n" +
                "RIGHT JOIN \n" +
                "\ttb_note_type tnt \n" +
                "ON tn.type_id = tnt.type_id\n" +
                "WHERE user_id = ?\n" +
                "GROUP BY tnt.type_id\n" +
                "ORDER BY 'count';";

        List<Object> objects = new ArrayList<>();

        objects.add(userId);

        return BaseDao.queryRows(sql,objects,NoteVo.class);
    }

    public List<NoteVo> findNoteCountDateByNoteId(Integer userId) {
        String sql = "select count(1) 'count',DATE_FORMAT(public_time,'%m月') name \n" +
                "from tb_note tn \n" +
                "inner join tb_note_type tnt on tn.type_id = tnt.type_id \n" +
                "WHERE tnt.user_id = ? \n" +
                "GROUP BY DATE_FORMAT(public_time,'%m') \n" +
                "ORDER BY DATE_FORMAT(public_time,\"%Y%m\") ASC";

        List<Object> objects = new ArrayList<>();
        objects.add(userId);

        return BaseDao.queryRows(sql, objects, NoteVo.class);
    }

    public List<Note> findNoteLonAndLatByUserId(Integer userId) {

        String sql = "SELECT lon ,lat FROM tb_note n INNER JOIN tb_note_type nt ON n.type_id = nt.type_id WHERE user_id = ?;";

        List<Object> objects = new ArrayList<Object>();
        objects.add(userId);

        return BaseDao.queryRows(sql,objects,Note.class);
    }
}
