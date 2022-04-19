module com.example.wordleex {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wordleex to javafx.fxml;
    exports com.example.wordleex;
}