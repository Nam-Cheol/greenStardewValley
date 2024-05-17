package stardewValley.A_PTH;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HelpInfo extends JLabel {

	StardewValleyFrame mContext;
	
	private Player player;
	
	private Keeper keeper;
	private Store store;
	private Water waterMan;

	private ImageIcon questionMark;
	private ImageIcon helpInfo1;
	private ImageIcon keyCommand;
	private ImageIcon keepInfo;
	private ImageIcon helpCommand; //

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

		helpCommand = new ImageIcon("img/Status/HelpCommand.png");//
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

	public ImageIcon getHelpCommand() {
		return helpCommand;
	}

	public void setHelpCommand(ImageIcon helpCommand) {
		this.helpCommand = helpCommand;
	}
	
	
//	public void setVisibleTrue() {
//		setIcon(questionMark);
//		setSize(50, 50);
//		setLocation(1200, 15);
//		
//		keeper.setIcon(keeper.getKeeper());
//		keeper.setSeeNPC(false);
//
//		store.setIcon(store.getSeller());
//		store.setSeeNPC(false);
//
//		waterMan.setIcon(waterMan.getWater());
//		waterMan.setSeeNPC(false);
//
//		waterMan.waterGauge.setVisible(true);
//
//		player.setIcon(player.getPlayerDown());
//	}

}