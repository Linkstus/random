package application;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Grid {

	//the state of the grid
	protected final int size = 10;
	
	//size of the grid
	protected int rows;
	protected int colms;
	
	public Grid(double width, double height) {
		rows = (int) width/size;
		colms = (int) height/size;
	}
	
	public int getCols() {
        return colms;
    }

    public int getRows() {
        return rows;
    }

    public double getWidth() {
        return rows * size;
    }

    public double getHeight() {
        return colms * size;
    }
   /* public void paint(GraphicsContext gc) {
    	for(int rows = 0; rows < grid.length; rows++) {
    	gc.setFill(Color.rgb(255, 255, 255, 0));
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
    }*/
}
