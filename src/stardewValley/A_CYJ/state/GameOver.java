package stardewValley.A_CYJ.state;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.A_CYJ.frame.StardewValleyFrame;

public class GameOver extends JLabel {
	StardewValleyFrame mContext;
	
	private ImageIcon gameOver;
	
	private int gameOverX;
	private int gameOverY;
	
	public GameOver(StardewValleyFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}
	
	public void initData() {
		gameOverX = 1930;
		gameOverY = 980;
		
		gameOver = new ImageIcon("img/Status/gameOver.png");
		
	}
	
	public void setInitLayout() {
		this.setIcon(gameOver);
		this.setLocation(gameOverX, gameOverY);
		this.setSize(1980, 980);
	}

//	public StardewValleyFrame getmContext() {
//		return mContext;
//	}
//
//	public void setmContext(StardewValleyFrame mContext) {
//		this.mContext = mContext;
//	}
//
//	public ImageIcon getGameOver() {
//		return gameOver;
//	}
//
//	public void setGameOver(ImageIcon gameOver) {
//		this.gameOver = gameOver;
//	}
//
//	public int getGameOverX() {
//		return gameOverX;
//	}
//
//	public void setGameOverX(int gameOverX) {
//		this.gameOverX = gameOverX;
//	}
//
//	public int getGameOvery() {
//		return gameOverY;
//	}
//
//	public void setGameOvery(int gameOvery) {
//		this.gameOverY = gameOvery;
//	}
	
	public void gameOver() {
		setIcon(gameOver);
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
