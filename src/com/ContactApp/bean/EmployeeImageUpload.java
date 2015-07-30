package com.ContactApp.bean;

public class EmployeeImageUpload 
{
	private byte[] ImageFile ;
	
	private Integer empIdpic;
	
	public byte[] getImageFile() {
		return ImageFile;
	}

	public void setImageFile(byte[] imageFile) {
		ImageFile = imageFile;
	}

	public Integer getEmpIdpic() {
		return empIdpic;
	}

	public void setEmpIdpic(Integer empIdpic) {
		this.empIdpic = empIdpic;
	}
	
	
}