package com.intoan.note.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonUtil {

    public static void toJson(HttpServletResponse resp, Object o){
        try {
            resp.setContentType("application/json;charset=UTF-8");
            PrintWriter writer = resp.getWriter();

            String json = JSON.toJSONString(o);

            writer.write(json);

//            writer.flush();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
