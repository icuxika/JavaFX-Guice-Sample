package com.icuxika.controller;

import com.google.inject.Inject;
import com.icuxika.AppFXML;
import com.icuxika.view.LoginView;
import com.icuxika.vm.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

@AppFXML(fxml = "login")
public abstract class LoginController extends StackPane implements LoginView {

    @Inject
    protected LoginViewModel loginViewModel;

    @FXML
    private Button loginButton;

    public void initialize() {
        loginButton.textProperty().bind(loginViewModel.loginButtonTextProperty());
        loginButton.setOnAction(actionEvent -> login());
    }

    public Button getLoginButton() {
        return loginButton;
    }
}
