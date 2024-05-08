package stardewValley.player;

import javax.swing.JLabel;

//TODO 플레이어의 기능 추가, 포함관계여야 함
public class playerKnc extends JLabel implements Moveable {

	// TODO player 의 속성
	
	// 플레이어의 좌표
	private int x;
	private int y;
	
	// 움직임의 on/off
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	// 벽에 충돌 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;
	private boolean upWallCrash;
	
	// TODO 생성자 및 데이터 구축
	public playerKnc() {
		initData();
		setInitLayout();
	}

	private void initData() {
	}

	private void setInitLayout() {
	}

	private void initThread() {
		
	}

	// TODO 움직임 구현
	@Override
	public void left() {
		
	}

	@Override
	public void right() {
		
	}

	@Override
	public void up() {
		
	}

	@Override
	public void down() {
		
	}
	
	
	
}
