package kodlamaio.HRMS.business.abstracts;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.entities.concretes.Candidate;

@Service
public interface CandidateCheckService {

	boolean fieldsFull(Candidate candidate);
}
