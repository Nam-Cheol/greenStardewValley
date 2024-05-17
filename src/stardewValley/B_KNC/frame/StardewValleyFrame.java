package stardewValley.B_KNC.frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import stardewValley.B_KNC.component.info.HelpInfo;
import stardewValley.B_KNC.component.npc.Farm;
import stardewValley.B_KNC.component.npc.Guide;
import stardewValley.B_KNC.component.npc.Keeper;
import stardewValley.B_KNC.component.npc.SeedZone;
import stardewValley.B_KNC.component.npc.Store;
import stardewValley.B_KNC.component.npc.Water;
import stardewValley.B_KNC.component.player.Player;
import stardewValley.B_KNC.component.status.Status;
import stardewValley.B_KNC.component.status.TimeGauge;
import stardewValley.B_KNC.component.vegetable.Vegetable;
import stardewValley.B_KNC.state.GameClear;
import stardewValley.B_KNC.state.GameOver;

public class StardewValleyFrame extends JFrame {

	StardewValleyFrame mContext = this;

	public JLabel backgroundMap;
	public Player player;

	public int choice;

	public Farm farm;

	public Store store;
	public Keeper keeper;
	public Water waterMan;
	public Guide guide;
	public SeedZone seedZone;

	public HelpInfo info;
	public Status status;

	public TimeGauge timeGauge;

	public GameOver gameOver;
	public GameClear gameClear;
	
	public int victoryMoney = 100_000;

	public StardewValleyFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/bg/test.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(1930, 980);

		choice = 0;
		
		store = new Store(mContext);
		keeper = new Keeper(mContext);
		waterMan = new Water(mContext);
		guide = new Guide(mContext);
		seedZone = new SeedZone(mContext);

		info = new HelpInfo(mContext);
		timeGauge = new TimeGauge(mContext);
		farm = new Farm(mContext);

		player = new Player(mContext);

