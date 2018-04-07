//Krishna Sindhuri Vemuri G01024066 SWE_645_HW3
//This is the StudentBean data model.
package SWE645_VEMURI_HW3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response;

@ManagedBean(name="studentBean")
@ApplicationScoped
public class StudentBean {

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String email;
	private Date dos;
	private Date dos1;
	private String[] likedMost;
	private String likedMost1;
	private String interested;
	private String likelihood;
	private String raffle;
	private String comments;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
			
			Client cl = ClientBuilder.newClient();
	        WebTarget target = cl.target("http://ec2-34-230-62-99.compute-1.amazonaws.com/SWE645_VEMURI_HW3/webresources/ziprest/");
	   
	        WebTarget resourceWebTarget;
	        resourceWebTarget = target.path(this.zip);
	               
	        Invocation.Builder invocationBuilder;
	        invocationBuilder = resourceWebTarget.request(MediaType.TEXT_PLAIN);
	        Response response = invocationBuilder.get();
	        
	        String s = response.readEntity(String.class);
	        setCity(s.split("-")[0]);
	        setState(s.split("-")[1]);
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDos() {
		return dos;
	}
	public void setDos(Date dos) {
		this.dos = dos;
	}
	public Date getDos1() {
		return dos1;
	}
	public void setDos1(Date dos1) {
		this.dos1 = dos1;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getRaffle() {
		return raffle;
	}
	public void setRaffle(String raffle) {
		this.raffle = raffle;
	}
	public String getInterested() {
		return interested;
	}
	public void setInterested(String interested) {
		this.interested = interested;
	}
	public String[] getLikedMost() {
		return likedMost;
	}
	public void setLikedMost(String[] likedMost) {
		this.likedMost = likedMost;
		likedMost1=getNumbers();
	}
	public String getLikedMost1() {
		return likedMost1;
	}
	public void setLikedMost1(String likedMost1) {
		this.likedMost1 = likedMost1;
	}
	public String getLikelihood() {
		return likelihood;
	}
	public void setLikelihood(String likelihood) {
		this.likelihood = likelihood;
	}
	public String getNumbers() {
		return Arrays.toString(likedMost);
	}
	public StudentBean(String firstName, String lastName, String address,
			String zip, String city, String state, String phone,
			String email, Date dos, Date dos1, String likedMost1, String interested, String likelihood,
			String raffle, String comments

	) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
		this.dos = dos;
		this.dos1 = dos1;
		this.likedMost1 = likedMost1;
		this.interested = interested;
		this.likelihood = likelihood;
		this.raffle = raffle;
		this.comments = comments ;

	}
	public StudentBean() {
		// TODO Auto-generated constructor stub
	}
public static final String likelihoodString = "very-likely,likely,unlikely";
private static final String[] likelihoodArray = likelihoodString.split(",");
	public List<String> completeLikelihood(String completePrefix){
		List<String> matches = new ArrayList<String>();
		for(String possibleLikelihood:likelihoodArray) {
			if(possibleLikelihood.toUpperCase().startsWith(completePrefix.toUpperCase()))
			{
				matches.add(possibleLikelihood);
			}
			}
		 return(matches);
	}
	
}