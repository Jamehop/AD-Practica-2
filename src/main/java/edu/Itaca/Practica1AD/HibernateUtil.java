package edu.Itaca.Practica1AD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {


	private static Session session;
	private HibernateUtil() {
		
	}
	/*public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		HibernateUtil.session = session;
	}*/
	
	public static Session setUp() throws Exception{
		if(session==null) {
			Configuration configuration=new Configuration().configure();
			SessionFactory sessionFactory=configuration.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
			session=sessionFactory.openSession();
		}
		return session;
	}
	
	public static void shutDown() {
		session.close();
	}
}
