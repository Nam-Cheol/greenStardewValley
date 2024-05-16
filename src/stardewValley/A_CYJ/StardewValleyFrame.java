package stardewValley.A_CYJ;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StardewValleyFrame extends JFrame {

	StardewValleyFrame mContext = this;

	private JLabel backgroundMap;
	public Player player;

	public int choice;

	public Farm farm;

	private Store store;
	private Keeper keeper;
	private Water waterMan;
	private Guide guide;
	private SeedZone seedZone;

	private HelpInfo info;
	private Status status;
	
	public Vegetable vegetable;
	private TimeGauge timeGauge;
	
	private GameOver gameOver;
	private GameClear gameClear;
	
	private int turn;

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
		turn = 1;
		
		store = new Store(mContext);
		keeper = new Keeper(mContext);
		waterMan = new Water(mContext);
		guide = new Guide(mContext);
		seedZone = new SeedZone(mContext);
		
		timeGauge = new TimeGauge(mContext);
		info = new HelpInfo(mContext);
		player = new Player(mContext, store, keeper, waterMan, guide, seedZone);
		farm = new Farm(mContext, player);
		status = new Status(mContext, player, store, keeper, waterMan);
		
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
		add(info);
		add(farm);
		add(guide);
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
					info.setIcon(info.getHelpInfo());
					info.setSize(50, 50);
					info.setLocation(1200, 15);
					keeper.setIcon(keeper.getKeeper());
					keeper.setSeeNPC(false);
					waterMan.setIcon(waterMan.getWater());
					waterMan.setSeeNPC(false);
					player.setIcon(player.getPlayerDown());
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
					vCount();
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
					vCount();
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
					vCount();
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
						saveCrop();
					}
					break;
				case KeyEvent.VK_F:
					if (store.isSellOn()) {
						sellParsnip();
						sellCarrot();
						sellBerry();
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
						if(waterMan.getPondGage() < 5) {
							return;
						}
						player.setIcon(player.getPlayerWater());
						if (player.getSprinklingCanGage() < player.getMAX_CANGAGE()) {
							player.setSprinklingCanGage(player.getMAX_CANGAGE());
							waterMan.setPondGage(waterMan.getPondGage() - 5);
						} else {
//							return;
						}
						player.amountWater();
					}
					break;
				case KeyEvent.VK_M:
					if (seedZone.isSeedOn()) {
						plusSeed();
						status.statusRepaint();
						if(turn == 2) {
//							timeGauge.setIcon(timeGauge.getTimeGauge1());
						}
						seedZone.setSeedOn(false);
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
					info.setIcon(info.getHelpInfo1());
					info.setSize(800, 520);
					info.setLocation(200, 200);
					keeper.setSeeNPC(true);
					keeper.setIcon(null);
					waterMan.setIcon(null);
					waterMan.setSeeNPC(true);
					player.setIcon(null);
				
					break;
				default:
					break;
				}

			}
		});

	}

	public void saveCrop() {
		System.out.println("작물 저장");
		keeper.setParsnipEach(keeper.getParsnipEach() + player.getHaveParsnip());
		player.setHaveParsnip(0);

		keeper.setCarrotEach(keeper.getCarrotEach() + player.getHaveCarrot());
		player.setHaveCarrot(0);

		keeper.setBerryEach(keeper.getBerryEach() + player.getHaveBerry());
		player.setHaveBerry(0);

		status.statusRepaint();
	}

	public void sellCarrot() {
		if (keeper.getCarrotEach() == 0) {
		} else {
			player.setMoney(player.getMoney() + (keeper.getCarrotEach() * store.getCarrotPrice()));
			keeper.setCarrotEach(0);
			status.getWallet().setText(Integer.toString(player.getMoney()));
		}
	}

	public void sellParsnip() {
		if (keeper.getParsnipEach() == 0) {
		} else {
			player.setMoney(player.getMoney() + (keeper.getParsnipEach() * store.getParsnipPrice()));
			keeper.setParsnipEach(0);
			status.getWallet().setText(Integer.toString(player.getMoney()));
		}
	}
	
	public void sellBerry() {
		if (keeper.getBerryEach() == 0) {
		} else {
			player.setMoney(player.getMoney() + (keeper.getBerryEach() * store.getBerryPrice()));
			keeper.setBerryEach(0);
			status.getWallet().setText(Integer.toString(player.getMoney()));
		}
	}

	public void vCount() {
		if (Vegetable.MAX_PLANT == 0) {
			player.setCreate(false);
			return;
		}
	}

	public void plusSeed() {
		if (vegetable.getMAX_PLANT() == 0) {
			if (turn == 1) {
				if (vegetable.getMAX_PLANT() == 0) {
					vegetable.setMAX_PLANT(1);
				}
				timeGauge.setIcon(timeGauge.getTimeGauge1());
				turn++;
			} else if (turn == 2) {
				if (vegetable.getMAX_PLANT() == 0) {
					vegetable.setMAX_PLANT(2);
				}
				timeGauge.setIcon(timeGauge.getTimeGauge2());
				turn++;
			} else if (turn == 3 && player.getMoney() <= 300) {
				gameOver.setIcon(gameOver.getGameOver());
				gameOver.setSize(1930, 930);
				gameOver.setLocation(0, 0);
				player.setIcon(null);
				player = null;
				keeper.setSeeNPC(true);
				keeper.setIcon(null);
				waterMan.setIcon(null);
				waterMan.setSeeNPC(true);
				store.setIcon(null);
				store.setSeeNPC(true);
				info.setIcon(null);
				timeGauge.setIcon(null);
				waterMan.removeWaterGage();
				
				store = null;
				keeper = null;
				waterMan = null;
				guide = null;
				seedZone = null;
				status.removeText();

			} else if (turn == 3 && player.getMoney() >= 300) {
				gameOver.setIcon(gameClear.getGameClear());
				gameOver.setSize(1930, 930);
				gameOver.setLocation(0, 0);
				keeper.setSeeNPC(true);
				keeper.setIcon(null);
				waterMan.setIcon(null);
				waterMan.setSeeNPC(true);
				store.setIcon(null);
				store.setSeeNPC(true);
				player.setIcon(null);
				info.setIcon(null);
				status.removeText();
				player = null;
			}
		}
	}
	
	public Status getStatus() {
		return status;
	}
	
	public static void main(String[] args) {
		new StardewValleyFrame();
	}
}
