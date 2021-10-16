import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game implements ActionListener {
	//Variables
		public static int WIDTH	= 1000;
		public static int HEIGHT= 1000;
		
		JFrame frame;
		JPanel panel;
		
		GamePanel gamePanel;
	
	
	public void run() {
	//Objects setup
			gamePanel = new GamePanel();
			gamePanel.setup();
	//Window setup
		frame = new JFrame("Game");
		panel = new JPanel();
		frame.add(gamePanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(gamePanel);
		frame.addMouseListener(gamePanel);
		
	//Setup game timer
		Timer timer = new Timer(60/1000, this);
		timer.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gamePanel.repaint();
	}
	
	

}