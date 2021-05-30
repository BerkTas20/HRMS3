package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateCheckService;
import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.core.abstracts.EmailService;
import kodlamaio.HRMS.core.adapters.MernisServiceAdapter;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateDao;
import kodlamaio.HRMS.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private final CandidateDao candidateDao;
	private final CandidateCheckService candidateCheckService;
	private final MernisServiceAdapter mernisServiceAdapter;
	private final EmailService emailService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, CandidateCheckService candidateCheckService,MernisServiceAdapter mernisServiceAdapter, EmailService emailService) {
    	this.candidateDao = candidateDao;
        this.candidateCheckService = candidateCheckService;
        this.mernisServiceAdapter = mernisServiceAdapter;
        this.emailService = emailService;
    }
	
	@Override
	 public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<>(candidateDao.findAll(),"Successfull");
		
	}

	public Result add(Candidate candidate){

        if(!candidateCheckService.fieldsFull(candidate)){
            return new ErrorResult("There is empty fields!");
        } else if (mernisServiceAdapter.isNatIdReal(candidate.getNationalityId(),
                candidate.getFirstName(), candidate.getLastName(), candidate.getBirthYear())){
            return new ErrorResult("Incompatible Nationality ID, Name, Surname, Birth Year!");
        }

        try {
            candidateDao.save(candidate);
            emailService.sendVerificationMail(candidate.getEmail());
            return new SuccessResult("Candidate Saved");
        } catch (Exception exception){
            exception.printStackTrace();
            return new ErrorResult("Registration Failed");
        }

    }

	@Override
	public Result delete(Candidate candidate) {
		this.candidateDao.delete(candidate);
		return new SuccessResult("Deletion is successful");
	}
}