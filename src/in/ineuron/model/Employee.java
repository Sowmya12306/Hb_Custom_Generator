package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="empTab")
public class Employee {
	
	/*@Id
	@Column(name="eid")
	@GenericGenerator(name ="gen1", strategy = "assigned")
	@GeneratedValue(generator = "gen1") 
	private Integer empId; */
	
	/*@Id
	@Column(name="eid")
	@GenericGenerator(name ="gen1", strategy = "increment")
	@GeneratedValue(generator = "gen1") 
	private Integer empId; */
	
	/*@Id
	@Column(name="eid")
	@GenericGenerator(name ="gen1", strategy = "identity")
	@GeneratedValue(generator = "gen1") */
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	
	@Column(name="ename")
	private String empName;
	
	@Column(name="esal")
	private Double empSal;
	
	static {
		System.out.println("Employee.class is loading....");
	}
	public Employee() {
		System.out.println("Mandatory zero args constructor");
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}

}
