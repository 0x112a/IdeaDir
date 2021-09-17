package com.intoan.note.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {

    private static InputStream inputStream = null;
    private static SqlSessionFactory sqlSessionFactory = null;
    private static SqlSession sqlSession = null;

    static {

        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }


    public static SqlSession getSqlSession(){


        sqlSession = sqlSessionFactory.openSession();

        return sqlSession;
    }

    public static void close(SqlSession sqlSession,InputStream inputStream){
        if (sqlSession != null){
            try {
                sqlSession.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
