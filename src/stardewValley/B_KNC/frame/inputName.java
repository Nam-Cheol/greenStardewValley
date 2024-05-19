package stardewValley.B_KNC.frame;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class inputName extends JFrame {
	public inputName() {
		setSize(300, 200);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setResizable(false);

		JLabel label;
		label = new JLabel("이름을 입력하세요");

		add(label);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(label.getFont().deriveFont(25.0f));
	}
}
