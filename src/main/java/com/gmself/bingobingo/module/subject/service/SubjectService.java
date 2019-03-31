package com.gmself.bingobingo.module.subject.service;


import com.gmself.bingobingo.module.subject.entity.User;

public interface SubjectService {

    String punchUser(User user);

    User getUserByPhoneNumber(String phoneNumber);

}
