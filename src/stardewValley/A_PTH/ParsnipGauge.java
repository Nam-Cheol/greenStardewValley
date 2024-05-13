package stardewValley.A_PTH;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ParsnipGauge extends JLabel{

	StardewValleyFrame mContext;
	
	private ImageIcon parsnipGauge;
	private ImageIcon parsnipGauge1;
	private ImageIcon parsnipGauge2;
	private ImageIcon parsnipGauge3;
	private ImageIcon parsnipGauge4;
	private ImageIcon parsnipGauge5;
	
	private int x;
	private int y;
	
	public ParsnipGauge(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
	}
	
	private void initData() {

		x = 1300;
		y = 520;

		parsnipGauge = new ImageIcon("img/gauge/ParsnipWater1.png");
		parsnipGauge1 = new ImageIcon("img/gauge/ParsnipWater2.png");
		parsnipGauge2 = new ImageIcon("img/gauge/ParsnipWater3.png");
		parsnipGauge3 = new ImageIcon("img/gauge/ParsnipWater4.png");
		parsnipGauge4 = new ImageIcon("img/gauge/ParsnipWater5.png");
		parsnipGauge5 = new ImageIcon("img/gauge/ParsnipWater6.png");
		
	}
	
	private void setInitLayout() {
		this.setIcon(parsnipGauge);
		this.setLocation(x, y);
		this.setSize(300, 180);
	}

	public ImageIcon getParsnipGauge() {
		return parsnipGauge;
	}

	public ImageIcon getParsnipGauge1() {
		return parsnipGauge1;
	}

	public ImageIcon getParsnipGauge2() {
		return parsnipGauge2;
	}

	public ImageIcon getParsnipGauge3() {
		return parsnipGauge3;
	}

	public ImageIcon getParsnipGauge4() {
		return parsnipGauge4;
	}

	public ImageIcon getParsnipGauge5() {
		return parsnipGauge5;
	}
	
	
}
