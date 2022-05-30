package com.icuxika.action;

import com.google.inject.Inject;
import com.icuxika.controller.HomeController;
import com.icuxika.vm.LoginViewModel;
import javafx.scene.Parent;

public class HomeAction extends HomeController {

    @Inject
    private LoginViewModel loginViewModel;

    @Override
    public Parent view() {
        return this;
    }

    @Override
    public void test() {
        loginViewModel.setLoginButtonText("登录");
    }

}
