//Krishna Sindhuri Vemuri G01024066 SWE_645_HW2
//This is the StudentBean data model.
package SWE645_VEMURI_HW2;

import java.util.Arrays;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="studentBean")
public class StudentBean {

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String email;
	private String dos;
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
	public String getDos() {
		return dos;
	}
	public void setDos(String dos) {
		this.dos = dos;
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
			String email, String dos, String likedMost1, String interested, String likelihood,
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
		this.likedMost1 = likedMost1;
		this.interested = interested;
		this.likelihood = likelihood;
		this.raffle = raffle;
		this.comments = comments ;

	}
	public StudentBean() {
		// TODO Auto-generated constructor stub
	}

}