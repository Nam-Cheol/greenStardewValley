package stardewValley.A_CYJ.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import stardewValley.A_CYJ.interfaces.IImagePack;



public class IntroGuide extends JFrame implements IImagePack {

	private JLabel bg;
	private JLabel guide1;
	private JLabel guide2;
	private JLabel guide3;
	private JPanel nameField;
	private JTextField text;
	private JButton startButton;
	private JButton guide1Button;
	private JButton guide2Button;
	private JButton guide3Button;
	private StardewValleyFrame game;

	public IntroGuide() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("Stardew Valley");
		setSize(1930, 980);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bg = new JLabel(new ImageIcon(introGuideBg));
		bg.setSize(1930, 980);
		bg.setLocation(0, 0);

		guide1 = new JLabel(new ImageIcon(WelcomeGuide));
		guide1.setSize(960, 630);
		guide1.setLocation(485, 120);

		guide2 = new JLabel(new ImageIcon(KeyGuide));
		guide2.setSize(960, 630);
		guide2.setLocation(485, 120);

		guide3 = new JLabel(new ImageIcon(HelpGuide));
		guide3.setSize(960, 630);
		guide3.setLocation(485, 120);

		nameField = new JPanel();
		nameField.setSize(180, 25);
		nameField.setLocation(620, 630);

		startButton = new JButton(new ImageIcon(StartButtonImg));//
		startButton.setSize(120, 83);
		startButton.setLocation(1335, 780);

		guide1Button = new JButton(new ImageIcon(Guide1ButtonImg));//
		guide1Button.setSize(120, 83);
		guide1Button.setLocation(485, 780);

		guide2Button = new JButton(new ImageIcon(Guide2ButtonImg));//
		guide2Button.setSize(120, 83);
		guide2Button.setLocation(685, 780);

		guide3Button = new JButton(new ImageIcon(Guide3ButtonImg));//
		guide3Button.setSize(120, 83);
		guide3Button.setLocation(885, 780);

		text = new JTextField(10);
	}

	public void setInitLayout() {
		bg.add(guide1);
		bg.add(guide2);
		bg.add(guide3);
		bg.add(nameField);

		bg.add(startButton);
		bg.add(guide1Button);
		bg.add(guide2Button);
		bg.add(guide3Button);

		nameField.add(text);

		add(bg);

		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);

		guide1.setVisible(true);
		guide2.setVisible(false);
		guide3.setVisible(false);
		nameField.setVisible(false);
		startButton.setVisible(false);
		guide1Button.setVisible(true);
		guide2Button.setVisible(true);
		guide3Button.setVisible(true);
	}

	private void addEventListener() {

		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				game = new StardewValleyFrame();
				game.status.getNameField().setText(text.getText());
				setVisible(false);
			}
		});

		guide1Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				guide1.setVisible(true);
				guide2.setVisible(false);
				guide3.setVisible(false);
				nameField.setVisible(false);
				startButton.setVisible(false);
			}
		});

		guide2Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				guide1.setVisible(false);
				guide2.setVisible(true);
				guide3.setVisible(false);
				nameField.setVisible(false);
				startButton.setVisible(false);
			}
		});

		guide3Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				guide1.setVisible(false);
				guide2.setVisible(false);
				guide3.setVisible(true);
				nameField.setVisible(true);
				startButton.setVisible(true);
			}
		});

	}

}
