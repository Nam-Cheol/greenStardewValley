package stardewValley.B_KNC;

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
	
	private JLabel haveParsnip;
	private JLabel haveCarrot;
	private JLabel haveBerry;
	
	private JLabel seed;
	
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
		carrot = new JLabel();
		parsnip = new JLabel();
		berry = new JLabel();
		
		carrotPrice = new JLabel();
		parsnipPrice = new JLabel();
		berryPrice = new JLabel();
		
		haveCarrot = new JLabel();
		haveParsnip = new JLabel();
		haveBerry = new JLabel();
		
		seed = new JLabel();
		
		f = new Font("휴먼편지체", Font.PLAIN, 35);
	}
	
	private void setInitLayout() {
		
		// 플레이어 지갑 세팅
		mContext.add(wallet);
		wallet.setLocation(1400, 280);
		wallet.setSize(400,100);
		wallet.setFont(f);
		wallet.setText(Integer.toString(player.getMoney()));
		// 당근의 가격
		mContext.add(carrotPrice);
		carrotPrice.setLocation(1780, 195);
		carrotPrice.setSize(100,100);
		carrotPrice.setFont(f);
		carrotPrice.setText(Integer.toString(store.getCarrotPrice()));
		
		// 파스닙의 가격
		mContext.add(parsnipPrice);
		parsnipPrice.setLocation(1780, 265);
		parsnipPrice.setSize(100,100);
		parsnipPrice.setFont(f);
		parsnipPrice.setText(Integer.toString(store.getParsnipPrice()));
		
		// 딸기의 가격
		mContext.add(berryPrice);
		berryPrice.setLocation(1780, 340);
		berryPrice.setSize(100,100);
		berryPrice.setFont(f);
		berryPrice.setText(Integer.toString(store.getBerryPrice()));
		
		// 당근의 저장 개수
		mContext.add(carrot);
		carrot.setLocation(1860, 645);
		carrot.setSize(100,100);
		carrot.setFont(f);
		carrot.setText(Integer.toString(keeper.getCarrotEach()));
		
		// 파스닙의 저장 개수
		mContext.add(parsnip);
		parsnip.setLocation(1860, 740);
		parsnip.setSize(100,100);
		parsnip.setFont(f);
		parsnip.setText(Integer.toString(keeper.getParsnipEach()));
		
		// 딸기의 저장 개수
		mContext.add(berry);
		berry.setLocation(1860, 840);
		berry.setSize(100,100);
		berry.setFont(f);
		berry.setText(Integer.toString(keeper.getBerryEach()));
		
		// 플레이어 당근 소지 수량
		mContext.add(haveCarrot);
		haveCarrot.setLocation(1640, 645);
		haveCarrot.setSize(100, 100);
		haveCarrot.setFont(f);
		haveCarrot.setText(Integer.toString(player.getHaveCarrot()));
		
		// 플레이어 파스닙 소지 수량
		mContext.add(haveParsnip);
		haveParsnip.setLocation(1640, 740);
		haveParsnip.setSize(100, 100);
		haveParsnip.setFont(f);
		haveParsnip.setText(Integer.toString(player.getHaveParsnip()));
		
		// 플레이어 딸기 소지 수량
		mContext.add(haveBerry);
		haveBerry.setLocation(1640, 840);
		haveBerry.setSize(100, 100);
		haveBerry.setFont(f);
		haveBerry.setText(Integer.toString(player.getHaveBerry()));
		
		// 씨앗 갯수
		mContext.add(seed);
		seed.setLocation(1820, 495);
		seed.setSize(100, 100);
		seed.setFont(f);
		seed.setText(Integer.toString(mContext.vegetable.getMAX_PLANT()));
		
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
}
