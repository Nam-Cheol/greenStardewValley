package stardewValley.frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import stardewValley.player.PlayerKnc;

//TODO 생성자가 호출될 때 플레이어가 생성되어야 함.
// 배경 추가해야 됨.
//추후 컴포넌트(야채)들도 추가해야 함.
public class StardewValleyFrameKNC extends JFrame {
	
	private JLabel backgroundMap;
	private PlayerKnc playerKnc;

	public StardewValleyFrameKNC() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(1930, 980);
		
		playerKnc = new PlayerKnc();
	}
	
	private void setInitLayout() {
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		add(playerKnc);
	}
	
	private void addEventListener() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 왼쪽으로 가능 상태 멈춤
					playerKnc.setLeft(false);
					playerKnc.setIcon(playerKnc.getPlayerL());
					break;
				case KeyEvent.VK_RIGHT:
					// 오른쪽으로 가능 상태 멈춤
					playerKnc.setRight(false);
					playerKnc.setIcon(playerKnc.getPlayerR());
					break;
				case KeyEvent.VK_UP:
					playerKnc.setUp(false);
					playerKnc.setIcon(playerKnc.getPlayerUp());
					break;
				case KeyEvent.VK_DOWN:
					playerKnc.setDown(false);
					playerKnc.setIcon(playerKnc.getPlayerDown());
					break;
				default:
					break;
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if(!playerKnc.isLeft()) {
						playerKnc.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if(!playerKnc.isRight()) {
						playerKnc.right();
					}
					break;
				case KeyEvent.VK_UP:
					if(!playerKnc.isUp()) {
						playerKnc.up();
					}
					break;
				case KeyEvent.VK_DOWN:
					if(!playerKnc.isDown()) {
						playerKnc.down();
					}
					break;
				default:
					break;
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new StardewValleyFrameKNC();
	}
}
