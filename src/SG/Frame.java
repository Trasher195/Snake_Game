package SG;






import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Frame extends JFrame {
	
	public static Timer tm;
	
	



	//
	//		Конструктор
	//
	public Frame() {
		//
		//		Создание и подключение Панели 
		//
		Panel pan = new Panel();
		Container con = getContentPane();
		con.add(pan);
		
		
		
		setVisible(true);

		setBounds(0, 0, 630, 650);
		
		setResizable(false);
		
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tm = new Timer(100,new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				setTitle("Snake Game"+" "+"Score:"+" "+ Logic.score);
				
			}
			
		});
		tm.start();

			
	

		
		
		}
	
		
		
		
	}
	
	

