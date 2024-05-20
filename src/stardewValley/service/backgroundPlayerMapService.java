package stardewValley.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import stardewValley.component.player.Player;
import stardewValley.frame.StardewValleyFrame;
import stardewValley.state.PlayerWay;

public class backgroundPlayerMapService implements Runnable {

	private Color redColor = new Color(255, 0, 0);
	private Color blueColor = new Color(0, 0, 255);

	private final int BLOCK = redColor.getRGB();
	private final int WATER = blueColor.getRGB();
	
	StardewValleyFrame mContext;

	private BufferedImage image;

	private Player player;

	public backgroundPlayerMapService(StardewValleyFrame mContext, Player player) {
		this.mContext = mContext;
		this.player = player;
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
			
			int storeX = Math.abs(player.getX() - mContext.store.getX());
			int storeY = Math.abs(player.getY() - mContext.store.getY());

			int keeperX = Math.abs(player.getX()+30 - mContext.keeper.getX());
			int keeperY = Math.abs(player.getY()-100 - mContext.keeper.getY());

			int waterX = Math.abs(player.getX()+45 - mContext.waterMan.getX()-50);
			int waterY = Math.abs(player.getY() - mContext.waterMan.getY()-50);
			
			int guideX = Math.abs(player.getX() - mContext.guide.getX());
			int guideY = Math.abs(player.getY() - mContext.guide.getY());
			
			int seedZoonX = Math.abs(player.getX()-40 - mContext.seedZone.getX());
			int seedZoonY = Math.abs(player.getY()-70 - mContext.seedZone.getY());

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
				
				// 3. NPC
			} else if (storeX < 80 && storeY < 170) {
				mContext.store.setIcon(mContext.store.getSellerOn());
				mContext.store.setSellOn(true);
			} else if (keeperX < 100 && keeperY < 60) {
				mContext.keeper.setIcon(mContext.keeper.getKeeperOn());
				mContext.keeper.setSaveOn(true);
			} else if (waterX < 100 && waterY < 100) {
				mContext.waterMan.setIcon(mContext.waterMan.getWaterOn());
				player.setScoopWater(true);
			} else if (guideX < 80 && guideY < 100) {
				mContext.guide.setIcon(mContext.guide.getGuideOn());
				player.setCreate(true);
				mContext.guide.setPlantOn(true);
			} else if (seedZoonX < 100 && seedZoonY < 50) {
				mContext.seedZone.setIcon(mContext.seedZone.getSeedZoneOn());
				mContext.seedZone.setSeedOn(true);
			}else {
				notWallCrash();
				seeNPC();
				mContext.choice = 0;
				mContext.guide.setGuideOn(mContext.guide.defalutGuide);
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
		if(mContext.store.isSeeNPC() == false) {
			mContext.store.setIcon(mContext.store.getSeller());
		}
		if(mContext.keeper.isSeeNPC() == false) {
			mContext.keeper.setIcon(mContext.keeper.getKeeper());
		}
		if(mContext.waterMan.isSeeNPC() == false) {
			mContext.waterMan.setIcon(mContext.waterMan.getWater());
		}
		if(mContext.guide.isSeeNPC() == false) {
			mContext.guide.setIcon(mContext.guide.getGuide());
		}
		if (mContext.seedZone.isSeeNpc() == false) {
			mContext.seedZone.setIcon(mContext.seedZone.getSeedZone());
		}
		player.setScoopWater(false);
		mContext.guide.setPlantOn(false);
		mContext.seedZone.setSeedOn(false);
	}
	
}
