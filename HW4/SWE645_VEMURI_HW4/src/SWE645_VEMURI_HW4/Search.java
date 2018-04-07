//Krishna Sindhuri Vemuri G01024066 SWE_645_HW4
//This is the Search data model used to search from database 

package SWE645_VEMURI_HW4;

import java.io.Serializable;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.faces.bean.SessionScoped;







@ManagedBean
@SessionScoped
public class Search implements Serializable {

	private static final long serialVersionUID = 1L;

	String firstName;
	String lastName;
	String city;
	String state;

	ArrayList<Student> surveyList;

	
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	
	
	
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
	
	public ArrayList<Student> getSurveyList() {
		return surveyList;
	}

	public void setSurveyList(ArrayList<Student> surveyList) {
		this.surveyList = surveyList;
	}



	
	
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	
	
	
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

		
	
	/**
	 * @param studentid
	 */
	public void deleteRows(int studentid) {

		EntityManager em = StoreData.getEntityManager();

		Map<String, String> value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String action = value.get("student");
		Student student = em.find(Student.class, studentid);
		em.getTransaction().begin();
		em.remove(student);
		em.getTransaction().commit();

	}

	public String searchRecords() {

		EntityManager em1 = StoreData.getEntityManager();

		CriteriaBuilder builder = em1.getCriteriaBuilder();
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);

		Root<Student> student = criteria.from(Student.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (!(firstName.trim().equals(""))) {
			System.out.println("firstnames");
			predicates.add(builder.equal(student.get("firstName"), getFirstName()));
		}

		if (!(lastName.trim().equals(""))) {
			System.out.println("lastnames");
			predicates.add(builder.equal(student.get("lastName"), getLastName()));
		}

		if (!(city.trim().equals(""))) {
			System.out.println("city");
			predicates.add(builder.equal(student.get("city"), getCity()));
		}
		if (!(state.trim().equals(""))) {
			System.out.println("state");
			predicates.add(builder.equal(student.get("state"), getState()));
		}

		criteria.select(student).where(predicates.toArray(new Predicate[] {}));
		surveyList = (ArrayList<Student>) em1.createQuery(criteria).getResultList();
		for (Student student1 : surveyList) {
			System.out.println(student1.getFirstName());
		}

		return "SearchResults.jsf";
	}

}
