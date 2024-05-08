package stardewValley.vegetable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stardewValley.player.player;

// TODO 각 야채의 특성 및 차이점 구현
public class vegetable1 extends JLabel implements vegetable {

	// 멤버 변수
	private vegetable1 vege1;
	private String name = "파스닙";
	// 플레이어
	private player player;
	private int x;
	private int y;
	// 성장
	private boolean growing;
	private ImageIcon growing1;
	private ImageIcon growing2;
	private ImageIcon growing3;
	private ImageIcon growing4;
	private ImageIcon lastGrowing;
	// 물
	private int waterGage;

	// 생성자
	public vegetable1(player player) {
		this.player = player;
		initData();
		setInitLayout();
	}

	// 메소드
	@Override
	public void initData() {
		vege1 = null; // TODO - null 또는 boolean 중에 선택
		growing = false;
		waterGage = 0;

		growing1 = new ImageIcon("img/Parsnip_Stage_1.png");
		growing2 = new ImageIcon("img/Parsnip_Stage_2.png");
		growing3 = new ImageIcon("img/Parsnip_Stage_3.png");
		growing4 = new ImageIcon("img/Parsnip_Stage_4.png");
		lastGrowing = new ImageIcon("img/Parsnip_Stage_5.png");
	}

	@Override
	public void setInitLayout() {
//		x = player.getX();
//		y = player.getY();
		sowSeeds();
//		setLocation(x, y);
	}

	public void sowSeeds() {
		// TODO - 방어 코드 작성하기
		// 만약 밭이 비었다면 플레이어가 씨앗을 심을 수 있다.
		// 만약 씨앗이 이미 심어져 있다면 플레이어가 더이상 심을 수 없다.
		if (vege1 == null) {
			setIcon(growing1);
			grow();
			setSize(30, 30);
		} else {
			System.out.println("이미 작물이 자라고 있습니다.");
		}
	}

	@Override
	public void grow() {
		growing = true;

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (growing) {
					try {
						Thread.sleep(5000);
						growing1.setImage(null);
						setIcon(growing2);

						Thread.sleep(5000);
						growing2.setImage(null);
						setIcon(growing3);

						Thread.sleep(5000);
						growing3.setImage(null);
						setIcon(growing4);

						Thread.sleep(5000);
						growing4.setImage(null);
						setIcon(lastGrowing);

						growing = false;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	}

	@Override
	public void harvest() {
		vege1.setIcon(null);
		vege1.remove(vege1);
		vege1.repaint();
	}

	@Override
	public void sprinkling() {
		waterGage++;

		if (1 <= waterGage && waterGage <= 3) {
			growing = true;
		} else {
			growing = false;
		}
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public player getPlayer() {
		return player;
	}

	public void setPlayer(player player) {
		this.player = player;
	}

	public boolean getGrowing() {
		return growing;
	}

	public void setGrowing(boolean Growing) {
		this.growing = Growing;
	}

	public int getWaterGage() {
		return waterGage;
	}

	public void setWaterGage(int waterGage) {
		this.waterGage = waterGage;
	}

} // end of class
