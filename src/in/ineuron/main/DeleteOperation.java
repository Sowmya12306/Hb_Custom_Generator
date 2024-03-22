package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.CustomGen;
import in.ineuron.util.HibernateUtil;

public class DeleteOperation {

	public static void main(String[] args) {
		Session session = null;
		CustomGen cusGen = null;
		Transaction transaction = null;
		boolean flag = false;
		String id="MCA93580";
		
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				transaction = session.beginTransaction();
				if(transaction!=null) {
				cusGen = session.get(CustomGen.class, id);
				if(cusGen!=null) {
					session.delete(cusGen);
					flag = true;
				}
				else
					System.err.println("Record Not Found!......");
			}
		}
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			HibernateUtil.closeSession(session);
		}
	}

}
