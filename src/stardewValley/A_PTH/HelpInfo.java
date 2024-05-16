package stardewValley.A_PTH;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HelpInfo extends JLabel {

	StardewValleyFrame mContext;

	private ImageIcon questionMark;
	private ImageIcon helpInfo1;
	private ImageIcon keyCommand;
	private ImageIcon keepInfo;

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

		questionMark = new ImageIcon("img/Status/questionMark1.png");
		helpInfo1 = new ImageIcon("img/Status/MainR.png");
		keyCommand = new ImageIcon("img/Status/KeyCommand.png");
		keepInfo = new ImageIcon("img/Status/tempD.png");

	}

	public void setInitLayout() {
		this.setIcon(questionMark);
		this.setLocation(infoX, infoY);
		this.setSize(50, 50);
		

	}
	
	public ImageIcon getQuestionMark() {
		return questionMark;
	}

	public ImageIcon getHelpInfo1() {
		return helpInfo1;
	}
	
	public ImageIcon getKeyCommand() {
		return keyCommand;
	}
	
	public ImageIcon getKeepInfo() {
		return keepInfo;
	}

}