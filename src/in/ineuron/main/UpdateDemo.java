package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class UpdateDemo {

	public static void main(String[] args) {
		Session session = null;
		Employee emp= null;
		Transaction transaction = null;
		int id=6;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				transaction = session.beginTransaction();
				if(transaction!=null) {
				    emp = new Employee();
					emp.setEmpId(id);
					emp.setEmpName("Abhisheik");
					emp.setEmpSal(22779.45);
					session.saveOrUpdate(emp);
					flag =true;
				System.out.println(emp);
				}
			}
		} catch (HibernateException e) {
//			e.printStackTrace();
			System.out.println("employee doesn't exist");
			flag= false;
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("record updated succesfully...");
			}
			else transaction.rollback();
		}
	}

}
