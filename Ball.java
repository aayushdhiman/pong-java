import java.awt.*;

public class Ball extends Polkadot {
	public static final int FRAME = 1000;
	private double dx; // pixels to move each time move() is called.
	private double dy;
	private int leftScore = 0;
	private int rightScore = 0;
	private boolean isWall = true;

	// constructors
	public Ball()// default constructor
	{
		super(200, 200, 20, Color.white);
		// to move vertically
		do {// continue to generate a random value until it's not 0
			dx = Math.random() * 12 - 6;
		} while (dx == 0);
		// to move horizontally
		do {// continue to generate a random value until it's not 0
			dy = Math.random() * 12 - 6;
		} while (dy == 0);
	}

	public Ball(double x, double y, double dia, Color c) {
		super(x, y, dia, c);
		do {
			dx = Math.random() * 12 - 6;
		} while (dx == 0);
		do {
			dy = Math.random() * 12 - 6;
		} while (dy == 0);
	}

	// modifier methods
	public void setdx(double x) {
		dx = x;
	}

	public void setdy(double y) {
		dy = y;
	}

	// accessor methods
	public double getdx() {
		return dx;
	}

	public double getdy() {
		return dy;
	}

	// instance methods
	public void move(double rightEdge, double bottomEdge, Graphics g) {
		// reset the x value to be what it currently is plus the change

		
		
		
		g.setColor(Color.GRAY);
		if (isWall) {

			for (int i = 10; i < FRAME; i += 20) {
				g.fillRect(FRAME/2 - 5, i, 10, 10);
			}
		}
		g.setColor(Color.WHITE);
		g.setFont(new Font("Monospaced", Font.BOLD, 80));

		g.drawString(Integer.toString(rightScore), FRAME/2 + 60, 70);
		g.drawString(Integer.toString(leftScore), FRAME/2 - 90, 70);

		setX(getX() + dx); // x = x + dx

		setY(getY() + dy); // y = y + dy

		// check for left & right edge bounces
		if (getX() >= rightEdge - getRadius()) // hits the right edge
		{
			setX(FRAME/2);
			setY(FRAME/2);
			
		
			
			
			// setX(rightEdge - getRadius());
			// dx = dx * -1;
			dx = 0;
			dy = 0;
			// dx = 0;
			rightScore++;

		}

		else if (getX() <= 0 + getRadius()) // hits the left edge
		{
			setX(FRAME/2);
			setY(FRAME/2);

			// setX(0 + getRadius());
			// dx = dx * -1;
			leftScore++;
			dx = 0;
			dy = 0;
		}

		if (getY() >= bottomEdge - getRadius() - 10) // hits the bottom edge
		{
			setY(bottomEdge - getRadius() - 10);
			dy = dy * -1;
		}

		else if (getY() <= 10 + getRadius()) // hits top edge
		{
			setY(10 + getRadius());
			dy = dy * -1;
		}

		if (leftScore >= 10) {
			isWall = false;
			g.setColor(Color.WHITE);
			g.setFont(new Font("Comic Sans", Font.BOLD, 65));
			g.drawString("GAME OVER!", FRAME/2 - 200, 200);
			g.drawString("Right Wins", FRAME/2 - 100, FRAME/2);
			setDiameter(0);

		}
		if (rightScore >= 10) {
			isWall = false;
			g.setColor(Color.WHITE);
			g.setFont(new Font("Comic Sans", Font.BOLD, 65));
			g.drawString("GAME OVER!", FRAME/2 - 200, 200);
			g.drawString("Left Wins", FRAME/2 - 100, FRAME/2);
			setDiameter(0);
		}

	}

}