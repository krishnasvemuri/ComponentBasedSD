//Krishna Sindhuri Vemuri G01024066 SWE_645_HW4
//This is the Survey class 
package SWE645_VEMURI_HW4;

import java.io.Serializable;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ManagedBean
public class Survey implements Serializable {

	private static final long serialVersionUID = 1L;
	public String likelihoodOptions = "VeryLikely,Likely,UnLikely";
	public String[] LikelihoodArray = likelihoodOptions.split(",");

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	Student student = new Student();


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student stud) {
		this.student = stud;
	}

	Search search = new Search();

	
	public Search getSearch() {
		return search;
	}

	
	public void setSearch(Search search) {
		this.search = search;
	}

	StudentService service = new StudentService();

	
	public StudentService getService() {
		return service;
	}

	
	public void setService(StudentService service) {
		this.service = service;
	}

	WinningResult result = new WinningResult();

	
	public WinningResult getResult() {
		return result;
	}

	
	public void setResult(WinningResult result) {
		this.result = result;
	}

	
	public List<String> completeLikelihood(String choices) {
		List<String> option = new ArrayList<String>();
		for (String i : LikelihoodArray) {
			if (i.toUpperCase().startsWith(choices.toUpperCase())) {
				option.add(i);
			}
		}
		return (option);
	}


	ArrayList<Student> studentsrecords = new ArrayList<Student>();

	
	public ArrayList<Student> getStudentRecords() {
		return studentsrecords;
	}

	
	public void setStudentrecords(ArrayList<Student> studentrecords) {
		this.studentsrecords = studentrecords;
	}

	
	public String showSubmit() {

		StudentService service1 = new StudentService();
		double mean = service1.calculateMean(student);
		double deviation = service1.calculateStandardDeviation(student);
		result.setMean(mean);
		student.setMean(mean);
		result.setDeviation(deviation);
		student.setDeviation(deviation);
		student.setDeviation(result.getDeviation());
		student.setMean(result.getMean());
		try {
			StoreData.surveyData(student);
		} catch (Exception e) {
			e.printStackTrace();

		}

		if (result.getMean() >= 90) {
			return "WinnerAcknowledgement.jsf";
		} else {
			return "SimpleAcknowledgement.jsf";
		}
	}

	public void renderStateCity() {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/test/webresources/zips/");
		WebTarget resourceWebTarget;
		resourceWebTarget = target.path(new String(this.student.getZip() + ""));

		Invocation.Builder invocationBuilder;
		invocationBuilder = resourceWebTarget.request(MediaType.TEXT_PLAIN);
		Response response = invocationBuilder.get();

		String s = response.readEntity(String.class);

		student.setCity(s.split(",")[0]);
		student.setState(s.split(",")[1]);

	}


	public ArrayList<Student> getStudentsrecords() {

		EntityManager em = StoreData.getEntityManager();

		return (ArrayList<Student>) em.createNamedQuery("selectall", Student.class).getResultList();
	}

	public void renderAll() {
		ZipRest zipCode = new ZipRest();
		String cityState = "";

		cityState = zipCode.LookUp(student.getZip());
		if (cityState == null) {
			return;
		}
		student.setCity(cityState.split(",")[0]);
		student.setState(cityState.split(",")[1]);
	}

	
	public void validateDate(FacesContext context, UIComponent componentToValidate, Object value)
			throws ValidatorException {
		Date dateOfStart = ((Date) value);

		Object dateOfSurvey= componentToValidate.getAttributes().get("dateOfSurvey");
		Date surveyValue = (Date) ((org.primefaces.component.calendar.Calendar) dateOfSurvey).getValue();

		if (dateOfStart == null)
			return;

		if (dateOfStart.before(surveyValue)) {
			FacesMessage message = new FacesMessage("Date of Start can not be before Date of Survey");
			throw new ValidatorException(message);
		}

	}

}
