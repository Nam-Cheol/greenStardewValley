package stardewValley.A_OHJ;

import java.awt.FlowLayout;
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

		nameField = new JPanel();
		nameField.setSize(175, 25);
		nameField.setLocation(680, 700);

		text = new JTextField(15);
	}

	public void setInitLayout() {
		bg.add(nameField);
		nameField.add(text);
		add(bg);

		setLayout(null);
		setVisible(true);
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
				game.getStatus().getNameField().setText(text.getText());
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
	
}
