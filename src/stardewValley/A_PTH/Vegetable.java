package stardewValley.A_PTH;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Vegetable extends JLabel implements IVegetable {
	
	protected String name = "ㅋㅋ 효정이 바보";
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
	protected ImageIcon rottened;
	// 물
	protected final int MAX_WATERGAGE = 4;
	protected int waterGage;
	protected boolean vegeGetWater;
	// 수확
	protected boolean canHarvest;
	protected boolean rmRottened;
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
//		vegetables = new Vegetable[3];
//		
//		for (int i = 0; i < 3; i++) {
//			vegetables[0].parsnip.setLocation(200, 740);
//			vegetables[1].parsnip.setLocation(270, 740);
//			vegetables[2].parsnip.setLocation(340, 740);
//			
//		}
//		setSize(48, 48);
	}

	@Override
	public void grow() {
	}

	@Override
	public void harvest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sprinkling() {
		// TODO Auto-generated method stub

	}

	public int getPrice() {
		return price;
	}

	public int getWaterGage() {
		return waterGage;
	}

	public void setWaterGage(int waterGage) {
		this.waterGage = waterGage;
	}

	public boolean isCanHarvest() {
		return canHarvest;
	}

	public void setCanHarvest(boolean canHarvest) {
		this.canHarvest = canHarvest;
	}

	public int getMAX_WATERGAGE() {
		return MAX_WATERGAGE;
	}

	public int getMaxPlant() {
		return MAX_PLANT;
	}

	public ImageIcon getRottened() {
		return rottened;
	}

	public void setRottened(ImageIcon rottened) {
		this.rottened = rottened;
	}

	public boolean isRmRottened() {
		return rmRottened;
	}

	public void setRmRottened(boolean rmRottened) {
		this.rmRottened = rmRottened;
	}
	
	
	
	
}
