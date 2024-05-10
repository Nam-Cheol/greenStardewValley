package stardewValley.A_PTH;

import javax.swing.JLabel;

public class Vegetable extends JLabel implements IVegetable {
	
	private int price;
	Player player;
	Parsnip parsnip;
	Strawberry berry;
	Carrot carrot;

	private Vegetable[] vegetables;
	
	
	@Override
	public void initData() {

	}

	@Override
	public void setInitLayout() {
//		vegetables = new Vegetable[3];
//		
//		for (int i = 0; i < 3; i++) {
//			vegetables[0].parsnip.setLocation(200, 740);
//			vegetables[1].parsnip.setLocation(270, 740);
//			vegetables[2].parsnip.setLocation(340, 740);
//			
//		}
//		setSize(48, 48);
	}

	@Override
	public void grow() {
		// TODO Auto-generated method stub

	}

	@Override
	public void harvest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sprinkling() {
		// TODO Auto-generated method stub

	}

	public int getPrice() {
		return price;
	}
}
