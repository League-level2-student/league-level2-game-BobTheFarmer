import java.awt.Graphics;

public class Enemy extends GameObject{

	int x;
	int y; 
	int width;
	int height;
	Enemy(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	void draw(Graphics g, Player p) {  
		//Draw
			g.fillRect(x, y, width, height);
			
		//Move toward player
			//X
				if(p.x<x-10) {
					x+=3;
				}
				if(p.x>x+10) {
					x-=3;
				}
	}
	
}
