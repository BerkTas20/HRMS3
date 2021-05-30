package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandicatesController {

	 private final CandidateService candidateService;

	    @Autowired
	    public CandicatesController(CandidateService candidateService) {
	        this.candidateService = candidateService;
	    }

	    @GetMapping("/getall")
	    public DataResult<List<Candidate>> getAll(){
	        return candidateService.getAll();
	    }

	    @PostMapping("/register")
	    public Result add(@RequestBody Candidate candidate){
	        return candidateService.add(candidate);
	    }
	    
	    @DeleteMapping("/delete")
	    public Result delete(@RequestBody Candidate candidate){
	        return candidateService.delete(candidate);
	    }
	}