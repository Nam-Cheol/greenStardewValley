package stardewValley.A_KNC;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class backgroundPlayerMapService implements Runnable {

	private BufferedImage image;
	private Player player;

	// 플레이어 상하좌우 색상 인식
	private Color upColor = new Color(image.getRGB(player.getX() + 50, player.getY() - 10));
	private Color downColor = new Color(image.getRGB(player.getX() + 50, player.getY() + 170));
	private Color leftColor = new Color(image.getRGB(player.getX() - 15, player.getY() + 50));
	private Color rightColor = new Color(image.getRGB(player.getX() + 115, player.getY() + 70));
	
	// 필요한 색상
	private Color redColor = new Color(255,0,0);
	
	public backgroundPlayerMapService(Player player) {
		this.player = player;

		try {
			image = ImageIO.read(new File("img/StardewValleyMapColorFrame1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		while (true) {
			// Player Color Observe
			
			
			Color redColor = new Color(255,0,0);
			
			int red = redColor.getRGB();
			int up = upColor.getRGB();

			System.out.println(redColor);
			
			// Player Wall Crash

			if (up == red) {
				player.setUpWallCrash(true);
				player.setUp(false);

			} else if (downColor.getRed() == 255 && downColor.getGreen() == 0 && downColor.getBlue() == 0) {
				player.setDownWallCrash(true);
				player.setDown(false);

			} else if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				player.setLeftWallCrash(true);
				player.setLeft(false);

			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				player.setRightWallCrash(true);
				player.setRight(false);

			} else if (upColor.getRed() == 0 && upColor.getGreen() == 0 && upColor.getBlue() == 255) {
				player.setUpWallCrash(true);
				player.setUp(false);
				
			} else if (downColor.getRed() == 0 && downColor.getGreen() == 0 && downColor.getBlue() == 255) {
				player.setDownWallCrash(true);
				player.setDown(false);
				
			} else if (leftColor.getRed() == 0 && leftColor.getGreen() == 0 && leftColor.getBlue() == 255) {
				player.setLeftWallCrash(true);
				player.setLeft(false);
				
			} else if (rightColor.getRed() == 0 && rightColor.getGreen() == 0 && rightColor.getBlue() == 255) {
				player.setRightWallCrash(true);
				player.setRight(false);
				
			} else {
				player.setUpWallCrash(false);
				player.setDownWallCrash(false);
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
