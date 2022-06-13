package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
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
