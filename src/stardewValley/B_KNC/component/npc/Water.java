package stardewValley.B_KNC.component.npc;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.B_KNC.frame.StardewValleyFrame;

public class Water extends JLabel {

	StardewValleyFrame mContext;

	private int x;
	private int y;

	private int parsnipPrice;
	private int carrotPrice;
	private int berryPrice;

	private int parsnipEach;
	private int carrotEach;
	private int berryEach;

	private ImageIcon water;
	private ImageIcon waterOn;

	private boolean seeNPC;
	
	public JLabel waterGauge;
	private ImageIcon waterGaugeMax;
	private ImageIcon waterGauge4;
	private ImageIcon waterGauge3;
	private ImageIcon waterGauge2;
	private ImageIcon waterGauge1;
	private ImageIcon waterGaugeEmpty;

	// 우물에 물 전체 양
	private int pondGage = 80_000;

	public Water(StardewValleyFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	private void initData() {

		x = 750;
		y = 500;

		water = new ImageIcon("img/npc/waterMan.png");
		waterOn = new ImageIcon("img/npc/waterManOn.png");
		
		waterGauge = new JLabel();
		waterGaugeEmpty = new ImageIcon("img/vege/Water_gauge_0.png");
		waterGauge1 = new ImageIcon("img/vege/Water_gauge_1.png");
		waterGauge2 = new ImageIcon("img/vege/Water_gauge_2.png");
		waterGauge3 = new ImageIcon("img/vege/Water_gauge_3.png");
		waterGauge4 = new ImageIcon("img/vege/Water_gauge_4.png");
		waterGaugeMax = new ImageIcon("img/vege/Water_gauge_5.png");

		seeNPC = false;
		
	}

	private void setInitLayout() {
		this.setIcon(water);
		this.setLocation(x, y);
		this.setSize(130, 200);
		
		mContext.add(waterGauge);
		waterGauge.setLocation(925, 660);
		waterGauge.setSize(200, 100);
		waterGauge.setIcon(waterGaugeMax);
	}

	public StardewValleyFrame getmContext() {
		return mContext;
	}

	// getter, setter

	public void setmContext(StardewValleyFrame mContext) {
		this.mContext = mContext;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getParsnipPrice() {
		return parsnipPrice;
	}

	public void setParsnipPrice(int parsnipPrice) {
		this.parsnipPrice = parsnipPrice;
	}

	public int getCarrotPrice() {
		return carrotPrice;
	}

	public void setCarrotPrice(int carrotPrice) {
		this.carrotPrice = carrotPrice;
	}

	public int getBerryPrice() {
		return berryPrice;
	}

	public void setBerryPrice(int berryPrice) {
		this.berryPrice = berryPrice;
	}

	public int getParsnipEach() {
		return parsnipEach;
	}

	public void setParsnipEach(int parsnipEach) {
		this.parsnipEach = parsnipEach;
	}

	public int getCarrotEach() {
		return carrotEach;
	}

	public void setCarrotEach(int carrotEach) {
		this.carrotEach = carrotEach;
	}

	public int getBerryEach() {
		return berryEach;
	}

	public void setBerryEach(int berryEach) {
		this.berryEach = berryEach;
	}

	public ImageIcon getWater() {
		return water;
	}

	public void setWater(ImageIcon water) {
		this.water = water;
	}

	public ImageIcon getWaterOn() {
		return waterOn;
	}

	public boolean isSeeNPC() {
		return seeNPC;
	}

	public void setSeeNPC(boolean seeNPC) {
		this.seeNPC = seeNPC;
	}

	// 시도
	public int getPondGage() {
		return pondGage;
	}

	public void setPondGage(int pondGage) {
		this.pondGage = pondGage;
	}

	public void minusPondGage() {
		if(pondGage < 0 ) {
			return;
		}
		if(pondGage != 0) {
			pondGage -= 1000;
		}
	}
	
	public void decreaseWaterImage() {
		if(pondGage >= 80_000) {
			waterGauge.setIcon(waterGaugeMax);
		} else if (pondGage >= 60_000 && pondGage < 80_000) {
			waterGauge.setIcon(waterGauge4);
		} else if (pondGage >= 40_000 && pondGage < 60_000) {
			waterGauge.setIcon(waterGauge3);
		} else if (pondGage >= 20_000 && pondGage < 40_000) {
			waterGauge.setIcon(waterGauge2);
		} else if (pondGage > 0  && pondGage < 20_000) {
			waterGauge.setIcon(waterGauge1);
		} else if (pondGage <= 0) {
			waterGauge.setIcon(waterGaugeEmpty);
		}
		
	}
	
	public void removeWaterGage() {
		waterGauge.setIcon(null);
	
}

}
