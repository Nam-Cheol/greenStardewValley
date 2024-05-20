package stardewValley.component.player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.component.status.WaterGauge;
import stardewValley.component.vegetable.Carrot;
import stardewValley.component.vegetable.Parsnip;
import stardewValley.component.vegetable.Strawberry;
import stardewValley.component.vegetable.Vegetable;
import stardewValley.frame.StardewValleyFrame;
import stardewValley.interfaces.Moveable;
import stardewValley.service.backgroundPlayerMapService;
import stardewValley.state.PlayerWay;


//TODO 플레이어의 기능 추가, 포함관계여야 함
public class Player extends JLabel implements Moveable {

	// TODO player 의 속성
	StardewValleyFrame mContext;

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

	private WaterGauge waterGauge;

	// 플레이어의 좌표
	private int x;
	private int y;

	// 움직임의 on/off
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	public PlayerWay playerWay;

	// 벽에 충돌 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;
	private boolean upWallCrash;
	private boolean downWallCrash;

	// 플레이어 속도 상태
	private final int SPEED = 20;
	
	// 작물을 심을 수 있는 상태
	private boolean create;

	// 플레이어의 소지 금액
	private int money;

	// 플레이어 소지 수량
	private int haveParsnip;
	private int haveCarrot;
	private int haveBerry;

	// 우물에서 물 퍼낼 때
	private int sprinklingCanGage;
	private final int MAX_CANGAGE = 5;
	private boolean scoopWater;

	// 플레이어의 턴
	private int turn;
	private int firstTurn = 1;
	private int middleTurn = 2;
	private int lastTurn = 3;
	
	// TODO 생성자 및 데이터 구축
	public Player(StardewValleyFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		new Thread(new backgroundPlayerMapService(this.mContext , this)).start();
	}

	private void initData() {


		playerL = new ImageIcon("img/character/PlayerStandLeft.png");
		playerL1 = new ImageIcon("img/character/PlayerWalkLeft.png");
		playerL2 = new ImageIcon("img/character/PlayerWalkLeft2.png");

		playerR = new ImageIcon("img/character/PlayerStandRight.png");
		playerR1 = new ImageIcon("img/character/PlayerWalkRight.png");
		playerR2 = new ImageIcon("img/character/PlayerWalkRight2.png");

		playerUp = new ImageIcon("img/character/PlayerStandUp.png");
		playerUp1 = new ImageIcon("img/character/PlayerWalkUp.png");
		playerUp2 = new ImageIcon("img/character/PlayerWalkUp2.png");

		playerDown = new ImageIcon("img/character/PlayerStand.png");
		playerDown1 = new ImageIcon("img/character/PlayerWalkDown.png");
		playerDown2 = new ImageIcon("img/character/PlayerWalkDown2.png");
		playerWater = new ImageIcon("img/character/PlayerWater.png");
		
		x = 600;
		y = 400;

		left = false;
		right = false;
		up = false;
		down = false;
		leftWallCrash = false;
		rightWallCrash = false;
		upWallCrash = false;
		downWallCrash = false;

		create = false;
		
		playerWay = PlayerWay.DOWN;

		money = 0;
		
		turn = 1;
		
		waterGauge = new WaterGauge(mContext);
	}

