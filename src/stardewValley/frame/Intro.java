package stardewValley.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import stardewValley.interfaces.IImagePack;

public class Intro extends JFrame implements IImagePack {

	private JPanel jPanel;
	private JLabel intro;

	public Intro() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("Stardew Valley");
		jPanel = new JPanel();
		intro = new JLabel(new ImageIcon(introBg));
	}

	private void setInitLayout() {
		jPanel.add(intro);
		add(jPanel);

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
				new IntroGuide();
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