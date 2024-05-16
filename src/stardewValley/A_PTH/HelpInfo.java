package stardewValley.A_PTH;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HelpInfo extends JLabel {

	StardewValleyFrame mContext;

	private ImageIcon helpInfo;
	private ImageIcon helpInfo1;
	private ImageIcon keyCommand;

	private int infoX;
	private int infoY;

	public HelpInfo(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;

	}

	public void initData() {

		infoX = 1200;
		infoY = 15;

		helpInfo = new ImageIcon("img/status/questionMark1.png");
		helpInfo1 = new ImageIcon("img/status/HelpInfoImage.png");
		keyCommand = new ImageIcon("img/Status/KeyCommand.png");

	}

	public void setInitLayout() {
		this.setIcon(helpInfo);
		this.setLocation(infoX, infoY);
		this.setSize(50, 50);

	}

	public ImageIcon getHelpInfo() {
		return helpInfo;
	}

	public ImageIcon getHelpInfo1() {
		return helpInfo1;
	}
	public ImageIcon getKeyCommand() {
		return keyCommand;
	}

}