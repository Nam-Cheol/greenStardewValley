package stardewValley.A_KNC;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Store extends JLabel implements Runnable{

	StardewValleyFrame mContext;
	
	private int x;
	private int y;
	
	private int parsnipPrice = (int)(Math.random()*1000) + 500;
	private int carrotPrice;
	private int berryPrice;
	
	private int parsnipEach;
	private int carrotEach;
	private int berryEach;
	
	private ImageIcon seller;
	private ImageIcon sellerOn;
	
	public Store(StardewValleyFrame mContext) {
		initData();
		setInitLayout();
		initThread();
		this.mContext = mContext;
	}
	
	private void initData() {
		
		x = 1000;
		y = 200;
		
		seller = new ImageIcon("img/seller.png");
		sellerOn = new ImageIcon("img/sellerOn.png");
		
		
		parsnipEach = (int)(Math.random()*1000) + 500;
		carrotEach = (int)(Math.random()*1000) + 500;
		berryEach = (int)(Math.random()*1000) + 500;
		
		
		
		
	}
	
	private void setInitLayout() {
		this.setIcon(seller);
		this.setLocation(x, y);
		this.setSize(100, 180);
	}
	
	private void initThread() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				parsnipEach = (int)(Math.random()*1000) + 500;
				carrotEach = (int)(Math.random()*1000) + 500;
				berryEach = (int)(Math.random()*1000) + 500;
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
				}
			}
		}).start();
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
	
	@Override
	public void run() {
		parsnipEach = (int)(Math.random()*1000) + 500;
		carrotEach = (int)(Math.random()*1000) + 500;
		berryEach = (int)(Math.random()*1000) + 500;
	}
	
	
	
}
