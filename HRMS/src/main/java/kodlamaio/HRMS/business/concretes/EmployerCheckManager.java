package kodlamaio.HRMS.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmployerCheckService;
import kodlamaio.HRMS.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckService{
	@Override
    public boolean fieldsFull(Employer employer) {
        return employer.getId() != 0 && employer.getEmail() != null && employer.getPassword() != null && employer.getCompanyName() != null
                && employer.getWebSite() != null && employer.getPhoneNumber() != null;
    }

    @Override
    public boolean isCompatibleWebSiteAndEmail(Employer employer){
        String emailDomain = employer.getEmail().split("@")[0].toLowerCase();
        String webSiteDomain = employer.getWebSite().split("\\.")[1].toLowerCase();
        return emailDomain.equals(webSiteDomain);
    }

}