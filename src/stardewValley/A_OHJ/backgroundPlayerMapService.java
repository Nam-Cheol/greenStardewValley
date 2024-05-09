package stardewValley.A_OHJ;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class backgroundPlayerMapService implements Runnable {
	private Color redColor   = new Color(255, 0, 0);
	private Color greenColor = new Color(0, 255, 0);
	private Color blueColor = new Color(0, 0, 255);
	
	private final int BLOCK = redColor.getRGB();
	private final int FARM = greenColor.getRGB(); 
	private final int WATER = blueColor.getRGB();

	private BufferedImage image;
	private Player player;
	private Parsnip parsnip;

	public backgroundPlayerMapService(Player player) {
		this.player = player;

		try {
			image = ImageIO.read(new File("img/StardewValleyMapColorFrame3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		while (true) {
			// Player Color Observe
			Color upColor = new Color(image.getRGB(player.getX() + 50, player.getY() - 10));
			Color downColor = new Color(image.getRGB(player.getX() + 50, player.getY() + 170));
			Color leftColor = new Color(image.getRGB(player.getX() - 15, player.getY() + 50));
			Color rightColor = new Color(image.getRGB(player.getX() + 115, player.getY() + 70));
			
			int up = upColor.getRGB();
			int down = downColor.getRGB();
			int left = leftColor.getRGB();
			int right = rightColor.getRGB();
			

			// Player Wall Crash
			
			
			// 1. BLOCK
			if (up == BLOCK) {
				stopUp();
			} else if (down == BLOCK) {
				stopDown();
			} else if (left == BLOCK) {
				stopLeft();
			} else if (right == BLOCK) {
				stopRight();
				
				
				
			// 2. WATER	
			} else if (up == WATER) {
				stopUp();
			} else if (down == WATER) {
				stopDown();
			} else if (left == WATER) {
				stopLeft();				
			} else if (right == WATER) {
				stopRight();				
				
			// 3. FARM
			} else if (up == FARM) {
				stopUp();
			} else if (down == FARM){
				stopDown();
				player.setCreate(true);
			} else if (left == FARM) {
				stopLeft();
			} else if (right == FARM) {
				stopRight();
			} else {
				notWallCrash();
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}

			player.setCreate(false);
		}

	}
	
	public void stopUp() {
		player.setUpWallCrash(true);
		player.setUp(false);
	}
	
	public void stopDown() {
		player.setDownWallCrash(true);
		player.setDown(false);
	}
	
	public void stopLeft() {
		player.setLeftWallCrash(true);
		player.setLeft(false);
	}
	
	public void stopRight() {
		player.setRightWallCrash(true);
		player.setRight(false);
	}
	
	public void notWallCrash() {
		player.setUpWallCrash(false);
		player.setDownWallCrash(false);
		player.setLeftWallCrash(false);
		player.setRightWallCrash(false);
	}

}
