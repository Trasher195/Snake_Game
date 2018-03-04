package SG;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {
int i=0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSnakeGame = new JLabel("SNAKE GAME");
		lblSnakeGame.setBounds(5, 5, 624, 55);
		lblSnakeGame.setForeground(new Color(139, 0, 0));
		lblSnakeGame.setBackground(new Color(0, 0, 255));
		lblSnakeGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnakeGame.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 55));
		contentPane.add(lblSnakeGame);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				if(i==0) {
					Frame frame = new Frame();
					i++;
				}
				else if(i>=1) {
					Frame.Visible=true;
				}
				
				setVisible(false);
				
				
			}
		});
		btnPlay.setFont(new Font("Miriam Fixed", Font.BOLD, 24));
		btnPlay.setBounds(264, 134, 160, 50);
		contentPane.add(btnPlay);
		
		JButton btnNewButton = new JButton("SETTINGS\r\n");
		btnNewButton.setFont(new Font("Miriam Fixed", Font.BOLD, 24));
		btnNewButton.setBounds(264, 195, 160, 50);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Miriam Fixed", Font.BOLD, 24));
		btnExit.setBounds(264, 253, 160, 50);
		contentPane.add(btnExit);
	}
}
