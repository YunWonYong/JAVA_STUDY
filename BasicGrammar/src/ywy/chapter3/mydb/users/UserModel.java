package ywy.chapter3.mydb.users;

import ywy.chapter3.mydb.Model;

public class UserModel implements Model{
	private String id;
	private String name;
	private String engName;
	private String gender;
	private String birthDate;
	private String realNumber;
	private String zipCode;
	private String address;
	private String addressDtl;
	private String email;
	private String emailAddress;
	private String phoneNumber;
	
	public UserModel() {
		
	}

	public UserModel(String id, String name, String engName, String gender, String birthDate, String realNumber,
			String zipCode, String address, String addressDtl, String email, String emailAddress, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.engName = engName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.realNumber = realNumber;
		this.zipCode = zipCode;
		this.address = address;
		this.addressDtl = addressDtl;
		this.email = email;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getRealNumber() {
		return realNumber;
	}

	public void setRealNumber(String realNumber) {
		this.realNumber = realNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDtl() {
		return addressDtl;
	}

	public void setAddressDtl(String addressDtl) {
		this.addressDtl = addressDtl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", engName=" + engName + ", gender=" + gender + ", birthDate="
				+ birthDate + ", realNumber=" + realNumber + ", zipCode=" + zipCode + ", address=" + address
				+ ", addressDtl=" + addressDtl + ", email=" + email + ", emailAddress=" + emailAddress
				+ ", phoneNumber=" + phoneNumber + "]";
	}
}
