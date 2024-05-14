package stardewValley.B_KNC;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Farm extends JLabel {

	StardewValleyFrame mContext;

	public Vegetable[] vegetables;

	private int x = 130;
	private int y = 580;

	private final int PLANT_MAX = 9;

	private ImageIcon farm;

	private Player player;

	private int choice;

	public Farm(StardewValleyFrame mContext, Player player) {
		this.mContext = mContext;
		this.player = player;
		initData();
		setInitLayout();
	}

	private void initData() {

		choice = 0;

		farm = new ImageIcon();

		vegetables = new Vegetable[PLANT_MAX];

	}

	private void setInitLayout() {
		this.setIcon(farm);
		this.setLocation(x, y);
		this.setSize(300, 300);
	}

	public void plantOn(int choice) {
		this.choice = choice;
		vegetables[choice - 1] = new Carrot(player);
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
			vegetables[choice - 1].setLocation(160 + (temp * (choice - 1)), 580);
		} else if (choice < 7) {
			vegetables[choice - 1].setLocation((temp * (choice - 1)) - 170, 680);
		} else if (choice < 10) {
			vegetables[choice - 1].setLocation((temp * (choice - 1)) - 500, 780);
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
		
	}

}
