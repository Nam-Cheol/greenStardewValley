package stardewValley.A_OHJ;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//TODO 플레이어의 기능 추가, 포함관계여야 함
public class Player extends JLabel implements Moveable {

	// TODO player 의 속성

	Parsnip parsnip;
	Carrot carrot;
	Strawberry berry;
	StardewValleyFrame mContext;

	// 플레이어의 이미지

	// 플레이어 왼쪽 이미지
	private ImageIcon playerL;
	private ImageIcon playerL1;
	private ImageIcon playerL2;

	// 플레이어 오른쪽 이미지
	private ImageIcon playerR;
	private ImageIcon playerR1;
	private ImageIcon playerR2;

	// 플레이어 위 이미지
	private ImageIcon playerUp;
	private ImageIcon playerUp1;
	private ImageIcon playerUp2;

	// 플레이어 아래 이미지
	private ImageIcon playerDown; // -> 디폴트
	private ImageIcon playerDown1;
	private ImageIcon playerDown2;

	private ImageIcon playerWater;

	private Store store;
	private Keeper keeper;
	private Water water;

	// 플레이어의 좌표
	private int x;
	private int y;

	// 움직임의 on/off
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	PlayerWay playerWay;

	// 벽에 충돌 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;
	private boolean upWallCrash;
	private boolean downWallCrash;

	// 플레이어 속도 상태
	private final int SPEED = 20;

	private boolean create;

	// 우물에서 물 퍼낼 때
	private boolean scoopWater;
	private int sprinklingCanGage;
	private final int MAX_CANGAGE = 5;

	private int wallet;

	private boolean sellParsnip;

	// TODO 생성자 및 데이터 구축
	public Player(StardewValleyFrame mContext, Store store, Keeper keeper, Water water) {
		this.store = store;
		this.keeper = keeper;
		this.water = water;
		initData();
		setInitLayout();
		this.mContext = mContext;
		new Thread(new backgroundPlayerMapService(this, store, keeper, water)).start();
	}

	private void initData() {

		x = 600;
		y = 600;

		playerL = new ImageIcon("img/PlayerStandLeft.png");
		playerL1 = new ImageIcon("img/PlayerWalkLeft.png");
		playerL2 = new ImageIcon("img/PlayerWalkLeft2.png");

		playerR = new ImageIcon("img/PlayerStandRight.png");
		playerR1 = new ImageIcon("img/PlayerWalkRight.png");
		playerR2 = new ImageIcon("img/PlayerWalkRight2.png");

		playerUp = new ImageIcon("img/PlayerStandUp.png");
		playerUp1 = new ImageIcon("img/PlayerWalkUp.png");
		playerUp2 = new ImageIcon("img/PlayerWalkUp2.png");

		playerDown = new ImageIcon("img/PlayerStand.png");
		playerDown1 = new ImageIcon("img/PlayerWalkDown.png");
		playerDown2 = new ImageIcon("img/PlayerWalkDown2.png");

		playerWater = new ImageIcon("img/PlayerWater.png");

		left = false;
		right = false;
		up = false;
		down = false;

		create = false;

		// 우물에서 물 퍼낼 때
		scoopWater = false;
		sprinklingCanGage = 0;

		leftWallCrash = false;
		rightWallCrash = false;
		upWallCrash = false;
		downWallCrash = false;

		playerWay = PlayerWay.DOWN;

		wallet = 0;
		sellParsnip = true;
	}

	private void setInitLayout() {
		this.setIcon(playerDown);
		this.setLocation(x, y);
		this.setSize(100, 120);

	}

	// TODO 움직임 구현
	@Override
	public void left() {
		playerWay = PlayerWay.LEFT;
		left = true;
		setIcon(playerL);

		new Thread(new Runnable() {

			@Override
			public void run() {
				int leftNum = 0;
				while (left) {
					setRight(false);
					setUp(false);
					setDown(false);
					delay();
					if (leftWallCrash) {
						break;
					} else {
						left = true;
					}

					if (leftNum % 2 == 0) {
						setIcon(playerL1);
						leftNum++;
						delay2();
					} else {
						setIcon(playerL2);
						leftNum++;
						delay2();
					}

					x -= SPEED;
					setLocation(x, y);
				}
				left = false;
			}
		}).start();

	}

