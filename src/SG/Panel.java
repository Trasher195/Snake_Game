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
	
	private JButton Start, Exit;
	
	private Panel pan;
	
	public boolean DevStile = false;
	
	public final static Color Blaked = new Color(0, 0, 0, 150);
	
	

	
	private class MyKey implements KeyListener{
		
		public void keyPressed(KeyEvent e){
			
		int key = e.getKeyCode();
		
		if(key==KeyEvent.VK_ESCAPE) {
			
			if(Logic.stop==false)Logic.stop=true;
			else if(Logic.stop==true)Logic.stop=false;
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
				LScore.setText("Счет:"+ Logic.score);
				
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
		
		LScore = new JLabel("Счет: 0");
		LScore.setForeground(Color.WHITE);
		LScore.setFont(new Font("Serif", 0, 30));
		LScore.setBounds(250, 630, 150, 50);
		
		add(LScore);
		
		Start = new JButton("Новая игра");
		Start.setForeground(Color.BLUE);
		Start.setFont(new Font("Serif", 0, 20));
		Start.setBounds(250,200,150,50);
		Start.setVisible(false);
		Start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Logic.Start();
				Start.setFocusable(false);
				Exit.setFocusable(false);
				pan.setFocusable(true);
				Frame.Visible=true;
				
				
			}

		});
		
		add(Start);
		
		
		Exit = new JButton("Выход");
		Exit.setForeground(Color.RED);
		Exit.setFont(new Font("Serif", 0, 20));
		Exit.setBounds(250,300,150,50);
		Exit.setVisible(false);
		Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				
				Frame.Visible = false;
				
			}

		});
		
		add(Exit);
		
	}
	
	
	
	
	public void paintComponent (Graphics gr) {
		
		super.paintComponent(gr);
		
		
		if(Logic.stop==true) {
			gr.setColor(Color.BLACK);
			gr.drawString("PAUSED", 250, 100);
			Start.setVisible(true);
			Exit.setVisible(true);
			System.out.println("Drawed");
		}else{
			Start.setVisible(false);
			Exit.setVisible(false);
		}
		gr.setColor(Color.BLACK);
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
		
		
		
		
	}




	
	
	
}
