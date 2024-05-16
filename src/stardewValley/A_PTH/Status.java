package stardewValley.A_PTH;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Status extends JLabel {

	StardewValleyFrame mContext;

	private Player player;
	private Store store;
	private Keeper keeper;
	private Water water;

	private JLabel wallet;
	private JLabel parsnip;
	private JLabel carrot;
	private JLabel berry;

	private JLabel parsnipPrice;
	private JLabel carrotPrice;
	private JLabel berryPrice;
	
	private JLabel haveParsnip;
	private JLabel haveCarrot;
	private JLabel haveBerry;
	
	private JLabel seed;
	private JLabel nameField; // 추가

	private Font f;

	public Status(StardewValleyFrame mContext, Player player, Store store, Keeper keeper, Water water) {
		this.mContext = mContext;
		this.player = player;
		this.store = store;
		this.keeper = keeper;
		this.water = water;
		initData();
		setInitLayout();

	}

	private void initData() {

		// 플레이어의 지갑 생성
		wallet = new JLabel();
		parsnip = new JLabel();
		carrot = new JLabel();
		berry = new JLabel();

		parsnipPrice = new JLabel();
		carrotPrice = new JLabel();
		berryPrice = new JLabel();

		nameField = new JLabel(); // 추가

		f = new Font("휴먼편지체", Font.PLAIN, 40);
	}

	private void setInitLayout() {

		// 플레이어 지갑 세팅
		mContext.add(wallet);
		wallet.setLocation(1400, 280);
		wallet.setSize(400, 100);
		wallet.setFont(f);
		wallet.setText(Integer.toString(player.getMoney()));

		// 파스닙의 저장 개수
		mContext.add(parsnip);
		parsnip.setLocation(1850, 580);
		parsnip.setSize(100, 100);
		parsnip.setFont(f);
		parsnip.setText(Integer.toString(keeper.getParsnipEach()));

		// 당근의 저장 개수
		mContext.add(carrot);
		carrot.setLocation(1850, 700);
		carrot.setSize(100, 100);
		carrot.setFont(f);
		carrot.setText(Integer.toString(keeper.getCarrotEach()));

		// 딸기의 저장 개수
		mContext.add(berry);
		berry.setLocation(1850, 810);
		berry.setSize(100, 100);
		berry.setFont(f);
		berry.setText(Integer.toString(keeper.getBerryEach()));

		// 파스닙의 가격
		mContext.add(parsnipPrice);
		parsnipPrice.setLocation(1780, 190);
		parsnipPrice.setSize(100, 100);
		parsnipPrice.setFont(f);
		parsnipPrice.setText(Integer.toString(store.getParsnipPrice()));

		// 당근의 가격
		mContext.add(carrotPrice);
		carrotPrice.setLocation(1780, 260);
		carrotPrice.setSize(100, 100);
		carrotPrice.setFont(f);
		carrotPrice.setText(Integer.toString(store.getCarrotPrice()));

		// 딸기의 가격
		mContext.add(berryPrice);
		berryPrice.setLocation(1780, 340);
		berryPrice.setSize(100, 100);
		berryPrice.setFont(f);
		berryPrice.setText(Integer.toString(store.getBerryPrice()));

		// 추가
		mContext.add(nameField);
		nameField.setLocation(1420, 200);
		nameField.setSize(100, 100);
		nameField.setFont(f);
	}

	public JLabel getWallet() {
		return wallet;
	}

	public void setWallet(JLabel wallet) {
		this.wallet = wallet;
	}

	public JLabel getParsnip() {
		return parsnip;
	}

	public void setParsnip(JLabel parsnip) {
		this.parsnip = parsnip;
	}

	public JLabel getCarrot() {
		return carrot;
	}

	public void setCarrot(JLabel carrot) {
		this.carrot = carrot;
	}

	public JLabel getBerry() {
		return berry;
	}

	public void setBerry(JLabel berry) {
		this.berry = berry;
	}

	public JLabel getParsnipPrice() {
		return parsnipPrice;
	}

	public JLabel getCarrotPrice() {
		return carrotPrice;
	}

	public JLabel getBerryPrice() {
		return berryPrice;
	}

	public void rePrice() {
		parsnipPrice.setText(Integer.toString(store.getParsnipPrice()));
		carrotPrice.setText(Integer.toString(store.getCarrotPrice()));
		berryPrice.setText(Integer.toString(store.getBerryPrice()));
	}
	public void statusRepaint() {
		carrot.setText(Integer.toString(keeper.getCarrotEach()));
		parsnip.setText(Integer.toString(keeper.getParsnipEach()));
		berry.setText(Integer.toString(keeper.getBerryEach()));
		
		haveCarrot.setText(Integer.toString(player.getHaveCarrot()));
		haveParsnip.setText(Integer.toString(player.getHaveParsnip()));
		haveBerry.setText(Integer.toString(player.getHaveBerry()));
		
		seed.setText(Integer.toString(mContext.vegetable.getMAX_PLANT()));
	}
	public JLabel removeText() {
		parsnip.setText(null);
		carrot.setText(null);
		berry.setText(null);
		parsnipPrice.setText(null);
		carrotPrice.setText(null);
		berryPrice.setText(null);
		wallet.setText(null);
		return removeText();
		
		
	}

	// 추가
	public JLabel getNameField() {
		return nameField;
	}

	public void setName(JLabel name) {
		this.nameField = name;
	}
	
}
