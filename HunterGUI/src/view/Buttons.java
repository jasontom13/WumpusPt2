//package view;
//
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JPanel;
//import javax.swing.SwingConstants;
//import javax.swing.plaf.basic.BasicArrowButton;
//
//public class Buttons extends JPanel{
//	
//	private ImageView buttons;
//	private BasicArrowButton up, down, left, right;
//	
//	public Buttons(){
//		
//		super();
//		
//		ActionListener buttonListener = new ButtonListener();
//		
//		this.setLayout(new GridLayout(2, 3));
//		this.setPreferredSize(new Dimension(75, 50));
//		
//		up = new BasicArrowButton(SwingConstants.NORTH);
//		down = new BasicArrowButton(SwingConstants.SOUTH);
//		left = new BasicArrowButton(SwingConstants.WEST);
//		right = new BasicArrowButton(SwingConstants.EAST);
//		
//		up.setFocusable(false);
//		down.setFocusable(false);
//		left.setFocusable(false);
//		right.setFocusable(false);
//		
//		up.addActionListener(buttonListener);
//		down.addActionListener(buttonListener);
//		left.addActionListener(buttonListener);
//		right.addActionListener(buttonListener);
//		
//		add(new JPanel());
//		add(up);
//		add(new JPanel());
//		add(left);
//		add(down);
//		add(right);
//	}
//	
//	private class ButtonListener implements ActionListener{
//		public void actionPerformed(ActionEvent arg0){
//		
//			if(arg0.getSource() == up){
//				buttons.move("down");
//			}
//			if(arg0.getSource() == down){
//				buttons.moveImage(5, 5);
//			}
//			if(arg0.getSource() == down){
//				buttons.moveImage(5, 5);
//			}
//			if(arg0.getSource() == down){
//				buttons.moveImage(5, 5);
//			}
//		}
//	}
//}
