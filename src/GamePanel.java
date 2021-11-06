import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener, MouseListener {
//Variables
	static int MENU = 0;
	static int GAME = 1;
	static int END = 2;
	int gameStage = MENU;
	int numBullets = 10;

	Graphics g;
	Font titleFont = new Font("Oxygen", Font.PLAIN, 48);
	Font subTitleFont = new Font("Oxygen", Font.PLAIN, 36);
	
	Player player = new Player(Game.WIDTH/2, Game.HEIGHT/2, 50, 50);
	EnemySpawner enemySpawner = new EnemySpawner();

	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	void game() {
	//Background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	
	//Draw Game
		//numBullets
			g.setColor(Color.WHITE);
			g.setFont(subTitleFont);
			g.drawString("Bullets: " + numBullets, Game.WIDTH-220, 30);
		player.draw(g);
		
		//Loop other objects
			for (int i = 0; i < bullets.size(); i++) {
				bullets.get(i).draw(g);
			}
	//Manage Enemys
		enemySpawner.manageEnemys(player, g);
		
	checkCollison();
	purge();
	}
	
	
	private void purge() {
		//Bullets
			for (int i = 0; i < bullets.size(); i++) {
				if(!bullets.get(i).isActive) {
					bullets.remove(i);
					i--;
				}
			}

		//Enemys
			for (int i = 0; i < enemySpawner.enemys.size(); i++) {
				if(!enemySpawner.enemys.get(i).isActive) {
					enemySpawner.enemys.remove(i);
					i--;
				}
			}

	}
	void purgeAll() {
		//WORKING ON THIS; RESET GAME
	//Bullets
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).isActive = false;
		}
	//Enemys
		for (int i = 0; i < enemySpawner.enemys.size(); i++) {
			enemySpawner.enemys.get(i).isActive = false;
		}
	}

	void checkCollison() {
	//Bullets
		for (int i = 0; i < bullets.size(); i++) {
		//Make bullets be able to be picked up if dead x and y
			if(bullets.get(i).deadX && bullets.get(i).deadY && player.collisionBox.intersects(bullets.get(i).collisionBox)) {
				numBullets++;
				bullets.get(i).isActive = false;
				
			}
		//Enemys
			for (int j = 0; j < enemySpawner.enemys.size(); j++) {
				if(bullets.get(i).collisionBox.intersects(enemySpawner.enemys.get(j).collisionBox)) {
					enemySpawner.enemys.get(j).isActive = false;
				
				}
			}
		
		}
	//Player
		for (int j = 0; j < enemySpawner.enemys.size(); j++) {
			if(player.collisionBox.intersects(enemySpawner.enemys.get(j).collisionBox)) {
			gameStage = END;
			purgeAll();
			}
		}
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
	
	public void mouseClicked(MouseEvent e) {
	if(numBullets>0) {
	//Get direction to shoot, and send to new Bullet
		int xToPlayer =  e.getX() - player.getX();
		int yToPlayer =  e.getY() - player.getY();
		
	//Make the Bullet
		Bullet bullet = new Bullet(player.getX(), player.getY(), 10, 10);
		bullets.add(bullet);
		
	//Find direction to shoot and send
		bullet.xMovment = xToPlayer/30;
		bullet.yMovment = yToPlayer/30;
		
	numBullets--;
	}
	}
	
	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void keyTyped(KeyEvent e) {}
	@Override public void keyReleased(KeyEvent e) {}
}
