package eCommerceUserRegistration.core.concretes;

import eCommerceUserRegistration.core.abstracts.SignUpViaMailService;
import eCommerceUserRegistration.entities.concretes.Users;
import eCommerceUserRegistration.signUpWithGoogle.RegisterViaGoogleManager;

public class RegisterViaGoogleManagerAdapter implements SignUpViaMailService {

	RegisterViaGoogleManager registerViaGoogle = new RegisterViaGoogleManager();

	@Override
	public void signUp(Users users) {
		registerViaGoogle.register(users);

	}

}
