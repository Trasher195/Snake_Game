package SG;






import java.awt.Container;

import javax.swing.*;

public class Frame extends JFrame {

	

	

	//
	//		�����������
	//
	public Frame() {
		//
		//		�������� � ����������� ������ 
		//
		Panel pan = new Panel();
		Container con = getContentPane();
		con.add(pan);
		
		setTitle("Snake Game");
		
		setBounds(0, 0, 800, 650);
		
		setResizable(false);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
}
