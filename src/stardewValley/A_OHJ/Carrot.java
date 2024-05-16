package stardewValley.A_OHJ;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// TODO 각 야채의 특성 및 차이점 구현
public class Carrot extends Vegetable {

	// 멤버 변수
	private String name = "당근";
	private int growSpeed = 5000;
	
	private int temp;

	// 생성자
	public Carrot(Player player, StardewValleyFrame mContext, Farm farm) {
		this.player = player;
		this.mContext = mContext;
		this.farm = farm;
		initData();
		setInitLayout();
		grow();
	}

	// 메소드
	@Override
	public void initData() {
		waterGauge = 3;
		growing = true;
		create = false;
		temp = mContext.choice;
		growing1 = new ImageIcon("img/vege/Carrot_Stage_1.png");
		growing2 = new ImageIcon("img/vege/Carrot_Stage_2.png");
		growing3 = new ImageIcon("img/vege/Carrot_Stage_3.png");
		lastGrowing = new ImageIcon("img/vege/Carrot_Stage_4.png");
	}

	@Override
	public void setInitLayout() {
		setSize(100, 110);
		setIcon(null);
	}

	@Override
	public void grow() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				MAX_PLANT--;
				setIcon(growing1);
				while (true) {
					mContext.farm.vegetableWaterGauge(waterGauge, temp);
					try {
						Thread.sleep(growSpeed);
						waterGauge--;
						mContext.farm.vegetableWaterGauge(waterGauge, temp);
					} catch (InterruptedException e) {
					}
					if (waterGauge == 0) {
						mContext.farm.vegetables[temp - 1].setIcon(rotten);
						mContext.farm.vegetableWaters[temp - 1].setIcon(null);
						mContext.farm.vegetableWaters[temp - 1] = null;
						return;
					}
					if (waterGauge > 6) {
						mContext.farm.vegetables[temp - 1].setIcon(rotten);
						mContext.farm.vegetableWaters[temp - 1].setIcon(null);
						mContext.farm.vegetableWaters[temp - 1] = null;
						return;
					}
					if (waterGauge >= 1 && waterGauge <= 5) {
						
						if(getIcon() == growing1) {
							setIcon(growing2);
							continue;
						}
						if(getIcon() == growing2) {
							setIcon(growing3);
							continue;
						}
						if(getIcon() == growing3) {
							setIcon(lastGrowing);
						}
						if (getIcon() == lastGrowing) {
							canHarvest = true;
							mContext.farm.vegetableWaters[temp - 1].setIcon(null);
							mContext.farm.vegetableWaters[temp - 1] = null;
							return;
						}
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
	
	@Override
	public int getPrice() {
		return price;
	}
	
	public boolean isCreate() {
		return create;
	}

	public void setCreate(boolean create) {
		this.create = create;
	}
	
	public ImageIcon getLastGrowing() {
		return lastGrowing;
	}

} // end of class
