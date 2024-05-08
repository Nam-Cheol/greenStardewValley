package stardewValley.player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//TODO 플레이어의 기능 추가, 포함관계여야 함
public class PlayerPTH extends JLabel {

	// Player X Y
	private int x;
	private int y;

	// Player ImageIcon
	private ImageIcon playerStandUp, playerWalkUp1, playerWalkUp2;
	private ImageIcon playerStandDown, playerWalkDown1, playerWalkDown2;
	private ImageIcon playerStandLeft, playerWalkLeft1, playerWalkLeft2;
	private ImageIcon playerStandRight, playerWalkRight1, playerWalkRight2;

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

	// Player ImageIcon
	public void setPlayerStandUp(ImageIcon playerStandUp) {
		this.playerStandUp = playerStandUp;
	}

	public void setPlayerUpWalk1(ImageIcon playerWalkUp1) {
		this.playerWalkUp1 = playerWalkUp1;
	}

	public void setPlayerUpWalk2(ImageIcon playerWalkUp2) {
		this.playerWalkUp2 = playerWalkUp2;
	}

	public void setPlayerStandDown(ImageIcon playerStandDown) {
		this.playerStandDown = playerStandDown;
	}

	public void setPlayerWalkDown1(ImageIcon playerWalkDown1) {
		this.playerWalkDown1 = playerWalkDown1;
	}

	public void setPlayerWalkDown2(ImageIcon playerWalkDown2) {
		this.playerWalkDown2 = playerWalkDown2;
	}

	public void setPlayerStandLeft(ImageIcon playerStandLeft) {
		this.playerStandLeft = playerStandLeft;
	}

	public void setPlayerWalkLeft1(ImageIcon playerWalkLeft1) {
		this.playerWalkLeft1 = playerWalkLeft1;
	}

	public void setPlayerWalkLeft2(ImageIcon playerWalkLeft2) {
		this.playerWalkLeft2 = playerWalkLeft2;
	}

	public void setPlayerStandRight(ImageIcon playerStandRight) {
		this.playerStandRight = playerStandRight;
	}

	public void setPlayerWalkRight1(ImageIcon playerWalkRight1) {
		this.playerWalkRight1 = playerWalkRight1;
	}

	public void setPlayerWalkRight2(ImageIcon playerWalkRight2) {
		this.playerWalkRight2 = playerWalkRight2;
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
		playerStandUp = new ImageIcon("img/PlayerStandDown.png");
		playerStandDown = new ImageIcon("img/PlayerStand.png");
		playerStandLeft = new ImageIcon("img/PlayerStandLeft.png");
		playerStandRight = new ImageIcon("img/PlayerStandDown.png");
		
		playerWalkUp1 = new ImageIcon("img/PlayerWalkUp.png");
		playerWalkUp2 = new ImageIcon("img/PlayerWalkUp2.png");
		
		playerWalkDown1 = new ImageIcon("img/PlayerWalkDown.png");
		playerWalkDown2 = new ImageIcon("img/PlayerWalkDown2.png");
		
		playerWalkLeft1 = new ImageIcon("img/PlayerWalkLeft.png");
		playerWalkLeft2 = new ImageIcon("img/PlayerWalkLeft2.png");
		
		playerWalkRight1 = new ImageIcon("img/PlayerWalkRight.png");
		playerWalkRight2 = new ImageIcon("img/PlayerWalkRight2.png");
		
	}

	private void setInitLayout() {
		// 브랜치 테슽
	}

}
