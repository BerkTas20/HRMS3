package kodlamaio.HRMS.core.abstracts;

import org.springframework.stereotype.Component;

@Component
public interface EmailService {
	
	public void sendVerificationMail(String email);
	
}
