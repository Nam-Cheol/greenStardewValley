package stardewValley.A_PTH;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

//TODO 생성자가 호출될 때 플레이어가 생성되어야 함.
// 배경 추가해야 됨.
//추후 컴포넌트(야채)들도 추가해야 함.
public class StardewValleyFrame extends JFrame {

	StardewValleyFrame mContext = this;

	private JLabel backgroundMap;
	private Player player;

	private int temp = 0;
	private Vegetable[] vegetables;

	private Store store;
	private Keeper keeper;
	private Water waterMan;

	private TimeGauge timeGauge;
	private CarrotGauge carrotGauge;
	private WaterGauge waterGauge;
	private BerryGauge berryGauge;
	private ParsnipGauge parsnipGauge;

	private HelpInfo info;
	private Status status;

	public StardewValleyFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/TempBackgroundMap.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(1930, 980);

		store = new Store(mContext);
		keeper = new Keeper(mContext);
		waterMan = new Water(mContext);

		player = new Player(mContext, store, keeper, waterMan, status);
		info = new HelpInfo(mContext);

		timeGauge = new TimeGauge(mContext);
		carrotGauge = new CarrotGauge(mContext);
		waterGauge = new WaterGauge(mContext);
		berryGauge = new BerryGauge(mContext);
		parsnipGauge = new ParsnipGauge(mContext);

		status = new Status(mContext, player, store, keeper, waterMan);
		new Thread(new Runnable() {

			@Override
			public void run() {
				status.getParsnipPrice().setText(Integer.toString(store.getParsnipPrice()));
			}
		}).start();
		vegetables = new Vegetable[3];

//		new Thread(store).start();
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
		add(info);

