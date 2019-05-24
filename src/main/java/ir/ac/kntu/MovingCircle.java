package ir.ac.kntu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author [Your Name]
 */
public class MovingCircle extends Application {

    KeyCode lastPressedKey;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        Circle circle = new Circle(100, 100, 40);
        pane.getChildren().add(circle);

        //TODO: this while loop is not going to work. WHY?
        //TODO: create a thread just with lambda expression
        // and put this while loop into it
        
        // Check last pressed key by comparing it to KeyCode.DIRECTION ex.: if(lastPressedKey==KeyCode.D)
        // and then move the circle like circle.setCenterX(circle.getCenterX() + 10);
        
        //ATTENTION: you need to invoke Platform.runLater. Ask Why.

            while (true) {
                try {
                    Thread.sleep(30);
                    //TODO: Handle Directions
                    Platform.runLater(() -> {
                        circle.setCenterX(circle.getCenterX() + 10);
                    });
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        //Start your thread:=> thread.start();
        Scene scene = new Scene(pane, 600, 600);
        scene.setOnKeyPressed(event -> {
            System.out.println("event = " + event);
            lastPressedKey = event.getCode();
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

