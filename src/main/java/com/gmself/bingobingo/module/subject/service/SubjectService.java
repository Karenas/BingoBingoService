package com.gmself.bingobingo.module.subject.service;


import com.gmself.bingobingo.module.subject.entity.User;

public interface SubjectService {

    int punchUser(User user);

    User getUserByPhoneNumber(String phoneNumber);

}
