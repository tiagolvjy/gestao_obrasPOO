package com.example.todoproject.controllers;

import com.example.todoproject.models.Task;
import com.example.todoproject.services.TaskService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class UpdateTaskController {


    @FXML
    TextField txtFieldTitle;

    @FXML
    TextField txtFieldDescription;

    TaskService taskService = new TaskService();

    Task task;

    public void onSaveButton() {
        task.setTitle(txtFieldTitle.getText());
        task.setDescription(txtFieldDescription.getText());
        taskService.update(task);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Editado!");
        alert.setHeaderText(null);
        alert.setContentText("Obra editada com sucesso");
        alert.showAndWait();
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void updateFields() {
        this.txtFieldDescription.setText(task.getDescription());
        this.txtFieldTitle.setText(task.getTitle());
    }
}