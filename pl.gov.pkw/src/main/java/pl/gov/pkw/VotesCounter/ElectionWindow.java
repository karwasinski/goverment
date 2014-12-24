package pl.gov.pkw.VotesCounter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class ElectionWindow  extends JPanel implements ActionListener {
	
	private JRadioButton option1;
	private JRadioButton option2;
	private JRadioButton option3;
	private JRadioButton selectedCandidate;
	private JButton confirmButton;
	private ButtonGroup options;
	public ElectionWindow() {
		this.option1 = new  JRadioButton("Candidat 1");
		this.option2 = new  JRadioButton("Candidat 2");
		this.option3 = new  JRadioButton("Candidat 3");
		this.selectedCandidate=new JRadioButton();
		this.confirmButton = new JButton("Confirm");
		this.options=new ButtonGroup();	
		initComponents();
	}
	
	void initComponents()
	{
		confirmButton.setEnabled(false);
		options.add(option1);
		options.add(option2);
		options.add(option3);
		option1.addActionListener(this);
		option2.addActionListener(this);
		option3.addActionListener(this);
		
		this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0),2));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createVerticalStrut(50));
		this.add(Box.createVerticalGlue());
		this.add(getRowElect(option1));
		this.add(Box.createVerticalStrut(15));
		this.add(getRowElect(option2));
		this.add(Box.createVerticalStrut(15));
		this.add(getRowElect(option3));
		this.add(Box.createVerticalStrut(15));
		this.add(confirmButton);
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalStrut(50));

	}
	JPanel getRowElect(JRadioButton option)
	{
		JPanel tempPanel= new JPanel();
		tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));
		tempPanel.add(Box.createHorizontalStrut(50));
		tempPanel.add(Box.createHorizontalGlue());
		tempPanel.add(option);
		tempPanel.add(Box.createHorizontalGlue());
		tempPanel.add(Box.createHorizontalStrut(150));
		return tempPanel;
	}
	public JRadioButton getSelectedCandidate() {
		return selectedCandidate;
	}
	public JButton getConfirmButton() {
		return confirmButton;
	}
	public void actionPerformed(ActionEvent event1) {
		selectedCandidate=(JRadioButton)event1.getSource();
		confirmButton.setEnabled(true);
	}
	
}
