package kodlamaio.HRMS.core.concretes;

import kodlamaio.HRMS.core.abstracts.MernisCheckService;
import kodlamaio.HRMS.entities.concretes.Candidate;

public class FakeMernisCheckService implements MernisCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		return true;
	}
}
