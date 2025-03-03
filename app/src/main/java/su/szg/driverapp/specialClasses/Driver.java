
package su.szg.driverapp.specialClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Driver {
	
	public Driver(Integer id) {
		this.id = id;
	}
	
	@SerializedName("deliverer_id")
	@Expose
	private Integer delivererId;
	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("user_id")
	@Expose
	private Integer userId;
	@SerializedName("passport_data")
	@Expose
	private Object passportData;
	@SerializedName("KYC_control")
	@Expose
	private KYCControl kYCControl;
	@SerializedName("company_made_id")
	@Expose
	private Integer companyMadeId;
	@SerializedName("full_name")
	@Expose
	private String fullName;
	@SerializedName("phone_number")
	@Expose
	private String phoneNumber;
	@SerializedName("contract_number")
	@Expose
	private String contractNumber;
	@SerializedName("birth_date")
	@Expose
	private Object birthDate;
	@SerializedName("can_work")
	@Expose
	private Boolean canWork;
	
	public Boolean getCanWork() {
		return canWork;
	}
	
	public void setCanWork(Boolean canWork) {
		this.canWork = canWork;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Object getPassportData() {
		return passportData;
	}
	
	public void setPassportData(Object passportData) {
		this.passportData = passportData;
	}
	
	public KYCControl getKYCControl() {
		return kYCControl;
	}
	
	public void setKYCControl(KYCControl kYCControl) {
		this.kYCControl = kYCControl;
	}
	
	public Integer getCompanyMadeId() {
		return companyMadeId;
	}
	
	public void setCompanyMadeId(Integer companyMadeId) {
		this.companyMadeId = companyMadeId;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getContractNumber() {
		return contractNumber;
	}
	
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	
	public Object getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Object birthDate) {
		this.birthDate = birthDate;
	}
	
	public Integer getDelivererId() {
		return delivererId;
	}
	
	public void setDelivererId(Integer delivererId) {
		this.delivererId = delivererId;
	}
}
