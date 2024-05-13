package stardewValley.A_CYJ;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import stardewValley.vegetable.vegetable;

//TODO 생성자가 호출될 때 플레이어가 생성되어야 함.
// 배경 추가해야 됨.
//추후 컴포넌트(야채)들도 추가해야 함.
public class StardewValleyFrame extends JFrame {

	StardewValleyFrame mContext = this;

	private JLabel backgroundMap;
	private Player player;

	private Vegetable[] vegetables;

	private Vegetable sNum;

	private Store store;
	private Keeper keeper;
	private Water water;

	int temp = 0;

	public StardewValleyFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(1930, 980);

		store = new Store(mContext);
		keeper = new Keeper(mContext);
		water = new Water(mContext);
		player = new Player(mContext, store, keeper, water);

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
		add(water);
		System.out.println(store.getX());
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
				case KeyEvent.VK_S:
					sellCrop();
//					if (player.isSellParsnip()) {
//						System.out.println(store.getParsnipPrice());
//					}
					break;
				case KeyEvent.VK_D:
					saveCrop();

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
					System.out.println(vegetables[temp].getsNum());
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

	// 저장하는 기능
	public void saveCrop() {
		System.out.println("작물 저장");
		keeper.setParsnipEach(keeper.getParsnipEach() + player.getHaveParsnip());
		player.setHaveParsnip(0);
		System.out.println("창고 파스닙 : " + keeper.getParsnipEach());
		System.out.println("플레이어 파스닙의 갯수 :" + player.getHaveParsnip());

		keeper.setCarrotEach(keeper.getCarrotEach() + player.getHaveCarrot());
		player.setHaveCarrot(0);
		System.out.println("창고 당근 : " + keeper.getCarrotEach());
		System.out.println("플레이어 당근의 갯수 " + player.getHaveCarrot());

		keeper.setBerryEach(keeper.getBerryEach() + player.getHaveBerry());
		player.setHaveBerry(0);
		System.out.println("창고 딸기 :" + keeper.getBerryEach());
		System.out.println("플레이어 딸기의 갯수" + player.getHaveBerry());
	}

	// 작물을 파는 기능
	public void sellCrop() {
		System.out.println("작물을 판다. 동작확인");
		System.out.println("현재 파스닙 가격" + store.getParsnipPrice());
		if (keeper.getParsnipEach() == 0) {
			System.out.println("보관된 파스닙이 없습니다.");
		} else {
			player.setWallet(keeper.getParsnipEach() * store.getParsnipPrice());
			keeper.setParsnipEach(0);
			System.out.println(player.getWallet());
			System.out.println("플레이어가 파스닙 팔아서 창고에 남은 갯수 " + keeper.getParsnipEach());
		}
	}

	public static void main(String[] args) {
		new StardewValleyFrame();
	}
}
