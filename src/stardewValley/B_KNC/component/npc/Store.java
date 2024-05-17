package stardewValley.B_KNC.component.npc;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.B_KNC.frame.StardewValleyFrame;

public class Store extends JLabel{

	StardewValleyFrame mContext;
	
	private int x;
	private int y;
	
	private int parsnipPrice;
	private int carrotPrice;
	private int berryPrice;
	
	private int parsnipEach;
	private int carrotEach;
	private int berryEach;
	
	private ImageIcon seller;
	private ImageIcon sellerOn;
	
	private boolean seeNPC;
	private boolean sellOn;
	
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
//		new Thread(new Runnable() {
		
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				carrotPrice = (int) (random.nextInt(1500)) + 500;
				parsnipPrice = (int) (random.nextInt(1000)) + 800;
				berryPrice = (int) (random.nextInt(500)) + 1000;
				
			}
		};
		timer.scheduleAtFixedRate(task, 0, 1000);
	}

	public StardewValleyFrame getmContext() {
		return mContext;
	}

	// getter, setter
	
	public void setmContext(StardewValleyFrame mContext) {
		this.mContext = mContext;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getParsnipPrice() {
		return parsnipPrice;
	}

	public void setParsnipPrice(int parsnipPrice) {
		this.parsnipPrice = parsnipPrice;
	}

	public int getCarrotPrice() {
		return carrotPrice;
	}

	public void setCarrotPrice(int carrotPrice) {
		this.carrotPrice = carrotPrice;
	}

	public int getBerryPrice() {
		return berryPrice;
	}

	public void setBerryPrice(int berryPrice) {
		this.berryPrice = berryPrice;
	}

	public int getParsnipEach() {
		return parsnipEach;
	}

	public void setParsnipEach(int parsnipEach) {
		this.parsnipEach = parsnipEach;
	}

	public int getCarrotEach() {
		return carrotEach;
	}

	public void setCarrotEach(int carrotEach) {
		this.carrotEach = carrotEach;
	}

	public int getBerryEach() {
		return berryEach;
	}

	public void setBerryEach(int berryEach) {
		this.berryEach = berryEach;
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
