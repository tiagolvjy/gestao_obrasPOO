package com.example.todoproject.services;

import com.example.todoproject.dao.UserDao;
import com.example.todoproject.db.DB;
import com.example.todoproject.exceptions.InvalidPasswordException;
import com.example.todoproject.models.User;

public class UserService {
//    FACTORY / ABSTRACT FACTORY -> GURU
    private final UserDao userDao = new UserDao(DB.getConnection());

    public void create(User user) {
        if(user.getPassword().length() < 6) {
            throw new InvalidPasswordException("O Password deve conter pelo menos 6 caracteres.");
        }
        userDao.insert(user);
    }
}
