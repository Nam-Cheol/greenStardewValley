package stardewValley.A_OHJ;

public class backgroundFarmService implements Runnable {

	private Player player;
	private Farm farm;

	public backgroundFarmService(Player player, Farm farm) {
		this.player = player;
		this.farm = farm;
	}

	@Override
	public void run() {

		while (true) {
			int farmX = (farm.getX()+300) - farm.getX();
			int farmY = (farm.getY()+300) - farm.getY();
			
			int startFarmX = Math.abs(player.getX() - farm.getX());
			int startFarmY = Math.abs(player.getY() - farm.getY());

			if (startFarmX < 30 && startFarmY < 30) {
				System.out.println("위");
				stopUp();
			} else if (startFarmX < 30 && startFarmY < 30) {
				System.out.println("아래");
				stopDown();
				player.setCreate(true);
			} else if (startFarmX < 30 && startFarmY < 30) {
				System.out.println("왼쪽");
				stopLeft();
			} else if (startFarmX < 30 && startFarmY < 30) {
				System.out.println("오른쪽");
				stopRight();
			}
		}
	}

	public void stopUp() {
		if (player.playerWay == PlayerWay.UP) {
			player.setUpWallCrash(true);
			player.setUp(false);
		}
	}

	public void stopDown() {
		if (player.playerWay == PlayerWay.DOWN) {
			player.setDownWallCrash(true);
			player.setDown(false);
		}
	}

	public void stopLeft() {
		if (player.playerWay == PlayerWay.LEFT) {
			player.setLeftWallCrash(true);
			player.setLeft(false);
		}
	}

	public void stopRight() {
		if (player.playerWay == PlayerWay.RIGHT) {
			player.setRightWallCrash(true);
			player.setRight(false);
		}
	}
}
