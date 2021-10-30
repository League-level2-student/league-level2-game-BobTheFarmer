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
	
	@Override
	public void actionPerformed(ActionEvent e) {

	//MAKE ENEMYS
		//Choose a edge to spawn on
			if(rando.nextInt(3) == 0) {
				spawnX = Game.WIDTH;
				spawnY = rando.nextInt(Game.HEIGHT);
			} else if(rando.nextInt(3) == 1) {
				spawnX = 0;
				spawnY = rando.nextInt(Game.HEIGHT);
			} else if(rando.nextInt(3) == 2) {
				spawnY = Game.HEIGHT;
				spawnX = rando.nextInt(Game.WIDTH);
			} else if(rando.nextInt(3) == 3) {
				spawnY = 0;
				spawnX = rando.nextInt(Game.WIDTH);
			} 
			
			
		//Make enemy
			Enemy enemy = new Enemy(spawnX, spawnY, 20, 20);
			enemys.add(enemy);
	}
	
	
	
	
	
	
	
	
	
}
