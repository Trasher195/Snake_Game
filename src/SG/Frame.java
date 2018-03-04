package SG;






import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Frame extends JFrame {
	public static boolean Visible = true;
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
		
		setTitle("Snake Game");
		
		Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize();
		
		int vert = sSize.height;
		int hor  = sSize.width;

		setBounds(0, 0, 635, 750);
		
		setResizable(false);
		
		setUndecorated(false);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tm = new Timer(1,new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Visible==true) {
					setVisible(true);
				}
				else if(Visible==false) {
					setVisible(false);
					
					
				}
			
				
			}
			
		});
		tm.start();

			
	

		
		
		}
	
		
		
		
	}
	
	

