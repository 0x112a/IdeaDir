package com.intoan.note.dao;

import com.intoan.note.po.User;
import com.intoan.note.util.JDBCUtil;
import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDao {

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public static int updateUser(User user) {

        String sql = "update tb_user set nick = ?,mood = ?,head = ? where user_id = ?";

        List<Object> param = new ArrayList<>();

        param.add(user.getNick());
        param.add(user.getMood());
        param.add(user.getHead());
        param.add(user.getUserId());

        int i = BaseDao.executeUpdate(sql, param);

        return i;
    }

    /**
     * 通过别名nick查数据
     */
    public User queryUserByNickAndUserId(String nick,Integer userId){

        String sql = "select user_id userId,user_name uname,user_pwd upwd,nick,head,mood from tb_user where nick=? and user_id<>?";

        List arrayList = new ArrayList();

        arrayList.add(nick);
        arrayList.add(userId);

        User user = (User)BaseDao.queryRow(sql, arrayList, User.class);

        return user;
    }

    /**
     * 通过用户名查询用户对象，返回用户对象
     * @param userName
     * @return User object
     */
    public User queryUserByName(String userName){
        User user = null;
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from tb_user where user_name=?";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1,userName);
            rs = pstm.executeQuery();

            if (rs.next()){
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUname(rs.getString("user_name"));
                user.setUpwd(rs.getString("user_pwd"));
                user.setNick(rs.getString("nick"));
                user.setHead(rs.getString("head"));
                user.setMood(rs.getString("mood"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,rs,pstm);
        }
        return user;
    }
    public User queryUserByName1(String name){
        String sql = "select user_id userId,user_name uname,user_pwd upwd,nick,head,mood from tb_user where user_name=?";

        List list = new ArrayList();
        list.add(name);

        User user = (User) BaseDao.queryRow(sql, list, User.class);

        return user;
    }

    /**
     * 插入一条数据
     */
    public int insertUser(User user){

        String sql = "insert into tb_user(user_name,user_pwd,nick,head,mood) value(?,?,?,?,?);";

        List list = new ArrayList();

        list.add(user.getUname());
        list.add(user.getUpwd());
        list.add(user.getNick());
        list.add(user.getHead());
        list.add(user.getMood());

        int row = BaseDao.executeUpdate(sql, list);

        return row;
    }
}
