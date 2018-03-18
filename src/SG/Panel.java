package SG;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel  {
	
	

	

	

	private Logic Logic;
	
	private Timer tmDraw,  tmUpdate;
	
	public static Image Bg, Body, Score, End;
	
	public static Image Head_down;

	public static Image Head_left;

	public static Image Head_right;

	public static Image Head_up;
	
	public static Image Head;
	
	private JLabel LScore;
	
	private JButton Start, Exit, Achievements, Shop, exitshop;
	
	private Panel pan;
	
	public boolean ach, shop;
	
	public final static Color Blaked = new Color(0, 0, 0, 150);
	
	

	
	private class MyKey implements KeyListener{
		
		public void keyPressed(KeyEvent e){
			
		int key = e.getKeyCode();
		
		if(key==KeyEvent.VK_ESCAPE) {
			
			if(Logic.stop==false)Logic.stop=true;
			else if(Logic.stop==true)Logic.stop=false;
			if(shop==true)shop=false;
		
			if(ach==true)ach=false;
			
				repaint();
			System.out.println("PAUSE");
			}
			
		
		
		if(key==KeyEvent.VK_LEFT){
			Logic.new_napr = 0;
		
		}
		else if(key==KeyEvent.VK_UP){
			Logic.new_napr = 1;
			
		}
		else if(key==KeyEvent.VK_RIGHT){
			Logic.new_napr = 2; 
			
		}
		else if(key==KeyEvent.VK_DOWN){
			Logic.new_napr = 3;
			
		}
		
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
			
		}
		
	}
	
	
	
	
	public Panel() {
		pan = this;
		
		this.addKeyListener(new MyKey());
		this.setFocusable(true);
		
		try {
			
			Bg = ImageIO.read(new File("BG.jpg"));
			
			Body = ImageIO.read(new File("Snake_body.jpg"));
			
			Head_down = ImageIO.read(new File("Snake_head_down.jpg"));
			
			Head_left = ImageIO.read(new File("Snake_head_left.jpg"));
			
			Head_right = ImageIO.read(new File("Snake_head_right.jpg"));
			
			Head_up = ImageIO.read(new File("Snake_head_up.jpg"));
			
			Score = ImageIO.read(new File("Snake_Score.png"));
			
			// End = ImageIO.read(new File("BG.jpg"));
			
			Head = Head_left;
			
			
		}catch(Exception ex){}
		
		Logic = new Logic();
			
		Logic.Start();
		tmUpdate = new Timer(100,new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Logic.endg==false && Logic.stop==false) {
					Logic.perem();
				}
				
				
			}
			
		});
		tmUpdate.start();
			
		
		tmDraw = new Timer(20,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				repaint();
				
				
			}
			
		});
		
		tmDraw.start();
		
		setLayout(null);
		
		
		
		Start = new JButton("New Game");
		Start.setForeground(Color.BLUE);
		Start.setFont(new Font("Serif", 0, 20));
		Start.setBounds(250,200,150,50);
		Start.setVisible(false);
		Start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Logic.Start();
				shop =false;
				ach =false;
				Start.setFocusable(false);
				Achievements.setVisible(false);
				Shop.setVisible(false);
				Exit.setFocusable(false);
				pan.setFocusable(true);
				
				
				
			}

		});
		
		add(Start);
		
		
		Achievements = new JButton("Achievements");
		Achievements.setForeground(Color.BLUE);
		Achievements.setFont(new Font("Serif", 0, 20));
		Achievements.setBounds(250,300,150,50);
		Achievements.setVisible(false);
		Achievements.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ach = true;
				shop=false;
				repaint();
				Start.setFocusable(false);
				Achievements.setVisible(false);
				Shop.setVisible(false);
				Exit.setFocusable(false);
				pan.setFocusable(true);
				
				
				
			}

		});
		
		add(Achievements);
		
		Shop = new JButton("Shop");
		Shop.setForeground(Color.BLUE);
		Shop.setFont(new Font("Serif", 0, 20));
		Shop.setBounds(250,400,150,50);
		Shop.setVisible(false);
		Shop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				shop = true;
				ach= false;
				repaint();
				Start.setFocusable(false);
				Achievements.setVisible(false);
				Shop.setVisible(false);
				Exit.setFocusable(false);
				pan.setFocusable(true);
				
				
				
			}

		});
		
		add(Shop);
		
		
		Exit = new JButton("Exit");
		Exit.setForeground(Color.RED);
		Exit.setFont(new Font("Serif", 0, 20));
		Exit.setBounds(250,500,150,50);
		Exit.setVisible(false);
		Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		
		add(Exit);
		
		exitshop = new JButton("Exit on menu");
		exitshop.setForeground(Color.RED);
		exitshop.setFont(new Font("Serif", 0, 20));
		exitshop.setBounds(10,10,150,50);
		exitshop.setVisible(false);
		exitshop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				shop=false;
				ach=false;
				exitshop.setVisible(false);
				
			}

		});
		add(exitshop);
		
	}
	
	
	
	
	public void paintComponent (Graphics gr) {
		
		super.paintComponent(gr);
		
		gr.drawImage(Bg, 0, 0, 635, 750, null);
		
		
		
		
		
		
		for(int i = 0; i<30; i++) {
			for(int j = 0; j<30; j++) {
				if(Logic.mas[i][j] != 0) {
					
					
					if(Logic.mas[i][j] == -1) {
						gr.drawImage(Score, 10+j*20, 10+i*20, 20, 20, null);
						
					}
					
					
					else if(Logic.mas[i][j] == 1) {
						gr.drawImage(Head, 10+j*20, 10+i*20, 20, 20, null);
						
					}
					
					else if(Logic.mas[i][j] >= 2) {
						gr.drawImage(Body, 10+j*20, 10+i*20, 20, 20, null);
						
					}
				}
			}
		}
		
		gr.setColor(Color.BLACK);
		
		for(int i = 0; i<= 30; i++) {
			gr.drawLine(10+i*20, 10, 10+i*20, 610);
			
			gr.drawLine(10, 10+i*20, 610, 10+i*20);
		}
		
		if(Logic.stop==true || Logic.endg==true || shop==true || ach==true) {
			gr.setColor(Blaked);
			gr.fillRect(0, 0, 635, 750);
			gr.setColor(Color.RED);
			Start.setVisible(true);
			Achievements.setVisible(true);
			Shop.setVisible(true);
			Exit.setVisible(true);
			
				if(Logic.endg==true){
					gr.setFont(new Font("TimesRoman", Font.BOLD, 35));
					gr.drawString("Game End", 250, 100);
					gr.drawString("You Score: "+Logic.score, 225, 150);
				}
				else if(Logic.stop==true){
					String text;
					text = "Paused";
					gr.setFont(new Font("TimesRoman", Font.BOLD, 38));
					if(shop!=true && ach!=true){
					gr.drawString(text, 250, 100);
					exitshop.setVisible(false);
					}
					
					if(shop==true){
						text = "Shop";
						gr.setFont(new Font("TimesRoman", Font.BOLD, 38));
						gr.drawString(text, 250, 100);
						Start.setVisible(false);
						Achievements.setVisible(false);
						Shop.setVisible(false);
						Exit.setVisible(false);
						exitshop.setVisible(true);
						
						
					}
					
					
					else if(ach==true){
						text = "Achievements";
						gr.setFont(new Font("TimesRoman", Font.BOLD, 38));
						gr.drawString(text, 250, 75);
						Start.setVisible(false);
						Achievements.setVisible(false);
						Shop.setVisible(false);
						Exit.setVisible(false);
						exitshop.setVisible(true);
					}
				}
				
			
			
		}else{
			Start.setVisible(false);
			Achievements.setVisible(false);
			Shop.setVisible(false);
			Exit.setVisible(false);
		}
		gr.setColor(Color.BLACK);
		
		
		
		
	}




	
	
	
}