		add(timeGauge);
		add(carrotGauge);
		add(waterGauge);
		add(berryGauge);
		add(parsnipGauge);

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
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight()) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					if (!player.isUp()) {
						player.up();
					}
					break;
				case KeyEvent.VK_DOWN:
					if (!player.isDown()) {
						player.down();
					}
					break;
				case KeyEvent.VK_Q:
					vCount();
					if (player.isCreate()) {
						for (int i = 0; i < 3; i++) {
							if (vegetables[i] == null) {
								vegetables[i] = player.createParsnip();
								player.setIcon(player.getPlayerWater());
								add(vegetables[i]);
								VLocation(i);
								break;
							}
						}
					}
					break;
				case KeyEvent.VK_W:
					vCount();
					if (player.isCreate()) {
						for (int i = 0; i < 3; i++) {
							if (vegetables[i] == null) {
								vegetables[i] = player.createCarrot();
								player.setIcon(player.getPlayerWater());
								add(vegetables[i]);
								VLocation(i);
								break;
							}
						}
					}
					break;
				case KeyEvent.VK_E:
					vCount();
					if (player.isCreate()) {
						for (int i = 0; i < 3; i++) {
							if (vegetables[i] == null) {
								vegetables[i] = player.createBerry();
								player.setIcon(player.getPlayerWater());
								add(vegetables[i]);
								VLocation(i);
								break;
							}
						}
					}
					break;
				case KeyEvent.VK_R:
					harvest();
					break;
				case KeyEvent.VK_D:
					saveCrop();
					break;
				case KeyEvent.VK_F:
					sellCrop();
					break;
				case KeyEvent.VK_NUMPAD1:
					if (vegetables != null) {

					}
					break;
				case KeyEvent.VK_NUMPAD2:

					break;
				case KeyEvent.VK_NUMPAD3:

					break;
				case KeyEvent.VK_NUMPAD4:

					break;
				case KeyEvent.VK_NUMPAD5:

					break;
				case KeyEvent.VK_NUMPAD6:

					break;
				case KeyEvent.VK_NUMPAD7:

					break;
				case KeyEvent.VK_NUMPAD8:

					break;
				case KeyEvent.VK_NUMPAD9:
					break;
				case KeyEvent.VK_M:
					for (int i = 0; i < 9; i++) {
						vegetables[i] = null;
					}
					break;
				case KeyEvent.VK_SPACE:
					Vegetable.MAX_PLANT = 5;
					System.out.println("동작중");
					player.setMoney(player.getMoney() + 10000);
					status.getWallet().setText(Integer.toString(player.getMoney()));
					if (player.isCreate()) {
						if (0 < player.getSprinklingCanGage()) {
							player.setIcon(player.getPlayerWater());
							player.setSprinklingCanGage(player.getSprinklingCanGage() - 1);

							if (player.getSprinklingCanGage() == 4) {
								waterGauge.setIcon(waterGauge.getWaterGauge4());
							}
							if (player.getSprinklingCanGage() == 3) {
								waterGauge.setIcon(waterGauge.getWaterGauge3());
							}
							if (player.getSprinklingCanGage() == 2) {
								waterGauge.setIcon(waterGauge.getWaterGauge2());
							}
							if (player.getSprinklingCanGage() == 1) {
								waterGauge.setIcon(waterGauge.getWaterGauge1());
							}
							if (player.getSprinklingCanGage() == 0) {
								waterGauge.setIcon(waterGauge.getWaterGauge());
							}

							System.out.println("밭에 물 준 후에 물뿌리개 : " + player.getSprinklingCanGage());
							vegetables[0].setWaterGage(vegetables[0].getWaterGage() + 1);
							vegetables[1].setWaterGage(vegetables[1].getWaterGage() + 1);
							vegetables[2].setWaterGage(vegetables[2].getWaterGage() + 1);
							System.out.println("식물이 받은 물 : " + vegetables[0].getWaterGage());
						} else {
							System.out.println("연못에 가서 물을 채우세요.");
						}
					}
					break;
				case KeyEvent.VK_A:
					parsnipGauge.setIcon(parsnipGauge.getParsnipGauge1());
					break;
				case KeyEvent.VK_F1:
					info.setIcon(info.getHelpInfo1());
					info.setSize(800, 520);
					info.setLocation(200, 200);
					keeper.setIcon(null);
					keeper.setSeeNPC(true);
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

	public void allStop() {
		player.setLeft(false);
		player.setRight(false);
		player.setUp(false);
		player.setDown(false);
	}

	public void VLocation(int i) {
		int temp = 60;
		vegetables[i].setLocation(190 + (temp * i), 690);
	}

	public void harvest() {
		for (int i = 0; i < 3; i++) {

			if (vegetables[i] != null) {
				System.out.println("인식은 했음");
				if (vegetables[i].isCanHarvest()) {
					System.out.println(vegetables[i].getName() + "을 수확했다.");
					// 작물 종류에 따라 플레이어의 작물 보유량 증가
					if (vegetables[i] instanceof Parsnip) {
						player.setHaveParsnip(player.getHaveParsnip() + 1);
						System.out.println("파스닙의 갯수 : " + player.getHaveParsnip());
					} else if (vegetables[i] instanceof Carrot) {
						player.setHaveCarrot(player.getHaveCarrot() + 1);
						System.out.println("당근의 갯수 : " + player.getHaveCarrot());
					} else if (vegetables[i] instanceof Strawberry) {
						player.setHaveBerry(player.getHaveBerry() + 1);
						System.out.println("딸기의 갯수 : " + player.getHaveBerry());
					}
					vegetables[i].setIcon(null);
					vegetables[i] = null;
					break;
				} else {
					System.out.println(vegetables[temp].getName() + " 은(는) 지금 자라는 중이다.");
				}
			}
		}
	}

	public void saveCrop() {
		System.out.println("작물 저장");
		keeper.setParsnipEach(keeper.getParsnipEach() + player.getHaveParsnip());
		player.setHaveParsnip(0);

		keeper.setCarrotEach(keeper.getCarrotEach() + player.getHaveCarrot());
		player.setHaveCarrot(0);

		keeper.setBerryEach(keeper.getBerryEach() + player.getHaveBerry());
		player.setHaveBerry(0);

		status.getParsnip().setText(Integer.toString(keeper.getParsnipEach()));
		status.getCarrot().setText(Integer.toString(keeper.getCarrotEach()));
		status.getBerry().setText(Integer.toString(keeper.getBerryEach()));
	}

	public void sellCrop() {
		System.out.println("작물을 판다. 동작확인");
		System.out.println("현재 파스닙 가격" + store.getParsnipPrice());
		if (keeper.getParsnipEach() == 0) {
			System.out.println("보관된 파스닙이 없습니다.");
		} else {
			player.setMoney(player.getMoney() + (keeper.getParsnipEach() * store.getParsnipPrice()));
			keeper.setParsnipEach(0);
			status.getWallet().setText(Integer.toString(player.getMoney()));
			System.out.println("플레이어가 파스닙 팔아서 창고에 남은 갯수 " + keeper.getParsnipEach());
		}
	}

	public void vCount() {
		if (Vegetable.MAX_PLANT == 0) {
			player.setCreate(false);
//			temp = 0;
			return;
		}
	}

	public Vegetable[] getVegetables() {
		return vegetables;
	}

	public void setVegetables(Vegetable[] vegetables) {
		this.vegetables = vegetables;
	}

	public static void main(String[] args) {
		new StardewValleyFrame();
	}
}
