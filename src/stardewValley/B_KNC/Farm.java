package stardewValley.B_KNC;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Farm extends JLabel {

	StardewValleyFrame mContext;
	
	public Vegetable[] vegetables;

	private int x = 130;
	private int y = 580;
	
	private final int PLANT_MAX = 9;
	
	private ImageIcon farm;
	
	private Player player;
	
	private int choice;
	
	private Guide guide;
	
	public Farm(StardewValleyFrame mContext, Player player) {
		this.mContext = mContext;
		this.player = player;
		initData();
		setInitLayout();
//		new Thread(new backgroundFarmService(player, this)).start();
	}
	
	private void initData() {
		
		choice = 0;
		
		farm = new ImageIcon("img/Farm.png");
		
		vegetables = new Vegetable[PLANT_MAX];
		
		guide = new Guide();
	}
	
	private void setInitLayout() {
		this.setIcon(farm);
		this.setLocation(x, y);
		this.setSize(300, 300);
		mContext.add(guide);
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
	
	static class Guide extends JLabel {
		private int x = 150;
		private int y = 450;
		
		private ImageIcon guide;
		private ImageIcon guideOn;
		
		public Guide() {
			guide = new ImageIcon("img/seller 복사.png");
			guideOn = new ImageIcon("img/sellerOn 복사.png");
			setIcon(guide);
			setLocation(x, y);
			setSize(100, 160);
		}
	}
}
