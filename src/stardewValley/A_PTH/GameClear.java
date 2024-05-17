package stardewValley.A_PTH;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class GameClear extends JLabel {
	StardewValleyFrame mContext;

	private ImageIcon gameClear;

	private int gameClearX;
	private int gameClearY;

	public GameClear(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
	}

	public void initData() {
		gameClearX = 1930;
		gameClearY = 980;

		gameClear = new ImageIcon("img/Status/gameClear.png");

	}

	public void setInitLayout() {
		this.setIcon(gameClear);
		this.setLocation(gameClearX, gameClearY);
		this.setSize(1980, 980);
	}

	public StardewValleyFrame getmContext() {
		return mContext;
	}

	public void setmContext(StardewValleyFrame mContext) {
		this.mContext = mContext;
	}

	public ImageIcon getGameClear() {
		return gameClear;
	}

	public void setGameClear(ImageIcon gameClear) {
		this.gameClear = gameClear;
	}

	public int getGameClearX() {
		return gameClearX;
	}

	public void setGameClearX(int gameClearX) {
		this.gameClearX = gameClearX;
	}

	public int getGameClearY() {
		return gameClearY;
	}

	public void setGameClearY(int gameCleary) {
		this.gameClearY = gameCleary;
	}
	
	public void gameClear() {
		setIcon(gameClear);
		setSize(1930, 930);
		setLocation(0, 0);
		mContext.player.setIcon(null);
		mContext.player.getWaterGauge().setIcon(null);
		mContext.player = null;
		mContext.guide.setIcon(null);
		mContext.guide.setSeeNPC(true);
		mContext.seedZone.setIcon(null);
		mContext.seedZone.setSeedZoneOn(null);
		mContext.keeper.setIcon(null);
        mContext.keeper.setSeeNPC(true);
        mContext.waterMan.setIcon(null);
        mContext.waterMan.setSeeNPC(true);
        
        mContext.store.setIcon(null);
        mContext.store.setSeeNPC(true);
        mContext.info.setIcon(null);
        mContext.timeGauge.setIcon(null);
        mContext.waterMan.removeWaterGage();
        mContext.status.removeText();
        mContext.store = null;
        mContext.keeper = null;
        mContext.waterMan = null;
        mContext.guide = null;
        mContext.seedZone = null;
	}

}
