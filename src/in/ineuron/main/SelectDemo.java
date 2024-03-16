package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class SelectDemo {

	public static void main(String[] args) {
		Session session = null;
		Employee employee = null;
		int id=3;
		
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				employee = session.load(Employee.class, id);
				System.out.println(employee);
			}
		} catch (HibernateException e) {
//			e.printStackTrace();
			System.out.println("employee doesn't exist");
		}
	}

}
