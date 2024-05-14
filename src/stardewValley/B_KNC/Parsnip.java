package stardewValley.B_KNC;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// TODO 각 야채의 특성 및 차이점 구현
public class Parsnip extends Vegetable{

	// 멤버 변수
	private String name = "파스닙";
	private int growSpeed = 5000;
	
	// 생성자
	public Parsnip(Player player) {
		this.player = player;
		initData();
		setInitLayout();
		grow();
	}

	// 메소드
	@Override
	public void initData() {
		waterGage = 2;
		growing = true;
		create = false;
		growing1 = new ImageIcon("img/Parsnip_Stage_1.png");
		growing2 = new ImageIcon("img/Parsnip_Stage_2.png");
		growing3 = new ImageIcon("img/Parsnip_Stage_3.png");
		growing4 = new ImageIcon("img/Parsnip_Stage_4.png");
		lastGrowing = new ImageIcon("img/Parsnip_Stage_5.png");
	}

	@Override
	public void setInitLayout() {
		x = player.getX();
		y = player.getY();
		setSize(48, 48);
		setIcon(null);
	}

	@Override
	public void grow() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				MAX_PLANT--;
				synchronized (this) {
					try {
						setIcon(growing1);
						Thread.sleep(3000);
						setWaterGage(getWaterGage() - 1);
						System.out.println(getWaterGage());
						notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (getWaterGage() == 0) {
						try {
							setIcon(null);
							this.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					if (getWaterGage() == MAX_WATERGAGE) {
						try {
							setIcon(null);
							this.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					try {
						Thread.sleep(growSpeed);
						setIcon(growing2);
						setWaterGage(getWaterGage() - 1);
						System.out.println(getWaterGage());
						notify();
					} catch (InterruptedException e) {
					}

					if (getWaterGage() == 0) {
						try {
							setIcon(null);
							this.wait();
						} catch (InterruptedException e) {
						}
					}
					if (getWaterGage() == MAX_WATERGAGE) {
						try {
							setIcon(null);
							this.wait();
						} catch (InterruptedException e) {
						}
					}

					try {
						Thread.sleep(growSpeed);
						setIcon(growing3);
						setWaterGage(getWaterGage() - 1);
						System.out.println(getWaterGage());
						notify();
					} catch (InterruptedException e) {
					}

					if (getWaterGage() == 0) {
						try {
							setIcon(null);
							this.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (getWaterGage() == MAX_WATERGAGE) {
						try {
							setIcon(null);
							this.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					try {
						Thread.sleep(growSpeed);
						setIcon(growing4);
						setWaterGage(getWaterGage() - 1);
						System.out.println(getWaterGage());
						notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (getWaterGage() == 0) {
						try {
							setIcon(null);
							this.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (getWaterGage() == MAX_WATERGAGE) {
						try {
							setIcon(null);
							this.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					try {
						Thread.sleep(growSpeed);
						setIcon(lastGrowing);
						canHarvest = true;
						System.out.println(getWaterGage());
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

	public boolean isCreate() {
		return create;
	}

	public void setCreate(boolean create) {
		this.create = create;
	}

	@Override
	public int getPrice() {
		return price;
	}

	public ImageIcon getLastGrowing() {
		return lastGrowing;
	}
	
	
	
	

} // end of class