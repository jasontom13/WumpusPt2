package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.HunterModel;

public class TextView extends JPanel implements Observer{

	private JTextArea text;
	JLabel message = new JLabel("");
	JLabel status = new JLabel("Current Room: Nothing");

	private JScrollPane scroll;
	
	public TextView(HunterModel game){
		
		text = new JTextArea();
//		text.setFocusTraversalKeysEnabled(false);
		scroll = new JScrollPane(text);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
	
		status.setHorizontalAlignment(SwingConstants.CENTER);
		message.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(new Font("Courier",Font.PLAIN, 12));
		text.setLayout(null);
		text.setLocation(200,200);
		text.setText(game.toString());
		text.setAlignmentX(CENTER_ALIGNMENT);
		add(scroll, BorderLayout.CENTER);
		add(message, BorderLayout.SOUTH);
		add(status, BorderLayout.NORTH);
	}
	
		@Override
	  public void update(Observable observed, Object arg) {
//		text.setText(game.toString());
	    HunterModel model = (HunterModel) observed;
	    if (model.gameOver())
	    {
	    	status.setText("GAMEOVER");
	    	message.setText(model.gameOverMessage());
	    	for (int i=0; i<model.getDungeon().length; i++){
	    		for (int j=0; j<model.getDungeon()[i].length; j++){
	    			model.setVisible(i,j);
	    		}
	    	}
	    	
	    	String map = model.toString();
	    	text.setText(map);
	    	model.deleteObserver(this);
	    }
	    
	    else{
	    	
		    if (model.hasGoop(model.getHunterRow(), model.getHunterCol()))
		    {
		    	status.setText("Current Room: Goop");
		    	message.setText("Looks like there's goop on the floor...");
		    }
	    	
		    else if (model.hasBlood(model.getHunterRow(), model.getHunterCol()))
		    {
		    	status.setText("Current Room: Blood");
		    	message.setText("Looks like there's blood on the floor...");
		    }
		    
		    else if (model.hasSlime(model.getHunterRow(), model.getHunterCol()))
		    {
		    	status.setText("Current Room: Slime");
		    	message.setText("Looks like there's slime on the floor...");
		    }
		    else
		    {
		    	status.setText("Current Room: Nothing");
		    	message.setText("");
		    }
		    
		    String map = model.toString();
		    text.setText(map);
	    }

	  }
}
