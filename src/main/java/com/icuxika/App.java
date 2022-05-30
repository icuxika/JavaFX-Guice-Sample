package com.icuxika;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.icuxika.inject.AppModule;
import com.icuxika.view.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 */
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Injector injector = Guice.createInjector(new AppModule());
        LoginView loginView = injector.getInstance(LoginView.class);
        stage.setScene(new Scene(loginView.view()));
        stage.show();
    }
}
