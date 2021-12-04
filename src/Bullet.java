import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Bullet extends GameObject{

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	Bullet(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		if (needImage) {
		    loadImage("bone.png");
		}
	}
	int xMovment;
	int yMovment;
	int cooldown = 0;
	int cooldown2 = 0;
	boolean deadY = false;
	boolean deadX = false;
	
	void draw(Graphics g) {		
		super.update();
		
		
		//Draw+Apply forces
		
		
			
			if (gotImage) {
				g.drawImage(image, x, y, width, height, null);
			} else {
				g.setColor(Color.MAGENTA);
				g.fillOval(x, y, width, height);
			}
			if(!GamePanel.paused) {
			x+=xMovment;
			y+=yMovment;
			
			cooldown++;
			cooldown2++;
		//Gravity
			if(cooldown==20 && !deadY) {
				yMovment+=1;
				cooldown = 0;
			}

			
		//X slow
			if(!deadX && cooldown2>100) {
				//Slow
					if(xMovment>=1) {
						xMovment-=1;
					} 
					if(xMovment<=-1) {
						xMovment+=1;
					}
				if(xMovment == 0) {deadX=true;}
				cooldown2=0;
				}
			
		//Bounces
		//Check for upward bounce
			if(y>=Game.HEIGHT-55) {
				y=Game.HEIGHT-55;

			if(!deadY) {
				yMovment = 0-yMovment+1;
				
				//Check for deadY
					if(yMovment < 1 && yMovment >-1) {
						deadY=true;
						yMovment = 0;
					}
			}
			
	
			
			
		}
		//Upward
			if(y<0) {
				yMovment = 0-yMovment;
			}
		//Right/Left
			if(x<0) {
				xMovment = 0-xMovment;
			}
			if(x>Game.WIDTH) {
				xMovment = 0-xMovment;
			}
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
