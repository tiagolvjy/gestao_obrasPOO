package com.example.todoproject.services;

import com.example.todoproject.dao.TaskDao;
import com.example.todoproject.db.DB;
import com.example.todoproject.models.Task;

import java.util.List;

public class TaskService {
    private TaskDao taskDao = new TaskDao(DB.getConnection());

    public List<Task> findAll() {
        return taskDao.findAll();
    }

    public void update(Task task){
        taskDao.update(task);
    }

    public void deleteById(Task task){
        taskDao.deleteById(task);
    }

}