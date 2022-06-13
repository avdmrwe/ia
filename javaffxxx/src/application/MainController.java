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
import javafx.util.Duration;

public class MainController implements Initializable{
	
	@FXML
	private Button clickme;
	
	private double deltaX = 5;
	
	
	Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

		@Override
		@FXML
		public void handle(ActionEvent event) {
			clickme.setLayoutX(clickme.getLayoutX() + deltaX);
			
		}
			
	}));
	
	public void handle(ActionEvent event) {
		clickme.setLayoutX(clickme.getLayoutX() + deltaX);
		
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
}

