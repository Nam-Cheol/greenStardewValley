package stardewValley.component.info;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.frame.StardewValleyFrame;

public class HelpInfo extends JLabel {

	StardewValleyFrame mContext;

	public ImageIcon questionMark;
	public ImageIcon helpInfo;
	public ImageIcon keyCommand;
	public ImageIcon keepInfo;

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
		helpInfo = new ImageIcon("img/Status/MainR.png");
		keyCommand = new ImageIcon("img/Status/KeyCommand.png");
		keepInfo = new ImageIcon("img/Status/tempD.png");

	}

	public void setInitLayout() {
		this.setIcon(questionMark);
		this.setLocation(infoX, infoY);
		this.setSize(50, 50);

	}
	
	public void setVisibleFalse() {
		mContext.info.setSize(955, 630);
		mContext.info.setLocation(200, 200);

		mContext.keeper.setIcon(null);
		mContext.keeper.setSeeNPC(true);

		mContext.waterMan.setIcon(null);
		mContext.waterMan.setSeeNPC(true);

		mContext.store.setIcon(null);
		mContext.store.setSeeNPC(true);
		
		mContext.guide.setIcon(null);
		mContext.guide.setSeeNPC(true);

		mContext.waterMan.waterGauge.setVisible(false);
		mContext.player.setIcon(null);
		mContext.player.setUp(true);
		mContext.player.setDown(true);
		mContext.player.setLeft(true);
		mContext.player.setRight(true);
	}
	
	public void setVisibleTrue() {
		mContext.info.setIcon(questionMark);
		mContext.info.setSize(50, 50);
		mContext.info.setLocation(1200, 15);

		mContext.keeper.setIcon(mContext.keeper.getKeeper());
		mContext.keeper.setSeeNPC(false);

		mContext.store.setIcon(mContext.store.getSeller());
		mContext.store.setSeeNPC(false);

		mContext.waterMan.setIcon(mContext.waterMan.getWater());
		mContext.waterMan.setSeeNPC(false);
		
		mContext.guide.setIcon(mContext.guide.getGuide());
		mContext.guide.setSeeNPC(false);

		mContext.waterMan.waterGauge.setVisible(true);

		mContext.player.setIcon(mContext.player.getPlayerDown());
		
	}

}