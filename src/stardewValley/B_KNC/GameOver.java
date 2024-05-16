package stardewValley.B_KNC;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameOver extends JLabel {
	StardewValleyFrame mContext;
	
	private ImageIcon gameOver;
	
	private int gameOverX;
	private int gameOvery;
	
	public GameOver(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
	}
	
	public void initData() {
		gameOverX = 1930;
		gameOvery = 980;
		
		gameOver = new ImageIcon("img/Status/gameOver.png");
		
	}
	
	public void setInitLayout() {
		this.setIcon(gameOver);
		this.setLocation(gameOverX, gameOvery);
		this.setSize(1980, 980);
	}

	public StardewValleyFrame getmContext() {
		return mContext;
	}

	public void setmContext(StardewValleyFrame mContext) {
		this.mContext = mContext;
	}

	public ImageIcon getGameOver() {
		return gameOver;
	}

	public void setGameOver(ImageIcon gameOver) {
		this.gameOver = gameOver;
	}

	public int getGameOverX() {
		return gameOverX;
	}

	public void setGameOverX(int gameOverX) {
		this.gameOverX = gameOverX;
	}

	public int getGameOvery() {
		return gameOvery;
	}

	public void setGameOvery(int gameOvery) {
		this.gameOvery = gameOvery;
	}
	
	
	
	
}
