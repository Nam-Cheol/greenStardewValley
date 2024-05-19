package stardewValley.B_KNC.frame;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class InputChar extends JFrame {
	public InputChar() {
		setSize(300, 200);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setResizable(false);

		JLabel label;
		label = new JLabel("캐릭터를 선택하세요");

		add(label);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(label.getFont().deriveFont(25.0f));
	}
}
