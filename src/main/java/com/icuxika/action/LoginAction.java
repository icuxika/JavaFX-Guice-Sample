package com.icuxika.action;

import com.google.inject.Inject;
import com.icuxika.controller.LoginController;
import com.icuxika.view.HomeView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginAction extends LoginController {

    @Inject
    private HomeView homeView;

    @Override
    public Parent view() {
        return this;
    }

    @Override
    public void login() {
        loginViewModel.setLoginButtonText("Sign in");
        System.out.println("login!!!");
        Stage stage = new Stage();
        stage.setScene(new Scene(homeView.view()));
        stage.show();
    }
}
