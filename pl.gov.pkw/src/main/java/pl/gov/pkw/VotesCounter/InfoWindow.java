package pl.gov.pkw.VotesCounter;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class InfoWindow extends JPanel {
	JLabel selectedCandidate;

	public InfoWindow(String string) {
		selectedCandidate = new JLabel(string);
		add(selectedCandidate);
	}
	
}
