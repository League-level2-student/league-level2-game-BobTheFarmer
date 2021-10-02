import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener {
//Variables
	static int MENU = 0;
	static int GAME = 1;
	static int END = 2;
	int gameStage = 0;

	Graphics g;
	Font titleFont = new Font("Oxygen", Font.PLAIN, 48);
	Font subTitleFont = new Font("Oxygen", Font.PLAIN, 36);

	void setup() {

	}

	public void paintComponent(Graphics g) {
		this.g = g;
		if (gameStage == GAME) {
			game();
		} else if (gameStage == MENU) {
			menu();
		} else {
			end();
		}
	}

	void game() {

	}

	void menu() {
		// Background
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

		// Text
		g.setColor(Color.RED);
		g.setFont(titleFont);
		g.drawString("Game", 400, 200);

		g.setFont(subTitleFont);
		g.drawString("Enter to start", 350, 400);
		g.drawString("Space for Instructions", 275, 475);
	}

	void end() {

	}

	@Override public void keyPressed(KeyEvent e) {
		//WORKING ON THIS METHOD; NOT WORKING
		System.out.println("Key Pressed");
	//Check For Menu Nav
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(gameStage == END) {
				gameStage = MENU;
			} else if(gameStage == MENU) {
				gameStage = GAME;
			}
			//TEMP
			if(gameStage == GAME) {
				gameStage = END;
			}
		} else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			JOptionPane.showMessageDialog(null, "Instructions");
		}
	}

	@Override public void keyTyped(KeyEvent e) {}
	@Override public void keyReleased(KeyEvent e) {}
}
