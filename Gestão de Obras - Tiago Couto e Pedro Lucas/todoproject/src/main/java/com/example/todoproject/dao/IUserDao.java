package com.example.todoproject.dao;

import com.example.todoproject.models.User;

import java.util.List;

public interface IUserDao {
    void insert(User user);
    void update(User user);
    void deleteById(Integer id);
    void findById(Integer id);
    List<User> findAll();

    Boolean findByUsernameAndPassword(String username, String password);
}
