import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player extends GameObject{


	int speed = 10;
	
	
	public static BufferedImage image;
	public static BufferedImage greyImage;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		if (needImage) {
		    loadImage ("cannon200.png", "cannon200 copy.png");
		}
	}
		void draw(Graphics g, int bullets) {
			super.update();
			if (gotImage) {
				if(bullets>0) {
					g.drawImage(image, x, y, width, height, null);
				} else {
					g.drawImage(greyImage, x, y, width, height, null);
				}
			} else { 
				if(bullets>0) {
					g.setColor(Color.BLUE);
				} else {
					g.setColor(Color.GRAY);
				}
				g.fillRect(x, y, width, height);
			}
			//Out of bullets
			
				
			//Check if out
				if(super.y>Game.HEIGHT-90) {
					super.y=Game.HEIGHT-90;
				} else if(y<0) {
					y=0;
				} else if(super.x>Game.WIDTH-50) {
					super.x=Game.WIDTH-50;
				} else if(x<0) {
					x=0;
				}
		
			
		}
	/*void drawOutOfBullets(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(x, y, width, height);
	}*/
//Movment
	void up() {
		y-=speed;
	}
	void down() {
		y+=speed;
	}
	void left() {
		x-=speed;
	}
	void right() {
		x+=speed;
	}
	
	int getX() {
		return x;
	}
	int getY() {
		return y;
	}
	
	
	
	void loadImage(String imageFile, String greyImageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	            greyImage = ImageIO.read(this.getClass().getResourceAsStream(greyImageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}
