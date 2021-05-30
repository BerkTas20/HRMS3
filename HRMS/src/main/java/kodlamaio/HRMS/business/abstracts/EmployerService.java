package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Employer;

@Service
public interface EmployerService {
	DataResult<List<Employer>>getAll();
	
	Result add(Employer employer);
	Result delete(Employer employer);
}
