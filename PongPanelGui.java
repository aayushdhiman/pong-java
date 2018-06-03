public class PongPanelGui implements Runnable {
	PongPanel panel;
	
	public PongPanelGui(PongPanel aPanel)
	{
		panel = aPanel;
	//	while(true)
		
	}
	public void run() {
		while(true)
			panel.updateBall();
	}
	

}