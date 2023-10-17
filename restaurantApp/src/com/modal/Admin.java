package com.modal;

public class Admin extends Details{
	
	private Integer adminId;
	
	public Admin() {
		
	}

	public Admin(Integer adminId) {
		super();
		this.adminId = adminId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + "]";
	}
	
	
}
