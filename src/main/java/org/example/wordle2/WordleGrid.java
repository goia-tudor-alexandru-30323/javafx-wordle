package org.example.wordle2;



import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class WordleGrid {
    private static final int ROWS = 6;
    private static final int COLUMNS = 5;
    private final TextField[][] cells = new TextField[ROWS][COLUMNS];

    public WordleGrid(GridPane grid) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                TextField tf = new TextField();
                tf.setPrefSize(50, 50);
                tf.setEditable(false);
                tf.setStyle("-fx-font-size: 20; -fx-alignment: center;");
                grid.add(tf, col, row);
                cells[row][col] = tf;
            }
        }
    }

    public void showGuess(int row, String guess, String target) {
        for (int i = 0; i < COLUMNS; i++) {
            char ch = guess.charAt(i);
            TextField tf = cells[row][i];
            tf.setText(String.valueOf(ch));

            if (ch == target.charAt(i)) {
                tf.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-size: 20; -fx-alignment: center;");
            } else if (target.contains(String.valueOf(ch))) {
                tf.setStyle("-fx-background-color: gold; -fx-text-fill: black; -fx-font-size: 20; -fx-alignment: center;");
            } else {
                tf.setStyle("-fx-background-color: gray; -fx-text-fill: white; -fx-font-size: 20; -fx-alignment: center;");
            }
        }
    }
}


