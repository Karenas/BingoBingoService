package com.gmself.bingobingo.controller;

import com.gmself.bingobingo.db.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@Controller
@RequestMapping("/app_subject")
public class ApplicationSubject {
    Random random = new Random();

//    private static SqlSessionFactory sqlSessionFactory;
//    static {
//        sqlSessionFactory =  SingletonMybatis.getSqlSessionFactory();
//    }

    @RequestMapping("/recording")
    public void doLogin(HttpServletRequest request, HttpServletResponse response)
    {

        String str = request.getMethod();

//        HashMap<String, Object> map = new HashMap<String, Object>();
//
//        int i = random.nextInt(3);
//        switch (i){
//            case 0:
//                map.put("00000", username);
//                break;
//            case 1:
//                map.put("11111", username);
//                break;
//            case 2:
//                map.put("22222", username);
//                break;
//        }

//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        try {
//            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            userMapper.insert(null);
//            sqlSession.commit();
//        }finally {
//            sqlSession.close();
//        }

//        try {
//            response.setContentType("application/json");
//            response.getWriter().write(map.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


}
