package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Employee;

public class TestApp {

	public static void main(String[] args) {
		//step-1 to create configuration object
		Configuration cfg = new Configuration();
		
		// step-2 to load mapping details, DB details into config object using configure() method
		cfg.configure(); //cofigures all properties from hibernate.cfg.xml by default
		
		//Step-3 To create sessionFacory object which contains pool of different objects need to perform hibernate operations	
		SessionFactory sessionFac = cfg.buildSessionFactory();
		
		// Step-4 open session by keeping our cfg info  
		Session session =sessionFac.openSession();
		
		//Step-5 Begin transaction (no needed for select operations)
		Transaction transaction = session.beginTransaction();  // this is only necessary for non-select operations like create, update, delete
		
		
		Employee emp = new Employee();
		emp.setEmpId(1);
		emp.setEmpName("suresh");
		emp.setEmpSal(2300.89);
		
		//Step-6 save object details in session
		session.save(emp);
		
        //Step-7 Commit transaction	
		transaction.commit();
		
		//step-8 Close the session 
		session.close();

	}

}
