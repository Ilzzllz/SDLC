package com.example.timeconverter.controller;

import com.example.timeconverter.model.TimeModel;
import com.example.timeconverter.view.InputView;
import com.example.timeconverter.view.MainView;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class TimeController {
    private final TimeModel model;
    private final MainView mainView;

    public TimeController(TimeModel model, MainView mainView) {
        this.model = model;
        this.mainView = mainView;
        initController();
    }

    private void initController() {
        mainView.getInputButton().setOnAction(e -> openInputDialog());
    }

    private void openInputDialog() {
        Stage inputStage = new Stage();
        InputView inputView = new InputView(inputStage, mainView.getLastInput(), this::processInput);
        inputView.show();
    }

    private void processInput(String input) {
        try {
            int minutes = Integer.parseInt(input.trim());
            if (minutes < 0) {
                throw new NumberFormatException("Отрицательное значение");
            }
            model.setWaitingTimeMinutes(minutes);
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка ввода");
            alert.setHeaderText("Некорректные данные");
            alert.setContentText("Пожалуйста, введите целое неотрицательное число.");
            alert.showAndWait();
        }
    }
}