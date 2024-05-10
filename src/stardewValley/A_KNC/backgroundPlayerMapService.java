package stardewValley.A_KNC;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class backgroundPlayerMapService implements Runnable {

	private Color redColor = new Color(255, 0, 0);
	private Color greenColor = new Color(0, 255, 0);
	private Color blueColor = new Color(0, 0, 255);

	private final int BLOCK = redColor.getRGB();
	private final int FARM = greenColor.getRGB();
	private final int WATER = blueColor.getRGB();

	private BufferedImage image;

	private Player player;
	private Store store;
	private Keeper keeper;
	private Water water;

	public backgroundPlayerMapService(Player player, Store store, Keeper keeper, Water water) {
		this.player = player;
		this.store = store;
		this.keeper = keeper;
		this.water = water;
		try {
			image = ImageIO.read(new File("img/StardewValleyMapColorFrame3.png"));
		} catch (IOException e) {
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

			int gap = 100;

			int storeX = Math.abs(player.getX() - store.getX());
			int storeY = Math.abs(player.getY() - store.getY());

			int keeperX = Math.abs(player.getX() - keeper.getX());
			int keeperY = Math.abs(player.getY() - keeper.getY());

			int waterX = Math.abs(player.getX() - water.getX());
			int waterY = Math.abs(player.getY() - water.getY());

			// 1. BLOCK

			if (up == BLOCK) {
				stopUp();
			} else if (down == BLOCK) {
				stopDown();
			} else if (left == BLOCK) {
				System.out.println("나야 나");
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
			} else if (down == FARM) {
				stopDown();
				player.setCreate(true);
			} else if (left == FARM) {
				stopLeft();
			} else if (right == FARM) {
				stopRight();

				// 4. NPC
			} else if (storeX < gap && storeY < gap) {
//				System.out.println("멈춰~~~~~~~!");
				player.setSellParsnip(true);
				store.setIcon(store.getSellerOn());
//				System.out.println(player.isSellParsnip());
			} else if (keeperX < gap && keeperY < gap) {
//				System.out.println("멈춰~~~~~~~!");
				keeper.setIcon(keeper.getKeeperOn());
			} else if (waterX < gap && waterY < gap) {
//				System.out.println("멈춰~~~~~~~!");
				water.setIcon(water.getWaterOn());
			} else {
				notWallCrash();
				player.setSellParsnip(false);
				store.setIcon(store.getSeller());
				keeper.setIcon(keeper.getKeeper());
				water.setIcon(water.getWater());
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}

			player.setCreate(false);
		}

	}

	public void stopUp() {
		if (player.playerWay == PlayerWay.UP) {
			player.setUpWallCrash(true);
			player.setUp(false);
		}
	}

	public void stopDown() {
		if (player.playerWay == PlayerWay.DOWN) {
			player.setDownWallCrash(true);
			player.setDown(false);
		}
	}

	public void stopLeft() {
		if (player.playerWay == PlayerWay.LEFT) {
			player.setLeftWallCrash(true);
			player.setLeft(false);
		}
	}

	public void stopRight() {
		if (player.playerWay == PlayerWay.RIGHT) {
			player.setRightWallCrash(true);
			player.setRight(false);
		}
	}

	public void notWallCrash() {
		player.setUpWallCrash(false);
		player.setDownWallCrash(false);
		player.setLeftWallCrash(false);
		player.setRightWallCrash(false);
	}

	public void stopMove() {

		if (player.isUp()) {
			player.setUp(false);
		} else if (player.isDown()) {
			player.setDown(false);
		} else if (player.isLeft()) {
			player.setLeft(false);
		} else if (player.isRight()) {
			player.setRight(false);
		}
	}

}
