package stardewValley.A_KNC;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// TODO 각 야채의 특성 및 차이점 구현
public class Carrot extends Vegetable {

	// 멤버 변수
	private String name = "당근";
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
	private ImageIcon lastGrowing;
	
	private int price;

	// 생성자
	public Carrot(Player player) {
		this.player = player;
		initData();
		setInitLayout();
		grow();
	}

	// 메소드
	@Override
	public void initData() {
		growing = true;
		growing1 = new ImageIcon("img/Carrot_Stage_1.png");
		growing2 = new ImageIcon("img/Carrot_Stage_2.png");
		growing3 = new ImageIcon("img/Carrot_Stage_3.png");
		lastGrowing = new ImageIcon("img/Carrot_Stage_4.png");
	}

	@Override
	public void setInitLayout() {
		x = player.getX();
		y = player.getY();
		setSize(48, 64);
		setLocation(x, y + plantLocation);
		setIcon(null);
	}

	@Override
	public void grow() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 1; i++) {
					try {
						setIcon(growing1);
						Thread.sleep(1000);
						setIcon(growing2);
						
						Thread.sleep(1000);
						setIcon(growing3);
						
						Thread.sleep(1000);
						setIcon(lastGrowing);
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
	
	@Override
	public int getPrice() {
		return price;
	}

} // end of class
