package pl.gov.pkw.VotesCounter;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WindowManager extends JFrame {
	LoginWindow firstLW;
	ElectionWindow firstEW;
	InfoWindow firstIW;
	
	WindowManager()
	{
		super("Login");
		firstLW = new LoginWindow();
		firstEW = new ElectionWindow();
		
		initComponents();
	}
	void initComponents()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(400, 400));
		this.setPreferredSize(new Dimension(500,500));
		this.setMaximumSize(new Dimension(600, 600));
		this.setLocation(300, 200);
		this.add(firstLW);
		this.setVisible(true);
		
		firstLW.getLoginButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event1) 
			
			{
				Pesel pesel = new Pesel (firstLW.getPeselTextField().getText());
				if(pesel.isValidFlag())	changePanel(firstEW);
				else System.out.println("Typed pesel is not valid");
			}
		});

		firstEW.getConfirmButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event2) 
			
			{
				firstIW = new InfoWindow (firstEW.getSelectedCandidate().getText());
				changePanel(firstIW);

			}
		});
	}
	
	public void changePanel(JPanel newPanel)
	{
		getContentPane().removeAll();
		getContentPane().add(newPanel);
		getContentPane().revalidate();
	}
	
}
