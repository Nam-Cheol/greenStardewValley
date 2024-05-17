package stardewValley.B_KNC.component.info;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.B_KNC.component.npc.Keeper;
import stardewValley.B_KNC.component.npc.Store;
import stardewValley.B_KNC.component.npc.Water;
import stardewValley.B_KNC.component.player.Player;
import stardewValley.B_KNC.frame.StardewValleyFrame;

public class HelpInfo extends JLabel {

	StardewValleyFrame mContext;

	private ImageIcon questionMark;
	private ImageIcon helpInfo;
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

		mContext.keeper.setSeeNPC(true);
		mContext.keeper.setIcon(null);

		mContext.waterMan.setIcon(null);
		mContext.waterMan.setSeeNPC(true);

		mContext.store.setIcon(null);
		mContext.store.setSeeNPC(true);

		mContext.waterMan.waterGauge.setVisible(false);
		mContext.player.setIcon(null);
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

		mContext.waterMan.waterGauge.setVisible(true);

		mContext.player.setIcon(mContext.player.getPlayerDown());
	}

	public ImageIcon getQuestionMark() {
		return questionMark;
	}

	public ImageIcon getHelpInfo() {
		return helpInfo;
	}

	public ImageIcon getKeyCommand() {
		return keyCommand;
	}

	public ImageIcon getKeepInfo() {
		return keepInfo;
	}

}