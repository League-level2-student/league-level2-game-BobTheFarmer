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
	int gameStage = MENU;

	Graphics g;
	Font titleFont = new Font("Oxygen", Font.PLAIN, 48);
	Font subTitleFont = new Font("Oxygen", Font.PLAIN, 36);
	
	Player player = new Player(Game.WIDTH/2, Game.HEIGHT/2, 50, 50);
	
	void game() {
	//Background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
	//Draw Game
		player.draw(g);
	}
	void setup() {
		
	}

	public void paintComponent(Graphics g) {
		this.g = g;
		if (gameStage == GAME) {
			game();
		} else if (gameStage == MENU) {
			menu();
		} else if (gameStage == END){
			end();
		}
	}

	

	void menu() {
	//Background
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

	// Text
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("Game", 430, 200);

		g.setFont(subTitleFont);
		g.drawString("Enter to start", 380, 400);
		g.drawString("Space for Instructions", 305, 475);
	}

	void end() {
	// Background
		g.setColor(Color.RED);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

	// Text
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("Game Over", 360, 200);
		g.drawString("Score:", 370, 400);
		g.setFont(subTitleFont);
		g.drawString("Enter to go back to menu", 275, 475);
	}

	@Override public void keyPressed(KeyEvent e) {
	//Check for player movment
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right();
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left();
		} else if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up();
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down();
		}
	//Check For Menu Nav
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(gameStage == END) {
				gameStage = MENU;
			} else
				if(gameStage == MENU) {
				gameStage = GAME;
			}
			//TEMP
				else if(gameStage == GAME) {
				gameStage = END;
			}
		} else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			JOptionPane.showMessageDialog(null, "Instructions");
		}
	}
	
	@Override public void keyTyped(KeyEvent e) {}
	@Override public void keyReleased(KeyEvent e) {}
}
