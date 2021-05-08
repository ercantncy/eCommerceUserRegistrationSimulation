package eCommerceUserRegistration.business.abstracts;



import eCommerceUserRegistration.entities.concretes.Users;

public interface EmailService {

//	void sendEmail();
	int sendVerificationCode();
}
