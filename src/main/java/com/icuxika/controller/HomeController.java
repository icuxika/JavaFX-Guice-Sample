package com.icuxika.controller;

import com.icuxika.AppFXML;
import com.icuxika.view.HomeView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

@AppFXML(fxml = "home")
public abstract class HomeController extends StackPane implements HomeView {

    @FXML
    private Button testButton;

    public void initialize() {
        testButton.setOnAction(actionEvent -> test());
    }
}
