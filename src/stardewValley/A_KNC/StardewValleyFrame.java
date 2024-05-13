package stardewValley.A_KNC;

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
	
	private int tempMoney;

	private Status status;
	
	private int temp = 0;

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

		
		
		tempMoney = 0;
		
		store = new Store(mContext);
		keeper = new Keeper(mContext);
		waterMan = new Water(mContext);
		
		player = new Player(mContext, store, keeper, waterMan);
		info = new HelpInfo(mContext);
		
		timeGauge = new TimeGauge(mContext);
		carrotGauge = new CarrotGauge(mContext);
		waterGauge = new WaterGauge(mContext);
		berryGauge = new BerryGauge(mContext);
		parsnipGauge = new ParsnipGauge(mContext);
		
		status = new Status(mContext, player, store, keeper, waterMan);
		
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
					waterMan.setIcon(waterMan.getWater());
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
					if (player.isSellParsnip()) {
						System.out.println(store.getParsnipPrice());
					}
					break;
				case KeyEvent.VK_SPACE:
					System.out.println("동작중");
					player.setMoney(player.getMoney() + 10000);
					status.getWallet().setText(Integer.toString(player.getMoney()));
					break;
				case KeyEvent.VK_A:
					parsnipGauge.setIcon(parsnipGauge.getParsnipGauge1());
					break;
				case KeyEvent.VK_F1:
					info.setIcon(info.getHelpInfo1());
					info.setSize(800, 520);
					info.setLocation(200, 200);
					keeper.setIcon(null);
					waterMan.setIcon(null);
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
		for (int i = 0; i < temp + 1; i++) {
			if (vegetables[temp] != null) {
				if (vegetables[temp].isCanHarvest()) {
					System.out.println(vegetables[temp].name + "을 수확했다.");
					// 작물 종류에 따라서 플레이어의 작물 보유량 증가
					if (vegetables[temp] instanceof Parsnip) {
						player.setHaveParsnip(player.getHaveParsnip() + 1);
						System.out.println("파스닙의 갯수 :" + player.getHaveParsnip());
					} else if (vegetables[temp] instanceof Carrot) {
						player.setHaveCarrot(player.getHaveCarrot() + 1);
						System.out.println("당근의 갯수 :" + player.getHaveCarrot());
					} else if (vegetables[temp] instanceof Strawberry) {
						player.setHaveBerry(player.getHaveBerry() + 1);
						System.out.println("딸기의 갯수 :" + player.getHaveBerry());
					}
					vegetables[temp].setCanHarvest(false);
					vegetables[temp].setIcon(null);
					vegetables[temp] = null;
					System.out.println(temp);
					temp++;
					if (temp == 3) {
						temp = 0;
					}
					System.out.println(temp);
					System.out.println();
					break;
				} else {
					System.out.println(vegetables[temp].name + "은 지금은 자라는 중이다.");
					break;
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
	
	public static void main(String[] args) {
		new StardewValleyFrame();
	}
}
