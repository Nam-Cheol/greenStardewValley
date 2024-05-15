package stardewValley.A_OHJ;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Intro extends JFrame {

	private JPanel frame;
	private JLabel intro;
	private StardewValleyFrame game;

	public Intro() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("Stardew Valley");
		frame = new JPanel();
		intro = new JLabel(new ImageIcon("img/intro/intro.png"));
	}

	private void setInitLayout() {
		frame.add(intro);
		add(frame);

		setSize(1930, 980);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void addEventListener() {
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				game = new StardewValleyFrame();
				setVisible(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
	}

	public static void main(String[] args) {
		new Intro();
	}

}
