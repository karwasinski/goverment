package hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import db.dto.UserDetails;

public class  HibernateTest {
	public static void main(String[] args) {
	UserDetails user = new UserDetails();
	user.setUserId(1);
	user.setUserName("Jan Nowak");
	
	Configuration configuration = new Configuration();
	configuration.configure("hibernate.cfg.xml");
	System.out.println("Hibernate Configuration loaded");
	
	ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	System.out.println("Hibernate serviceRegistry created");
	
	SessionFactory sessionFactory = configuration.buildSessionFactory(sr);
	Session session = sessionFactory.getCurrentSession();//openSession();
	session = sessionFactory.openSession();
	session.beginTransaction();
	session.save(user);
	session.getTransaction().commit();
	session.close();
	
	}
	
}
