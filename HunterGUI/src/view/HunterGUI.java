package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;

import model.HunterModel;

public class HunterGUI extends JFrame{

	public class Buttons extends JPanel{
		
		private ImageView buttons;
		private BasicArrowButton up, down, left, right;
		
		public Buttons(){
			
			super();
			
			ActionListener buttonListener = new ButtonListener();
			
			this.setLayout(new GridLayout(2, 3));
			this.setPreferredSize(new Dimension(75, 50));
			
			up = new BasicArrowButton(SwingConstants.NORTH);
			down = new BasicArrowButton(SwingConstants.SOUTH);
			left = new BasicArrowButton(SwingConstants.WEST);
			right = new BasicArrowButton(SwingConstants.EAST);
			
			up.setFocusable(false);
			down.setFocusable(false);
			left.setFocusable(false);
			right.setFocusable(false);
			
			up.addActionListener(buttonListener);
			down.addActionListener(buttonListener);
			left.addActionListener(buttonListener);
			right.addActionListener(buttonListener);
			
			add(new JPanel());
			add(up);
			add(new JPanel());
			add(left);
			add(down);
			add(right);
		}
		
		private class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0){
			
				if(arg0.getSource() == up){
					model.move("up");
				}
				if(arg0.getSource() == down){
					model.move("down");
				}
				if(arg0.getSource() == right){
					model.move("right");
				}
				if(arg0.getSource() == left){
					model.move("left");
				}
			}
		}
	}
	
	public class ArrowButtons extends JPanel{
		
		private ImageView buttons;
		private BasicArrowButton up, down, left, right;
		
		public ArrowButtons(){
			
			super();
			
			ActionListener buttonListener = new ButtonListener();
			
			this.setLayout(new GridLayout(2, 3));
			this.setPreferredSize(new Dimension(75, 50));
			
			up = new BasicArrowButton(SwingConstants.NORTH);
			down = new BasicArrowButton(SwingConstants.SOUTH);
			left = new BasicArrowButton(SwingConstants.WEST);
			right = new BasicArrowButton(SwingConstants.EAST);
			
			up.setFocusable(false);
			down.setFocusable(false);
			left.setFocusable(false);
			right.setFocusable(false);
			
			up.addActionListener(buttonListener);
			down.addActionListener(buttonListener);
			left.addActionListener(buttonListener);
			right.addActionListener(buttonListener);
			
			add(new JPanel());
			add(up);
			add(new JPanel());
			add(left);
			add(down);
			add(right);
		}
		
		private class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0){
			
				if(arg0.getSource() == up){
					model.shootArrow("up");
				}
				if(arg0.getSource() == down){
					model.shootArrow("down");
				}
				if(arg0.getSource() == right){
					model.shootArrow("right");
				}
				if(arg0.getSource() == left){
					model.shootArrow("left");
				}
			}
		}
	}
	
	public static void main(String[] args){
		new HunterGUI().setVisible(true);
	}
	
	private JTabbedPane tabbedPanels;
	private ImageView image;
	private HunterModel model = new HunterModel();
	private JPanel imageView = new ImageView();
	private JPanel textView = new TextView(model);
	private JPanel buttons = new Buttons();
	private JPanel buttonPanel = new JPanel();
	private JPanel arrowButtons = new ArrowButtons();
	private JLabel arrow = new JLabel("Shoot Arrow");
	private JLabel move = new JLabel("Move");

	
	public HunterGUI(){
		layoutGUI();
		registerListeners();
		setUpModelAndObservers();
	}

	private void setUpModelAndObservers() {
		model.addObserver((Observer) imageView);
		model.addObserver((Observer) textView);

	}

	private void registerListeners() {
		addKeyListener(new KeyboardListener());
	}

	private void layoutGUI() {

		setTitle("Hunter and the Wumpus");
		setSize(400, 400);
		setLocation(700,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		tabbedPanels = new JTabbedPane();
		tabbedPanels.add(imageView, "ImageView");
		tabbedPanels.add(textView, "TextView");
		
		
		add(tabbedPanels, BorderLayout.CENTER);
		buttonPanel.setLayout(new GridLayout(2,2, 15, 0));
		buttonPanel.add(move);
		move.setHorizontalAlignment(move.CENTER);
		buttonPanel.add(arrow);
		arrow.setHorizontalAlignment(arrow.CENTER);
		buttonPanel.add(buttons);
		buttonPanel.add(arrowButtons);
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	private class KeyboardListener implements KeyListener{
		
		public void keyPressed(KeyEvent arg0) {

			switch(arg0.getKeyCode()){
				case KeyEvent.VK_UP:
					model.move("up");
					break;
				case KeyEvent.VK_DOWN:
					model.move("down");
					break;
				case KeyEvent.VK_LEFT:
					model.move("left");
					break;
				case KeyEvent.VK_RIGHT:
					model.move("right");
					break;
				default:
					break;
			}
		}

		public void keyReleased(KeyEvent arg0) {}
		public void keyTyped(KeyEvent arg0) {}
	}
}
