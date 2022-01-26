module ua.ithillel.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens ua.ithillel.javafx to javafx.fxml;
    exports ua.ithillel.javafx;
    exports ua.ithillel.javafx.userapp;
}