package hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import db.dto.UserDetails;

public class  HibernateTest {
	public static void main(String[] args) {
	UserDetails user = new UserDetails();
	user.setUserId(1);
	user.setUserName("Jan Nowak");
	
	//@SuppressWarnings("deprecation")
	SessionFactory sesionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sesionFactory.openSession();
	session.beginTransaction();
	session.save(user);
	session.getTransaction().commit();
	
	}
	
}
