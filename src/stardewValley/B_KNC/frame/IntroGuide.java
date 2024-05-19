package stardewValley.B_KNC.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import stardewValley.B_KNC.interfaces.IImagePack;

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
	private JButton nextBtn;
	private JButton preBtn;
	private StardewValleyFrame game;

	private JButton ch1;
	private JButton ch2;
	private JButton ch3;
	private JButton ch4;

	private ImageIcon player = new ImageIcon(playerImg);
	private ImageIcon playerSelect = new ImageIcon(playerSelectImg);
	private ImageIcon playerS = new ImageIcon(playerSImg);
	private ImageIcon playerDown1 = new ImageIcon(playerDown1Img);
	private ImageIcon playerDown2 = new ImageIcon(playerDown2Img);
	private ImageIcon playerSl = new ImageIcon(playerSLImg);
	private ImageIcon playerLeft1 = new ImageIcon(playerLeft1Img);
	private ImageIcon playerLeft2 = new ImageIcon(playerLeft2Img);
	private ImageIcon playerSr = new ImageIcon(playerSRImg);
	private ImageIcon playerRight1 = new ImageIcon(playerRight1Img);
	private ImageIcon playerRight2 = new ImageIcon(playerRight2Img);
	private ImageIcon playerSu = new ImageIcon(playerSUImg);
	private ImageIcon playerUp1 = new ImageIcon(playerUp1Img);
	private ImageIcon playerUp2 = new ImageIcon(playerUp2Img);
	private ImageIcon playerWater = new ImageIcon(playerWaterImg);

	private ImageIcon alex = new ImageIcon(alexImg);
	private ImageIcon alexSelect = new ImageIcon(alexSelectImg);
	private ImageIcon alexS = new ImageIcon(alexSImg);
	private ImageIcon alexDown1 = new ImageIcon(alexDown1Img);
	private ImageIcon alexDown2 = new ImageIcon(alexDown2Img);
	private ImageIcon alexSl = new ImageIcon(alexSLImg);
	private ImageIcon alexLeft1 = new ImageIcon(alexLeft1Img);
	private ImageIcon alexLeft2 = new ImageIcon(alexLeft2Img);
	private ImageIcon alexSr = new ImageIcon(alexSRImg);
	private ImageIcon alexRight1 = new ImageIcon(alexRight1Img);
	private ImageIcon alexRight2 = new ImageIcon(alexRight2Img);
	private ImageIcon alexSu = new ImageIcon(alexSUImg);
	private ImageIcon alexUp1 = new ImageIcon(alexUp1Img);
	private ImageIcon alexUp2 = new ImageIcon(alexUp2Img);
	private ImageIcon alexWater = new ImageIcon(alexWaterImg);

	private ImageIcon jodi = new ImageIcon(jodiImg);
	private ImageIcon jodiS = new ImageIcon(jodiSImg);
	private ImageIcon jodiDown1 = new ImageIcon(jodiDown1Img);
	private ImageIcon jodiDown2 = new ImageIcon(jodiDown2Img);
	private ImageIcon jodiSl = new ImageIcon(jodiSLImg);
	private ImageIcon jodiLeft1 = new ImageIcon(jodiLeft1Img);
	private ImageIcon jodiLeft2 = new ImageIcon(jodiLeft2Img);
	private ImageIcon jodiSr = new ImageIcon(jodiSRImg);
	private ImageIcon jodiRight1 = new ImageIcon(jodiRight1Img);
	private ImageIcon jodiRight2 = new ImageIcon(jodiRight2Img);
	private ImageIcon jodiSu = new ImageIcon(jodiSUImg);
	private ImageIcon jodiUp1 = new ImageIcon(jodiUp1Img);
	private ImageIcon jodiUp2 = new ImageIcon(jodiUp2Img);
	private ImageIcon jodiWater = new ImageIcon(jodiWaterImg);
	private ImageIcon jodiSelect = new ImageIcon(jodiSelectImg);

	private ImageIcon avi = new ImageIcon(aviImg);
	private ImageIcon aviSelect = new ImageIcon(aviSelectImg);
	private ImageIcon aviS = new ImageIcon(aviSImg);
	private ImageIcon aviDown1 = new ImageIcon(aviDown1Img);
	private ImageIcon aviDown2 = new ImageIcon(aviDown2Img);
	private ImageIcon aviSl = new ImageIcon(aviSLImg);
	private ImageIcon aviLeft1 = new ImageIcon(aviLeft1Img);
	private ImageIcon aviLeft2 = new ImageIcon(aviLeft2Img);
	private ImageIcon aviSr = new ImageIcon(aviSRImg);
	private ImageIcon aviRight1 = new ImageIcon(aviRight1Img);
	private ImageIcon aviRight2 = new ImageIcon(aviRight2Img);
	private ImageIcon aviSu = new ImageIcon(aviSUImg);
	private ImageIcon aviUp1 = new ImageIcon(aviUp1Img);
	private ImageIcon aviUp2 = new ImageIcon(aviUp2Img);
	private ImageIcon aviWater = new ImageIcon(aviWaterImg);

	public IntroGuide() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("Stardew Valley");
		setSize(1930, 980);
		setResizable(false);
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
		nameField.setLocation(865, 570);

		startButton = new JButton(new ImageIcon(StartButtonImg));
		startButton.setSize(120, 83);
		startButton.setLocation(1300, 780);

		guide1Button = new JButton(new ImageIcon(Guide1ButtonImg));
		guide1Button.setSize(120, 83);
		guide1Button.setLocation(485, 780);

		guide2Button = new JButton(new ImageIcon(Guide2ButtonImg));
		guide2Button.setSize(120, 83);
		guide2Button.setLocation(685, 780);

		guide3Button = new JButton(new ImageIcon(Guide3ButtonImg));
		guide3Button.setSize(120, 83);
		guide3Button.setLocation(885, 780);

		nextBtn = new JButton(new ImageIcon(nextBtnImg));
		nextBtn.setSize(120, 83);
		nextBtn.setLocation(1105, 780);
		preBtn = new JButton(new ImageIcon(preBtnImg));
		preBtn.setSize(120, 83);
		preBtn.setLocation(1105, 780);

		text = new JTextField(15);

		ch1 = new JButton();
		ch1.setSize(80, 150);
		ch1.setLocation(600, 300);
		ch1.setIcon(player);

		ch2 = new JButton();
		ch2.setSize(80, 150);
		ch2.setLocation(810, 300);
		ch2.setIcon(alex);

		ch3 = new JButton();
		ch3.setSize(80, 145);
		ch3.setLocation(1030, 300);
		ch3.setIcon(jodi);

		ch4 = new JButton();
		ch4.setSize(80, 140);
		ch4.setLocation(1250, 300);
		ch4.setIcon(avi);
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
		bg.add(nextBtn);
		bg.add(preBtn);

		nameField.add(text);

		bg.add(ch1);
		bg.add(ch2);
		bg.add(ch3);
		bg.add(ch4);

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
		nextBtn.setVisible(true);
		preBtn.setVisible(false);

		ch1.setVisible(false);
		ch2.setVisible(false);
		ch3.setVisible(false);
		ch4.setVisible(false);
	}

	private void addEventListener() {

		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (text.getText().equals("")) {
					new inputName();
				} else if (ch1.getIcon() != playerSelect && ch2.getIcon() != alexSelect && ch3.getIcon() != jodiSelect
						&& ch4.getIcon() != aviSelect) {
					new InputChar();
				} else if (ch1.getIcon() == playerSelect) {
					game = new StardewValleyFrame();
					game.getStatus().getNameField().setText(text.getText());
					setVisible(false);
					player();
				} else if (ch2.getIcon() == alexSelect) {
					game = new StardewValleyFrame();
					game.getStatus().getNameField().setText(text.getText());
					setVisible(false);
					alex();
				} else if (ch3.getIcon() == jodiSelect) {
					game = new StardewValleyFrame();
					game.getStatus().getNameField().setText(text.getText());
					setVisible(false);
					jodi();
				} else {
					game = new StardewValleyFrame();
					game.getStatus().getNameField().setText(text.getText());
					setVisible(false);
					avi();
				}
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
				nameField.setVisible(false);
				startButton.setVisible(false);
				ch1.setVisible(false);
				ch2.setVisible(false);
				ch3.setVisible(false);
				ch4.setVisible(false);
			}
		});

		nextBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				guide1.setVisible(false);
				guide2.setVisible(false);
				guide3.setVisible(false);
				nameField.setVisible(true);
				guide1Button.setVisible(false);
				guide2Button.setVisible(false);
				guide3Button.setVisible(false);
				nextBtn.setVisible(false);
				preBtn.setVisible(true);
				startButton.setVisible(true);
				ch1.setVisible(true);
				ch2.setVisible(true);
				ch3.setVisible(true);
				ch4.setVisible(true);
			}
		});

		preBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				guide1.setVisible(true);
				guide2.setVisible(false);
				guide3.setVisible(false);
				nameField.setVisible(false);
				guide1Button.setVisible(true);
				guide2Button.setVisible(true);
				guide3Button.setVisible(true);
				nextBtn.setVisible(true);
				preBtn.setVisible(false);
				startButton.setVisible(false);
				ch1.setVisible(false);
				ch2.setVisible(false);
				ch3.setVisible(false);
				ch4.setVisible(false);
			}
		});

		ch1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ch1.setIcon(playerSelect);
				ch2.setIcon(alex);
				ch3.setIcon(jodi);
				ch4.setIcon(avi);
			}
		});
		ch2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ch1.setIcon(player);
				ch2.setIcon(alexSelect);
				ch3.setIcon(jodi);
				ch4.setIcon(avi);
			}
		});
		ch3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ch1.setIcon(player);
				ch2.setIcon(alex);
				ch3.setIcon(jodiSelect);
				ch4.setIcon(avi);
			}
		});
		ch4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ch1.setIcon(player);
				ch2.setIcon(alex);
				ch3.setIcon(jodi);
				ch4.setIcon(aviSelect);
			}
		});

	}

	public void player() {
		game.getPlayer().setIcon(playerS);
		game.getPlayer().setPlayerL(playerSl);
		game.getPlayer().setPlayerL1(playerLeft1);
		game.getPlayer().setPlayerL2(playerLeft2);
		game.getPlayer().setPlayerR(playerSr);
		game.getPlayer().setPlayerR1(playerRight1);
		game.getPlayer().setPlayerR2(playerRight2);
		game.getPlayer().setPlayerUp(playerSu);
		game.getPlayer().setPlayerUp1(playerUp1);
		game.getPlayer().setPlayerUp2(playerUp2);
		game.getPlayer().setPlayerDown(playerS);
		game.getPlayer().setPlayerDown1(playerDown1);
		game.getPlayer().setPlayerDown2(playerDown2);
		game.getPlayer().setPlayerWater(playerWater);
	}

	public void alex() {
		game.getPlayer().setIcon(alexS);
		game.getPlayer().setPlayerL(alexSl);
		game.getPlayer().setPlayerL1(alexLeft1);
		game.getPlayer().setPlayerL2(alexLeft2);
		game.getPlayer().setPlayerR(alexSr);
		game.getPlayer().setPlayerR1(alexRight1);
		game.getPlayer().setPlayerR2(alexRight2);
		game.getPlayer().setPlayerUp(alexSu);
		game.getPlayer().setPlayerUp1(alexUp1);
		game.getPlayer().setPlayerUp2(alexUp2);
		game.getPlayer().setPlayerDown(alexS);
		game.getPlayer().setPlayerDown1(alexDown1);
		game.getPlayer().setPlayerDown2(alexDown2);
		game.getPlayer().setPlayerWater(alexWater);
	}

	public void jodi() {
		game.getPlayer().setIcon(jodiS);
		game.getPlayer().setPlayerL(jodiSl);
		game.getPlayer().setPlayerL1(jodiLeft1);
		game.getPlayer().setPlayerL2(jodiLeft2);
		game.getPlayer().setPlayerR(jodiSr);
		game.getPlayer().setPlayerR1(jodiRight1);
		game.getPlayer().setPlayerR2(jodiRight2);
		game.getPlayer().setPlayerUp(jodiSu);
		game.getPlayer().setPlayerUp1(jodiUp1);
		game.getPlayer().setPlayerUp2(jodiUp2);
		game.getPlayer().setPlayerDown(jodiS);
		game.getPlayer().setPlayerDown1(jodiDown1);
		game.getPlayer().setPlayerDown2(jodiDown2);
		game.getPlayer().setPlayerWater(jodiWater);
	}

	public void avi() {
		game.getPlayer().setIcon(aviS);
		game.getPlayer().setPlayerL(aviSl);
		game.getPlayer().setPlayerL1(aviLeft1);
		game.getPlayer().setPlayerL2(aviLeft2);
		game.getPlayer().setPlayerR(aviSr);
		game.getPlayer().setPlayerR1(aviRight1);
		game.getPlayer().setPlayerR2(aviRight2);
		game.getPlayer().setPlayerUp(aviSu);
		game.getPlayer().setPlayerUp1(aviUp1);
		game.getPlayer().setPlayerUp2(aviUp2);
		game.getPlayer().setPlayerDown(aviS);
		game.getPlayer().setPlayerDown1(aviDown1);
		game.getPlayer().setPlayerDown2(aviDown2);
		game.getPlayer().setPlayerWater(aviWater);
	}

}
