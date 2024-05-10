package stardewValley.A_PTH;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class backgroundVegetableService implements Runnable{

	Player player;
	Parsnip parsnip;
	Carrot carrot;
	Strawberry berry;
	

	
	private BufferedImage image;
	
	public backgroundVegetableService(Player player, Parsnip parsnip, Carrot carrot, Strawberry berry) {
		this.player = player;
		this.parsnip = parsnip;
		this.carrot = carrot;
		this.berry = berry;
			
		try {
			image = ImageIO.read(new File("img/StardewValleyMapColorFrame3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		while(true) {
			if(player.getX() > 185 && player.getX() < 235 && player.getY() > 640 && player.getY() < 690) {
				System.out.println("area1");
				player.isCreate();
				parsnip.setLocation(205, 740);
				carrot.setLocation(205, 740);
				berry.setLocation(205, 740);
				
			} else if(player.getX() > 250 && player.getX() < 305 && player.getY() > 640 && player.getY() < 690) {
				System.out.println("area2");
				player.isCreate();
				parsnip.setLocation(270, 740);
				carrot.setLocation(270, 740);
				berry.setLocation(270, 740);
				
			} else if(player.getX() > 320 && player.getX() < 370 && player.getY() > 640 && player.getY() < 690) {
				System.out.println("area3");
				player.isCreate();
				parsnip.setLocation(340, 740);
				carrot.setLocation(340, 740);
				berry.setLocation(340, 740);
			} else {
				player.setCreate(false);
			}
				
			
		}
	}

}
