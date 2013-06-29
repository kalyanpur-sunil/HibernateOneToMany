package org.sunil.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT")
public class Department implements Serializable{

	private static final long serialVersionUID = -984323948152845047L;

	@Id
	@GeneratedValue
	@Column(name="deptId")
	private int deptId;

	@Column(name="deptName", nullable=false)	
	private String deptName;

	@OneToMany(mappedBy="dept", cascade=CascadeType.ALL,targetEntity=Employee.class,fetch=FetchType.LAZY)
	private List<Employee> empList = new ArrayList<Employee>();

	public Department() {
		super();
	}

	public Department( String deptName) {
		super();
		this.deptName = deptName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
