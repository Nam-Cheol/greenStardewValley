package stardewValley.player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//TODO 플레이어의 기능 추가, 포함관계여야 함
public class playerCYJ extends JLabel implements Moveable {

	// TODO player 의 속성

	// 플레이어의 이미지  
	private ImageIcon playerL, playerL1, playerL2;
	private ImageIcon playerR, playerR1, playerR2;
	private ImageIcon playerUp, playerUp1, playerUp2;
	private ImageIcon playerDown, playerDown1, playerDown2;

	// 플레이어의 좌표
	private int x;
	private int y;

	// 플레이어 수확물
	private int vege;

	// 플레이어 씨앗
	private int seed;

	// 플레이어 물
	private int water;

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
	private final int JUMPSPEED = 4;

	// TODO 생성자 및 데이터 구축
	public playerCYJ() {
		initData();
		setInitLayout();
		initThread();
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

		left = false;
		right = false;
		up = false;
		down = false;
		
		water = 0;
		vege = 0;
		
		

		leftWallCrash = false;
		rightWallCrash = false;
		upWallCrash = false;
		downWallCrash = false;

		playerWay = PlayerWay.DOWN;
	}

	private void setInitLayout() {
		this.setIcon(playerDown);
		this.setLocation(x, y);
		this.setSize(100, 120);
	}

	private void initThread() {

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

	public int getSPEED() {
		return SPEED;
	}

	public int getJUMPSPEED() {
		return JUMPSPEED;
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
	
	

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	// 씨앗 심기 Q
	public void puttingSeed() {
		// q를 누르고 green 영역에 player가 해당 범위에 간다면
		// seed를 심고 glow가 시작된다.
	}

	// 작물 수확 W
	public void harvesting() {
		// 만약 seed의 grow grow가 완료된 작물에 한하여
		// w를 눌러 vege 값이 늘어 난다. 
	}
	

	// 물 뿌리기 E
	public void sprinkleWater() {

	}

	// 작물 팔기 R
	public void vegeSell() {
		// 저장소에 있는 vege데이터를 가져와서 
		// treadcenter의 vege pirce 값으로 치환한다.
	}

	// 물 채우기 A
	public void putWater() {
		
		if (water == 4) {
			System.out.println("물이 가득 찼습니다.");
			return;
		} else if (water <= 3) {
			water = 4;
		}
	}
	
	// 창고 저장 S
	public void saveVege() {
		
		if (vege == 0) {
			System.out.println("수확물이 없습니다.");
		} else if (vege > 0) {
			//s키를 눌렀을 때 창고에 내가 가진 수확물을 뺸다.
			//playerCYJ.vege 어? 
		}
	}

}
