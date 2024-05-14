//package stardewValley.A_CYJ;
//
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//
//public class SeedZone extends JLabel {
//	StardewValleyFrame mContext;
//	
//	private int x;
//	private int y;
//	
//	private ImageIcon seedZone;
//	private ImageIcon seedZoneOn;
//	
//	private boolean seeNpc;
//	
//	protected static int MAX_PLANT = 5;
//	
//	public SeedZone(StardewValleyFrame mContext) {
//		initData();
//		setInitLayout();
//		this.mContext = mContext;
//	}
//	
//	private void initData() {
//		
//		x = 600;
//		y = 300;
//		
//		seedZone = new ImageIcon("img/seedmakerTest.png");
//	}
//	
//	private void setInitLayout() {
//		this.setIcon(seedZone);
//		this.setLocation(x, y);
//		this.setSize(130, 200);
//	}
//
//	public StardewValleyFrame getmContext() {
//		return mContext;
//	}
//
//	public void setmContext(StardewValleyFrame mContext) {
//		this.mContext = mContext;
//	}
//
//	public int getX() {
//		return x;
//	}
//
//	public void setX(int x) {
//		this.x = x;
//	}
//
//	public int getY() {
//		return y;
//	}
//
//	public void setY(int y) {
//		this.y = y;
//	}
//
//	public ImageIcon getSeedZone() {
//		return seedZone;
//	}
//
//	public void setSeedZone(ImageIcon seedZone) {
//		this.seedZone = seedZone;
//	}
//
//	public ImageIcon getSeedZoneOn() {
//		return seedZoneOn;
//	}
//
//	public void setSeedZoneOn(ImageIcon seedZoneOn) {
//		this.seedZoneOn = seedZoneOn;
//	}
//
//	public boolean isSeeNpc() {
//		return seeNpc;
//	}
//
//	public void setSeeNpc(boolean seeNpc) {
//		this.seeNpc = seeNpc;
//	}
//
//	public static int getMAX_PLANT() {
//		return MAX_PLANT;
//	}
//
//	public static void setMAX_PLANT(int mAX_PLANT) {
//		MAX_PLANT = mAX_PLANT;
//	}
//	
//	
//	
//}
