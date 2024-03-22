package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.CustomGen;
import in.ineuron.util.HibernateUtil;

public class SelectDemo {

	public static void main(String[] args) {
		Session session = null;
		CustomGen cusGen = null;
		int id=1;
		
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				cusGen = session.load(CustomGen.class, id);
				System.out.println(cusGen);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("employee doesn't exist");
		}
	}

}
