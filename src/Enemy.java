import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GameObject{

	int x;
	int y; 
	int width;
	int height;
	int movmentCooldown = 0;
	Enemy(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	void draw(Graphics g, Player p) {  
		super.update();
		//Draw
			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);
			
		//Move toward player
			movmentCooldown++;
			if(movmentCooldown == 10) {
			//X
				if(p.x<x-10) {
					x-=1;
				}
				if(p.x>x+10) {
					x+=1;
				}
			//Y
				if(p.y<y-10) {
					y-=1;
				}
				if(p.y>y+10) {
					y+=1;
				}
				movmentCooldown = 0;
			}
	}
	
}
