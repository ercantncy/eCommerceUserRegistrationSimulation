package eCommerceUserRegistration.core.concretes;

import eCommerceUserRegistration.core.abstracts.SignUpViaMailService;
import eCommerceUserRegistration.entities.concretes.Users;

public class RegisterViaYahooManager  implements SignUpViaMailService{

	@Override
	public void signUp(Users users) {
		System.out.println(users.getEmail()+ " Successfully signed up via Yahoo");
		
	}

}
