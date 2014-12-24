package pl.gov.pkw.TestVotesCounter;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.gov.pkw.VotesCounter.Pesel;
import pl.gov.pkw.VotesCounter.Sex;

public class TestPeselValidation {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void lastDigitShouldEquelCountedValidDigit() {
		Pesel pesel = new Pesel ("91091504432");
		assertEquals(2, pesel.countValidDigit());
	}
	
	@Test
	public void birthDateShouldBeGiven() {
		Pesel pesel = new Pesel ("91091504432");
		Date date = new Date();
		try {
			date = new SimpleDateFormat("dd.MM.yyyy").parse("15.09.1991");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertEquals(date, pesel.getBirthDate());
	}
	
	@Test
	public void birthAfter2000DateShouldBeGiven() {
		Pesel pesel = new Pesel ("91291504432");
		Date date = new Date();
		try {
			date = new SimpleDateFormat("dd.MM.yyyy").parse("15.09.2091");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertEquals(date, pesel.getBirthDate());
	}
	
	@Test
	public void birthBefore1900DateShouldBeGiven() {
		Pesel pesel = new Pesel ("91891504432");
		Date date = new Date();
		try {
			date = new SimpleDateFormat("dd.MM.yyyy").parse("15.09.1891");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertEquals(date, pesel.getBirthDate());
	}
	
	@Test
	public void checkIfUserIsBorn() {
		Pesel pesel = new Pesel ("91091504432");
		assertEquals(true, pesel.isBornFlag());
	}
	
	@Test
	public void checkIfUserIsAdult() {
		Pesel pesel = new Pesel ("91891504432");
		assertEquals(true, pesel.isAdultFlag());
	}
	
	@Test
	public void checkSexOfUser() {
		Pesel pesel = new Pesel ("91891504432");
		assertEquals(Sex.men, pesel.getSex());
	}

}
