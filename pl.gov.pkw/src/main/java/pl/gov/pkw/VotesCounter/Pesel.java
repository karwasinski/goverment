package pl.gov.pkw.VotesCounter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pesel {
	String pesel;
	private int[] peselInts = new int[11];
	private Date birthDate;
	private boolean validFlag;
	private boolean bornFlag;
	private boolean adultFlag;
	private Sex sex;


	public Pesel(String pesel) {
		this.pesel = pesel;
		char[] peselChars = pesel.toCharArray();
		char peselChar;
		for ( int i = 0; i < pesel.length(); i++){
			peselChar = peselChars[i];
			this.peselInts[i] = Integer.parseInt(String.valueOf(peselChar));
		}
		initFlags();
	}

	private void initFlags() {
		setValidFlag();	
		setBirthDate();
		setBornFlag();
		setAdultFlag();
		setSex();
	}

	public int countValidDigit() {
		int validDigit= (10-(1*peselInts[0] + 3*peselInts[1] + 7*peselInts[2] + 9*peselInts[3] + 1*peselInts[4] + 3*peselInts[5] + 7*peselInts[6] + 9*peselInts[7] + 1*peselInts[8] + 3*peselInts[9])%10)%10;
		return validDigit;
	}

	public void setBirthDate() {
		try {
			if ( peselInts[2] < 2 )
			this.birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(peselInts[4]+(peselInts[5]+"."+peselInts[2]+peselInts[3]+".19"+peselInts[0]+peselInts[1]));
			else if ( peselInts[2] < 4 )
			this.birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(peselInts[4]+(peselInts[5]+"."+(peselInts[2]-2)+peselInts[3]+".20"+peselInts[0]+peselInts[1]));
			else if ( peselInts[2] < 6 )
				this.birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(peselInts[4]+(peselInts[5]+"."+(peselInts[2]-4)+peselInts[3]+".21"+peselInts[0]+peselInts[1]));
			else if ( peselInts[2] < 8 )
				this.birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(peselInts[4]+(peselInts[5]+"."+(peselInts[2]-6)+peselInts[3]+".22"+peselInts[0]+peselInts[1]));
			else if ( peselInts[2] < 10 )
				this.birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(peselInts[4]+(peselInts[5]+"."+(peselInts[2]-8)+peselInts[3]+".18"+peselInts[0]+peselInts[1]));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setValidFlag() {
		validFlag = peselInts[10]==countValidDigit() ? true : false;
	}
	
	public boolean isValidFlag() {
		return validFlag;
	}
	
	public void setBornFlag() {
		Date date = new Date();
		bornFlag = birthDate.before(date) ? true : false;
	}
	
	public boolean isBornFlag() {
		return bornFlag;
	}
	
	public void setAdultFlag() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, -18);
		date = cal.getTime();
		adultFlag = birthDate.before(date) ? true : false;
	}

	public boolean isAdultFlag() {
		return adultFlag;
	}
	
	public void setSex() {
		if(peselInts[9]%2==0)
			this.sex = Sex.woman;
		else this.sex = Sex.men;
	}
	
	public Sex getSex() {
		return sex;
	}

}
