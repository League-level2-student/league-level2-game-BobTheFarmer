import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class EnemySpawner implements ActionListener {
	
	ArrayList<Enemy> enemys = new ArrayList<Enemy>();
	Timer t;
	Random rando = new Random();
	int spawnX;
	int spawnY;
	int speed = 1000;
	
	EnemySpawner() {
		t = new Timer(1000, this);
		t.start();
	}
	
	void manageEnemys(Player player, Graphics g) {
	//MANAGE ENEMYS
		for (int i = 0; i < enemys.size(); i++) {
			enemys.get(i).draw(g, player);
		}
	}
	
	void updateTimer(int score) {
	//Change timer speed to match score
		speed = 1000-(score*20);
		if(speed<200) {
			speed = 100;
		}
		t.setDelay(speed);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	//MAKE ENEMYS	
		//Choose a edge to spawn on
			int randomNum = rando.nextInt(3);
			if(randomNum == 0) {
				spawnX = Game.WIDTH;
				spawnY = rando.nextInt(Game.HEIGHT);
			} else if(randomNum == 1) {
				spawnX = 0;
				spawnY = rando.nextInt(Game.HEIGHT);
			} else if(randomNum == 2) {
				spawnY = 0;
				spawnX = rando.nextInt(Game.WIDTH);
			} 
			
			
		//Make enemy
			Enemy enemy = new Enemy(spawnX, spawnY, 20, 20);
			enemys.add(enemy);
	}
	
	
	
	
	
	
	
	
	
}
