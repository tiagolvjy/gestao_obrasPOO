package com.example.todoproject.controllers;

import com.example.todoproject.MainApplication;
import com.example.todoproject.models.Task;
import com.example.todoproject.services.TaskService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    private TaskService taskService = new TaskService();

    @FXML
    private TableView<Task> taskTableView;

    @FXML
    private TableColumn<Task, Integer> tableColumnId;
    @FXML
    private TableColumn<Task, Integer> tableColumnTitle;
    @FXML
    private TableColumn<Task, Integer> tableColumnDescription;

    @FXML
    private ObservableList<Task> observableList;

    @FXML
    public void onCreateTask() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("create-task-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1260, 710);
            Stage stage = new Stage();
            stage.setTitle("Nova Obra");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onUpdateTaskAction(){
        Task selectedTask = taskTableView.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("edit-task-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1260, 710);
            Stage stage = new Stage();
            stage.setTitle("Atualizar Obra");
            stage.setScene(scene);
            UpdateTaskController updateTaskController = fxmlLoader.getController();
            updateTaskController.setTask(selectedTask);
            updateTaskController.updateFields();
            stage.show();

            stage.setOnHiding(event -> updateTable());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onDeleteTaskAction(){
        Task selectedTask = taskTableView.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("delete-task-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 420, 240);
            Stage stage = new Stage();
            stage.setTitle("Deletar Obra");
            stage.setScene(scene);
            DeleteTaskController deleteTaskController = fxmlLoader.getController();
            deleteTaskController.setTask(selectedTask);
            deleteTaskController.updateFields();
            stage.show();

            stage.setOnHiding(event -> updateTable());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        updateTable();
    }

    public void updateTable() {
        observableList = FXCollections.observableList(taskService.findAll());
        taskTableView.setItems(observableList);
    }
}
