package org.sunil.main;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sunil.entity.Department;
import org.sunil.entity.Employee;
import org.sunil.util.HibernateUtil;

public class Test {
	public static void main(String []args){
		SessionFactory sessionFactory = HibernateUtil.getFactoryInstance();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Department dept = new Department("HR");
		session.save(dept);

		Employee emp2 = new Employee("Employee2", dept);
		Employee emp3 = new Employee("Employee3", dept);

		session.save(emp2);
		session.save(emp3);

		tx.commit();

		System.out.println("*DEPARTMENTS*");
		List<Department> depts = session.createQuery("from Department order by deptName").list();

		for(Department d : depts){
			System.out.println(d.getDeptName());
		}
		
		System.out.println();
		
		System.out.println("*Employees*");
		
		List<Employee> employees = session.createQuery("from Employee").list();
		for(Employee emp : employees){
			System.out.println("Emp Name: "+emp.getName()+"\t"+emp.getDept().getDeptName());
		}

		session.close();
	}
}
