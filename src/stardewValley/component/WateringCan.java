package stardewValley.component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class WateringCan extends JLabel{
	
	private int x;
	private int y;
	private ImageIcon wateringCan;

	public WateringCan() {
		initData();
		setInitLayout();
	}

	private void initData() {
		x = 1300;
		y = 600;
		wateringCan = new ImageIcon("img/Watering_Can.png");
	}

	private void setInitLayout() {
		this.setIcon(wateringCan);
		this.setLocation(x, y);
		this.setSize(400, 280);
	}
	
}
