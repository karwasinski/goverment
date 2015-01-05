package hibernate;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import db.dto.Zip_codes;

public class  HibernateTest {
//	public static void main(String[] args) {
//	Zip_codes user = new Zip_codes();
//	user.setId(2);
//	user.setZip_code("55-447");
//	
//	
//	
//	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//	Session session = sessionFactory.openSession();//getCurrentSession();//
//
//	//Get All Zip_codes
//	Transaction tx = session.beginTransaction();
//	Query query = session.createQuery("from Zip_codes");
//	List<Zip_codes> zipList = query.list();
//	for(Zip_codes zip : zipList){
//		System.out.println("List of Employees::"+zip.getId()+","+zip.getZip_code());
//		}
//	
//	session.beginTransaction();
//	//session.save(user);
//	session.getTransaction().commit();
//	sessionFactory.close();
//	
//	}
	
}
