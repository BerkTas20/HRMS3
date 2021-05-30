package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Candidate;

@Service
public interface CandidateService {

	DataResult<List<Candidate>>getAll();
	Result add(Candidate candidate);
	Result delete(Candidate candidate);
}
