package stardewValley.A_CYJ;

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

	private boolean seeNPC;

	// 우물에 물 전체 양
	private long pondGage;

	public Water(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
	}

	private void initData() {

		x = 750;
		y = 500;

		water = new ImageIcon("img/npc/waterMan.png");
		waterOn = new ImageIcon("img/npc/waterManOn.png");

		parsnipEach = 0;
		carrotEach = 0;
		berryEach = 0;

		seeNPC = false;
		// todo 테스트로 총량 줄여놓음
		pondGage = 99L;
	}

	private void setInitLayout() {
		this.setIcon(water);
		this.setLocation(x, y);
		this.setSize(130, 200);
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
	public long getPondGage() {
		if(pondGage < 0) {
			return pondGage;			
		}
		return 0;
	}

	public void setPondGage(long pondGage) {
		this.pondGage = pondGage;
	}

	// TODO - 수정 필요, 연못에 물이 자동적으로 줄어들도록
	public void minusPondGage() {
		while (getPondGage() != 0) {
			setPondGage(getPondGage() - 100);
		}
	}

}
