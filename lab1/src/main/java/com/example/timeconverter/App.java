package com.example.timeconverter;

import com.example.timeconverter.controller.TimeController;
import com.example.timeconverter.model.TimeModel;
import com.example.timeconverter.view.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        TimeModel model = new TimeModel();

        MainView mainView = new MainView(primaryStage, model);

        new TimeController(model, mainView);
    }

    public static void main(String[] args) {
        launch(args);
    }
}