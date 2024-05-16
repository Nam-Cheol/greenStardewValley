package stardewValley.A_CYJ;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import stardewValley.A_OHJ.IntroGuide;

class AudioPlay extends JPanel {
	Clip clip = null;

	AudioPlay() {

		try {
			clip = AudioSystem.getClip(); // 사용 가능한 쓰레드 할당
			File file = new File("audio/Stardew-Valley-OST-Stardew-Valley-Overture.wav");

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
			clip.open(audioInputStream);
			clip.start();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

public class Intro extends JFrame {

	private JPanel jPanel;
	private JLabel intro;
	private StardewValleyFrame game;
	private IntroGuide introName;

	public Intro() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("Stardew Valley");
		jPanel = new JPanel();
		intro = new JLabel(new ImageIcon("img/intro/intro.png"));
	}

	private void setInitLayout() {
		jPanel.add(intro);
		jPanel.add(new AudioPlay());
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
				introName = new IntroGuide();
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
