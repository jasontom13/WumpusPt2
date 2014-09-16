package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.HunterModel;

public class ImageView extends JPanel implements Observer{

	private BufferedImage image;
	private Dimension size;
	private Point pos;
	
	
	public ImageView(String filename) {

		super();
		this.setBackground(Color.BLACK);
		
		
	
	}


	public ImageView() {

		try {
			image = ImageIO.read(new File("TheHunter.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		this.setBackground(Color.BLACK);
	}


	public void moveImage(int i, int j) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(Observable observed, Object arg) {
		HunterModel model = (HunterModel) observed;
		
	}


}
