package com.gmself.bingobingo.module.subject.service;

import com.gmself.bingobingo.module.subject.entity.User;


public interface SubjectService {

    String PunchUser(User user);

    User getUserByPhoneNumber(String phoneNumber);

}
