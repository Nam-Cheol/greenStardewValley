package stardewValley.A_KNC;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CarrotGauge extends JLabel{

	StardewValleyFrame mContext;
	
	private ImageIcon carrotGauge;
	private ImageIcon carrotGauge1;
	private ImageIcon carrotGauge2;
	private ImageIcon carrotGauge3;
	private ImageIcon carrotGauge4;
	private ImageIcon carrotGauge5;
	
	private int x;
	private int y;
	
	public CarrotGauge(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
	}
	
	private void initData() {

		x = 1300;
		y = 640;

		carrotGauge = new ImageIcon("img/gauge/CarrotWater1.png");
		carrotGauge1 = new ImageIcon("img/gauge/CarrotWater2.png");
		carrotGauge2 = new ImageIcon("img/gauge/CarrotWater3.png");
		carrotGauge3 = new ImageIcon("img/gauge/CarrotWater4.png");
		carrotGauge4 = new ImageIcon("img/gauge/CarrotWater5.png");
		carrotGauge5 = new ImageIcon("img/gauge/CarrotWater6.png");
		
	}
	
	private void setInitLayout() {
		this.setIcon(carrotGauge);
		this.setLocation(x, y);
		this.setSize(400, 180);
	}
}
