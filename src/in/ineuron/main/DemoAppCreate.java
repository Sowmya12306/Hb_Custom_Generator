package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
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
			Employee emp = new Employee();
//			emp.setEmpId(9);
			emp.setEmpName("Surabhi");
			emp.setEmpSal(10016.89);
			Integer id = (Integer) session.save(emp);  // save method can be used with geneators for auto increment of id, it is serialzable, belongs to hibernate, This method give instructons to save the object and returns the generated value as return type to the application 
//			 emp in L1-cache 
		//	session.persist(emp); // this method return type is void, so does not support generated value concept, is JPA method implemented by hibernate, gives instruction to hibernte to perform save operation, doesn't allow to work with generators
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
				transaction.commit(); // stored in DB through ORM
			}
			else transaction.rollback();
			HibernateUtil.closeSession(session);
		}
		
	}

}
