//Krishna Sindhuri Vemuri G01024066 SWE_645_HW4
//This is the Student data model with few validations and also named queries

package SWE645_VEMURI_HW4;

import java.io.Serializable;
import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries(value = { @NamedQuery(name = "selectall", query = "SELECT s FROM Student s"),
		@NamedQuery(name = "searchfirstname", query = "SELECT s FROM Student s WHERE s.firstName=:firstnames"),
		@NamedQuery(name = "searchlastname", query = "SELECT s FROM Student s WHERE s.lastName=:lastnames"),
		@NamedQuery(name = "searchcity", query = "SELECT s FROM Student s WHERE s.city=:city"),
		@NamedQuery(name = "searchstate", query = "SELECT s FROM Student s WHERE s.state=:state"),
		@NamedQuery(name = "searchall", query = "SELECT s FROM Student s WHERE s.city=:city AND s.state=:state AND s.firstName=:firstnames AND s.lastName=:lastnames"),
		@NamedQuery(name = "searchfirstnameslastnames", query = "SELECT s FROM Student s WHERE s.firstName=:firstnames AND s.lastName=:lastnames"),
		@NamedQuery(name = "searchfirstnamescity", query = "SELECT s FROM Student s WHERE s.firstName=:firstnames AND s.city=:city"),
		@NamedQuery(name = "searchfirstnamestate", query = "SELECT s FROM Student s WHERE s.state=:state AND s.firstName=:firstnames"),
		@NamedQuery(name = "searchlastnamescity", query = "SELECT s FROM Student s WHERE s.lastName=:lastnames AND s.city=:city"),
		@NamedQuery(name = "searchlastnamestate", query = "SELECT s FROM Student s WHERE s.state=:state AND s.lastName=:lastnames")

})
@Entity
@Table

public class Student implements Serializable {
	static final long serialVersionUID = 1L;
	int studentId;
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	String zip;
	String email;
	String phone;
	List<String> likedMost;
	String interested;
	String likelihood;
	String raffle;
	String dos;
	String dos1;
	String comments;
	double mean;
	double deviation;

	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "studentId")
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Column
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	
	
	
	
	
	@Column
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	
	
	
	@Column
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	
	
	@Column
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
	
	
	
	@Column
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	
	
	
	@Column
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}



	
	
	@Column
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	@Column
	public String getPhone() {
		return phone;
	}
	public void setPhone(String telephone) {
		this.phone = telephone;
	}


	
	
	
	@Column
	public String getDos() {
		return dos;
	}
	public void setDos(String dos) {
		this.dos = dos;
	}


	
	
	@Column
	public String getDos1() {
		return dos1;
	}
	public void setDos1(String dos1) {
		this.dos1 = dos1;
	}


	
	
	@Column
	@ElementCollection(fetch = FetchType.EAGER)
	public List<String> getLikedMost() {

		return likedMost;
	}
	public void setLikedMost(List<String> likedMost) {
		this.likedMost = likedMost;
	}


	@Column
	public String getInterested() {
		return interested;
	}
	public void setInterested(String interested) {
		this.interested = interested;
	}


	
	
	
	@Column
	public String getLikelihood() {
		return likelihood;
	}
	public void setLikelihood(String likelihood) {
		this.likelihood = likelihood;
	}

	

	
	
	
	@Column
	public String getRaffle() {
		return raffle;
	}
	public void setRaffle(String raffle) {
		this.raffle = raffle;
	}


	
	
	
	
	@Column
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	

	
	
	
	
	
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}

	
	
	
	public double getDeviation() {
		return deviation;
	}

	
    public void setDeviation(double deviation) {
	 	this.deviation = deviation;
	}

	

    
    
    
    public void validateRaffle(FacesContext context, UIComponent componenttobeValidated, Object value) {

		String validateData = (String) value;
		context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(
				"Enter atleast, 10 comma separated values between 1 and 100");

		if (!(validateRaffleData(validateData)))
			throw new ValidatorException(message);

	}

	
        
	
	    public boolean validateRaffleData(String validateData) {

		String[] raffleArray = validateData.split(",");

		for (int i = 0; i < raffleArray.length; i++) {
			if (raffleArray[i] == "")
				continue;
			else
				raffleArray[i] = raffleArray[i].trim();
		}

		try {
			if (raffleArray.length < 10) {
				return false;
			} else {
				for (int lcv = 0; lcv < raffleArray.length; lcv++) {
					if ((Integer.parseInt(raffleArray[lcv]) > 100)||(Integer.parseInt(raffleArray[lcv]) < 1)) {
						return false;
					}
				}
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
