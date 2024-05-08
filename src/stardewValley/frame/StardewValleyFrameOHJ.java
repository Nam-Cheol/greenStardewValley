package stardewValley.frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import stardewValley.player.PlayerKnc;
import stardewValley.player.PlayerOHJ;
import stardewValley.vegetable.Carrot;
import stardewValley.vegetable.Parsnip;
import stardewValley.vegetable.Strawberry;

//TODO 생성자가 호출될 때 플레이어가 생성되어야 함.
// 배경 추가해야 됨.
//추후 컴포넌트(야채)들도 추가해야 함.
public class StardewValleyFrameOHJ extends JFrame {

	private JLabel backgroundMap;
	private PlayerOHJ playerOHJ;

	public StardewValleyFrameOHJ() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(1930, 980);

		playerOHJ = new PlayerOHJ();
	}

	private void setInitLayout() {
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		add(playerOHJ);
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
					playerOHJ.setLeft(false);
					playerOHJ.setIcon(playerOHJ.getPlayerL());
					break;
				case KeyEvent.VK_RIGHT:
					// 오른쪽으로 가능 상태 멈춤
					playerOHJ.setRight(false);
					playerOHJ.setIcon(playerOHJ.getPlayerR());
					break;
				case KeyEvent.VK_UP:
					playerOHJ.setUp(false);
					playerOHJ.setIcon(playerOHJ.getPlayerUp());
					break;
				case KeyEvent.VK_DOWN:
					playerOHJ.setDown(false);
					playerOHJ.setIcon(playerOHJ.getPlayerDown());
					break;
				default:
					break;
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (!playerOHJ.isLeft()) {
						playerOHJ.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!playerOHJ.isRight()) {
						playerOHJ.right();
					}
					break;
				case KeyEvent.VK_UP:
					if (!playerOHJ.isUp()) {
						playerOHJ.up();
					}
					break;
				case KeyEvent.VK_DOWN:
					if (!playerOHJ.isDown()) {
						playerOHJ.down();
					}
					break;
				case KeyEvent.VK_NUMPAD1:
//					playerOHJ.plantParsnip();
					add(new Parsnip(playerOHJ));
					break;
				case KeyEvent.VK_NUMPAD2:
					add(new Carrot(playerOHJ));
					break;
				case KeyEvent.VK_NUMPAD3:
					add(new Strawberry(playerOHJ));
					break;
				default:
					break;
				}
			}
		});
	}

	public static void main(String[] args) {
		new StardewValleyFrameOHJ();
	}
}
