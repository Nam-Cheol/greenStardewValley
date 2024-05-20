package stardewValley.B_KNC.component.npc;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.B_KNC.component.player.Player;
import stardewValley.B_KNC.component.vegetable.Carrot;
import stardewValley.B_KNC.component.vegetable.Parsnip;
import stardewValley.B_KNC.component.vegetable.Strawberry;
import stardewValley.B_KNC.component.vegetable.Vegetable;
import stardewValley.B_KNC.frame.StardewValleyFrame;

public class Farm extends JLabel {

	StardewValleyFrame mContext;

	public Vegetable[] vegetables;
	public JLabel[] vegetableWaters;

	private int x = 130;
	private int y = 580;

	private final int PLANT_MAX = 9;

	private ImageIcon vegetableWaterStatus1;
	private ImageIcon vegetableWaterStatus2;
	private ImageIcon vegetableWaterStatus3;
	private ImageIcon vegetableWaterStatus4;
	private ImageIcon vegetableWaterStatus5;
	private ImageIcon vegetableWaterStatus6;
	private ImageIcon vegetableWaterStatus7;

	private ImageIcon farm;

	public Farm(StardewValleyFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	private void initData() {

		farm = new ImageIcon();
		vegetables = new Vegetable[PLANT_MAX];

		vegetableWaterStatus1 = new ImageIcon("img/vege/Water_gauge_0.png");
		vegetableWaterStatus2 = new ImageIcon("img/vege/Water_gauge_1.png");
		vegetableWaterStatus3 = new ImageIcon("img/vege/Water_gauge_2.png");
		vegetableWaterStatus4 = new ImageIcon("img/vege/Water_gauge_3.png");
		vegetableWaterStatus5 = new ImageIcon("img/vege/Water_gauge_4.png");
		vegetableWaterStatus6 = new ImageIcon("img/vege/Water_gauge_5.png");
		vegetableWaterStatus7 = new ImageIcon("img/vege/Water_gauge_6.png");
		vegetableWaters = new JLabel[PLANT_MAX];

	}

	private void setInitLayout() {
		this.setIcon(farm);
		this.setLocation(x, y);
		this.setSize(300, 300);
	}

	public void VLocation(int choice) {
		int temp = 110;
		if (choice < 4) {
			vegetables[choice - 1].setLocation(110 + (temp * (choice - 1)), 560);
		} else if (choice < 7) {
			vegetables[choice - 1].setLocation((temp * (choice - 1)) - 220, 660);
		} else if (choice < 10) {
			vegetables[choice - 1].setLocation((temp * (choice - 1)) - 550, 760);
		}
	}

	public void harvest(int choice) {

		if (vegetables[choice - 1] != null) {

			if (vegetables[choice - 1].isCanHarvest()) {

				if (vegetables[choice - 1] instanceof Parsnip) {
					mContext.player.setHaveParsnip(mContext.player.getHaveParsnip() + 1);
				} else if (vegetables[choice - 1] instanceof Carrot) {
					mContext.player.setHaveCarrot(mContext.player.getHaveCarrot() + 1);
				} else if (vegetables[choice - 1] instanceof Strawberry) {
					mContext.player.setHaveBerry(mContext.player.getHaveBerry() + 1);
				}
				vegetables[choice - 1].setIcon(null);
				vegetables[choice - 1] = null;
			}
		}
	}

	public void remove(int choice) {
		vegetables[choice - 1].setIcon(null);
		vegetables[choice - 1] = null;
	}

	public void sprinkling(int choice) {
		if (0 < mContext.player.getSprinklingCanGage()) {
			mContext.player.setIcon(mContext.player.getPlayerWater());
			mContext.player.setSprinklingCanGage(mContext.player.getSprinklingCanGage() - 1);
			vegetables[choice - 1].setWaterGage(vegetables[choice - 1].getWaterGage() + 1);
		}
	}

	public void waterValue(int choice) {
		vegetableWaters[choice - 1] = new JLabel();
		vegetableWaters[choice - 1].setSize(100, 50);
		vegetableWaters[choice - 1].setIcon(vegetableWaterStatus1);
		waterValueLocation(choice);
		mContext.add(vegetableWaters[choice - 1]);
	}

	public void waterValueLocation(int choice) {
		if (choice == 1) {
			vegetableWaters[choice - 1].setLocation(90, 560);
		} else if (choice == 2) {
			vegetableWaters[choice - 1].setLocation(210, 560);
		} else if (choice == 3) {
			vegetableWaters[choice - 1].setLocation(330, 560);
		} else if (choice == 4) {
			vegetableWaters[choice - 1].setLocation(90, 660);
		} else if (choice == 5) {
			vegetableWaters[choice - 1].setLocation(210, 660);
		} else if (choice == 6) {
			vegetableWaters[choice - 1].setLocation(330, 660);
		} else if (choice == 7) {
			vegetableWaters[choice - 1].setLocation(90, 760);
		} else if (choice == 8) {
			vegetableWaters[choice - 1].setLocation(210, 760);
		} else if (choice == 9) {
			vegetableWaters[choice - 1].setLocation(330, 760);
		}
	}

	public void vegetableWaterGauge(int waterGage, int choice) {
		if (vegetableWaters[choice - 1] != null) {
			if (waterGage == 0) {
				vegetableWaters[choice - 1].setIcon(vegetableWaterStatus1);
			} else if (waterGage == 1) {
				vegetableWaters[choice - 1].setIcon(vegetableWaterStatus2);
			} else if (waterGage == 2) {
				vegetableWaters[choice - 1].setIcon(vegetableWaterStatus3);
			} else if (waterGage == 3) {
				vegetableWaters[choice - 1].setIcon(vegetableWaterStatus4);
			} else if (waterGage == 4) {
				vegetableWaters[choice - 1].setIcon(vegetableWaterStatus5);
			} else if (waterGage == 5) {
				vegetableWaters[choice - 1].setIcon(vegetableWaterStatus6);
			} else if (waterGage <= 7) {
				vegetableWaters[choice - 1].setIcon(vegetableWaterStatus7);
			}
		}
	}

}
