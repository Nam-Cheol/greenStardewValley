package stardewValley.A_CYJ;

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

	
	
	
	public Color getGreenColor() {
		return greenColor;
	}

	public void setGreenColor(Color greenColor) {
		this.greenColor = greenColor;
	}

	public backgroundPlayerMapService(Player player) {
		this.player = player;

		try {
			image = ImageIO.read(new File("img/StardewValleyMapColorFrame2.png"));
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
			

			// Player Wall Crash
			
			
			// 1. BLOCK
			if (upColor.getRGB() == BLOCK) {
				player.setUpWallCrash(true);
				player.setUp(false);

			} else if (downColor.getRGB() == BLOCK) {
				player.setDownWallCrash(true);
				player.setDown(false);

			} else if (leftColor.getRGB() == BLOCK) {
				player.setLeftWallCrash(true);
				player.setLeft(false);

			} else if (rightColor.getRGB() == BLOCK) {
				player.setRightWallCrash(true);
				player.setRight(false);
				
			

				
				// 2. WATER	
			} else if (upColor.getRGB() == WATER) {
				player.setUpWallCrash(true);
				player.setUp(false);
				
			} else if (downColor.getRed() == WATER) {
				player.setDownWallCrash(true);
				player.setDown(false);
				
			} else if (leftColor.getRed() == WATER) {
				player.setLeftWallCrash(true);
				player.setLeft(false);
				
			} else if (rightColor.getRed() == WATER) {
				player.setRightWallCrash(true);
				player.setRight(false);
				
			} else {
				player.setUpWallCrash(false);
				player.setDownWallCrash(false);
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}
				
				
			// 3. FARM
//			} else if (upColor.getRGB() == FARM) {
//				parsnip.setUpCreate(true);
//				parsnip.grow();
//				
//			} else if (downColor.getRGB() == FARM){
//				parsnip.setDownCreate(true);
//				parsnip.grow();
//				
//			} else if (leftColor.getRGB() == FARM) {
//				parsnip.setLeftCreate(true);
//				parsnip.grow();
//				
//			} else if (rightColor.getRGB() == FARM) {
//				parsnip.setRightCreate(true);
//				parsnip.grow();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
