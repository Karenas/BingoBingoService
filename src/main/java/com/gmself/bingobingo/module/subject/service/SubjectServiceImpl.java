package com.gmself.bingobingo.module.subject.service;

import com.gmself.bingobingo.base.CommonDao;
import com.gmself.bingobingo.module.subject.db.dao.UserMapper;
import com.gmself.bingobingo.module.subject.entity.User;
import com.gmself.bingobingo.module.subject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl extends CommonDao implements SubjectService{

   @Autowired
   private UserMapper userMapper;

   public String punchUser(User user){

      return "来自 SubjectServiceImpl 的返回值";
   }

   @Override
   public User getUserByPhoneNumber(String phoneNumber) {
//      return userMapper.selectUserByPhoneNumber(phoneNumber);
      return null;
   }

}
