package employee.Inheritance;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class employeeDao {

	Configuration con;SessionFactory  sf;
	Session ses;
	Transaction tran ;
	
	public void connect() {
		con = new Configuration().configure().addAnnotatedClass(employee.class).addAnnotatedClass(FresherEmployee.class).addAnnotatedClass(ExperienceEmployee.class);
		sf = con.buildSessionFactory();
		ses = sf.openSession();
		tran = ses.beginTransaction();
	}
	
	public void disconnect() {
		tran.commit();
		ses.close();
	}
	
	public Session registerEmp(employee emp) {
		ses.save(emp);
		return ses;
	}
	
	public Session registerEmp(FresherEmployee f) {
		ses.save(f);
		return ses;
	}
	
	public Session registerEmp(ExperienceEmployee e) {
		ses.save(e);
		return ses;
	}
	
	public int deleteEmp(int id) {
		Query q = ses.createQuery("delete from employee emp where emp.empId=: Id").setParameter("Id", id);
		int count = q.executeUpdate();
		return count;
	}
	
	public employee fetchEmp(int id) {
		employee emp = (employee) ses.load(employee.class, id);
		return emp;
	}
	
	public List fetchAll() {
		Query q =  ses.createQuery(" from employee");
		List<employee> empl = q.getResultList();
		return empl;
	}
}
