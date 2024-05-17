package stardewValley.A_CYJ.component.npc;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.A_CYJ.frame.StardewValleyFrame;



public class Keeper extends JLabel{

	StardewValleyFrame mContext;
	
	private int x;
	private int y;
	
	private int parsnipPrice;
	private int carrotPrice;
	private int berryPrice;
	
	private int parsnipEach;
	private int carrotEach;
	private int berryEach;
	
	private ImageIcon keeper;
	private ImageIcon keeperOn;
	
	private boolean saveOn;
	private boolean seeNPC;
	
	public Keeper(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
	}
	
	private void initData() {
		
		x = 450;
		y = 130;
		
		keeper = new ImageIcon("img/npc/keeper.png");
		keeperOn = new ImageIcon("img/npc/keeperOn.png");
		
		parsnipEach = 0;
		carrotEach = 0;
		berryEach = 0;
		
		seeNPC = false;
		saveOn = false;
	}
	
	private void setInitLayout() {
		this.setIcon(keeper);
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

	public ImageIcon getKeeper() {
		return keeper;
	}

	public ImageIcon getKeeperOn() {
		return keeperOn;
	}

	public boolean isSeeNPC() {
		return seeNPC;
	}

	public void setSeeNPC(boolean seeNPC) {
		this.seeNPC = seeNPC;
	}

	public boolean isSaveOn() {
		return saveOn;
	}

	public void setSaveOn(boolean saveOn) {
		this.saveOn = saveOn;
	}
	
	
	
}
