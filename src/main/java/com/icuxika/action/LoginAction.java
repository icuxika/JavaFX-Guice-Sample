package com.icuxika.action;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.icuxika.controller.LoginController;
import com.icuxika.view.HomeView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginAction extends LoginController {

    @Inject
    private Injector injector;

    @Override
    public Parent view() {
        return this;
    }

    @Override
    public void login() {
        loginViewModel.setLoginButtonText("Sign in");
        System.out.println("login!!!");
        HomeView homeView = injector.getInstance(HomeView.class);
        Stage stage = new Stage();
        stage.setScene(new Scene(homeView.view()));
        stage.show();
    }
}
