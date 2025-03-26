package org.example.wordle2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class WordleGame extends Application {
    private String targetWord = WordList.getRandom();
    private int currentRow = 0;
    private WordleGrid wordleGrid;

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);

        wordleGrid = new WordleGrid(grid);

        TextField inputField = new TextField();
        inputField.setPromptText("Enter 5-letter word");
        inputField.setMaxWidth(200);

        Button submitButton = new Button("Submit");
        Label resultLabel = new Label();

        submitButton.setOnAction(e -> {
            String guess = inputField.getText().toLowerCase().trim();

            if (guess.length() != 5) {
                resultLabel.setText("Please enter exactly 5 letters.");
                return;
            }

            wordleGrid.showGuess(currentRow, guess, targetWord);
            currentRow++;

            if (guess.equals(targetWord)) {
                resultLabel.setText("🎉 You guessed it!");
                submitButton.setDisable(true);
            } else if (currentRow >= 6) {
                resultLabel.setText("💀 Game over! The word was: " + targetWord);
                submitButton.setDisable(true);
            } else {
                inputField.clear();
            }
        });

        VBox root = new VBox(15, grid, inputField, submitButton, resultLabel);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Wordle");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
