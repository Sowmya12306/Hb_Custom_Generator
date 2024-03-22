package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.ineuron.model.CustomGen;
import in.ineuron.util.HibernateUtil;

public class DemoAppCreate {
	public static void main(String[] args) {
		Session session=null;
		boolean flag=false;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSession();
			
			if(session!=null) {
				transaction = session.beginTransaction();
			}
			if(transaction!=null)
			{
			CustomGen custom = new CustomGen();
			custom.setEmpName("Prajwal");
			custom.setSalary(34909.80);
			String id = (String) session.save(custom);  
			System.out.println("The id of the record is " + id) ;
			flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(flag ==true) {
				transaction.commit(); 
			}
			else transaction.rollback();
			HibernateUtil.closeSession(session);
		}
		
	}

}
