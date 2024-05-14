package stardewValley.B_KNC;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Farm extends JLabel {

	StardewValleyFrame mContext;

	private int x;
	private int y;
	
	private ImageIcon farm;
	
	public Farm(StardewValleyFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}
	
	private void initData() {
		x = 200;
		y = 500;
		
		farm = new ImageIcon("img/Farm.png");
	}
	
	private void setInitLayout() {
		this.setIcon(farm);
		this.setLocation(x, y);
		this.setSize(300, 300);
	}
}
