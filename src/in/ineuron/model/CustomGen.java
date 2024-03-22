package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CustomGen implements Serializable{
	
	
	private static final long serialVersionUID = -4578836933763597845L;
	@Id
	@GenericGenerator(name = "emp_id", strategy = "in.ineuron.generator.RandomGenerator")
	@GeneratedValue(generator = "emp_id")  
	private String eId;
	@Column(unique= true, nullable = false)
	private String empName;
	private Double salary;
	
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "CustomGen [eId=" + eId + ", empName=" + empName + ", salary=" + salary + "]";
	}
	
}