package stardewValley.A_OHJ;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IntroGuide extends JFrame implements IImagePack {

	private JLabel bg;
	private JLabel guide1;
	private JLabel guide2;
	private JLabel guide3;
	private JPanel nameField;
	private JTextField text;
	private JButton buttonField; //
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

		Icon icon1 = new ImageIcon(introGuideBg);
		bg = new JLabel(icon1);
		bg.setSize(1930, 980);
		bg.setLocation(0, 0);

		Icon icon2 = new ImageIcon(WelcomeGuide);
		guide1 = new JLabel(icon2);
		guide1.setSize(960, 630);
		guide1.setLocation(485, 175);

		Icon icon3 = new ImageIcon(KeyGuide);
		guide2 = new JLabel(icon3);
		guide2.setSize(960, 630);
		guide2.setLocation(485, 175);

		Icon icon4 = new ImageIcon(HelpGuide);
		guide3 = new JLabel(icon4);
		guide3.setSize(960, 630);
		guide3.setLocation(485, 175);

		nameField = new JPanel();
		nameField.setSize(180, 25);
		nameField.setLocation(615, 690);

		Icon icon5 = new ImageIcon("img/vege/Carrot.png");
		buttonField = new JButton(icon5);//
		buttonField.setSize(180, 100);
		buttonField.setLocation(10, 10);

		text = new JTextField(15);
	}

	public void setInitLayout() {
		bg.add(guide1);
		bg.add(guide2);
		bg.add(guide3);
		bg.add(nameField);
		bg.add(buttonField);//

		nameField.add(text);

		add(bg);

		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);

		guide1.setVisible(true);
		guide2.setVisible(false);
		guide3.setVisible(false);
		nameField.setVisible(false);
		buttonField.setVisible(false);//
	}

	private void addEventListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_A) {
					guide1.setVisible(false);
					guide2.setVisible(true);
					guide3.setVisible(false);
					nameField.setVisible(false);
				} else if (e.getKeyCode() == KeyEvent.VK_S) {
					guide1.setVisible(false);
					guide2.setVisible(false);
					guide3.setVisible(true);
					nameField.setVisible(true);
					buttonField.setVisible(true);//
				}
			}
		});

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getComponent().getName().equals(buttonField)) {
					game = new StardewValleyFrame();
					game.getStatus().getNameField().setText(text.getText());
					setVisible(false);
				}
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

	public JLabel getBg() {
		return bg;
	}

	public void setBg(JLabel bg) {
		this.bg = bg;
	}

	public JPanel getNameField() {
		return nameField;
	}

	public void setNameField(JPanel nameField) {
		this.nameField = nameField;
	}

	public JTextField getText() {
		return text;
	}

	public void setText(JTextField text) {
		this.text = text;
	}

	
	public JButton getButtonField() {
		return buttonField;
	}

	public void setButtonField(JButton buttonField) {
		this.buttonField = buttonField;
	}

	public StardewValleyFrame getGame() {
		return game;
	}

	public void setGame(StardewValleyFrame game) {
		this.game = game;
	}

}
