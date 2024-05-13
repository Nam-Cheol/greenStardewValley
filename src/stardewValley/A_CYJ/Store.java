package stardewValley.A_CYJ;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Store extends JLabel implements Runnable {

	StardewValleyFrame mContext;

	private int x;
	private int y;

	Random random = new Random();

	private int parsnipPrice = (int) (random.nextInt(1000)) + 500;
	private int carrotPrice = (int) (random.nextInt(1000)) + 500;
	private int berryPrice = (int) (random.nextInt(1000)) + 500;

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

//		parsnipPrice = (int) (random.nextInt(1000)) + 500;
//		carrotPrice = (int) (random.nextInt(1000)) + 500;
//		berryPrice = (int) (random.nextInt(1000)) + 500;

	}

	private void setInitLayout() {
		this.setIcon(seller);
		this.setLocation(x, y);
		this.setSize(100, 180);
	}

	private void initThread() {
//		new Thread(new Runnable() {
		
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				parsnipPrice = (int) (random.nextInt(1000)) + 500;
				carrotPrice = (int) (random.nextInt(1000)) + 500;
				berryPrice = (int) (random.nextInt(1000)) + 500;
				
			}
		};
		timer.scheduleAtFixedRate(task, 0, 10000);
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

	public ImageIcon getSeller() {
		return seller;
	}

	public ImageIcon getSellerOn() {
		return sellerOn;
	}

	@Override
	public void run() {
		parsnipPrice = (int) (random.nextInt(1000)) + 500;
		carrotPrice = (int) (random.nextInt(1000)) + 500;
		berryPrice = (int) (random.nextInt(1000)) + 500;
	}

}
