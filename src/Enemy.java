import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Enemy extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	int movmentCooldown = 0;
	Enemy(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		if (needImage) {
		    loadImage("enemy.png");
		}
	}
	
	void draw(Graphics g, Player p) {  
		super.update();
		//Draw
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);
		}
			
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
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
}
