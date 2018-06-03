import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class PongPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final int FRAME = 1000;

	private BufferedImage myImage;
	private Ball ball;
	private Bumper leftBumper;
	private Bumper rightBumper;
	private boolean rightUp;
	private boolean rightDown;
	private boolean leftUp;
	private boolean leftDown;
	private boolean multiplayer = false;
	private boolean fake = false;

	private int delayLength = 10;

	public PongPanel() {
		getPanelGraphics();

		ball = new Ball();
		leftBumper = new Bumper(50, 400, 25, 400, Color.white);
		rightBumper = new Bumper(950, 400, 25, 400, Color.white);

		PongPanelGui ballGui = new PongPanelGui(this);
		Thread ballThread = new Thread(ballGui);
		ballThread.start();

		addKeyListener(new Key());
		addMouseListener(new Mouse());
		setFocusable(true);

	}// PongPanel

	private void drawBall() {
		Graphics graphics = getPanelGraphics();

		graphics.setColor(Color.WHITE);

		if (multiplayer == false && fake == false) {
			graphics.setFont(new Font("Sans Serif", Font.BOLD, 50));
			graphics.drawString("Choose Mode:", FRAME / 2 - 200, 100);
			graphics.drawString("Multiplayer", FRAME / 2 + 130, FRAME / 2);
			graphics.drawString("Single Player", 100, FRAME / 2);

		}
		graphics.setColor(Color.WHITE);
		if (multiplayer == true || fake == true) {
			ball.move(FRAME, FRAME, graphics);
			leftBumper.draw(graphics);
			rightBumper.draw(graphics);
			ball.draw(graphics);

		}

		BumperCollision.collide(leftBumper, ball);
		BumperCollision.collide(rightBumper, ball);

		if (fake == true) {
			if (ball.getY() < FRAME / 2) {
				leftBumper.setY((int) ball.getY());

			} else {

				leftBumper.setY(FRAME / 2);
			}
		}

		repaint();

	}// drawBall

	private class Mouse extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {
			if (multiplayer == true || fake == true) {

				ball.setdx(Math.random() * 12 - 6);
				ball.setdy(Math.random() * 12 - 6);
				ball.setX(e.getX());
				ball.setY(e.getY());
			}
			double Xcord = e.getX();
			if (multiplayer == false && fake == false) {
				if (Xcord >= 500) {
					multiplayer = true;

				} else {
					fake = true;

				}

			}

		}// mouseClicked

	}// Mouse

	private class Key extends KeyAdapter {
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				rightUp = true;
				rightDown = false;

			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				rightUp = false;
				rightDown = true;

			}
			if (rightUp)
				rightBumper.setY(rightBumper.getY() - 10);
			if (rightDown)
				rightBumper.setY(rightBumper.getY() + 10);

			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				ball.setdx(Math.random() * 12 - 6);
				ball.setdy(Math.random() * 12 - 6);
			}

			if (multiplayer == true) {

				if (e.getKeyCode() == KeyEvent.VK_W) {
					leftUp = true;
					leftDown = false;

				}

				if (e.getKeyCode() == KeyEvent.VK_S) {
					leftUp = false;
					leftDown = true;

				}
				if (leftUp)
					leftBumper.setY(leftBumper.getY() - 10);
				if (leftDown)
					leftBumper.setY(leftBumper.getY() + 10);

			}

			if (rightBumper.getY() < 0) {
				rightBumper.setY(0);
			}
			if (rightBumper.getY() > FRAME - 400) {
				rightBumper.setY(FRAME - 400);
			}
			if (leftBumper.getY() < 0) {
				leftBumper.setY(0);
			}
			if (leftBumper.getY() > FRAME - 400) {
				leftBumper.setY(FRAME - 400);
			}

		}// keyPressed

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				rightUp = false;
			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				rightDown = false;
			}

			if (e.getKeyCode() == KeyEvent.VK_W) {
				leftUp = false;
			}

			if (e.getKeyCode() == KeyEvent.VK_S) {
				leftDown = false;
			}

		}// keyReleased
	}// key

	public void paintComponent(Graphics g) {
		g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
	}// paintComponent

	private Graphics getPanelGraphics() {

		if (null == myImage) {
			myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
		}
		int w = FRAME;
		int h = FRAME;

		Graphics g = myImage.getGraphics();
		g.setColor(Color.BLACK);// blue

		g.fillRect(0, 0, w, h);
		return g;
	}// getPanelGraphics

	public void updateBall() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					drawBall();
					try {
						Thread.sleep(delayLength);
					} catch (InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// updateBall

}// PongPanel