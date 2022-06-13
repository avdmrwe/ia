package application;

import javafx.scene.Node;

public class isDraggable {
	
	private static double mousePosX;
	private static double mousePosY;
	
	public static void dragThis(Node node) {
		
		node.setOnMousePressed(mouseEvent -> {
			mousePosX = mouseEvent.getX();
			mousePosY = mouseEvent.getY();
		});
		
		node.setOnMouseDragged(mouseEvent -> {
			node.setLayoutX(mouseEvent.getSceneX() - mousePosX);
			node.setLayoutY(mouseEvent.getSceneY() - mousePosY);

		});
	}
	
	
}
