package com.example.todoproject.controllers;

import com.example.todoproject.MainApplication;
import com.example.todoproject.services.LoginService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    TextField txtFieldEmail;
    @FXML
    TextField txtFieldPassword;

    @FXML
    Text textError;

    LoginService loginService = new LoginService();

    @FXML
    public void onRegisterAction() {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("signup-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1260, 710);
            Stage stage = new Stage();
            stage.setTitle("Cadastrar Usuário");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onLoginAction() {
        textError.setText("");
        try {
            loginService.login(
                    txtFieldEmail.getText(),
                    txtFieldPassword.getText()
            );
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home-view.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 1260, 710);
                Stage stage = new Stage();
                stage.setTitle("Bem Vindo!");
                stage.setScene(scene);
                stage.show();
                Stage stageLogin = (Stage) textError.getScene().getWindow();
                stageLogin.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            textError.setText(e.getMessage());
        }
    }
}