package com.icuxika.inject;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import com.icuxika.AppFXML;
import com.icuxika.AppResource;
import com.icuxika.action.HomeAction;
import com.icuxika.action.LoginAction;
import com.icuxika.view.HomeView;
import com.icuxika.view.LoginView;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(LoginView.class).to(LoginAction.class);

        bind(HomeView.class).to(HomeAction.class);

        bindListener(new AbstractMatcher<>() {
            @Override
            public boolean matches(TypeLiteral<?> typeLiteral) {
                Class<?> viewClass = typeLiteral.getRawType().getSuperclass();
                return viewClass.isAnnotationPresent(AppFXML.class);
            }
        }, new TypeListener() {
            @Override
            public <I> void hear(TypeLiteral<I> typeLiteral, TypeEncounter<I> typeEncounter) {
                typeEncounter.register((InjectionListener<I>) i -> {
                    Class<?> viewClass = i.getClass().getSuperclass();
                    if (viewClass.isAnnotationPresent(AppFXML.class)) {
                        AppFXML appFXML = viewClass.getAnnotation(AppFXML.class);
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        URL url = AppResource.load(appFXML.fxml() + "/" + appFXML.fxml() + ".fxml");
                        fxmlLoader.setLocation(url);
                        fxmlLoader.setController(i);
                        // fxml 文件需要使用 <fx:root>
                        fxmlLoader.setRoot(i);
                        try {
                            fxmlLoader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
