package kodlamaio.HRMS.core.concretes;

import kodlamaio.HRMS.core.abstracts.EmailCheckService;

public class FakeEmailCheckManager implements EmailCheckService {
	@Override
	public boolean emailCheck(String email) {
		return true;
	}
}
