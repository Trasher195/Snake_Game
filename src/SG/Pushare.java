package SG;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pushare extends JDialog {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public Pushare(String product, int price) {
		
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("Pushare");
		setBounds(100, 100, 616, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblYouWantTo = new JLabel("You want to buy "+product+"?"+"\r\n\r\nFor"+price+"gold");
			lblYouWantTo.setForeground(Color.BLACK);
			lblYouWantTo.setHorizontalAlignment(SwingConstants.CENTER);
			lblYouWantTo.setBounds(27, 10, 563, 136);
			lblYouWantTo.setFont(new Font("Lucida Console", Font.PLAIN, 18));
			contentPanel.add(lblYouWantTo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if(Logic.Money<=price) {
						Logic.Money=Logic.Money - price;
						if(product=="Blue Pack") {
							Panel.LockBlue= false;
							dispose();
						}
						else if(product=="Green Pack") {
							Panel.LockGreen=false;
							dispose();
						}
						else if(product=="Spider Pack") {
							Panel.LockSpider=false;
							dispose();
						}
						}else {
							Error er = new Error();
						}
					}
					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
