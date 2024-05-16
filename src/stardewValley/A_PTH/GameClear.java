package stardewValley.A_PTH;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameClear extends JLabel {
	StardewValleyFrame mContext;

	private ImageIcon gameClear;

	private int gameClearX;
	private int gameCleary;

	public GameClear(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
	}

	public void initData() {
		gameClearX = 1930;
		gameCleary = 980;

		gameClear = new ImageIcon("img/Status/gameClear.png");

	}

	public void setInitLayout() {
		this.setIcon(gameClear);
		this.setLocation(gameClearX, gameCleary);
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

	public int getGameCleary() {
		return gameCleary;
	}

	public void setGameCleary(int gameCleary) {
		this.gameCleary = gameCleary;
	}

}
