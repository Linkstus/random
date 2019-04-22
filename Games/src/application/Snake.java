package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Snake {

	protected int x = 0;
	protected int y = 0;
	protected int xSpeed = 1;
	protected int ySpeed = 0;
	
	public void update() {
		x = this.x + xSpeed;
		y = this.y + ySpeed;
	}

	public void show(GraphicsContext gc) {
		//Rectangle rect = new Rectangle(x, y, 100, 100);
		//gc.rect(x, y, 100, 100);
		gc.setFill(Color.GREEN);
		gc.fillRect(x, y, 10, 10);
	}
}
