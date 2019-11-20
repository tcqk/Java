package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Jaja extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(new Button("Button"));
        Scene scene = new Scene(stackPane, 300, 200);
        primaryStage.setScene(scene);
//        primaryStage.show();

        Stage stage = new Stage();
        stage.setScene(new Scene(new Button("Hello"), 300, 200));
        stage.setTitle("Next stage");
//        stage.show();

        Stage stage1 = new Stage();
        Pane pane1 = new Pane();
        Circle circle1 = new Circle();
        circle1.setRadius(50);
        circle1.setCenterX(100);
        circle1.setCenterY(100);
        circle1.centerXProperty().bind(pane1.widthProperty().divide(2));
        circle1.centerYProperty().bind(pane1.heightProperty().divide(2));
        circle1.setFill(new Color(0,0,1,1));
        pane1.getChildren().add(circle1);
        stage1.setScene(new Scene(pane1, 200, 200));
//        stage1.show();

        StackPane stackPane1 = new StackPane();
        Image image = new Image("");
        ImageView imageView = new ImageView(image);
    }
}
