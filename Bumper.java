
import java.awt.*;

public class Bumper {
	// private fields, all ints, for a Bumper
	// hint: the "location" of the bumper begins at its top left corner.
	private int myX;
	private int myY;
	private int myWidth;
	private int myHeight;
	private Color myColor;

	// Default constructor
	public Bumper() {
		myX = 200;
		myY = 200;
		myWidth = 20;
		myHeight = 100;
		
	}

	// 5-arg constructor
	public Bumper(int x, int y, int xWidth, int yWidth, Color c) {
		myX = x;
		myY = y;
		myWidth = xWidth;
		myHeight = yWidth;
		myColor = c;
	}

	// ***********************************************
	//
	// Accessor methods (one for each field)
	//
	// ***********************************************

	public int getX() {
		return myX;
	}

	public int getY() {
		return myY;
	}
	public int getHeight() {
		return myHeight;
	}
	public int getWidth() {
		return myWidth;
	}
	public Color getColor() {
		return myColor;
	}

	public void setX(int x) {
		myX = x;
	}

	public void setY(int y) {
		myY = y;
	}
	public void setHeight(int h) {
		myHeight = h;
	}
	public void setWidth(int w) {
		myWidth = w;
	}
	public void setColor(Color c) {
		myColor = c;
	}

	/**
	 * Chooses a random (x,y) location for the Bumper. Bumper stays entirely in the
	 * window.
	 * 
	 * @param rightEdge
	 *            the right side of the window
	 * @param bottomEdge
	 *            the bottom side of the window
	 */
	public void jump(int rightEdge, int bottomEdge) {
		myX = (int) (Math.random() * rightEdge);
		myY = (int) (Math.random() * bottomEdge);
	}

	/**
	 * Draws a rectangular bumper on the buffer
	 * 
	 * @param myBuffer
	 *            the picture drawn on the screen
	 */
	public void draw(Graphics myBuffer) {
		// change the color of myBuffer (using appropriate data fields)
		// use myBuffer to draw the Bumper (using appropriate data fields)
		// YOUR CODE HERE
		myBuffer.setColor(myColor);
		myBuffer.fillRect(myX,myY ,myWidth,myHeight);
		
	}

	/**
	 * Returns true if any part of the Polkadot is inside the bumper
	 * 
	 * @return true if any part of the polkadot is inside the bumper
	 */
	public boolean inBumper(Polkadot dot) {
		for (int x = getX(); x <= getX() + getWidth(); x++) // starts at upper left corner(x,y)
			for (int y = getY(); y <= getY() + getHeight(); y++)
				if (distance(x, y, dot.getX(), dot.getY()) <= dot.getRadius()) // checks every point on the bumper
					return true;
		return false;
		// THIS METHOD IS ALREADY COMPLETE
	}

	/**
	 * Calculates the distance between (x1, y1) and (x2, y2)
	 * 
	 * @param x1
	 *            Comment...
	 * @param y1
	 *            Comment...
	 * @param x2
	 *            Comment...
	 * @param y2
	 *            Comment...
	 * @return the distance between (x1, y1) and (x2, y2)
	 */
	private double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		// THIS METHOD IS ALREADY COMPLETE
	}
}