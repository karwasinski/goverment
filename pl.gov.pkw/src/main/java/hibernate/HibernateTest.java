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
	user.setId(1);
	user.setZip_code("50-447");
	
	
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();//openSession();

	session.beginTransaction();
	//session.save(user);
	session.getTransaction().commit();
	sessionFactory.close();
	
	}
	
}
