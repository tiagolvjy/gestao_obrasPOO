package com.example.todoproject.controllers;

import com.example.todoproject.models.Task;
import com.example.todoproject.services.TaskService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class DeleteTaskController {

    @FXML
    public Label lblTaskTitle;

    TaskService taskService = new TaskService();
    Task task;

    public void onConfirmButton() {
        if (task != null) {
            taskService.deleteById(task);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Deletado!");
            alert.setHeaderText(null);
            alert.setContentText("Obra deletada com sucesso");
            alert.showAndWait();
        }
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void updateFields() {
        this.lblTaskTitle.setText(task.getTitle());
    }
}
