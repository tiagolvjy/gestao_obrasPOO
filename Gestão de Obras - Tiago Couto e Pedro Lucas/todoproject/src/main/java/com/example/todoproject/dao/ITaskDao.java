package com.example.todoproject.dao;

import com.example.todoproject.models.Task;
import com.example.todoproject.models.User;

import java.util.List;

public interface ITaskDao {
    void insert(Task task);
    void update(Task task);
    void deleteById(Task task);
    void findById(Integer id);
    List<Task> findAll();

}
