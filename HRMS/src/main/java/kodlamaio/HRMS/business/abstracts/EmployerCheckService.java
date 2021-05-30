package kodlamaio.HRMS.business.abstracts;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.entities.concretes.Employer;

@Service
public interface EmployerCheckService {

	boolean fieldsFull(Employer employer);
	
	boolean isCompatibleWebSiteAndEmail(Employer employer);
	
}
