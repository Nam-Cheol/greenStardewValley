package stardewValley.A_PTH;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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

	private Store store;
	private Keeper keeper;
	private Water water;

	private Vegetable[] vegetables;

	private TimeGauge timeGauge;
	private ParsnipGauge parsnipGauge;
	private CarrotGauge carrotGauge;
	private BerryGauge berryGauge;
	private WaterGauge waterGauge;

//	private Vegetable parsnipCount;
//	private Vegetable carrotCount;
//	private Vegetable berryCount;

	private int tempMoney;
	private JLabel money;
	


	Graphics gold;

	private int temp = 0;

	private HelpInfo info;

//	private boolean q;

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

		tempMoney = 10_000;

		store = new Store(mContext);
		keeper = new Keeper(mContext);
		water = new Water(mContext);

		player = new Player(mContext, store, keeper, water);
		info = new HelpInfo(mContext);

		timeGauge = new TimeGauge(mContext);
		parsnipGauge = new ParsnipGauge(mContext);
		carrotGauge = new CarrotGauge(mContext);
		berryGauge = new BerryGauge(mContext);
		waterGauge = new WaterGauge(mContext);

		vegetables = new Vegetable[3];

//		q = false;
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

		add(info);

		add(timeGauge);
		add(parsnipGauge);
		add(carrotGauge);
		add(berryGauge);
		add(waterGauge);

		gold = backgroundMap.getGraphics();
		gold.setColor(Color.black);
		gold.setFont(new Font("굴림", Font.PLAIN, 50));
		gold.drawString(Integer.toString(tempMoney), 1400, 340);
		gold.dispose();
//		if(q) {
//		}
//		add(info);

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
				case KeyEvent.VK_F1:
					info.setIcon(info.getHelpInfo());
					info.setSize(50, 50);
					info.setLocation(1200, 15);
					keeper.setIcon(keeper.getKeeper());
					water.setIcon(water.getWater());
					player.setIcon(player.getPlayerDown());

				default:
					break;
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println(e.getKeyCode());
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
				case KeyEvent.VK_T:
					Vegetable.maxPlant = 2;
					System.out.println("씨앗 채워짐");
					break;
				case KeyEvent.VK_F1:
//					q = true;
//					add(info);
//					backgroundMap.add(info);
					info.setIcon(info.getHelpInfo1());
					info.setSize(800, 520);
					info.setLocation(200, 200);
					keeper.setIcon(null);
					water.setIcon(null);
//					System.out.println(e.getKeyCode());
					player.mContext.allStop();
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
		vegetables[i].setLocation(180 + (temp * i), 680);
	}

	public void vCount() {
				player.setCreate(true);
			System.out.println("Planted");
			if(Vegetable.maxPlant == 0){ // maxPlant == 0 이라면
				player.setCreate(false);
				System.out.println("end");
				return;
			}
		
	}

	public void harvest() {
		for (int i = 0; i < temp + 1; i++) {
			if (vegetables[temp] != null) {
				if (vegetables[temp].isCanHarvest()) {
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
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		new StardewValleyFrame();
	}

}
