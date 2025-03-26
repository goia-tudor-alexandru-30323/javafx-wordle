module org.example.wordle2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.wordle2 to javafx.fxml;
    exports org.example.wordle2;
}