/**
 * 
 */
package com.company.local.customer.domain;

public class CustomerDTO{
	private String fullName;
	private String policyNumber;
	private String address;
	public CustomerDTO(){}
	public CustomerDTO(String fullName, String policyNumber, String address, String email, String mobilePhoneNumber) {
		super();
		this.fullName = fullName;
		this.policyNumber = policyNumber;
		this.address = address;
		this.email = email;
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	@Override
	public String toString() {
		return "Customer [fullName=" + fullName + ", policyNumber=" + policyNumber + ", address="
				+ address + ", email=" + email + ", mobilePhoneNumber=" + mobilePhoneNumber + "]";
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String email;
	private String mobilePhoneNumber;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
}
