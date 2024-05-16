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
	public Player player;

	public int choice;

	public Farm farm;

	private Store store;
	private Keeper keeper;
	private Water waterMan;
	private Guide guide;
	
	private CarrotGauge carrotGauge;
	private BerryGauge berryGauge;
	private ParsnipGauge parsnipGauge;
	private Water waterGauge;

	private HelpInfo info;
	private Status status;

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


		store = new Store(mContext);
		keeper = new Keeper(mContext);
		waterMan = new Water(mContext);
		guide = new Guide(mContext);

		player = new Player(mContext, store, keeper, waterMan, guide);
		info = new HelpInfo(mContext);

		carrotGauge = new CarrotGauge(mContext);
		berryGauge = new BerryGauge(mContext);
		parsnipGauge = new ParsnipGauge(mContext);
		waterGauge = new Water(mContext);

		status = new Status(mContext, player, store, keeper, waterMan);

		farm = new Farm(mContext, player);
		
		choice = 0;
		
		status.getParsnipPrice().setText(Integer.toString(store.getParsnipPrice()));

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

		add(waterGauge);
		add(carrotGauge);
		add(berryGauge);
		add(parsnipGauge);
		add(farm);
		add(guide);

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
					if (player.isCreate()) {
						if (farm.vegetables[choice-1] == null) {
							farm.vegetables[choice-1] = player.createParsnip();
							player.setIcon(player.getPlayerWater());
							add(farm.vegetables[choice-1]);
							farm.VLocation(choice);
							farm.waterValue(choice);
							farm.waterValueLocation(choice);
						}
					}
					break;
				case KeyEvent.VK_W:
					if (player.isCreate()) {
							if (farm.vegetables[choice-1] == null) {
								farm.vegetables[choice-1] = player.createCarrot();
								player.setIcon(player.getPlayerWater());
								add(farm.vegetables[choice-1]);
								farm.VLocation(choice);
								farm.waterValue(choice);
								farm.waterValueLocation(choice);
						}
					}
					break;
				case KeyEvent.VK_E:
					if (player.isCreate()) {
						if (farm.vegetables[choice-1] == null) {
							farm.vegetables[choice-1] = player.createBerry();
							player.setIcon(player.getPlayerWater());
							add(farm.vegetables[choice-1]);
							farm.VLocation(choice);
							farm.waterValue(choice);
							farm.waterValueLocation(choice);
						}
					}
					break;
				case KeyEvent.VK_R:
					if(farm.vegetables[choice-1] != null) {
						if(farm.vegetables[choice-1].getIcon() == farm.vegetables[choice-1].rotten) {
							farm.remove(choice);
						}
						farm.harvest(choice);
					}
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
						saveProducts();
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
						if (player.getSprinklingCanGage() < player.getMaxCanGauge()) {
							player.setSprinklingCanGage(player.getMaxCanGauge());
							waterMan.setPondGage(waterMan.getPondGage() - 5);
							player.amountWater();
						} else {
							System.out.println("물뿌리개가 이미 가득 찼어요.");
							return;
						}
					}
					break;
				case KeyEvent.VK_P:
					Vegetable.MAX_PLANT = 5;
					break;
				case KeyEvent.VK_NUMPAD1:
					choice = 7;
					break;
				case KeyEvent.VK_NUMPAD2:
					choice = 8;
					break;
				case KeyEvent.VK_NUMPAD3:
					choice = 9;
					break;
				case KeyEvent.VK_NUMPAD4:
					choice = 4;
					break;
				case KeyEvent.VK_NUMPAD5:
					choice = 5;
					break;
				case KeyEvent.VK_NUMPAD6:
					choice = 6;
					break;
				case KeyEvent.VK_NUMPAD7:
					choice = 1;
					break;
				case KeyEvent.VK_NUMPAD8:
					choice = 2;
					break;
				case KeyEvent.VK_NUMPAD9:
					choice = 3;
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

		saveProducts();
	}

	public void sellParsnip() {
		if (keeper.getParsnipEach() == 0) {
			System.out.println("보관된 파스닙이 없습니다.");
		} else {
			player.setMoney(player.getMoney() + (keeper.getParsnipEach() * store.getParsnipPrice()));
			keeper.setParsnipEach(0);
			status.getWallet().setText(Integer.toString(player.getMoney()));
			System.out.println("플레이어가 파스닙 팔아서 창고에 남은 갯수 " + keeper.getParsnipEach());
		}
	}

	public void sellCarrot() {
		if (keeper.getCarrotEach() == 0) {
			System.out.println("보관된 당근이 없습니다.");
		} else {
			player.setMoney(player.getMoney() + (keeper.getCarrotEach() * store.getCarrotPrice()));
			keeper.setCarrotEach(0);
			status.getWallet().setText(Integer.toString(player.getMoney()));
			System.out.println("플레이어가 파스닙 팔아서 창고에 남은 갯수 " + keeper.getCarrotEach());
		}
	}

	public void sellBerry() {
		if (keeper.getBerryEach() == 0) {
			System.out.println("보관된 딸기가 없습니다.");
		} else {
			player.setMoney(player.getMoney() + (keeper.getBerryEach() * store.getBerryPrice()));
			keeper.setBerryEach(0);
			status.getWallet().setText(Integer.toString(player.getMoney()));
			System.out.println("플레이어가 파스닙 팔아서 창고에 남은 갯수 " + keeper.getBerryEach());
		}
	}

	public void vCount() {
		if (Vegetable.MAX_PLANT == 0) {
			player.setCreate(false);
			return;
		}
	}

	public void saveProducts() {
		status.getParsnip().setText(Integer.toString(keeper.getParsnipEach()));
		status.getCarrot().setText(Integer.toString(keeper.getCarrotEach()));
		status.getBerry().setText(Integer.toString(keeper.getBerryEach()));
	}
	
	public static void main(String[] args) {
		new StardewValleyFrame();
	}
}
