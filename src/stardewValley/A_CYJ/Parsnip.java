package stardewValley.A_CYJ;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// TODO 각 야채의 특성 및 차이점 구현
public class Parsnip extends JLabel implements vegetable {

	// 멤버 변수
	private String name = "파스닙";
	StardewValleyFrame mContext;
	// 플레이어
	private Player player;
	private int x;
	private int y;
	private int plantLocation = 130;
	
	public int parsnipEach;
	// 성장
	private boolean growing;
	private ImageIcon growing1;
	private ImageIcon growing2;
	private ImageIcon growing3;
	private ImageIcon growing4;
	private ImageIcon lastGrowing;

	private int waterGage;
	
	
	// 생성자
	public Parsnip(StardewValleyFrame mContext) {
		this.mContext = mContext;
		this.player = mContext.getPlayer();
		initData();
		setInitLayout();
		grow();
	}

	// 메소드
	@Override
	public void initData() {
		growing = true;
		growing1 = new ImageIcon("img/Parsnip_Stage_1.png");
		growing2 = new ImageIcon("img/Parsnip_Stage_2.png");
		growing3 = new ImageIcon("img/Parsnip_Stage_3.png");
		growing4 = new ImageIcon("img/Parsnip_Stage_4.png");
		lastGrowing = new ImageIcon("img/Parsnip_Stage_5.png");
		waterGage = 2;
		parsnipEach = 0;
	}

	@Override
	public void setInitLayout() {
		x = player.getX();
		y = player.getY();
		setSize(48, 48);
		setLocation(x, y + plantLocation);
		setIcon(null);
	}

	@Override
	public void grow() {
		setIcon(growing1);
	}

	@Override
	public void harvest() {
		setIcon(null);
	}

	@Override
	public void sprinkling() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (mContext) {

					for (int i = 0; i < 1; i++) {
						try {
							setIcon(growing1);
							Thread.sleep(1000);
							setIcon(growing2);

							Thread.sleep(1000);
							setIcon(growing3);

							if(waterGage >= 1 && waterGage <= 3) {
								Thread.sleep(1000);
								setIcon(growing4);
								parsnipEach++;
								System.out.println(parsnipEach);
							}

							Thread.sleep(1000);
						  
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
		System.out.println("올라가니?" + parsnipEach);
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getWater() {
		return waterGage;
	}

	public void setWater(int watherGage) {
		this.waterGage += watherGage;
	}

} // end of class
