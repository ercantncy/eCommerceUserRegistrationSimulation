package eCommerceUserRegistration.business.abstracts;



import eCommerceUserRegistration.entities.concretes.Users;

public interface UserService {

	 void registerUser(Users users);
	 void registerViaMail(Users users);
	 void verifyUser(Users users,int verificationCode);
	 void logIn(String email,String password);
	
	
}
