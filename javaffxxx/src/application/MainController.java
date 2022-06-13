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
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class MainController implements Initializable{
	
	@FXML
	private Button clickme;
	
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


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
}
