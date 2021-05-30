package kodlamaio.HRMS.core.concretes;

import org.springframework.stereotype.Component;

import kodlamaio.HRMS.core.abstracts.EmailService;

@Component
public class EmailManager implements EmailService {

	@Override
	public void sendVerificationMail(String email) {
		
		System.out.println("'"+email+"' A confirmation e-mail has been sent to the e-mail address.");
	}

}
