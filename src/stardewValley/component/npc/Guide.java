package stardewValley.component.npc;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.frame.StardewValleyFrame;

public class Guide extends JLabel {

	StardewValleyFrame mContext;
	
	private int x;
	private int y;
	
	private ImageIcon guide;
	private ImageIcon guideOn;
	public ImageIcon defalutGuide;
	
	private boolean seeNPC;
	private boolean plantOn;
	
	public Guide(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
	}
	
	private void initData() {
		x = 430;
		y = 430;
		
		guide = new ImageIcon("img/npc/scarecrow.png");
		guideOn = new ImageIcon("img/npc/scarecrowOn.png");
		defalutGuide = new ImageIcon("img/npc/scarecrowOn.png");
		
		seeNPC = false;
		plantOn = false;
	}
	
	private void setInitLayout() {
		this.setIcon(guide);
		this.setLocation(x, y);
		this.setSize(125, 180);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public ImageIcon getGuide() {
		return guide;
	}

	public void setGuide(ImageIcon guide) {
		this.guide = guide;
	}

	public ImageIcon getGuideOn() {
		return guideOn;
	}

	public void setGuideOn(ImageIcon guideOn) {
		this.guideOn = guideOn;
	}

	public boolean isSeeNPC() {
		return seeNPC;
	}

	public void setSeeNPC(boolean seeNPC) {
		this.seeNPC = seeNPC;
	}
	
	public boolean isPlantOn() {
		return plantOn;
	}

	public void setPlantOn(boolean plantOn) {
		this.plantOn = plantOn;
	}
	
}
