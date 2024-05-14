package stardewValley.B_KNC;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Farm extends JLabel {

	StardewValleyFrame mContext;
	
	public Vegetable[] vegetables;

	private int x;
	private int y;
	
	private final int PLANT_MAX = 9;
	
	private ImageIcon farm;
	
	private Player player;
	
	private int choice;
	
	public Farm(StardewValleyFrame mContext, Player player) {
		this.mContext = mContext;
		this.player = player;
		initData();
		setInitLayout();
	}
	
	private void initData() {
		x = 130;
		y = 580;
		
		choice = 0;
		
		farm = new ImageIcon("img/Farm.png");
		
		vegetables = new Vegetable[PLANT_MAX];
	}
	
	private void setInitLayout() {
		this.setIcon(farm);
		this.setLocation(x, y);
		this.setSize(300, 300);
	}
	
	public void plantOn(int plantNum) {
		vegetables[plantNum] = new Parsnip(player);
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
	
	
}
