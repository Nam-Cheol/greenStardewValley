package stardewValley.A_KNC;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BerryGauge extends JLabel{

	StardewValleyFrame mContext;
	
	private ImageIcon berryGauge;
	private ImageIcon berryGauge1;
	private ImageIcon berryGauge2;
	private ImageIcon berryGauge3;
	private ImageIcon berryGauge4;
	private ImageIcon berryGauge5;
	
	private int x;
	private int y;
	
	public BerryGauge(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
	}
	
	private void initData() {

		x = 1300;
		y = 755;

		berryGauge = new ImageIcon("img/gauge/StrawberryWater1.png");
		berryGauge1 = new ImageIcon("img/gauge/StrawberryWater2.png");
		berryGauge2 = new ImageIcon("img/gauge/StrawberryWater3.png");
		berryGauge3 = new ImageIcon("img/gauge/StrawberryWater4.png");
		berryGauge4 = new ImageIcon("img/gauge/StrawberryWater5.png");
		berryGauge5 = new ImageIcon("img/gauge/StrawberryWater6.png");
		
	}
	
	private void setInitLayout() {
		this.setIcon(berryGauge);
		this.setLocation(x, y);
		this.setSize(300, 180);
	}
}
