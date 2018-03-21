package SG;






import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
		addWindowListener(new WindowListener() {
		     // ...
		     public void windowClosing(WindowEvent event) {

		        LoaderSave.WriteSave("Files/Saves/Money.save", Logic.Money);
		        if(Panel.LockBlue==false) {
		        LoaderSave.WriteSave("Files/Saves/LockBlue.save", 0);
		        }else {
		        	LoaderSave.WriteSave("Files/Saves/LockBlue.save", 1);
		        }
		        
		        if(Panel.LockGreen==false) {
		        LoaderSave.WriteSave("Files/Saves/LockGreen.save", 0);
		        }else {
		        	 LoaderSave.WriteSave("Files/Saves/LockGreen.save", 1);
		        }
		        
		        if(Panel.LockSpider) {
		        	LoaderSave.WriteSave("Files/Saves/LockSpider.save", 0);
		        }else {
		        	LoaderSave.WriteSave("Files/Saves/LockSpider.save", 1);
		        }
		         System.exit(0);
		     }

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	
		
		
		setVisible(true);

		setBounds(0, 0, 630, 650);
		
		setResizable(true);
		
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tm = new Timer(100,new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				setTitle("Snake Game"+" "+"Score:"+" "+ Logic.score+"   Money: "+Logic.Money );
				
			}
			
		});
		tm.start();

			
	

		
		
		}
	
		
		
		
	}
	
	

