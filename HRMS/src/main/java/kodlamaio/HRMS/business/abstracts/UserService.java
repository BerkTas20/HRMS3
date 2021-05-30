package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.User;

@Service
public interface UserService {

	DataResult<List<User>> getAll();
	
	
}
