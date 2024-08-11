package Springmvcproject1.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import Springmvcproject1.dto.EmployeeDto;

@Component
public class EmployeeDao {

		EntityManagerFactory e=Persistence.createEntityManagerFactory("mvcproject1");
		EntityManager m=e.createEntityManager();
		EntityTransaction t=m.getTransaction();
		
		public void addUser(EmployeeDto s) {
			t.begin();
			m.persist(s);
			t.commit();
		}

		public List<EmployeeDto> fetchall() {
			javax.persistence.Query q=m.createQuery("select a from EmployeeDto a");
		
			List<EmployeeDto> l=q.getResultList();
	
			return l;
		
		}
		
		public Object deleteID(int id) {
			
			EmployeeDto d2=m.find(EmployeeDto.class, id);
			if(d2!=null) {
				t.begin();
				m.remove(d2);
				t.commit();
				return "data deleted sucssfully from data base";
			}else {
				return "no data found in database";
			}
		}
		
		public Object fetchID( int id) {
			EmployeeDto d1=m.find(EmployeeDto.class, id);
			if(d1!=null) {
				return d1;
			}else {
				return "no data found";
			}
		}
		
		public String updatewith(int id, String name) {
			// TODO Auto-generated method stub
			EmployeeDto d1=m.find(EmployeeDto.class, id);
//				d1.setId(id);
				d1.setName(name);
		        t.begin();
		        m.merge(d1);
		        t.commit();
		        return "database is updated";
		}
}
