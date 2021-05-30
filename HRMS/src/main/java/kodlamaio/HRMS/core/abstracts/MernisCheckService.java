package kodlamaio.HRMS.core.abstracts;

import kodlamaio.HRMS.entities.concretes.Candidate;

public interface MernisCheckService {
	public boolean checkIfRealPerson(Candidate candidate);
}