	private void setInitLayout() {
		this.setIcon(playerDown);
		this.setLocation(x, y);
		this.setSize(100, 120);
		mContext.add(waterGauge);
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

	public Vegetable createParsnip() {
		return new Parsnip(this, mContext, mContext.farm);
	}

	public Vegetable createCarrot() {
		return new Carrot(this, mContext, mContext.farm);
	}

	public Vegetable createBerry() {
		return new Strawberry(this, mContext, mContext.farm);
	}

	// getter, setter

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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

	public boolean isCreate() {
		return create;
	}

	public void setCreate(boolean create) {
		this.create = create;
	}

	public int getHaveParsnip() {
		return haveParsnip;
	}

	public void setHaveParsnip(int haveParsnip) {
		this.haveParsnip = haveParsnip;
	}

	public int getHaveCarrot() {
		return haveCarrot;
	}

	public void setHaveCarrot(int haveCarrot) {
		this.haveCarrot = haveCarrot;
	}

	public int getHaveBerry() {
		return haveBerry;
	}

	public void setHaveBerry(int haveBerry) {
		this.haveBerry = haveBerry;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

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

	public WaterGauge getWaterGauge() {
		return waterGauge;
	}

	public void setWaterGauge(WaterGauge waterGauge) {
		this.waterGauge = waterGauge;
	}
	
	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	public void setPlayerL(ImageIcon playerL) {
		this.playerL = playerL;
	}

	public void setPlayerL1(ImageIcon playerL1) {
		this.playerL1 = playerL1;
	}

	public void setPlayerL2(ImageIcon playerL2) {
		this.playerL2 = playerL2;
	}

	public void setPlayerR(ImageIcon playerR) {
		this.playerR = playerR;
	}

	public void setPlayerR1(ImageIcon playerR1) {
		this.playerR1 = playerR1;
	}

	public void setPlayerR2(ImageIcon playerR2) {
		this.playerR2 = playerR2;
	}

	public void setPlayerUp(ImageIcon playerUp) {
		this.playerUp = playerUp;
	}

	public void setPlayerUp1(ImageIcon playerUp1) {
		this.playerUp1 = playerUp1;
	}

	public void setPlayerUp2(ImageIcon playerUp2) {
		this.playerUp2 = playerUp2;
	}

	public void setPlayerDown(ImageIcon playerDown) {
		this.playerDown = playerDown;
	}

	public void setPlayerDown1(ImageIcon playerDown1) {
		this.playerDown1 = playerDown1;
	}

	public void setPlayerDown2(ImageIcon playerDown2) {
		this.playerDown2 = playerDown2;
	}

	public void setPlayerWater(ImageIcon playerWater) {
		this.playerWater = playerWater;
	}

	public void plusSeed() {
		if (Vegetable.getSeed() == 0) {
			if (turn == firstTurn) {
				if (Vegetable.getSeed() == 0) {
					Vegetable.setSeed(Vegetable.getMAX_PLANT());
				}
				mContext.timeGauge.setIcon(mContext.timeGauge.getTimeGauge1());
				turn++;
			} else if (turn == middleTurn) {
				if (Vegetable.getSeed() == 0) {
					Vegetable.setSeed(Vegetable.getMAX_PLANT());
				}
				mContext.timeGauge.setIcon(mContext.timeGauge.getTimeGauge2());
				turn++;
			} else if (turn == lastTurn && money <= mContext.victoryMoney) {
				mContext.gameOver.gameOver();

			} else if (turn == lastTurn && money >= mContext.victoryMoney) {
				mContext.gameClear.gameClear();
			}
		}
	}

	public void amountWater() {
		if (sprinklingCanGage == 0) {
			waterGauge.setIcon(waterGauge.getWaterGauge());
		} else if (sprinklingCanGage == 1) {
			waterGauge.setIcon(waterGauge.getWaterGauge1());
		} else if (sprinklingCanGage == 2) {
			waterGauge.setIcon(waterGauge.getWaterGauge2());
		} else if (sprinklingCanGage == 3) {
			waterGauge.setIcon(waterGauge.getWaterGauge3());
		} else if (sprinklingCanGage == 4) {
			waterGauge.setIcon(waterGauge.getWaterGauge4());
		} else if (sprinklingCanGage == 5) {
			waterGauge.setIcon(waterGauge.getWaterGauge5());
		}
	}
	
	public void sellVegetable() {
		if (mContext.keeper.getCarrotEach() == 0) {
		} else {
			money += (mContext.keeper.getCarrotEach() * mContext.store.getCarrotPrice());
			mContext.keeper.setCarrotEach(0);
			mContext.status.getWallet().setText(Integer.toString(money));
		}
		if (mContext.keeper.getParsnipEach() == 0) {
		} else {
			money += (mContext.keeper.getParsnipEach() * mContext.store.getParsnipPrice());
			mContext.keeper.setParsnipEach(0);
			mContext.status.getWallet().setText(Integer.toString(money));
		}
		if (mContext.keeper.getBerryEach() == 0) {
		} else {
			money += (mContext.keeper.getBerryEach() * mContext.store.getBerryPrice());
			mContext.keeper.setBerryEach(0);
			mContext.status.getWallet().setText(Integer.toString(money));
		}
	}
	
	public void stopPlant() {
		if (Vegetable.getSeed() == 0) {
			create = false;
			return;
		}
	}

	public void saveCrop() {
		mContext.keeper.setParsnipEach(mContext.keeper.getParsnipEach() + haveParsnip);
		haveParsnip = 0;
		
		mContext.keeper.setCarrotEach(mContext.keeper.getCarrotEach() + haveCarrot);
		haveCarrot = 0;

		mContext.keeper.setBerryEach(mContext.keeper.getBerryEach() + haveBerry);
		haveBerry = 0;		

		mContext.status.statusRepaint();
	}
}
