package com.icuxika.vm;

import com.google.inject.Singleton;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Singleton
public class LoginViewModel {
    private final StringProperty loginButtonText = new SimpleStringProperty("Login");

    public StringProperty loginButtonTextProperty() {
        return loginButtonText;
    }

    public void setLoginButtonText(String text) {
        loginButtonTextProperty().set(text);
    }
}
