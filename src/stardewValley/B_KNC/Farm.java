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
		
	}

	public void sprinkling(int choice) {
		if (0 < player.getSprinklingCanGage()) {
			player.setIcon(player.getPlayerWater());
			player.setSprinklingCanGage(player.getSprinklingCanGage() - 1);
			System.out.println("밭에 물 준 후에 물뿌리개 : " + player.getSprinklingCanGage());
			vegetables[choice-1].setWaterGage(vegetables[choice-1].getWaterGage() + 1);
			System.out.println("식물이 받은 물 : " + vegetables[choice-1].getWaterGage());
		} else {
			System.out.println("연못에 가서 물을 채우세요.");
		}
	}
}
