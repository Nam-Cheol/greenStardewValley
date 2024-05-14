package stardewValley.A_PTH;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// TODO 각 야채의 특성 및 차이점 구현
public class Strawberry extends Vegetable {

	// 멤버 변수
	private String name = "딸기";
	// 플레이어
	private Player player;
	private int x;
	private int y;
	private int plantLocation = 130;
	// 성장
	private boolean growing;
	private ImageIcon growing1;
	private ImageIcon growing2;
	private ImageIcon growing3;
	private ImageIcon growing4;
	private ImageIcon growing5;
	private ImageIcon lastGrowing;
	
	private Strawberry[] berry;
	
	// 생성자
	public Strawberry(Player player) {
		this.player = player;
		initData();
		setInitLayout();
		grow();
	}

	// 메소드
	@Override
	public void initData() {
		growing = true;
		growing1 = new ImageIcon("img/vege/Strawberry_Stage_1.png");
		growing2 = new ImageIcon("img/vege/Strawberry_Stage_2.png");
		growing3 = new ImageIcon("img/vege/Strawberry_Stage_3.png");
		growing4 = new ImageIcon("img/vege/Strawberry_Stage_4.png");
		growing5 = new ImageIcon("img/vege/Strawberry_Stage_5.png");
		lastGrowing = new ImageIcon("img/vege/Strawberry_Stage_6.png");
	}

	@Override
	public void setInitLayout() {
		
			setSize(48, 57);
			setIcon(null);
		x = player.getX();
		y = player.getY();
		setLocation(x, y + plantLocation);
	}

	@Override
	public void grow() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				MAX_PLANT--;
				for(int i = 0; i < 1; i++) {
					try {
						setIcon(growing1);
						Thread.sleep(1000);
						setIcon(growing2);
						
						Thread.sleep(1000);
						setIcon(growing3);
						
						Thread.sleep(1000);
						setIcon(growing4);
						
						Thread.sleep(1000);
						setIcon(growing5);
						
						Thread.sleep(1000);
						setIcon(lastGrowing);
						
						canHarvest = true;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public void harvest() {
	}

	@Override
	public void sprinkling() {
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

} // end of class
