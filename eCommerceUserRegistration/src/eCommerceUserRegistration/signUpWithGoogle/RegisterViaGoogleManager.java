package eCommerceUserRegistration.signUpWithGoogle;

import eCommerceUserRegistration.entities.concretes.Users;

public class RegisterViaGoogleManager {

	public void register(Users users) {

		System.out.println(users.getEmail() + " Successfully signed up via Google");
	}
}
