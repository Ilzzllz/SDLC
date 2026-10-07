package com.example.timeconverter.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class InputView {
    private final Stage stage;
    private final Consumer<String> onSubmit;

    public InputView(Stage owner, int lastValue, Consumer<String> onSubmit) {
        this.stage = new Stage();
        this.onSubmit = onSubmit;
        stage.initOwner(owner);
        stage.initModality(Modality.WINDOW_MODAL);
        createUI(lastValue);
    }

    private void createUI(int lastValue) {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Label label = new Label("Введите время ожидания (в минутах):");
        TextField inputField = new TextField();
        inputField.setText(lastValue > 0 ? String.valueOf(lastValue) : "");
        inputField.setPromptText("Например: 30");

        Button okButton = new Button("OK");
        okButton.setOnAction(e -> {
            onSubmit.accept(inputField.getText());
            stage.close();
        });

        root.getChildren().addAll(label, inputField, okButton);
        Scene scene = new Scene(root, 300, 150);
        stage.setTitle("Ввод данных");
        stage.setScene(scene);
    }

    public void show() {
        stage.showAndWait();
    }
}