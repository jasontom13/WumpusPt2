package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
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
	private BufferedImage floor;
	private Dimension size;
	private Point pos;
	HunterModel game;
	private JPanel view = new JPanel();
	

	
	public ImageView(String filename) {

		super();
		this.setBackground(Color.BLACK);
		
		
	
	}


	public ImageView(HunterModel model) {

		try {
			image = ImageIO.read(new File("TheHunter.png"));
			floor = ImageIO.read(new File("Ground.png"));
			
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		game = model;
		
		
		layoutGUI();
	}


	public void moveImage(int i, int j) {
		// TODO Auto-generated method stub
		
	}
	
	public void layoutGUI(){
		setForeground(Color.BLACK);
//		setLayout(new GridLayout(game.getDungeon().length, game.getDungeon()[1].length,40,40));
//		for (int i=0; i<game.getDungeon().length; i++){
//			for (int j=0; j<game.getDungeon()[1].length;j++){
//				JPanel a = new JPanel();
//				add(a);
//			}
//		}
		
//		view.setPreferredSize(new Dimension(500,500));
//		view.setBackground(Color.BLACK);
//		add(view);
//		System.out.println(view.getAlignmentX());
//		System.out.print(view.getAlignmentY());
		
		
		
	}
	
	@Override
	public void update(Observable observed, Object arg) {
		HunterModel model = (HunterModel) observed;
		
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
	
	    int x = (this.getWidth() - floor.getWidth(null)) / 2;
	    int y = (this.getHeight() - floor.getHeight(null)) / 2;
		for (int i=0; i<game.getDungeon().length; i++){
			for (int j=0; j<game.getDungeon()[1].length;j++){
				g2.drawImage(floor, 14+floor.getHeight()*i, 5+floor.getWidth()*j, null);
		}
		
		
	
		
				
	}

	}
}
