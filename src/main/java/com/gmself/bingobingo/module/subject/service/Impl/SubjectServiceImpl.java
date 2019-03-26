package com.gmself.bingobingo.module.subject.service.Impl;

import com.gmself.bingobingo.module.subject.db.CommonDao;
import com.gmself.bingobingo.module.subject.db.dao.UserMapper;
import com.gmself.bingobingo.module.subject.entity.User;
import com.gmself.bingobingo.module.subject.service.SubjectService;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class SubjectServiceImpl extends CommonDao implements SubjectService{

   @Autowired
   private UserMapper userMapper;

   public String PunchUser(User user){

      return "来自 SubjectServiceImpl 的返回值";
   }

   @Override
   public User getUserByPhoneNumber(String phoneNumber) {
      return userMapper.selectUserByPhoneNumber(phoneNumber);
   }

}
