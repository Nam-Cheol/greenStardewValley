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
				case KeyEvent.VK_NUMPAD1:
					if(player.isCreate()) {
						for(int i = 0; i < 3; i++) {
							if(vegetables[i] ==null) {
								vegetables[i] = player.createParsnip();;
								player.setIcon(player.getPlayerWater());
								add(vegetables[i]);
								break;
							}
						}
					}
					break;
				case KeyEvent.VK_NUMPAD2:
					if(player.isCreate()) {
						carrot = player.createCarrot();
						player.setIcon(player.getPlayerWater());
						add(carrot);
					}
					break;
				case KeyEvent.VK_NUMPAD3:
					if(player.isCreate()) {
						berry = player.createBerry();
						player.setIcon(player.getPlayerWater());
						add(berry);
					}
				case KeyEvent.VK_NUMPAD4:
					vegetables[0].setIcon(null);
					break;
				case KeyEvent.VK_Q:
					if(player.isSellParsnip()) {
						System.out.println(store.getParsnipPrice());
					}
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
	
	public Player getPlayer() {
		return player;
	}

	public static void main(String[] args) {
		new StardewValleyFrame();
	}
}
