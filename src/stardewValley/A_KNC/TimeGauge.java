package stardewValley.A_KNC;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TimeGauge extends JLabel {

	StardewValleyFrame mContext;

	private ImageIcon timeGauge;
	private ImageIcon timeGauge1;
	private ImageIcon timeGauge2;

	private int x;
	private int y;

	public TimeGauge(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
	}

	private void initData() {

		x = 500;
		y = 500;

		timeGauge = new ImageIcon("img/Time1.png");
		timeGauge1 = new ImageIcon("img/sellerOn.png");
		timeGauge2 = new ImageIcon("img/sellerOn.png");
		
	}

	private void setInitLayout() {
		this.setIcon(timeGauge);
		this.setLocation(x, y);
		this.setSize(100, 180);
	}
}
