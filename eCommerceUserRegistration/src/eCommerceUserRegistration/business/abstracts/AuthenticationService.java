package eCommerceUserRegistration.business.abstracts;

import eCommerceUserRegistration.entities.concretes.Users;

public interface AuthenticationService {

	boolean authUser(Users users);
	boolean checkNameLenght(Users users);
	boolean checkPasswordLength(Users users);
	boolean checkEmail(Users users);
	
}
