package stardewValley.A_KNC;

import java.awt.Font;
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

	private int tempMoney;
	private JLabel money;
	
	private Gold gold;
	
	
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

		tempMoney = 9999;
		
		store = new Store(mContext);
		keeper = new Keeper(mContext);
		waterMan = new Water(mContext);
		
		player = new Player(mContext, store, keeper, waterMan);
		
		timeGauge = new TimeGauge(mContext);
		carrotGauge = new CarrotGauge(mContext);
		waterGauge = new WaterGauge(mContext);
		berryGauge = new BerryGauge(mContext);
		parsnipGauge = new ParsnipGauge(mContext);
		
		Font f = new Font("PF스타더스트", Font.PLAIN, 3);

		gold = new Gold();
		
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
		
		add(timeGauge);
		add(carrotGauge);
		add(waterGauge);
		add(berryGauge);
		add(parsnipGauge);
		add(gold);
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
				case KeyEvent.VK_D:
					System.out.println("동작중");
					break;
				case KeyEvent.VK_F:
					if (player.isSellParsnip()) {
						System.out.println(store.getParsnipPrice());
					}
					break;
				case KeyEvent.VK_SPACE:
					System.out.println("동작중");
					break;
				case KeyEvent.VK_A:
					System.out.println("동작중");
					break;
				case KeyEvent.VK_F1:
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
