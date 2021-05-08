package eCommerceUserRegistration.core.abstracts;

import eCommerceUserRegistration.entities.concretes.Users;

public interface SignUpViaMailService {

	void signUp(Users users);
}
