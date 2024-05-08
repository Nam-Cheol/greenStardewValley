package stardewValley.frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import stardewValley.player.PlayerPTH;

//TODO 생성자가 호출될 때 플레이어가 생성되어야 함.
// 배경 추가해야 됨.
//추후 컴포넌트(야채)들도 추가해야 함.
public class StardewValleyFramePTH extends JFrame{
	
	StardewValleyFramePTH mContext = this;
	
	private JLabel backgroundMap;
	private PlayerPTH player;

	public StardewValleyFramePTH() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/StardewValleyMapColorFrame1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(1930, 980);
		
		player = new PlayerPTH(mContext);
	}
	
	private void setInitLayout() {
		setLayout(null);
//		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		add(player);
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
					if(!player.isLeft()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if(!player.isRight()) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					if(!player.isUp()) {
						player.up();
					}
					break;
				case KeyEvent.VK_DOWN:
					if(!player.isDown()) {
						player.down();
					}
					break;
				default:
					break;
				}				
			}
		});
		
	}
	public static void main(String[] args) {
		new StardewValleyFramePTH();
		
	}
}

