package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class DeleteDemo {

	public static void main(String[] args) {
		Session session = null;
		Employee employee = null;
		Transaction transaction = null;
		boolean flag = false;
		int id=3;
		
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				transaction = session.beginTransaction();
			}
			if(transaction!=null) {
				Employee emp = session.get(Employee.class, id); //emp record is fetched 
				if(emp!=null) { // checks the record is present or not 
				session.delete(emp); //performs delete operation and stores in L1 cache
				flag = true;
				}
				else
					System.out.println("record not available for deletion..");
				return;
			}
		}
			catch (HibernateException e) {
			System.out.println("No record exists");
			flag = false;

		}
		finally {
			if(flag==true) {
				transaction.commit();  //if record is present for deletion then delete it from DB
				System.out.println("Record deleted succesfully...");
			}
			else {
				transaction.rollback();
				System.out.println("Record deletion failed");
			}
			HibernateUtil.closeSession(session);
		}
	}

}
