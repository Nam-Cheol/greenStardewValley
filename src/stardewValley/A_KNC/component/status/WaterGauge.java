package stardewValley.A_KNC.component.status;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.A_KNC.StardewValleyFrame;

public class WaterGauge extends JLabel{

	StardewValleyFrame mContext;
	
	private ImageIcon waterGauge;
	private ImageIcon waterGauge1;
	private ImageIcon waterGauge2;
	private ImageIcon waterGauge3;
	private ImageIcon waterGauge4;
	private ImageIcon waterGauge5;
	
	private int x;
	private int y;
	
	public WaterGauge(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
	}
	
	private void initData() {

		x = 1300;
		y = 350;

		waterGauge = new ImageIcon("img/gauge/WaterGauge1.png");
		waterGauge1 = new ImageIcon("img/gauge/WaterGauge2.png");
		waterGauge2 = new ImageIcon("img/gauge/WaterGauge3.png");
		waterGauge3 = new ImageIcon("img/gauge/WaterGauge4.png");
		waterGauge4 = new ImageIcon("img/gauge/WaterGauge5.png");
		waterGauge5 = new ImageIcon("img/gauge/WaterGauge6.png");
		
	}
	
	private void setInitLayout() {
		this.setIcon(waterGauge);
		this.setLocation(x, y);
		this.setSize(300, 180);
	}

	public ImageIcon getWaterGauge() {
		return waterGauge;
	}

	public ImageIcon getWaterGauge1() {
		return waterGauge1;
	}

	public ImageIcon getWaterGauge2() {
		return waterGauge2;
	}

	public ImageIcon getWaterGauge3() {
		return waterGauge3;
	}

	public ImageIcon getWaterGauge4() {
		return waterGauge4;
	}

	public ImageIcon getWaterGauge5() {
		return waterGauge5;
	}
	
	
}
