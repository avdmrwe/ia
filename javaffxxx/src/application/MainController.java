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
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MainController implements Initializable{
	
	@FXML
	private Pane scenePane;
	
	@FXML
	private Rectangle snapTo;
	
	@FXML
	private Button clickme;
	
	@FXML
	private Circle circleONE;
	
	@FXML
	private Circle circleTWO;

	@FXML
	private Circle circleTHREE;
	
	@FXML
	private Line rightLine;
	
	@FXML
	private Pane lowerPane;
	

	public static int nextScene = 0;
	
	private int repeatAddCheck = 0;

		
	private double delta = 2;
	
	
	

	
	
	
	Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

		
		@Override
		@FXML
		public void handle(ActionEvent event) {
			
						
			if(Hello.keyIsPressed == 1) {
				outOfBounds(clickme);
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
			
			snapToArea(circleONE, snapTo);
			snapToArea(circleTWO, snapTo);
			snapToArea(circleTHREE, snapTo);
			
		}
						
		}));
	
	public void firstRun() {
		repeatAddCheck = 1;
	}
		
	public void outOfBounds(Node node) {
        /*System.out.println(bounds.getMaxX());
        System.out.println(clickmeBounds.getMaxX());*/
		
		Bounds bounds = scenePane.getBoundsInParent();
		Bounds clickmeBounds = clickme.getBoundsInParent();

        if (bounds.getMaxX() <= clickmeBounds.getMaxX()) {
			clickme.setLayoutX(clickme.getLayoutX() - 400);
			
			if(repeatAddCheck == 0) {
				Node groupOne[] = new Node[2];
				groupOne[0] = circleONE;
				groupOne[1] = scenePane;
				
				
				for (int i = 0; i <= 1; i++) {
					groupOne[i].setVisible(false);
				}
				firstRun();
			}

			
        }
        if (bounds.getMaxY() <= clickmeBounds.getMaxY()) {
			clickme.setLayoutY(clickme.getLayoutY() - 5);
        }
        if (bounds.getMinX() >= clickmeBounds.getMinX()) {
			clickme.setLayoutX(clickme.getLayoutX() + 5);
        }
        if (bounds.getMinY() >= clickmeBounds.getMinY()) {
			clickme.setLayoutY(clickme.getLayoutY() + 5);
        }
       }
       
        
        
        
        /*boolean rightBorder = clickme.getLayoutX() >= (bounds.getMaxX() - clickme.getWidth());
        boolean leftBorder = clickme.getLayoutX() <= (bounds.getMinX() + clickme.getWidth());
        boolean bottomBorder = clickme.getLayoutY() >= (bounds.getMaxY() - clickme.getWidth());
        boolean topBorder = clickme.getLayoutY() <= (bounds.getMinY() + clickme.getWidth());

        if (rightBorder || leftBorder) {
            System.out.println("hit horizontal border");
        }
        if (bottomBorder || topBorder) {
            System.out.println("hit vertical border");
        }*/

	public void snapToArea(Node object, Node area) {
		Bounds snapBounds = area.getBoundsInParent();
		Bounds circleBounds = object.getBoundsInParent();
		
		object.setOnMouseReleased(mouseEvent -> {
			if(circleBounds.intersects(snapBounds)) {
				System.out.println("snappy!");
				object.setLayoutX(snapBounds.getMinX() + ((snapBounds.getMaxX() - snapBounds.getMinX()) / 2));
				object.setLayoutY(snapBounds.getMaxY() - ((snapBounds.getMaxY() - snapBounds.getMinY()) / 2));					
			}
		});
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
