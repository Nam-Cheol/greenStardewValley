package stardewValley.A_PTH;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.vegetable.vegetable;

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

	private ImageIcon farm;

	private Player player;

	public Farm(StardewValleyFrame mContext, Player player) {
		this.mContext = mContext;
		this.player = player;
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

		vegetableWaters = new JLabel[9];

	}

	private void setInitLayout() {
		this.setIcon(farm);
		this.setLocation(x, y);
		this.setSize(300, 300);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
					player.setHaveParsnip(player.getHaveParsnip() + 1);
				} else if (vegetables[choice - 1] instanceof Carrot) {
					player.setHaveCarrot(player.getHaveCarrot() + 1);
				} else if (vegetables[choice - 1] instanceof Strawberry) {
					player.setHaveBerry(player.getHaveBerry() + 1);
				}
				vegetables[choice - 1].setIcon(null);
				vegetables[choice - 1] = null;
			} else {
				System.out.println(vegetables[choice - 1].getName() + "은 지금은 자라는 중이다.");
			}
		}
	}

	public void remove(int choice) {
			vegetables[choice-1].setIcon(null);
			vegetables[choice-1] = null;
	}

	public void sprinkling(int choice) {
		if (0 < player.getSprinklingCanGage()) {
			player.setIcon(player.getPlayerWater());
			player.setSprinklingCanGage(player.getSprinklingCanGage() - 1);
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
		if(vegetableWaters[choice - 1] != null) {
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
			}
		}
//		if (waterGage == 0) {
//			vegetableWaters[choice-1].setIcon(vegetableWaterStatus1);
//		} else if (waterGage == 1) {
//			for(int i = 0; i < 9; i++) {
//				if(vegetableWaters[i] != null) {
//					vegetableWaters[i].setIcon(vegetableWaterStatus2);
//				}
//			}
//		} else if (waterGage == 2) {
//			for(int i = 0; i < 9; i++) {
//				if(vegetableWaters[i] != null) {
//					vegetableWaters[i].setIcon(vegetableWaterStatus3);
//				}
//			}
//		} else if (waterGage == 3) {
//			for(int i = 0; i < 9; i++) {
//				if(vegetableWaters[i] != null) {
//					vegetableWaters[i].setIcon(vegetableWaterStatus4);
//				}
//			}
//		} else if (waterGage == 4) {
//			for(int i = 0; i < 9; i++) {
//				if(vegetableWaters[i] != null) {
//					vegetableWaters[i].setIcon(vegetableWaterStatus5);
//				}
//			}
//		} else if (waterGage == 5) {
//			for(int i = 0; i < 9; i++) {
//				if(vegetableWaters[i] != null) {
//					vegetableWaters[i].setIcon(vegetableWaterStatus6);
//				}
//			}
//		}
	}
}
