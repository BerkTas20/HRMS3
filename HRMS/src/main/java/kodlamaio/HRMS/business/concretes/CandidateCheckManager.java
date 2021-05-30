package kodlamaio.HRMS.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateCheckService;
import kodlamaio.HRMS.entities.concretes.Candidate;

@Service
public class CandidateCheckManager implements CandidateCheckService {

	@Override
	public boolean fieldsFull(Candidate candidate) {
		return candidate.getId() != 0 && candidate.getEmail() != null && candidate.getPassword() != null && candidate.getFirstName() != null
                && candidate.getLastName() != null && candidate.getNationalityId() != null && candidate.getBirthYear() != 0;
    }

}