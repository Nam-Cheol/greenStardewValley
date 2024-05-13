package stardewValley.A_KNC;

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
		
		f = new Font("휴먼편지체", Font.PLAIN, 40);
	}
	
	private void setInitLayout() {
		
		// 플레이어 지갑 세팅
		mContext.add(wallet);
		wallet.setLocation(1400, 280);
		wallet.setSize(400,100);
		wallet.setFont(f);
		wallet.setText(Integer.toString(player.getMoney()));
		
		// 파스닙의 저장 개수
		mContext.add(parsnip);
		parsnip.setLocation(1850, 580);
		parsnip.setSize(100,100);
		parsnip.setFont(f);
		parsnip.setText(Integer.toString(keeper.getParsnipEach()));
		
		// 당근의 저장 개수
		mContext.add(carrot);
		carrot.setLocation(1850, 700);
		carrot.setSize(100,100);
		carrot.setFont(f);
		carrot.setText(Integer.toString(keeper.getCarrotEach()));
		
		// 딸기의 저장 개수
		mContext.add(berry);
		berry.setLocation(1850, 810);
		berry.setSize(100,100);
		berry.setFont(f);
		berry.setText(Integer.toString(keeper.getBerryEach()));
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
	
	
	
}