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
	private ImageIcon helpCommand;

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
	public ImageIcon getHelpCommand() {
		return helpCommand;
	}
	public void setVisibleTrue() {
		setIcon(questionMark);
		setSize(50, 50);
		setLocation(1200, 15);
		
		mContext.keeper.setIcon(mContext.keeper.getKeeper());
		mContext.keeper.setSeeNPC(false);

		mContext.store.setIcon(mContext.store.getSeller());
		mContext.store.setSeeNPC(false);

		mContext.waterMan.setIcon(mContext.waterMan.getWater());
		mContext.waterMan.setSeeNPC(false);

		mContext.waterMan.waterGauge.setVisible(true);

		mContext.player.setIcon(mContext.player.getPlayerDown());
	}
	public void setVisibleFalse(int temp) {
		if(temp == 1) {
			setIcon(helpInfo1);
		} else if (temp == 2){
			setIcon(keyCommand);
		} else if (temp == 3) {
			setIcon(keepInfo);
		} else if (temp == 4) {
//			setIcon
		}
		
		setSize(955, 630);
		setLocation(200, 200);
		
		mContext.keeper.setIcon(null);
		mContext.keeper.setSeeNPC(true);
		
		mContext.waterMan.setIcon(null);
		mContext.waterMan.setSeeNPC(true);
		
		mContext.waterMan.waterGauge.setVisible(false);
		
		mContext.store.setIcon(null);
		mContext.store.setSeeNPC(true);
		
		mContext.player.setIcon(null);
	}
	

}