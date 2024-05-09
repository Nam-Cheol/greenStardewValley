package stardewValley.A_KNC;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Vegetable extends JLabel implements IVegetable {
	
	private String name;
	private Player player;
	
	private int x;
	private int y;
	private int plantLocation = 130;
	
	private boolean growing;
	private ImageIcon growing1;
	private ImageIcon growing2;
	private ImageIcon growing3;
	private ImageIcon growing4;
	private ImageIcon growing5;
	private ImageIcon lastGrowing;

	public Vegetable(Player player) {
		this.player = player;
		initData();
		setInitLayout();
		grow();
	}
	
	@Override
	public void initData() {}

	@Override
	public void setInitLayout() {}

	@Override
	public void grow() {}

	@Override
	public void harvest() {}

	@Override
	public void sprinkling() {}

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

	public int getPlantLocation() {
		return plantLocation;
	}

	public void setPlantLocation(int plantLocation) {
		this.plantLocation = plantLocation;
	}

	public boolean isGrowing() {
		return growing;
	}

	public void setGrowing(boolean growing) {
		this.growing = growing;
	}

	public ImageIcon getGrowing1() {
		return growing1;
	}

	public void setGrowing1(ImageIcon growing1) {
		this.growing1 = growing1;
	}

	public ImageIcon getGrowing2() {
		return growing2;
	}

	public void setGrowing2(ImageIcon growing2) {
		this.growing2 = growing2;
	}

	public ImageIcon getGrowing3() {
		return growing3;
	}

	public void setGrowing3(ImageIcon growing3) {
		this.growing3 = growing3;
	}

	public ImageIcon getGrowing4() {
		return growing4;
	}

	public void setGrowing4(ImageIcon growing4) {
		this.growing4 = growing4;
	}

	public ImageIcon getGrowing5() {
		return growing5;
	}

	public void setGrowing5(ImageIcon growing5) {
		this.growing5 = growing5;
	}

	public ImageIcon getLastGrowing() {
		return lastGrowing;
	}

	public void setLastGrowing(ImageIcon lastGrowing) {
		this.lastGrowing = lastGrowing;
	}

	
	
}
