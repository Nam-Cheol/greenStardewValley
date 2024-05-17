package stardewValley.B_KNC.component.npc;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.B_KNC.frame.StardewValleyFrame;

public class SeedZone extends JLabel {
	StardewValleyFrame mContext;
	
	private int x;
	private int y;
	
	private ImageIcon seedZone;
	private ImageIcon seedZoneOn;
	
	private boolean seeNpc;
	private boolean seedOn;
	
	public SeedZone(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
	}
	
	private void initData() {
		
		x = 580;
		y = 10;
		
		seedZone = new ImageIcon("img/npc/seedmakerTest.png");
		seedZoneOn = new ImageIcon("img/npc/seedActive.png");
		
		seedOn = false;
		seeNpc = false;
	}
	
	private void setInitLayout() {
		this.setIcon(seedZone);
		this.setLocation(x, y);
		this.setSize(120, 200);
	}

	public StardewValleyFrame getmContext() {
		return mContext;
	}

	public void setmContext(StardewValleyFrame mContext) {
		this.mContext = mContext;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ImageIcon getSeedZone() {
		return seedZone;
	}

	public void setSeedZone(ImageIcon seedZone) {
		this.seedZone = seedZone;
	}

	public ImageIcon getSeedZoneOn() {
		return seedZoneOn;
	}

	public void setSeedZoneOn(ImageIcon seedZoneOn) {
		this.seedZoneOn = seedZoneOn;
	}

	public boolean isSeeNpc() {
		return seeNpc;
	}

	public void setSeeNpc(boolean seeNpc) {
		this.seeNpc = seeNpc;
	}

	public boolean isSeedOn() {
		return seedOn;
	}

	public void setSeedOn(boolean seedOn) {
		this.seedOn = seedOn;
	}
	
	


	
	
	
}
