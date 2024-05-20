package stardewValley.component.npc;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.frame.StardewValleyFrame;

public class Store extends JLabel{

	StardewValleyFrame mContext;
	
	private int x;
	private int y;
	
	private int parsnipPrice;
	private int carrotPrice;
	private int berryPrice;
	
	private ImageIcon seller;
	private ImageIcon sellerOn;
	
	private boolean seeNPC;
	private boolean sellOn;
	
	private int priceTime = 100;
	
	private Random random = new Random();
	
	public Store(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		livePrice();
		this.mContext = mContext;
	}
	
	private void initData() {
		
		x = 800;
		y = 200;
		
		seller = new ImageIcon("img/npc/seller.png");
		sellerOn = new ImageIcon("img/npc/sellerOn.png");
		
		seeNPC = false;
		sellOn = false;
		
	}
	
	private void setInitLayout() {
		this.setIcon(seller);
		this.setLocation(x, y);
		this.setSize(130, 200);
	}
	
	private void livePrice() {
		
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				carrotPrice = (int) (random.nextInt(100)) + 800;
				parsnipPrice = (int) (random.nextInt(800)) + 800;
				berryPrice = (int) (random.nextInt(1500)) + 500;
				
			}
		};
		timer.scheduleAtFixedRate(task, 0, priceTime);
	}

	// getter, setter
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getParsnipPrice() {
		return parsnipPrice;
	}

	public int getCarrotPrice() {
		return carrotPrice;
	}

	public int getBerryPrice() {
		return berryPrice;
	}

	public ImageIcon getSeller() {
		return seller;
	}

	public ImageIcon getSellerOn() {
		return sellerOn;
	}
	
	public boolean isSeeNPC() {
		return seeNPC;
	}

	public void setSeeNPC(boolean seeNPC) {
		this.seeNPC = seeNPC;
	}

	public boolean isSellOn() {
		return sellOn;
	}

	public void setSellOn(boolean sellOn) {
		this.sellOn = sellOn;
	}
	
}
