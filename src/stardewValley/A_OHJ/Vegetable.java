package stardewValley.A_OHJ;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Vegetable extends JLabel implements IVegetable {

	// 멤버 변수
	protected String name;
	// 포함관계 - 프레임, 플레이어
	StardewValleyFrame mContext;
	protected Player player;
	protected int x;
	protected int y;
	protected int plantLocation = 130;
	// 성장
	protected boolean growing;
	protected ImageIcon growing1;
	protected ImageIcon growing2;
	protected ImageIcon growing3;
	protected ImageIcon growing4;
	protected ImageIcon growing5;
	protected ImageIcon lastGrowing;
	protected ImageIcon rottenImg;
	// 물
	protected final int MAX_WATERGAGE = 4;
	protected int waterGage;
	protected boolean vegeGetWater;
	protected JLabel waterGauge;
	protected ImageIcon watergauge0;
	protected ImageIcon watergauge1;
	protected ImageIcon watergauge2;
	protected ImageIcon watergauge3;
	protected ImageIcon watergauge4;
	protected ImageIcon watergauge5;
	// 수확
	protected boolean canHarvest;
	protected boolean rotten;
	// 밭에 접근
	protected boolean create;
	// 작물 가격
	protected int price;

	protected static int MAX_PLANT = 5;

	@Override
	public void initData() {
	}

	@Override
	public void setInitLayout() {
	}

	@Override
	public void grow() {
	}

	@Override
	public void harvest() {
	}

	@Override
	public void sprinkling() {
	}

	public int getPrice() {
		return price;
	}

	public boolean isCanHarvest() {
		return canHarvest;
	}

	public void setCanHarvest(boolean canHarvest) {
		this.canHarvest = canHarvest;
	}

	public int getWaterGage() {
		return waterGage;
	}

	public void setWaterGage(int waterGage) {
		this.waterGage = waterGage;
	}

	public static void setMAX_PLANT(int mAX_PLANT) {
		MAX_PLANT = mAX_PLANT;
	}

	public boolean getRotten() {
		return rotten;
	}

	public void setRotten(boolean rotten) {
		this.rotten = rotten;
	}

}
