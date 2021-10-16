import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends GameObject{
	int x;
	int y;
	int width;
	int height;
	
	Bullet(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	//WORKING ON THIS
	int xMovment;
	int yMovment;
	int cooldown = 0;
	void draw(Graphics g) {
		System.out.println("Draw");
		x+=xMovment;
		y+=yMovment;
		g.setColor(Color.CYAN);
		g.fillRect(x, y, width, height);
		if(cooldown==20) {
		yMovment+=1;
		cooldown = 0;
		}
		cooldown++;
		if(y>Game.HEIGHT-100) {
			y=Game.HEIGHT-100;
			yMovment = 10+(0-yMovment);
		}
}
}
