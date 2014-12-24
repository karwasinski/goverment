package pl.gov.pkw.VotesCounter;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginWindow extends javax.swing.JPanel {
	private static final String RESPESEL = "[0-9]{11}";
	private static final String EMPTYSTRING = "";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton loginButton;
    private JComboBox<String> postCodeComboBox;
    private JLabel peselLabel;
    private JLabel postCodeLabel;
    private JPanel middlePanel;
    private JTextField peselTextField;
    private String selectedPostCode;

    
	public LoginWindow()
	{
		this.loginButton=new JButton("Login");
		this.postCodeComboBox=new JComboBox<String>();
		this.peselLabel = new JLabel("PESEL");
		this.postCodeLabel = new JLabel("PostCode");
		this.middlePanel = new JPanel();
		this.setPeselTextField(new JTextField(8));
		initComponents();
	}
	
	
	void initComponents()
	{	
		getPeselTextField().setTransferHandler(null);
        postCodeComboBox.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { EMPTYSTRING, "Item 2", "Item 3", "Item 4" }));//add option to ComboBox
        loginButton.setEnabled(false);
        postCodeComboBox.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent eventA) {
        		checkIfLoginButtonEneble();
        	}
        });
        getPeselTextField().addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
				validationPeselTextField(e);
			}
			
			public void keyReleased(KeyEvent e) {
				validationPeselTextField(e);
			}
			
			public void keyPressed(KeyEvent e) {
				
			}
		});
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JPanel postCodePanel= new JPanel();
        postCodePanel.setLayout(new FlowLayout());
        postCodePanel.add(postCodeLabel);
        postCodePanel.add(Box.createHorizontalStrut(60));
        postCodePanel.add(postCodeComboBox);
        
        JPanel peselPanel= new JPanel();
        peselPanel.setLayout(new FlowLayout());
        peselPanel.add(peselLabel);
        peselPanel.add(Box.createHorizontalStrut(50));
        peselPanel.add(getPeselTextField());
        
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        middlePanel.add(Box.createVerticalStrut(50));
        middlePanel.add(postCodePanel);
        middlePanel.add(Box.createVerticalGlue());
        middlePanel.add(Box.createVerticalStrut(50));
        middlePanel.add(peselPanel);
        middlePanel.add(Box.createVerticalStrut(50));
        middlePanel.add(Box.createVerticalGlue());
        middlePanel.add(loginButton);
        middlePanel.add(Box.createVerticalStrut(50));
        
        this.add(Box.createHorizontalStrut(50));
        this.add(middlePanel);
        this.add(Box.createHorizontalStrut(50));
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0),2));
        
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public boolean checkPesel() {
		/*	char numberPesel[]=getPeselTextField().getText().toCharArray();
			for (int i = 0; i<11; i++){
				if(!Character.isDigit(numberPesel[i])){
					return false;
				}
			}
				return true;*/
					
			if (getPeselTextField().getText().matches(RESPESEL))
				{
			    	return true;
			    }
			else return false;
	}
	public void validationPeselTextField(KeyEvent e){
		if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9'))
            e.consume();
		if (getPeselTextField().getText().length()>=11)
			e.consume();
		checkIfLoginButtonEneble();
		
	}
	public void checkIfLoginButtonEneble(){
		selectedPostCode=(String) postCodeComboBox.getSelectedItem();
    	if (!EMPTYSTRING.equals(selectedPostCode) && checkPesel())
    		{
    			loginButton.setEnabled(true);
    		}
    	else if (EMPTYSTRING.equals(selectedPostCode)|| !checkPesel())
    		loginButton.setEnabled(false);	
		
	}


	public JTextField getPeselTextField() {
		return peselTextField;
	}


	public void setPeselTextField(JTextField peselTextField) {
		this.peselTextField = peselTextField;
	}
}



