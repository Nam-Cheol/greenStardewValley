package stardewValley.A_PTH;

import java.awt.Font;

import javax.swing.JLabel;

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
	
	private JLabel carrotCurrent;
	private JLabel berryCurrent;
	
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
		
		carrotCurrent = new JLabel();
		berryCurrent = new JLabel();
		
		f = new Font("휴먼편지체", Font.PLAIN, 40);
	}
	
	private void setInitLayout() {
		
		// 플레이어 지갑 세팅
		mContext.add(wallet);
		wallet.setLocation(1400, 280);
		wallet.setSize(400,100);
		wallet.setFont(f);
		wallet.setText(Integer.toString(player.getMoney()));
		
		// 당근 보유 현황(플레이어)
		mContext.add(carrotCurrent);
		carrotCurrent.setLocation(1600, 700);
		carrotCurrent.setSize(100, 100);
		carrotCurrent.setFont(f);
		carrotCurrent.setText(Integer.toString(player.getHaveCarrot())); // carrotCurrent 는 JLabel 로 그저 carrot 의 개수를 띄어줌
		
		// 딸기 보유 현황(플레이어)
		mContext.add(berryCurrent);
		berryCurrent.setLocation(1600, 810);
		berryCurrent.setSize(100, 100);
		berryCurrent.setFont(f);
		berryCurrent.setText(Integer.toString(player.getHaveBerry()));
		
		// 파스닙의 창고 저장 개수
		mContext.add(parsnip);
		parsnip.setLocation(1850, 580);
		parsnip.setSize(100,100);
		parsnip.setFont(f);
		parsnip.setText(Integer.toString(keeper.getParsnipEach()));
		
		// 당근의 창고 저장 개수
		mContext.add(carrot);
		carrot.setLocation(1850, 700);
		carrot.setSize(100,100);
		carrot.setFont(f);
		
		carrot.setText(Integer.toString(keeper.getCarrotEach()));
		
		// 딸기의 창고 저장 개수
		mContext.add(berry);
		berry.setLocation(1850, 810);
		berry.setSize(100,100);
		berry.setFont(f);
		berry.setText(Integer.toString(player.getHaveBerry()));
		
		// 파스닙의 가격
		mContext.add(parsnipPrice);
		parsnipPrice.setLocation(1780, 190);
		parsnipPrice.setSize(100,100);
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
	
	public JLabel getCarrotCurrent() {
		return carrotCurrent;
	}

	public void setCarrotCurrent(JLabel carrotCurrent) {
		this.carrotCurrent = carrotCurrent;
	}
	

	public JLabel getBerryCurrent() {
		return berryCurrent;
	}

	public void setBerryCurrent(JLabel berryCurrent) {
		this.berryCurrent = berryCurrent;
	}

	public void rePrice() {
		parsnipPrice.setText(Integer.toString(store.getParsnipPrice()));
		carrotPrice.setText(Integer.toString(store.getCarrotPrice()));
		berryPrice.setText(Integer.toString(store.getBerryPrice()));
	}
	public void currentHave() {
		parsnip.setText(Integer.toString(player.getHaveParsnip()));
	}
	
	
}
