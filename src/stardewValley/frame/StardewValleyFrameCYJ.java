package stardewValley.frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import stardewValley.player.playerCYJ;

//TODO 생성자가 호출될 때 플레이어가 생성되어야 함.
// 배경 추가해야 됨.
//추후 컴포넌트(야채)들도 추가해야 함.
public class StardewValleyFrameCYJ extends JFrame {

	private JLabel backgroundMap;
	private playerCYJ playerCYJ;

	public StardewValleyFrameCYJ() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(1930, 980);

		playerCYJ = new playerCYJ();
	}

	private void setInitLayout() {
		setLayout(null);
//		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		add(playerCYJ);
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
					playerCYJ.setLeft(false);
					playerCYJ.setIcon(playerCYJ.getPlayerL());
					break;
				case KeyEvent.VK_RIGHT:
					// 오른쪽으로 가능 상태 멈춤
					playerCYJ.setRight(false);
					playerCYJ.setIcon(playerCYJ.getPlayerR());
					break;
				case KeyEvent.VK_UP:
					playerCYJ.setUp(false);
					playerCYJ.setIcon(playerCYJ.getPlayerUp());
					break;
				case KeyEvent.VK_DOWN:
					playerCYJ.setDown(false);
					playerCYJ.setIcon(playerCYJ.getPlayerDown());
					break;
				default:
					break;
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (!playerCYJ.isLeft()) {
						playerCYJ.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!playerCYJ.isRight()) {
						playerCYJ.right();
					}
					break;
				case KeyEvent.VK_UP:
					if (!playerCYJ.isUp()) {
						playerCYJ.up();
					}
					break;
				case KeyEvent.VK_DOWN:
					if (!playerCYJ.isDown()) {
						playerCYJ.down();
					}
				case KeyEvent.VK_Q:
					if (playerCYJ.getWater() == 0) {
						System.out.println("눌러지나 확인");
						playerCYJ.getWater();
					}
					break;
				default:
					break;
				}
			}
		});
	}

	public static void main(String[] args) {
		new StardewValleyFrameCYJ();
	}

}