		status = new Status(mContext);
		gameOver = new GameOver(mContext);
		gameClear = new GameClear(mContext);

	}

	private void setInitLayout() {
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		add(player);

		add(store);
		add(keeper);
		add(waterMan);
		add(seedZone);
		add(guide);

		add(farm);
		add(info);
		add(timeGauge);

		add(gameOver);
		add(gameClear);

	}

	private void addEventListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 왼쪽으로 가능 상태 멈춤
					player.setLeft(false);
					player.setIcon(player.getPlayerL());
					break;
				case KeyEvent.VK_RIGHT:
					// 오른쪽으로 가능 상태 멈춤
					player.setRight(false);
					player.setIcon(player.getPlayerR());
					break;
				case KeyEvent.VK_UP:
					player.setUp(false);
					player.setIcon(player.getPlayerUp());
					break;
				case KeyEvent.VK_DOWN:
					player.setDown(false);
					player.setIcon(player.getPlayerDown());
					break;
				case KeyEvent.VK_F1:
					info.setVisibleTrue();
					break;
				case KeyEvent.VK_F2:
					info.setVisibleTrue();
					break;
				case KeyEvent.VK_F3:
					info.setVisibleTrue();
					break;
				default:
					break;
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (!player.isLeft()) {
						status.rePrice();
						player.left();
						waterMan.decreaseWaterImage();
						waterMan.minusPondGage();
						waterMan.decreaseWaterImage();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight()) {
						status.rePrice();
						player.right();
						waterMan.decreaseWaterImage();
						waterMan.minusPondGage();
						waterMan.decreaseWaterImage();
					}
					break;
				case KeyEvent.VK_UP:
					if (!player.isUp()) {
						status.rePrice();
						player.up();
						waterMan.decreaseWaterImage();
						waterMan.minusPondGage();
						waterMan.decreaseWaterImage();
					}
					break;
				case KeyEvent.VK_DOWN:
					if (!player.isDown()) {
						status.rePrice();
						player.down();
						waterMan.decreaseWaterImage();
						waterMan.minusPondGage();
						waterMan.decreaseWaterImage();
					}
					break;
				case KeyEvent.VK_Q:
					if (choice <= 0) {
						return;
					}
					player.stopPlant();
					if (player.isCreate()) {
						if (farm.vegetables[choice - 1] == null) {
							farm.vegetables[choice - 1] = player.createCarrot();
							player.setIcon(player.getPlayerWater());
							add(farm.vegetables[choice - 1]);
							farm.VLocation(choice);
							farm.waterValue(choice);
							farm.waterValueLocation(choice);
							status.statusRepaint();
						}
					}
					break;
				case KeyEvent.VK_W:
					if (choice <= 0) {
						return;
					}
					player.stopPlant();
					if (player.isCreate()) {
						if (farm.vegetables[choice - 1] == null) {
							farm.vegetables[choice - 1] = player.createParsnip();
							player.setIcon(player.getPlayerWater());
							add(farm.vegetables[choice - 1]);
							farm.VLocation(choice);
							farm.waterValue(choice);
							farm.waterValueLocation(choice);
							status.statusRepaint();
						}
					}
					break;
				case KeyEvent.VK_E:
					if (choice <= 0) {
						return;
					}
					player.stopPlant();
					if (player.isCreate()) {
						if (farm.vegetables[choice - 1] == null) {
							farm.vegetables[choice - 1] = player.createBerry();
							player.setIcon(player.getPlayerWater());
							add(farm.vegetables[choice - 1]);
							farm.VLocation(choice);
							farm.waterValue(choice);
							farm.waterValueLocation(choice);
							status.statusRepaint();
						}
					}
					break;
				case KeyEvent.VK_R:
					if (choice <= 0) {
						return;
					}
						if (farm.vegetables[choice - 1] != null) {
							if (farm.vegetables[choice - 1].getIcon() == farm.vegetables[choice - 1].rotten) {
								farm.remove(choice);
							}
							farm.harvest(choice);
						}
					status.statusRepaint();
					break;
				case KeyEvent.VK_D:
					if (keeper.isSaveOn()) {
						player.saveCrop();
					}
					break;
				case KeyEvent.VK_F:
					if (store.isSellOn()) {
						player.sellVegetable();
						status.statusRepaint();
					}
					break;
				case KeyEvent.VK_SPACE:
					if (player.isCreate()) {
						farm.sprinkling(choice);
						player.amountWater();
					}
					break;
				case KeyEvent.VK_A:
					if (player.isScoopWater() == true) {
						if (waterMan.getPondGage() < 5) {
							return;
						}
						player.setIcon(player.getPlayerWater());
						if (player.getSprinklingCanGage() < player.getMAX_CANGAGE()) {
							player.setSprinklingCanGage(player.getMAX_CANGAGE());
							waterMan.setPondGage(waterMan.getPondGage() - 5);
						}
						player.amountWater();
					}
					break;
				case KeyEvent.VK_M:
					if (seedZone.isSeedOn() || waterMan.getPondGage() == 0) {
						player.plusSeed();
						status.statusRepaint();
					}
					break;
				case KeyEvent.VK_NUMPAD1:
					choice = 7;
					guide.setGuideOn(new ImageIcon("img/npc/scarecrowOn_1.png"));
					break;
				case KeyEvent.VK_NUMPAD2:
					choice = 8;
					guide.setGuideOn(new ImageIcon("img/npc/scarecrowOn_2.png"));
					break;
				case KeyEvent.VK_NUMPAD3:
					choice = 9;
					guide.setGuideOn(new ImageIcon("img/npc/scarecrowOn_3.png"));
					break;
				case KeyEvent.VK_NUMPAD4:
					choice = 4;
					guide.setGuideOn(new ImageIcon("img/npc/scarecrowOn_4.png"));
					break;
				case KeyEvent.VK_NUMPAD5:
					choice = 5;
					guide.setGuideOn(new ImageIcon("img/npc/scarecrowOn_5.png"));
					break;
				case KeyEvent.VK_NUMPAD6:
					choice = 6;
					guide.setGuideOn(new ImageIcon("img/npc/scarecrowOn_6.png"));
					break;
				case KeyEvent.VK_NUMPAD7:
					choice = 1;
					guide.setGuideOn(new ImageIcon("img/npc/scarecrowOn_7.png"));
					break;
				case KeyEvent.VK_NUMPAD8:
					choice = 2;
					guide.setGuideOn(new ImageIcon("img/npc/scarecrowOn_8.png"));
					break;
				case KeyEvent.VK_NUMPAD9:
					choice = 3;
					guide.setGuideOn(new ImageIcon("img/npc/scarecrowOn_9.png"));
					break;
				case KeyEvent.VK_F1:
					info.setIcon(info.helpInfo);
					info.setVisibleFalse();
					break;
				case KeyEvent.VK_F2:
					info.setIcon(info.keyCommand);
					info.setVisibleFalse();
					break;
				case KeyEvent.VK_F3:
					info.setIcon(info.keepInfo);
					info.setVisibleFalse();
					break;
				default:
					break;
				}

			}
		});

	}

	public static void main(String[] args) {
		new StardewValleyFrame();
	}
	
}
