module com.example.stra {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stra to javafx.fxml;
    exports com.example.stra;
}