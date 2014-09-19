package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.HunterModel;

public class ImageView extends JPanel implements Observer{

	private BufferedImage hunter;
	private BufferedImage floor;
	private BufferedImage slime;
	private BufferedImage blood;
	private BufferedImage goop;
	private BufferedImage slimepit;
	private BufferedImage wumpus;
	int k=0;
	
	
	private Dimension size;
	private Point pos;
	HunterModel game;
	private JPanel view = new JPanel();
	JPanel rooms[][];

	

	
	public ImageView(String filename) {

		super();
		this.setBackground(Color.BLACK);
		
		
	
	}


	public ImageView(HunterModel model) {

		try {
			hunter = ImageIO.read(new File("TheHunter.png"));
			floor = ImageIO.read(new File("Ground.png"));
			slime = ImageIO.read(new File("Slime.png"));
			blood = ImageIO.read(new File("Blood.png"));
			slimepit = ImageIO.read(new File("SlimePit.png"));
			goop = ImageIO.read(new File("Goop.png"));
			wumpus = ImageIO.read(new File("Wumpus.png"));
			
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		game = model;
		
		
		layoutGUI();
	}
	
	public void layoutGUI(){
		rooms = new JPanel[game.getDungeon().length][game.getDungeon()[1].length];
		
		GridLayout layout = new GridLayout(game.getDungeon().length, game.getDungeon()[1].length);
		setLayout(layout);
		

		
		for (int i=0; i<game.getDungeon().length; i++){
		for (int j=0; j<game.getDungeon()[1].length;j++){
			
				rooms[i][j]=new GamePanel(i,j);
				rooms[i][j].setBackground(Color.BLACK);
				rooms[i][j].repaint();
				add(rooms[i][j]);
			}
		}
		
	
}
	
	@Override
	public void update(Observable observed, Object arg) {
		game = (HunterModel) observed;
		repaint();
		k++;
		System.out.println(k);
		if (game.gameOver()){
			game.deleteObserver(this);
		}
		
		
		
		
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
	

//		for (int i=0; i<game.getDungeon().length; i++){
//			for (int j=0; j<game.getDungeon()[1].length;j++){
//				if (game.getHunterRow()==i && game.getHunterCol()==j){
//					rooms[i][j]=new HunterPanel();
//				}
//				else if (game.hasWumpus(i, j)){
//					rooms[i][j]=new WumpusPanel();
//				}
//				else if (game.hasPit(i, j)){
//					rooms[i][j]=new SlimePitPanel();
//				}
//				else if (game.hasGoop(i, j)){
//					rooms[i][j]=new GoopPanel();
//				}
//				else if (game.hasSlime(i,j)){
//					rooms[i][j]=new SlimePanel();
//				}
//				else if (game.hasBlood(i, j)){
//					rooms[i][j]=new BloodPanel();
//				}
//				else
//				{
//					rooms[i][j]=new FloorPanel();
//				}
//				add(rooms[i][j]);
//			}
//			
//
//		}
		
//		for (int i=0; i<game.getDungeon().length; i++){
//			for (int j=0; j<game.getDungeon()[1].length;j++){
//				if (game.getHunterRow()==i && game.getHunterCol()==j){
//		            g2.drawImage(floor, rooms[i][j].getX(), rooms[i][j].getY(), null);
//		            g2.drawImage(hunter, 0, 0, null);
//				}
//				else if (game.hasWumpus(i, j)){
//		            g2.drawImage(floor, 0, 0, null);
//		            g2.drawImage(wumpus, 0, 0, null);
//				}
//				else if (game.hasPit(i, j)){
//					g2.drawImage(floor, 0, 0, null);
//		            g2.drawImage(slimepit, 0, 0, null);
//				}
//				else if (game.hasGoop(i, j)){
//					g2.drawImage(floor, 0, 0, null);
//		            g2.drawImage(goop, 0, 0, null);
//				}
//				else if (game.hasSlime(i,j)){
//					g2.drawImage(floor, 0, 0, null);
//		            g2.drawImage(slime, 0, 0, null);
//				}
//				else if (game.hasBlood(i, j)){
//					g2.drawImage(floor, 0, 0, null);
//		            g2.drawImage(blood, 0, 0, null);
//				}
//				else
//				{
//					g2.drawImage(floor, 0, 0, null);
//				}
//				add(rooms[i][j]);
//			}
//			
//
//		}
		
		
		
		
	
		
				
	}
	
	
    private class GamePanel extends JPanel{

    	int i, j;
        public GamePanel(int a, int b){
          i=a;
          j=b;
        }

        @Override 
        public void paintComponent(Graphics g) { 
            super.paintComponent(g); 
        	Graphics2D g2 = (Graphics2D)g;
        	
        	if(game.isVisible(i,j)){
        		
        	
 
        		if (game.getHunterRow()==i && game.getHunterCol()==j){
        			g2.drawImage(floor, 0, 0, null);
        			if (game.hasWumpus(i,j)){
        				g2.drawImage(wumpus, 0, 0, null);
        			}
        			else if (game.hasPit(i, j)){
        				g2.drawImage(slimepit, 0, 0, null);
        			}
        			else if (game.hasGoop(i, j)){
        				g2.drawImage(goop, 0, 0, null);
        			}
        			else if (game.hasSlime(i, j)){
        				g2.drawImage(slime, 0, 0, null);
        			}
        			else if (game.hasBlood(i, j)){
        				g2.drawImage(blood, 0, 0, null);
        			}
        			g2.drawImage(hunter, 0, 0, null);
        		}
        		else if (game.hasWumpus(i, j)){
        			g2.drawImage(floor, 0, 0, null);
        			g2.drawImage(wumpus, 0, 0, null);
        		}
        		else if (game.hasPit(i, j)){
        			g2.drawImage(floor, 0, 0, null);
        			g2.drawImage(slimepit, 0, 0, null);
        		}
        		else if (game.hasGoop(i, j)){
        			g2.drawImage(floor, 0, 0, null);
        			g2.drawImage(goop, 0, 0, null);
        		}
        		else if (game.hasSlime(i,j)){
        			g2.drawImage(floor, 0, 0, null);
        			g2.drawImage(slime, 0, 0, null);
        		}
        		else if (game.hasBlood(i, j)){
        			g2.drawImage(floor, 0, 0, null);
        			g2.drawImage(blood, 0, 0, null);
        		}
        		else
        		{
        			g2.drawImage(floor, 0, 0, null);
        		}
        	}
      
        	

        }   	
        
    }
    

    

	
}
