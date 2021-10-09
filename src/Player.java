import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player extends GameObject{


	int speed = 10;
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		if (needImage) {
		    loadImage ("cannon200.png");
		}
	}
		void draw(Graphics g) {
			if (gotImage) {
				g.drawImage(image, x, y, width, height, null);
			} else {
				g.setColor(Color.BLUE);
				g.fillRect(x, y, width, height);
			}
		}
	
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
