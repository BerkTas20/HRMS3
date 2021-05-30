package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.SystemEmployeeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.SystemEmployee;

@RestController
@RequestMapping("/api/system_employees")
public class SystemEmployeesController {

	 private final SystemEmployeeService systemEmployeeService;

	    @Autowired
	    public SystemEmployeesController(SystemEmployeeService systemEmployeeService) {
	        this.systemEmployeeService = systemEmployeeService;
	    }

	    @GetMapping("/getall")
	    public DataResult<List<SystemEmployee>> getAll(){
	        return systemEmployeeService.getAll();
	    }
	    
	    @PostMapping("/add")
	    public Result add(@RequestBody SystemEmployee systemEmployee){
	        return systemEmployeeService.add(systemEmployee);
	    }
	    
	    
}
