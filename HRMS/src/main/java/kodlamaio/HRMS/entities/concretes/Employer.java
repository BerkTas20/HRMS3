package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class Employer extends User {

	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_site")
	private String webSite;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name="verification_status")
	private boolean verificationStatus;
	
	public Employer(int id, String email, String password, String companyName, String webSite, String phoneNumber,boolean verificationStatus){
		super(id,email,password);
        this.companyName = companyName;
        this.webSite = webSite;
        this.phoneNumber = phoneNumber;
        this.verificationStatus = verificationStatus;
	}
	
	
	
}
