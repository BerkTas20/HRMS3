package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.SystemEmployeeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.SystemEmployeeDao;
import kodlamaio.HRMS.entities.concretes.SystemEmployee;

@Service
public class SystemEmployeeManager implements SystemEmployeeService {

	private final SystemEmployeeDao systemEmployeeDao;
	
	@Autowired
	public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao) {
		this.systemEmployeeDao = systemEmployeeDao;
	}
	
	
	@Override
	public DataResult<List<SystemEmployee>> getAll() {
		
		return new SuccessDataResult<List<SystemEmployee>>(systemEmployeeDao.findAll(),"Data listed!");
	}


	@Override
	public Result add(SystemEmployee systemEmployee) {
		 try {
	            systemEmployeeDao.save(systemEmployee);
	            return new SuccessResult("System Employee Saved");
	        } catch (Exception exception){
	            exception.printStackTrace();
	            return new ErrorResult("Registration Failed");
	        }
	}


	

	

	
	
}
