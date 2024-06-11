package com.example.todoproject.services;

import com.example.todoproject.dao.ITaskDao;
import com.example.todoproject.dao.TaskDao;
import com.example.todoproject.db.DB;
import com.example.todoproject.models.Task;

public class CreateTaskService {
    ITaskDao taskDao = new TaskDao(DB.getConnection());
    public void save(Task task) {
        taskDao.insert(task);
    }
}
