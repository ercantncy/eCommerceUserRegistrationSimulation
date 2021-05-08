package eCommerceUserRegistration.business.concretes;


import java.util.regex.Pattern;

import eCommerceUserRegistration.business.abstracts.AuthenticationService;
import eCommerceUserRegistration.entities.concretes.Users;


public class AuthenticationManager implements AuthenticationService {
	
	
	
	@Override
	public boolean authUser(Users users) {
		if (checkEmail(users) && checkNameLenght(users) && checkPasswordLength(users)) {
			
			return true;
		}
		
		return false;
	}

	@Override
	public boolean checkNameLenght(Users users) {
		if (users.getFirstName().length()<2 || users.getLastName().length()<2) {
			System.out.println("Name and Lastname must be at least 2 characters");
			return false;
		}
		 return true;
	}

	@Override
	public boolean checkPasswordLength(Users users) {
		
		if (users.getPassword().length()<6) {
			System.out.println("Password must be at least 6 characters");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkEmail(Users users) {
		Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
		if (EMAIL_REGEX.matcher(users.getEmail()).matches()) {
			return true;
		}
		System.out.println("Enter a correct E-Mail Address!");
		return false;
	}

	

}
