package stardewValley.A_OHJ;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IntroName extends JFrame {

	private JLabel bg;

	// 추가2 - 아래 3줄
	private JLabel guidebook1;
	private JLabel guidebook2;
	private JLabel guidebook3;

	private JPanel nameField;
	private JTextField text;
	private StardewValleyFrame game;

	public IntroName() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("Stardew Valley");
		setSize(1930, 980);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Icon icon = new ImageIcon("img/intro/name.png");
		bg = new JLabel(icon);
		bg.setSize(1930, 980);
		bg.setLocation(0, 0);

		// 추가2-아래 3줄
		Icon icon2 = new ImageIcon("img/intro/temptitle.png");
		guidebook1 = new JLabel(icon2);
		guidebook1.setSize(955, 630);
		guidebook1.setLocation(500, 180);

		Icon icon3 = new ImageIcon("img/intro/KeyCommand.png");
		guidebook2 = new JLabel(icon3);
		guidebook2.setSize(955, 630);
		guidebook2.setLocation(500, 180);

		Icon icon4 = new ImageIcon("img/intro/helpInfo.png.png");
		guidebook3 = new JLabel(icon4);
		guidebook3.setSize(955, 630);
		guidebook3.setLocation(500, 180);

		nameField = new JPanel();
		nameField.setSize(175, 25);
		nameField.setLocation(680, 700);

		text = new JTextField(15);
	}

	public void setInitLayout() {
		bg.add(nameField);

		bg.add(guidebook1); // 추가2

		nameField.add(text);
		add(bg);

		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);

		nameField.setVisible(false); // 추가2
		guidebook1.setVisible(false); // 추가2
		guidebook2.setVisible(false); // 추가2
		guidebook3.setVisible(false); // 추가2
	}

	private void addEventListener() {
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO - 수정 필요
				if (e.getClickCount() == 1) {
					guidebook1.setVisible(true);
				} else if (e.getClickCount() >= 2) {
					guidebook1.setVisible(false);
					guidebook2.setVisible(true);
				} else if (e.getClickCount() == 3) {
					guidebook1.setVisible(false);
					guidebook2.setVisible(false);
					guidebook3.setVisible(true);
					nameField.setVisible(true); // 추가2
				} else if (e.getClickCount() == 4) {
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

	public StardewValleyFrame getGame() {
		return game;
	}

	public void setGame(StardewValleyFrame game) {
		this.game = game;
	}

	// 추가2
//	public String getInputText() {
//		return inputText;
//	}
//
//	public void setInputText(String inputText) {
//		this.inputText = inputText;
//	}

}
