package stardewValley.A_PTH;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Gold extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.drawString("ㅋㅋzzzzzzzzzz", 300, 300);
		g.setFont( new Font("PF스타더스트", Font.PLAIN, 3));
	}
	
}
