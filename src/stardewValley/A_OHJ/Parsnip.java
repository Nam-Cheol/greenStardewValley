package stardewValley.A_OHJ;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// TODO 각 야채의 특성 및 차이점 구현
public class Parsnip extends JLabel implements vegetable {

	// 멤버 변수
	private String name = "파스닙";
	// 플레이어
	private StardewValleyFrame mContext;
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
	private boolean canHarvest;
	// 물
	private int parsnipWaterGage;
	private final int MAX_WATERGAGE = 4;

	// 생성자
	public Parsnip(StardewValleyFrame mContext) {
		this.mContext = mContext;
		this.player = mContext.getPlayer();
		initData();
		setInitLayout();
		sowSeeds();
	}

	// 메소드
	@Override
	public void initData() {
		growing = true;
		canHarvest = false;
		parsnipWaterGage = 2;

		growing1 = new ImageIcon("img/Parsnip_Stage_1.png");
		growing2 = new ImageIcon("img/Parsnip_Stage_2.png");
		growing3 = new ImageIcon("img/Parsnip_Stage_3.png");
		growing4 = new ImageIcon("img/Parsnip_Stage_4.png");
		lastGrowing = new ImageIcon("img/Parsnip_Stage_5.png");
	}

	@Override
	public void setInitLayout() {
		x = player.getX();
		y = player.getY();
		setSize(48, 48);
		setLocation(x, y + plantLocation);
		setIcon(null);
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

	public int getWaterParsnip() {
		return parsnipWaterGage;
	}

	public void setWaterParsnip(int parsnipWaterGage) {
		this.parsnipWaterGage = parsnipWaterGage;
	}

	//
	public void sowSeeds() {
		setIcon(growing1);
		growing = true;
		grow();
	}

	@Override
	public void grow() {
		System.out.println("-------------> 파스닙 클래스 grow : 시작");
		new Thread(new Runnable() {
			@Override
			public void run() {
				if (growing == true) {
					try {
						Thread.sleep(3000);
						setIcon(growing2);
						System.out.println("-------------> 파스닙 클래스 grow : 파스닙 2단계");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(growing == true) {
						try {
							Thread.sleep(3000);
							setIcon(growing3);
							System.out.println("-------------> 파스닙 클래스 grow : 파스닙 3단계");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if(growing == true) {
							try {
								Thread.sleep(3000);
								setIcon(growing4);
								System.out.println("-------------> 파스닙 클래스 grow : 파스닙 4단계");
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							if(growing == true) {
								try {
									Thread.sleep(3000);
									setIcon(lastGrowing);
									System.out.println("-------------> 파스닙 클래스 grow : 파스닙 다 자람");
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								canHarvest = true;
							} // 네 번째 if
						} // 세 번째 if
					} // 두 번째 if
				} // 첫 번째 if
				 else {
					Thread.yield();
				}
			}
		}).start();
	} // end of grow()

	@Override
	public void harvest() {
		if (canHarvest == true) {
			System.out.println("-------------> 파스닙 클래스 : 파스닙 수확한다.");
			setIcon(null);
		} else {
			System.out.println("-------------> 파스닙 클래스 : 지금은 자라는 중이다.");
		}
	}

	@Override
	public void sprinkling(int water) {
		synchronized (this) {
			int currentWater = getWaterParsnip();
			if (0 < currentWater && currentWater != MAX_WATERGAGE) {
				setWaterParsnip(currentWater + water);
				System.out.println("-------------> 파스닙 클래스 : " + currentWater);
				growing = true;
			} else {
				growing = false;
				setIcon(null);
				System.out.println("-------------> 파스닙 클래스 : 물 너무 많이 줘서 죽었다.");
			}
		}

	}

} // end of class
