package com.gmself.bingobingo.module.subject.controller;

import com.gmself.bingobingo.module.subject.entity.User;
import com.gmself.bingobingo.module.subject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/m_subject", method = RequestMethod.POST)
public class RequestSubject {

    @Autowired
    private SubjectService subjectService = null;

    @PostMapping(value = "/punch")
    public void doPunchUser(HttpServletRequest request, HttpServletResponse response, @RequestBody User user)
    {

//        String str = subjectService.PunchUser(user);

        User user1 = subjectService.getUserByPhoneNumber(user.getPhoneNumber());

        System.out.println(user1.getName());

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
