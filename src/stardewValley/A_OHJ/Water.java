package stardewValley.A_OHJ;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Water extends JLabel{

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
	
	public Water(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
	}
	
	private void initData() {
		
		x = 750;
		y = 560;
		
		water = new ImageIcon("img/waterMan.png");
		waterOn = new ImageIcon("img/waterManOn.png");
		
		parsnipEach = 0;
		carrotEach = 0;
		berryEach = 0;
		
	}
	
	private void setInitLayout() {
		this.setIcon(water);
		this.setLocation(x, y);
		this.setSize(100, 180);
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

	public ImageIcon getWaterOn() {
		return waterOn;
	}
	
	
	
}
