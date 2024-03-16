package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Employee;

public class StandardWay {

	public static void main(String[] args) {
		
		
		
		Configuration cfg = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		boolean flag = false;
		Integer idValue = null;
		
	    cfg =new Configuration();
	    cfg.configure();
	    System.out.println("generated properties "+ cfg.getProperties());
	    sessionFactory = cfg.buildSessionFactory();
	    session = sessionFactory.openSession();
	    
	    
	    Employee emp = new Employee();
	    emp.setEmpId(2);
	    emp.setEmpName("Rajesh");
	    emp.setEmpSal(2300.89);
		
	    try {
	    	transaction = session.beginTransaction();
	    	idValue = (Integer)(session.save(emp));
	    	System.out.println("Generated value "+ idValue);
	    	flag=true;
	    }catch(HibernateException ex) {
	    	ex.printStackTrace();
	    }catch(Exception ex) {
	    	ex.printStackTrace();
	    }
	    	finally {
	    	if (flag ==true) {
	    		transaction.commit();
	    	}
	    	else transaction.rollback();
	    	sessionFactory.close();
	    	session.close();
	    }

	}

}
