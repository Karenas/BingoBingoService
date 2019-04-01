package com.gmself.bingobingo.module.subject.service;

import com.gmself.bingobingo.base.CommonDao;
import com.gmself.bingobingo.module.subject.constant.CheckCode_subject;
import com.gmself.bingobingo.module.subject.constant.RespCode_punch;
import com.gmself.bingobingo.module.subject.db.dao.UserMapper;
import com.gmself.bingobingo.module.subject.entity.User;
import com.gmself.bingobingo.module.subject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl extends CommonDao implements SubjectService{

   @Autowired
   private UserMapper userMapper;

   public int punchUser(User user){

      int r = userMapper.updateByPhoneNumber(user);
      if (r <= 0){
         r = userMapper.insert(user);
      }

      if (r!=-1){
         return RespCode_punch.SUCCESS;
      }else {
         return RespCode_punch.DATABASE_FAIL;
      }
//      return RespCode_punch.SUCCESS;
   }

   @Override
   public User getUserByPhoneNumber(String phoneNumber) {
//      return userMapper.selectUserByPhoneNumber(phoneNumber);
      return null;
   }

}
