package stardewValley.frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

//TODO 생성자가 호출될 때 플레이어가 생성되어야 함.
// 배경 추가해야 됨.
//추후 컴포넌트(야채)들도 추가해야 함.
public class StardewValleyFrameOHJ extends JFrame {
	
	private JLabel backgroundMap;
	private JLabel status;

	public StardewValleyFrameOHJ() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		status = new JLabel(new ImageIcon("img/status.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(1280, 980);
	}
	
	private void setInitLayout() {
		setLayout(null);
//		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void addEventListener() {
		
	}
	
}
