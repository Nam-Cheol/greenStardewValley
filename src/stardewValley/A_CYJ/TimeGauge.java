package stardewValley.A_CYJ;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.vegetable.vegetable;

public class TimeGauge extends JLabel {

	StardewValleyFrame mContext;

	private ImageIcon timeGauge;
	private ImageIcon timeGauge1;
	private ImageIcon timeGauge2;
	private Vegetable vegetables; 

	private int x;
	private int y;

	public TimeGauge(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
	}

	private void initData() {

		x = 1680;
		y = -40;
		timeGauge = new ImageIcon("img/gauge/Time1.png");
		if(Vegetable.getMAX_PLANT() == 0) {
			timeGauge1 = new ImageIcon("img/gauge/Time2.png");
			if(Vegetable.getMAX_PLANT() == 0) {
				timeGauge2 = new ImageIcon("img/gauge/Time3.png");
				
			}
		}
		
	}

	private void setInitLayout() {
		this.setIcon(timeGauge);
		this.setLocation(x, y);
		this.setSize(250, 180);
	}

	public ImageIcon getTimeGauge() {
		return timeGauge;
	}

	public ImageIcon getTimeGauge1() {
		return timeGauge1;
	}

	public ImageIcon getTimeGauge2() {
		return timeGauge2;
	}
	
	
}
