package stardewValley.A_PTH;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// TODO 각 야채의 특성 및 차이점 구현
public class Parsnip extends Vegetable {

	StardewValleyFrame mContext;

	// 멤버 변수
	private String name = "파스닙";
	private int growSpeed = 5000;
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

	private ParsnipGauge gauge;
	
	private JLabel waterGauge;
	private ImageIcon watergauge0;
	private ImageIcon watergauge1;
	private ImageIcon watergauge2;
	private ImageIcon watergauge3;
	private ImageIcon watergauge4;
	private ImageIcon watergauge5;

	private boolean create;

	private int price;

	// 생성자
	public Parsnip(Player player) {
		this.player = player;
		initData();
		setInitLayout();
		grow();

	}

	// 메소드
	@Override
	public void initData() {
		waterGage = 2;
		growing = true;
		create = false;
		growing1 = new ImageIcon("img/Parsnip_Stage_1.png");
		growing2 = new ImageIcon("img/Parsnip_Stage_2.png");
		growing3 = new ImageIcon("img/Parsnip_Stage_3.png");
		growing4 = new ImageIcon("img/Parsnip_Stage_4.png");
		lastGrowing = new ImageIcon("img/Parsnip_Stage_5.png");
		rottened = new ImageIcon("img/Rotten_Plant.png");

		watergauge0 = new ImageIcon("img/Water_gauge_0.png");
		watergauge1 = new ImageIcon("img/Water_gauge_1.png");
		watergauge2 = new ImageIcon("img/Water_gauge_2.png");
		watergauge3 = new ImageIcon("img/Water_gauge_3.png");
		watergauge4 = new ImageIcon("img/Water_gauge_4.png");
		watergauge5 = new ImageIcon("img/Water_gauge_5.png");

		price = (int) (Math.random() * 500) + 1000;

		waterGauge = new JLabel();

	}

	@Override
	public void setInitLayout() {
		x = player.getX();
		y = player.getY();
		setSize(100, 110);

		setIcon(null);

	}

	@Override
	public void grow() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				MAX_PLANT--;
				synchronized (this) {
					try {
						setIcon(growing1);
						Thread.sleep(growSpeed);
						setWaterGage(getWaterGage() - 1);
//						rmParsnip();
						System.out.println(getWaterGage());
						notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					try {
						Thread.sleep(growSpeed);
						setIcon(growing2);
						setWaterGage(getWaterGage() - 1);
//						rmParsnip();
						System.out.println(getWaterGage());
						notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					try {
						Thread.sleep(growSpeed);
						setIcon(growing3);
						setWaterGage(getWaterGage() - 1);
//						rmParsnip();
						System.out.println(getWaterGage());
						notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					try {
						Thread.sleep(growSpeed);
						setIcon(growing4);
						setWaterGage(getWaterGage() - 1);
//						rmParsnip();
						System.out.println(getWaterGage());
						notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					try {
						Thread.sleep(growSpeed);
						setIcon(lastGrowing);

						canHarvest = true;
						System.out.println(getWaterGage());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}).start();
	}

	@Override
	public void harvest() {
	}

	@Override
	public void sprinkling() {
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

	@Override
	public int getPrice() {
		return price;
	}

	public void waterGaugeP() {

		if (waterGage == 1) {
			waterGauge.setIcon(watergauge1);

		} else if (waterGage == 2) {
			waterGauge.setIcon(watergauge2);

		} else if (waterGage == 3) {
			waterGauge.setIcon(watergauge3);

		} else if (waterGage == 4) {
			waterGauge.setIcon(watergauge4);

		} else if (waterGage == 5) {
			waterGauge.setIcon(watergauge5);
		
		} else if (waterGage == 0) {
			waterGauge.setIcon(watergauge0);
		}
	}
//
//	public void rmParsnip() {
//		if (getWaterGage() == 0 || getWaterGage() == MAX_WATERGAGE) {
//			try {
//				setIcon(rottened);
//				rmRottened = true;
//				this.wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}

} // end of class
