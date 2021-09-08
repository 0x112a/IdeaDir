package com.intoan.note.dao;

import com.intoan.note.po.Type;
import com.intoan.note.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDao {

    /**
     * 查用户的所有类别
     * @param userId
     * @return
     */
    public List<Type> selectAllTypeByUserId(Integer userId){

        String sql = "select type_id typeId, type_name typeName, user_id userId from tb_note_type where user_id = ?";

        List<Object> objects = new ArrayList<>();

        objects.add(userId);

        List list = BaseDao.queryRows(sql, objects, Type.class);

        return list;

    }

    /**
     * 删除一条记录
     * @param typeId
     * @return
     */
    public int deleteTypeByTypeId(String typeId) {

        String sql = "delete from tb_note_type where type_id = ?";

        List<Object> list = new ArrayList<>();

        list.add(typeId);

        int i = BaseDao.executeUpdate(sql, list);


        return i;
    }


    /**
     * 判断类型是否关联有笔记
     * @param typeId
     * @return
     */
    public long findNoteCountByTypeId(String typeId){

        String sql = "select count(1) from tb_note where type_id = ?";

        List<Object> list = new ArrayList<>();

        list.add(typeId);

        long count = (long)BaseDao.findSingleValue(sql, list);

        return count;


    }

    /**
     * 检查对象是否存在
     * @param typeName
     * @param typeId
     * @param userId
     * @return
     */
    public Integer checkTypeName(String typeName, String typeId, Integer userId) {

        String sql = "select type_id typeId, type_name typeName, user_id userId from tb_note_type where user_id = ? and type_name = ?";

        List<Object> list = new ArrayList<>();
        list.add(userId);
        list.add(typeName);

        Type o = (Type) BaseDao.queryRow(sql, list, Type.class);

        if (o == null) {
            return 1;
        }else {
            if (typeId.equals(o.getTypeId().toString())){
                return 1;
            }
        }

        return 0;
    }


    /**
     * 增加类型
     * @param typeName
     * @param userId
     * @return
     */
    public Integer addTypeByUserId(String typeName, Integer userId) {
        int row = 0;

        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "insert into tb_note_type(type_name,user_id) value(?,?)";

        try {

            connection = JDBCUtil.getConnection();
            pstm = connection.prepareStatement(sql);
            pstm.setString(1,typeName);
            pstm.setInt(2,userId);

            int i = pstm.executeUpdate();

            if (i > 0){
                rs = pstm.getGeneratedKeys();

                if (rs.next()){
                    row = rs.getInt("type_id");
                }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,rs,pstm);
        }

        return row;
    }

    /**
     * 修改类型
     * @param typeName
     * @param typeId
     * @return
     */
    public Integer updateTypeByTypeId(String typeName, String typeId) {
        String sql = "update tb_note_type set type_name = ? whete type_id = ?";

        List<Object> list = new ArrayList<>();
        list.add(typeName);
        list.add(typeId);

        int i = BaseDao.executeUpdate(sql, list);

        return i;
    }
}
