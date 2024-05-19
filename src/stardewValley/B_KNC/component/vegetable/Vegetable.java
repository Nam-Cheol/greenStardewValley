package stardewValley.B_KNC.component.vegetable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.B_KNC.component.npc.Farm;
import stardewValley.B_KNC.component.player.Player;
import stardewValley.B_KNC.frame.StardewValleyFrame;

public abstract class Vegetable extends JLabel {

	// 포함관계 - 프레임, 플레이어
	StardewValleyFrame mContext;
	protected Player player;
	protected Farm farm;
	// 성장
	protected boolean growing;
	protected ImageIcon growing1;
	protected ImageIcon growing2;
	protected ImageIcon growing3;
	protected ImageIcon growing4;
	protected ImageIcon growing5;
	protected ImageIcon lastGrowing;
	public ImageIcon rotten = new ImageIcon("img/vege/Rotten_Plant.png");
	// 물
	protected int waterGauge;
	// 수확
	protected boolean canHarvest;

	protected static int MAX_PLANT = 30;
	protected static int seed = 30;

	public abstract void initData();

	public abstract void setInitLayout();

	public abstract void grow();

	public boolean isCanHarvest() {
		return canHarvest;
	}

	public int getWaterGage() {
		return waterGauge;
	}

	public void setWaterGage(int waterGage) {
		this.waterGauge = waterGage;
	}

	public static int getSeed() {
		return seed;
	}

	public static void setSeed(int seed) {
		Vegetable.seed = seed;
	}

	public static int getMAX_PLANT() {
		return MAX_PLANT;
	}

}