	@Override
	public void right() {
		playerWay = PlayerWay.RIGHT;
		right = true;
		setIcon(playerR);

		new Thread(new Runnable() {

			@Override
			public void run() {
				int rightNum = 0;
				while (right) {
					setLeft(false);
					setUp(false);
					setDown(false);
					delay();
					if (rightWallCrash) {
						break;
					} else {
						right = true;
					}

					if (rightNum % 2 == 0) {
						setIcon(playerR1);
						rightNum++;
						delay2();
					} else {
						setIcon(playerR2);
						rightNum++;
						delay2();
					}
					x += SPEED;
					setLocation(x, y);
				}
				right = false;

			}
		}).start();
	}

	@Override
	public void up() {
		playerWay = PlayerWay.UP;
		up = true;
		setIcon(playerUp);

		new Thread(new Runnable() {

			@Override
			public void run() {
				int upNum = 0;
				while (up) {
					setLeft(false);
					setRight(false);
					setDown(false);
					delay();
					if (upWallCrash) {
						break;
					} else {
						up = true;
					}
					if (upNum % 2 == 0) {
						setIcon(playerUp1);
						upNum++;
						delay2();
					} else {
						setIcon(playerUp2);
						upNum++;
						delay2();
					}
					y -= SPEED;
					setLocation(x, y);
				}
				up = false;
			}
		}).start();
	}

	@Override
	public void down() {
		playerWay = PlayerWay.DOWN;
		down = true;
		setIcon(playerDown);

		new Thread(new Runnable() {

			@Override
			public void run() {
				int downNum = 0;
				while (down) {
					setLeft(false);
					setRight(false);
					setUp(false);
					delay();
					if (downWallCrash) {
						break;
					} else {
						down = true;
					}
					if (downNum % 2 == 0) {
						setIcon(playerDown1);
						downNum++;
						delay2();
					} else {
						setIcon(playerDown2);
						downNum++;
						delay2();
					}
					y += SPEED;
					setLocation(x, y);
				}
				down = false;
			}
		}).start();
	}

	// 걷는 모습 장면 전환 딜레이
	public void delay() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void delay2() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 파스닙 심기
	public Vegetable createParsnip() {
		return new Parsnip(this);
	}

	public Vegetable createCarrot() {
		return new Carrot(this);
	}

	public Vegetable createBerry() {
		return new Strawberry(this);
	}

	// getter, setter

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	public boolean isUpWallCrash() {
		return upWallCrash;
	}

	public void setUpWallCrash(boolean upWallCrash) {
		this.upWallCrash = upWallCrash;
	}

	public boolean isDownWallCrash() {
		return downWallCrash;
	}

	public void setDownWallCrash(boolean downWallCrash) {
		this.downWallCrash = downWallCrash;
	}

	public int getSPEED() {
		return SPEED;
	}

	public ImageIcon getPlayerL() {
		return playerL;
	}

	public ImageIcon getPlayerR() {
		return playerR;
	}

	public ImageIcon getPlayerUp() {
		return playerUp;
	}

	public ImageIcon getPlayerDown() {
		return playerDown;
	}

	public ImageIcon getPlayerWater() {
		return playerWater;
	}

//	public Parsnip plantParsnip() {
//		return parsnip = new Parsnip(this);
//	}

	public boolean isCreate() {
		return create;
	}

	public void setCreate(boolean create) {
		this.create = create;
	}

	public boolean isSellParsnip() {
		return sellParsnip;
	}

	public void setSellParsnip(boolean sellParsnip) {
		this.sellParsnip = sellParsnip;
	}

	// 시도
	public boolean isScoopWater() {
		return scoopWater;
	}

	public void setScoopWater(boolean scoopWater) {
		this.scoopWater = scoopWater;
	}

	public int getSprinklingCanGage() {
		return sprinklingCanGage;
	}

	public void setSprinklingCanGage(int sprinklingCanGage) {
		this.sprinklingCanGage = sprinklingCanGage;
	}

	public int getMAX_CANGAGE() {
		return MAX_CANGAGE;
	}

}
