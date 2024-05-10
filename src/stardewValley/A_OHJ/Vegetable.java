package stardewValley.A_OHJ;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Vegetable extends JLabel implements IVegetable{

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
	// 물
	protected final int MAX_WATERGAGE = 4;
	protected int waterGage;
	protected boolean vegeGetWater;
	// 수확
	protected boolean canHarvest;
	// 밭에 접근
	protected boolean create;
	// 작물 가격
	protected int price;
	
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
		if (canHarvest == true) {
			System.out.println("--> 파스닙 클래스 : 파스닙 수확한다.");
			setIcon(null);
		} else {
			System.out.println("--> 파스닙 클래스 : 지금은 자라는 중이다.");
		}
	}

	@Override
	public void sprinkling() {
	}

	public int getPrice() {
		return price;
	}
	
}
