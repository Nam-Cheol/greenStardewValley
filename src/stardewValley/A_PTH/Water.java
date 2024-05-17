package stardewValley.A_PTH;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
	
	public JLabel waterGauge;
	
	private ImageIcon waterGaugeMax;
	private ImageIcon waterGauge4;
	private ImageIcon waterGauge3;
	private ImageIcon waterGauge2;
	private ImageIcon waterGauge1;
	private ImageIcon waterGaugeEmpty;
	
	private boolean seeNPC;
	
	private long pondGage;

	public Water(StardewValleyFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		
	}

	private void initData() {

		x = 750;
		y = 560;

		water = new ImageIcon("img/npc/waterMan.png");
		waterOn = new ImageIcon("img/npc/waterManOn.png");
		
		waterGauge = new JLabel();
		
		waterGaugeEmpty = new ImageIcon("img/vege/Water_gauge_0.png");
		waterGauge1 = new ImageIcon("img/vege/Water_gauge_1.png");
		waterGauge2 = new ImageIcon("img/vege/Water_gauge_2.png");
		waterGauge3 = new ImageIcon("img/vege/Water_gauge_3.png");
		waterGauge4 = new ImageIcon("img/vege/Water_gauge_4.png");
		waterGaugeMax = new ImageIcon("img/vege/Water_gauge_5.png");
		
		
		
		parsnipEach = 0;
		carrotEach = 0;
		berryEach = 0;
		
		seeNPC = false;
		
		pondGage = 50_000L;

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

	public void decreaseWaterImage() {
		if(pondGage >= 50_000) {
			waterGauge.setIcon(waterGaugeMax);
		} else if (pondGage >= 40_000 && pondGage < 50_000) {
			waterGauge.setIcon(waterGauge4);
		} else if (pondGage >= 30_000 && pondGage < 40_000) {
			waterGauge.setIcon(waterGauge3);
		} else if (pondGage >= 20_000 && pondGage < 30_000) {
			waterGauge.setIcon(waterGauge2);
		} else if (pondGage > 0  && pondGage < 20_000) {
			waterGauge.setIcon(waterGauge1);
		} else if (pondGage == 0) {
			waterGauge.setIcon(waterGaugeEmpty);
		}
		
	}
	public void removeWaterImg() {
		setWaterGaugeEmpty(null);
		setWaterGauge1(null);
		setWaterGauge2(null);
		setWaterGauge3(null);
		setWaterGauge4(null);
		setWaterGaugeMax(null);
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

	public boolean isSeeNPC() {
		return seeNPC;
	}

	public void setSeeNPC(boolean seeNPC) {
		this.seeNPC = seeNPC;
	}

	public ImageIcon getWaterOn() {
		return waterOn;
	}

	public void setWaterOn(ImageIcon waterOn) {
		this.waterOn = waterOn;
	}

	public long getPondGage() {
		return pondGage;
	}

	public void setPondGage(long pondGage) {
		this.pondGage = pondGage;
	}

	public void setWater(ImageIcon water) {
		this.water = water;
	}
	
	public ImageIcon getWaterGaugeMax() {
		return waterGaugeMax;
	}

	public void setWaterGaugeMax(ImageIcon waterGaugeMax) {
		this.waterGaugeMax = waterGaugeMax;
	}

	public ImageIcon getWaterGauge4() {
		return waterGauge4;
	}

	public void setWaterGauge4(ImageIcon waterGauge4) {
		this.waterGauge4 = waterGauge4;
	}

	public ImageIcon getWaterGauge3() {
		return waterGauge3;
	}

	public void setWaterGauge3(ImageIcon waterGauge3) {
		this.waterGauge3 = waterGauge3;
	}

	public ImageIcon getWaterGauge2() {
		return waterGauge2;
	}

	public void setWaterGauge2(ImageIcon waterGauge2) {
		this.waterGauge2 = waterGauge2;
	}

	public ImageIcon getWaterGauge1() {
		return waterGauge1;
	}

	public void setWaterGauge1(ImageIcon waterGauge1) {
		this.waterGauge1 = waterGauge1;
	}

	public ImageIcon getWaterGaugeEmpty() {
		return waterGaugeEmpty;
	}

	public void setWaterGaugeEmpty(ImageIcon waterGaugeEmpty) {
		this.waterGaugeEmpty = waterGaugeEmpty;
	}

	public void minusPondGage() {
		if(pondGage < 0 ) {
			return;
		}
		if(pondGage != 0) {
			pondGage -= 100;
		}
	}
	
	
}
