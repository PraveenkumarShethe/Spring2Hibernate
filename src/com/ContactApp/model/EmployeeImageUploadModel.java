package com.ContactApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeePicture")
public class EmployeeImageUploadModel 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "empidpic")
	private Integer empIdpic;
	
	@Column(name = "empImage")
	private byte[] empImage;

	public Integer getEmpIdpic() {
		return empIdpic;
	}

	public void setEmpIdpic(Integer empIdpic) {
		this.empIdpic = empIdpic;
	}

	public byte[] getEmpImage() {
		return empImage;
	}

	public void setEmpImage(byte[] empImage) {
		this.empImage = empImage;
	}
}