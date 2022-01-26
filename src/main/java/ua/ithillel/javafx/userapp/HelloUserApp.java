package ua.ithillel.javafx.userapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.util.List;


public class HelloUserApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello user app");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 350);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

        HBox topPane = buildTopPane();
        HBox bottomPane = buildBottomPane();
        VBox centralPane = buildCentralPane();

        Button helloButton = new Button("Say hello");
        helloButton.setPrefSize(90, 20);
        helloButton.getStyleClass().setAll("btn", "btn-success");

        Text text = new Text("");
        text.setFont(Font.font("Arial", 35));
        centralPane.getChildren().add(text);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll(List.of("Stepan", "Ivan", "Banan", "Ignat"));
        topPane.getChildren().add(choiceBox);

        helloButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text.setText("Hello from : " + choiceBox.getValue());
            }
        });

        bottomPane.getChildren().add(helloButton);


        root.setTop(topPane);
        root.setBottom(bottomPane);
        root.setCenter(centralPane);

        stage.setScene(scene);
        stage.show();
    }

    private VBox buildCentralPane() {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: #beb8b8");
        return vBox;
    }

    private HBox buildBottomPane() {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setStyle("-fx-background-color: #839d88");
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }

    private HBox buildTopPane() {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setStyle("-fx-background-color: #839d88");

        Text text = new Text();
        text.setText("Hello user app");
        text.setFont(Font.font("Arial", 15));

        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(text);
        return hBox;
    }
}
