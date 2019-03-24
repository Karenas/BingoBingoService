package com.gmself.bingobingo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Random;

@Controller
@RequestMapping("/my")
public class ReturnOne {
    Random random = new Random();

    @RequestMapping("/login")
    public void doLogin(HttpServletRequest request, HttpServletResponse response,String username, String password)
    {
        HashMap<String, Object> map = new HashMap<String, Object>();

        int i = random.nextInt(3);
        switch (i){
            case 0:
                map.put("00000", username);
                break;
            case 1:
                map.put("11111", username);
                break;
            case 2:
                map.put("22222", username);
                break;
        }

        try {
            response.setContentType("application/json");
            response.getWriter().write(map.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
