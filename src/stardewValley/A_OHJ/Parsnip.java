package stardewValley.A_OHJ;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// TODO 각 야채의 특성 및 차이점 구현
public class Parsnip extends JLabel implements IVegetable {

	// 멤버 변수
	private String name = "파스닙";
	StardewValleyFrame mContext;
	// 플레이어
	private Player player;
	private int x;
	private int y;
	private int plantLocation = 130;
	// 성장
	private boolean growing;
	private ImageIcon growing1;
	private ImageIcon growing2;
	private ImageIcon growing3;
	private ImageIcon growing4;
	private ImageIcon lastGrowing;
	// 물
	private final int MAX_WATERGAGE = 4;
	private int waterGage;
	private boolean vegeGetWater;
	// 수확
	private boolean canHarvest;

	private boolean create;

	private int price;

	// 생성자
	public Parsnip(StardewValleyFrame mContext) {
//		this.player = player;
		this.mContext = mContext;
		this.player = mContext.getPlayer();
		initData();
		setInitLayout();
		growStep1();
	}

	// 메소드
	@Override
	public void initData() {
		growing = true;
		canHarvest = false;
		waterGage = 2;
		vegeGetWater = false;
		create = false;

		growing1 = new ImageIcon("img/Parsnip_Stage_1.png");
		growing2 = new ImageIcon("img/Parsnip_Stage_2.png");
		growing3 = new ImageIcon("img/Parsnip_Stage_3.png");
		growing4 = new ImageIcon("img/Parsnip_Stage_4.png");
		lastGrowing = new ImageIcon("img/Parsnip_Stage_5.png");
		price = (int) (Math.random() * 500) + 1000;
	}

	@Override
	public void setInitLayout() {
		x = player.getX();
		y = player.getY();
		setSize(48, 48);
		setLocation(x, y + plantLocation);
		setIcon(null);
	}

	@Override
	public void growStep1() {
		try {
			setIcon(growing1);
			System.out.println("--> 파스닙 클래스 grow : 시작");
			Thread.sleep(3000);
			setIcon(growing2);
			System.out.println("--> 파스닙 클래스 grow : 파스닙 2단계");

//			Thread.sleep(1000);
//			setIcon(growing3);
//
//			Thread.sleep(1000);
//			setIcon(growing4);
//
//			Thread.sleep(1000);
//			setIcon(lastGrowing);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (0 < getWaterGage() && getWaterGage() < MAX_WATERGAGE) {
			growStep2();
		}
	}

	// 시도
	public void growStep2() {
		try {
			Thread.sleep(3000);
			setIcon(growing3);
			System.out.println("--> 파스닙 클래스 grow : 파스닙 3단계");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
		int currentWater = getWaterGage();
		if (0 < currentWater && currentWater < MAX_WATERGAGE) {
			vegeGetWater = true;
			setWaterGage(currentWater + 1);
			System.out.println("--> 파스닙 클래스 : " + getWaterGage());
		} else {
			vegeGetWater = false;
			growing = false;
			setIcon(null);
			System.out.println("--> 파스닙 클래스 : 물 너무 많이 줘서 죽었다.");
		}
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isCreate() {
		return create;
	}

	public void setCreate(boolean create) {
		this.create = create;
	}

	public int getPrice() {
		return price;
	}

	// 물
	public int getWaterGage() {
		return waterGage;
	}

	public void setWaterGage(int waterGage) {
		this.waterGage = waterGage;
	}

} // end of class
