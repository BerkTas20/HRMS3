package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmployerCheckService;
import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.core.abstracts.EmailService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.EmployerDao;
import kodlamaio.HRMS.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private final EmployerDao employerDao;
	private final EmployerCheckService employerCheckService;
	private final EmailService emailService;
	
	@Autowired
	   public EmployerManager(EmployerDao employerDao, EmployerCheckService employerCheckService,EmailService emailService) {
		this.employerDao = employerDao;
        this.employerCheckService = employerCheckService;
        this.emailService = emailService;
	}
	
	
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<>(employerDao.findAll(),"Success listed!");
	}


	@Override
	public Result add(Employer employer) {
		if (employerCheckService.fieldsFull(employer)){
            return new ErrorResult("Fields are still empty!!!");
        } else if (employerCheckService.isCompatibleWebSiteAndEmail(employer)){
            return new ErrorResult("Website and email are faulty!!!");
        }

        try {
            employerDao.save(employer);
            emailService.sendVerificationMail(employer.getEmail());
            return new SuccessResult("Employer Saved");
        } catch (Exception exception){
            exception.printStackTrace();
            return new ErrorResult("Registration Failed");
        }	
	}


	@Override
	public Result delete(Employer employer) {
		this.employerDao.delete(employer);
		return new SuccessDataResult<>("Succesfully deleted!");
	}

}
