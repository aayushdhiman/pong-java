import javax.swing.JFrame;

public class PongDriver {
	public static void main(String[] args) {
		JFrame frame = new JFrame("PONG");
		frame.setSize(1000, 1000);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new PongPanel());
		frame.setVisible(true);
	}
}