package stardewValley.B_KNC.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import stardewValley.B_KNC.component.npc.Guide;
import stardewValley.B_KNC.component.npc.Keeper;
import stardewValley.B_KNC.component.npc.SeedZone;
import stardewValley.B_KNC.component.npc.Store;
import stardewValley.B_KNC.component.npc.Water;
import stardewValley.B_KNC.component.player.Player;
import stardewValley.B_KNC.state.PlayerWay;

public class backgroundPlayerMapService implements Runnable {

	private Color redColor = new Color(255, 0, 0);
	private Color blueColor = new Color(0, 0, 255);

	private final int BLOCK = redColor.getRGB();
	private final int WATER = blueColor.getRGB();

	private BufferedImage image;

	private Player player;
	private Store store;
	private Keeper keeper;
	private Water water;
	private Guide guide;
	private SeedZone seedZone;

	public backgroundPlayerMapService(Player player, Store store, Keeper keeper, Water water, Guide guide, SeedZone seedZone) {
		this.player = player;
		this.store = store;
		this.keeper = keeper;
		this.water = water;
		this.guide = guide;
		this.seedZone = seedZone;
		try {
			image = ImageIO.read(new File("img/bg/StardewValleyMapColorFrame3.png"));
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

			int gapY = 100;
			int gapX = 50;
			
			int storeX = Math.abs(player.getX() - store.getX());
			int storeY = Math.abs(player.getY() - store.getY());

			int keeperX = Math.abs(player.getX()+30 - keeper.getX());
			int keeperY = Math.abs(player.getY()-100 - keeper.getY());

			int waterX = Math.abs(player.getX() - water.getX()-50);
			int waterY = Math.abs(player.getY() - water.getY()-50);
			
			int guideX = Math.abs(player.getX() - guide.getX());
			int guideY = Math.abs(player.getY() - guide.getY());
			
			int seedZoonX = Math.abs(player.getX()-40 - seedZone.getX());
			int seedZoonY = Math.abs(player.getY()-70 - seedZone.getY());

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
				
				// 3. NPC
			} else if (storeX < 80 && storeY < 170) {
				store.setIcon(store.getSellerOn());
				store.setSellOn(true);
			} else if (keeperX < 100 && keeperY < 60) {
				keeper.setIcon(keeper.getKeeperOn());
				keeper.setSaveOn(true);
			} else if (waterX < 100 && waterY < 100) {
				water.setIcon(water.getWaterOn());
				player.setScoopWater(true);
			} else if (guideX < 80 && guideY < 100) {
				guide.setIcon(guide.getGuideOn());
				player.setCreate(true);
				guide.setPlantOn(true);
			} else if (seedZoonX < 100 && seedZoonY < 50) {
				seedZone.setIcon(seedZone.getSeedZoneOn());
				seedZone.setSeedOn(true);
			}else {
				notWallCrash();
				player.setSellParsnip(false);
				seeNPC();
			}

			try {
				Thread.sleep(1);
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
		if (player.playerWay == PlayerWay.UP) {
			player.setUp(false);
		} else if (player.playerWay == PlayerWay.DOWN) {
			player.setDown(false);
		} else if (player.playerWay == PlayerWay.LEFT) {
			player.setLeft(false);
		} else if (player.playerWay == PlayerWay.RIGHT) {
			player.setRight(false);
		}
	}

	public void seeNPC() {
		if(store.isSeeNPC() == false) {
			store.setIcon(store.getSeller());
		}
		if(keeper.isSeeNPC() == false) {
			keeper.setIcon(keeper.getKeeper());
		}
		if(water.isSeeNPC() == false) {
			water.setIcon(water.getWater());
		}
		if(guide.isSeeNPC() == false) {
			guide.setIcon(guide.getGuide());
		}
		if (seedZone.isSeeNpc() == false) {
			seedZone.setIcon(seedZone.getSeedZone());
		}
		player.setScoopWater(false);
		guide.setPlantOn(false);
	}
	
}
