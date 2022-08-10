package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Hello extends Application {
	
	public static int keyIsPressed = 0;
	public static String theKey = null;

	
	@Override
	public void start(Stage primaryStage) {
			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
				Scene scene = new Scene(root);
							
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setResizable(false);
			
				
				
				
				
			    root.setOnKeyPressed(new EventHandler<KeyEvent>() {
			        @Override
			        public void handle(KeyEvent event) {
			        	System.out.println("key pressed: " + event.getCode().toString());
			        	keyIsPressed = 1;
			        	theKey = event.getCode().toString();
			        }
			    });
			    
			    root.setOnKeyReleased(new EventHandler<KeyEvent>() {
			    	@Override
			    	public void handle(KeyEvent event) {
			        	System.out.println("key released: " + event.getCode().toString());
			        	keyIsPressed = 0;
			        	theKey = event.getCode().toString();
			    	}
			    });



			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
	}
	
	
	
        	
        	
        	
	public static void main(String[] args) {
		launch(args);
	}
}

	
	//i <3 anja


