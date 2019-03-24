package com.gmself.bingobingo.moudle.subject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@Controller
@RequestMapping(value = "/app_subject", method = RequestMethod.POST)
public class ApplicationSubject {
    Random random = new Random();

//    private static SqlSessionFactory sqlSessionFactory;
//    static {
//        sqlSessionFactory =  SingletonMybatis.getSqlSessionFactory();
//    }

    @PostMapping(value = "/recording")
    public void doLogin(HttpServletRequest request, HttpServletResponse response, @RequestBody String string)
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
