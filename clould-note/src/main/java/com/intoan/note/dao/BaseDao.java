package com.intoan.note.dao;

import com.intoan.note.util.JDBCUtil;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {

    private static Logger logger = LoggerFactory.getLogger(BaseDao.class);

    /**
     * 更新操作
     * @param sql
     * @param param
     * @return
     */
    public static int executeUpdate(String sql, List<Object> param){
        Connection conn = null;
        PreparedStatement pstm = null;
        int row = 0;

        try {
            conn = JDBCUtil.getConnection();
            pstm = conn.prepareStatement(sql);

            if (param != null && param.size() > 0){
                for (int i = 0; i < param.size(); i++) {
                    pstm.setObject(i+1,param.get(i));
                }
            }

            row = pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(conn,null,pstm);
        }

        return row;
    }

    /**
     * 查询每个单独的字段
     */
    public static Object findSingleValue(String sql,List<Object> param){
        Object object = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            pstm = conn.prepareStatement(sql);

            if (param != null && param.size()>0){
                for (int i = 0; i < param.size(); i++) {
                    pstm.setObject(i+1,param.get(i));
                }
            }

             rs = pstm.executeQuery();

            if (rs.next()){
                object = rs.getObject(1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(conn,rs,pstm);
        }

        return object;
    }

    /**
     * 查询集合
     */
    public static List queryRows(String sql,List<Object> param,Class cls){
        List<Object> list = new ArrayList();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            pstm = conn.prepareStatement(sql);

            if (param != null && param.size()>0){

                for (int i = 0; i < param.size(); i++) {
                    pstm.setObject(i+1,param.get(i));

                }
            }

            rs = pstm.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();

            int columnCount = metaData.getColumnCount();

            while (rs.next()){

                Object o = cls.newInstance();

                for (int i = 1; i<=columnCount; i++){

//                    String columnName = metaData.getColumnName(i);
                    String columnLabel = metaData.getColumnLabel(i);
//                    logger.info(metaData.getColumnLabel(i));

                    Field field = cls.getDeclaredField(columnLabel);

                    String name = "set" + columnLabel.substring(0, 1).toUpperCase() + columnLabel.substring(1);

                    Method method = cls.getMethod(name, field.getType());

                    method.invoke(o, rs.getObject(columnLabel));
                }

                list.add(o);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,rs,pstm);
        }

        return list;
    }

    /**
     * 查一条记录
     */
    public static Object queryRow(String sql,List<Object> param,Class cls){
        Object object = null;

        List list = queryRows(sql, param, cls);

        if (list != null && list.size()>0){

            object = list.get(0);

        }

        return object;
    }
}
