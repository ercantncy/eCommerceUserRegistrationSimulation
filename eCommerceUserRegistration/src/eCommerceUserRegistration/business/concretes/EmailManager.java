package eCommerceUserRegistration.business.concretes;

import java.util.Random;

import eCommerceUserRegistration.business.abstracts.EmailService;
import eCommerceUserRegistration.entities.concretes.Users;

public class EmailManager implements EmailService {

	int verificaationCode;
	

	public EmailManager() {
		Random rand = new Random();
		this.verificaationCode = Math.abs(rand.nextInt() / 10000);

	}

//	@Override
//	public void sendEmail() {
//		
//		System.out.println("Verification code has been sent to your mail address: ");
//		
//	}

	@Override
	public int sendVerificationCode() {
//		System.out.println("Verification code has been sent to your Email address. "+"\n"+"Verification Code: "+this.verificaationCode);
		
		
		return verificaationCode;
		
		
	}

}
