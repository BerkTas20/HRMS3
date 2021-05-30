package kodlamaio.HRMS.business.abstracts;

import java.util.List;


import org.springframework.stereotype.Service;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.SystemEmployee;

@Service
public interface SystemEmployeeService {

	DataResult<List<SystemEmployee>>getAll();
	 Result add(SystemEmployee systemEmployee);
	
	 
}
