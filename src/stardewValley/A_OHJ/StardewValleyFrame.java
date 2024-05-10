package stardewValley.A_OHJ;

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

	private Vegetable parsnip;
	private Vegetable carrot;
	private Vegetable berry;
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
					// 파스닙 심기
					if (player.isCreate()) {
						for (int i = 0; i < 3; i++) {
							System.out.println("Q키 : 파스닙 심기");
							if (vegetables[i] == null) {
								vegetables[i] = player.createParsnip();
//								player.setIcon(player.getPlayerWater());
								add(vegetables[i]);
								VLocation(i);
								break;
							}
						}
					}
					break;
				case KeyEvent.VK_W:
					// 당근 심기
					if (player.isCreate()) {
						for (int i = 0; i < 3; i++) {
							System.out.println("W키 : 당근 심기");
							if (vegetables[i] == null) {
								vegetables[i] = player.createCarrot();
//								player.setIcon(player.getPlayerWater());
								add(vegetables[i]);
								VLocation(i);
								break;
							}
						}
					}
					break;
				case KeyEvent.VK_E:
					// 딸기 심기
					if (player.isCreate()) {
						for (int i = 0; i < 3; i++) {
							System.out.println("E키 : 딸기 심기");
							if (vegetables[i] == null) {
								vegetables[i] = player.createBerry();
//								player.setIcon(player.getPlayerWater());
								add(vegetables[i]);
								VLocation(i);
								break;
							}
						}
					}
				case KeyEvent.VK_R:
					// 수확하기
					if (player.isCreate()) {
						harvest();
						break;
					}
					break;
				case KeyEvent.VK_SPACE:
					// 물 주기
					if (player.isCreate()) {
						if(0 < player.getSprinklingCanGage()) {
							player.setIcon(player.getPlayerWater());
							player.setSprinklingCanGage(player.getSprinklingCanGage() - 1);
							System.out.println("밭에 물 준 후에 물뿌리개 : " + player.getSprinklingCanGage());
						}else {
							System.out.println("연못에 가서 물을 채우세요.");
						}
					}
					break;

				case KeyEvent.VK_F:
					// 상점에 팔기
					if (player.isSellParsnip()) {
						System.out.println(store.getParsnipPrice());
					}
					break;

				case KeyEvent.VK_A:
					water.minusPondGage();
					// 연못에서 물 채우기
					if (player.isScoopWater() == true) {
						player.setIcon(player.getPlayerWater());
						System.out.println("채우기 전" + player.getSprinklingCanGage());
						System.out.println("연못 전 : " + water.getPondGage());
						if (player.getSprinklingCanGage() < player.getMAX_CANGAGE()) {
							player.setSprinklingCanGage(10);
							water.setPondGage(water.getPondGage() - 10);
							System.out.println("채운 후" + player.getSprinklingCanGage());
							System.out.println("연못 후 : " + water.getPondGage());
						} else {
							System.out.println("물뿌리개가 이미 가득 찼어요.");
						}
					}

					break;

				case KeyEvent.VK_D:
					// 창고에 저장
					System.out.println("동작중");
					break;
				case KeyEvent.VK_F1:
					// 도움말, 게임 설명
					System.out.println("동작중");
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
					vegetables[temp].setCanHarvest(false);
					vegetables[temp].setIcon(null);
					vegetables[temp] = null;
					System.out.println(temp);
					temp++;
					if (temp == 3) {
						temp = 0;
					}
					System.out.println(temp);
					break;
				} else {
					System.out.println(vegetables[temp].name + "은 지금은 자라는 중이다.");
					break;
				}
			}
		}
	}

	public Player getPlayer() {
		return player;
	}

	public static void main(String[] args) {
		new StardewValleyFrame();
	}
}
