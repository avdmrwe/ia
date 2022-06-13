package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Hello extends Application {
	
	
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

