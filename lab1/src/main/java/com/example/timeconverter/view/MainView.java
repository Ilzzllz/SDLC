package com.example.timeconverter.view;

import com.example.timeconverter.model.TimeModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class MainView implements Observer {
    private final Stage stage;
    private final TimeModel model;
    private Label resultLabel;
    private Button inputButton;
    private int lastInput = 0;

    public MainView(Stage stage, TimeModel model) {
        this.stage = stage;
        this.model = model;
        this.model.addObserver(this);
        createUI();
    }

    private void createUI() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Конвертер времени ожидания");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        inputButton = new Button("Ввести данные");
        resultLabel = new Label("Введите время ожидания...");
        resultLabel.setWrapText(true);

        root.getChildren().addAll(titleLabel, inputButton, resultLabel);

        Scene scene = new Scene(root, 450, 300);
        stage.setTitle("Конвертер времени ожидания");
        stage.setScene(scene);
        stage.show();
    }

    public Button getInputButton() {
        return inputButton;
    }

    public int getLastInput() {
        return lastInput;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof TimeModel) {
            TimeModel m = (TimeModel) o;
            int minutes = m.getWaitingTimeMinutes();
            lastInput = minutes;
            updateResult(minutes);
        }
    }

    private void updateResult(int minutes) {
        StringBuilder sb = new StringBuilder();
        sb.append("Вы прождали: ").append(minutes).append(" мин.\n");
        sb.append("Это ощущается как:\n\n");

        sb.append("• Очередь в поликлинике: ~").append(minutes * 15).append(" мин.\n");

        sb.append("• Загрузка Windows: ~").append(minutes * 10).append(" мин.\n");

        sb.append("• Ожидание доставки еды: ~").append(minutes * 5).append(" мин.\n");

        sb.append("• Прогрев микроволновки: ~").append(minutes).append(" мин.");

        resultLabel.setText(sb.toString());
    }
}