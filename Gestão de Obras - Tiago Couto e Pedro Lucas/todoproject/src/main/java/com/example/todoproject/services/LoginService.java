package com.example.todoproject.services;

import com.example.todoproject.dao.UserDao;
import com.example.todoproject.db.DB;
import com.example.todoproject.exceptions.InvalidUserException;

public class LoginService {

    UserDao userDao = new UserDao(DB.getConnection());

    public void login(String username, String password) {
        Boolean authenticated = userDao.findByUsernameAndPassword(username, password);
        if (!authenticated) {
            throw new InvalidUserException("Usuário e/ou senha inválidos!");
        }
    }
}
