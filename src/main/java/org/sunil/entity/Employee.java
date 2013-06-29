package org.sunil.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable{
	
	private static final long serialVersionUID = -6901776304271335193L;

	@Id
	@GeneratedValue
	@Column(name="empId")
	private int id;
	
	@Column(name="empName")
	private String name;

	@ManyToOne(targetEntity=Department.class)
	@JoinColumn(name="deptId")
	private Department dept;
	
	public Employee() {
		super();
	}

	public Employee(String name, Department dept) {
		super();
		this.name = name;
		this.dept = dept;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	
}
