package com.example.todoproject.controllers;

import com.example.todoproject.models.Task;
import com.example.todoproject.services.CreateTaskService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateTaskController {

    @FXML
    TextField txtFieldTitle;
    @FXML
    TextField txtFieldDescription;

    CreateTaskService createTaskService = new CreateTaskService();

    @FXML
    public void onSaveButton() {
        Task task = new Task(
                txtFieldTitle.getText(),
                txtFieldDescription.getText()
        );
        createTaskService.save(task);
    }
}
