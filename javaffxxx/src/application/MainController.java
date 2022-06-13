package application;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MainController implements Initializable{
	
	@FXML
	private Pane scenePane;

	@FXML
	private Button clickme;
	
	@FXML
	private Circle circleONE;
	
	@FXML
	private Circle circleTWO;

	@FXML
	private Circle circleTHREE;

		
	private double delta = 2;

	
	
	Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

		
		@Override
		@FXML
		public void handle(ActionEvent event) {
			if(Hello.keyIsPressed == 1) {
				if(Hello.theKey == "D") {
					clickme.setLayoutX(clickme.getLayoutX() + delta);
				}
				else if(Hello.theKey == "A") {
					clickme.setLayoutX(clickme.getLayoutX() - delta);
				}
				else if(Hello.theKey == "W") {
					clickme.setLayoutY(clickme.getLayoutY() - delta);
				}
				else if(Hello.theKey == "S") {
					clickme.setLayoutY(clickme.getLayoutY() + delta);
				}
			}
				
				
		}
		
	}));
	
	public void handle(ActionEvent event) {
		
	}
	
	public boolean outOfBounds(Node node) {
        Bounds bounds = node.getBoundsInLocal();
        boolean rightBorder = clickme.getLayoutX() >= (bounds.getMaxX() - clickme.getWidth());
        boolean leftBorder = clickme.getLayoutX() <= (bounds.getMinX() + clickme.getWidth());
        boolean bottomBorder = clickme.getLayoutY() >= (bounds.getMaxY() - clickme.getWidth());
        boolean topBorder = clickme.getLayoutY() <= (bounds.getMinY() + clickme.getWidth());

        if (rightBorder || leftBorder) {
            System.out.println("hit vertical border");
        }
        if (bottomBorder || topBorder) {
            System.out.println("hit horizontal border");
        }
        return false;
    }




	@Override
	public void initialize(URL location, ResourceBundle resources) {
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		isDraggable.dragThis(circleONE);
		isDraggable.dragThis(circleTWO);
		isDraggable.dragThis(circleTHREE);


	}
}
