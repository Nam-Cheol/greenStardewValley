package stardewValley.B_KNC.component.vegetable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.B_KNC.component.npc.Farm;
import stardewValley.B_KNC.component.player.Player;
import stardewValley.B_KNC.frame.StardewValleyFrame;

// TODO 각 야채의 특성 및 차이점 구현
public class Parsnip extends Vegetable {

	// 멤버 변수
	private String name = "파스닙";
	private int growSpeed = 5000;
	private int temp;

	// 생성자
	public Parsnip(Player player, StardewValleyFrame mContext, Farm farm) {
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
		growing1 = new ImageIcon("img/vege/Parsnip_Stage_1.png");
		growing2 = new ImageIcon("img/vege/Parsnip_Stage_2.png");
		growing3 = new ImageIcon("img/vege/Parsnip_Stage_3.png");
		growing4 = new ImageIcon("img/vege/Parsnip_Stage_4.png");
		lastGrowing = new ImageIcon("img/vege/Parsnip_Stage_5.png");
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
				seed--;
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
							setIcon(growing4);
							continue;
						}
						if(getIcon() == growing4) {
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

	@Override
	public int getPrice() {
		return price;
	}
	
} // end of class