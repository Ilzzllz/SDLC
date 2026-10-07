module com.example.timeconverter {
    requires javafx.controls;
    opens com.example.timeconverter to javafx.graphics;
    exports com.example.timeconverter;
}