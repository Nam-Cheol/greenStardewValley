package stardewValley.player;

//TODO 플레이어의 기능 추가, 포함관계여야 함
public class PlayerPTH {
	
	// Player X Y
	private int x;
	private int y;
	// 이미지 icon 변수들
	
	// Player Size
	private final int PLAYERX = 100;
	private final int PLAYERY = 120;
	
	// Player Movement
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	// Player RedColor Crash
	private boolean leftWallCrash;
	private boolean rightWallCrash;
	private boolean upWallCrash;
	private boolean downWallCrash;
	
	// Player Speed
	private final int SPEED = 4;
	
	
	// getter, setter
	
	// X Y
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	// Player Size
	public int getPlayerX() {
		return PLAYERX;
	}
	public int getPlayerY() {
		return PLAYERY;
	}
	// movement
	public boolean isLeft() {
		return left;
	}
	public boolean isRight() {
		return right;
	}
	public boolean isUp() {
		return up;
	}
	public boolean isDown() {
		return down;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public void setup(boolean up) {
		this.up = up;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}
	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}
	public void setUpWallCrash(boolean upWallCrash) {
		this.upWallCrash = upWallCrash;
	}
	public void setDownWallCrash(boolean downWallCrash) {
		this.downWallCrash = downWallCrash;
	}
	
	// SPEED
	public int getSPEED() {
		return SPEED;
	}
	
	
	
	public PlayerPTH() {
		initData();
		setInitLayout();
	}

	private void initData() {
		// 브랜치 테스트 2 
	}

	private void setInitLayout() {
		// 브랜치 테슽 
	}

}
