package eCommerceUserRegistration;

import java.util.Scanner;

import eCommerceUserRegistration.business.abstracts.UserService;
import eCommerceUserRegistration.business.concretes.AuthenticationManager;
import eCommerceUserRegistration.business.concretes.EmailManager;
import eCommerceUserRegistration.business.concretes.UserManager;
import eCommerceUserRegistration.core.concretes.RegisterViaGoogleManagerAdapter;
import eCommerceUserRegistration.dataAccess.concretes.HibernateUserDao;
import eCommerceUserRegistration.entities.concretes.Users;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		Users u1 = new Users(1, "lale", "karanfil", "123@asd.com", "2321111");
		Users u2 = new Users(1, "b", "çam", "acd@asd.com", "2321111");
		Users u3 = new Users(1, "ahmet", "mehmet", "acdasd.com", "2321111");
		Users u4 = new Users(1, "papatya", "gül", "acd@asd.com", "232");
		Users u5 = new Users(1, "kiraz", "çilek", "123@asd.com", "2321111");
		Users u6 = new Users(1, "elma", "portakal", "123@asfd.com", "2321111");

		// manual registration
		UserService service = new UserManager(new AuthenticationManager(), new EmailManager(), new HibernateUserDao());

		// user1 that fulfills all requirements and confirms verification code and successfully logins
		service.registerUser(u1);

		int verificationCode = scan.nextInt();
		service.verifyUser(u1, verificationCode);
		service.logIn(u1.getEmail(), u1.getPassword());

		// user2 that fulfills all requirements except firstname/lastname length
		System.out.println("----------------------------------------");
		service.registerUser(u2);

		// user3 that fulfills all requirements except email format
		System.out.println("----------------------------------------");
		service.registerUser(u3);

		// user4 that fulfills all requirements except password length
		System.out.println("----------------------------------------");
		service.registerUser(u4);

		// user5 that fulfills all requirements except email address already in use
		System.out.println("----------------------------------------");
		service.registerUser(u5);

		// user6 that fulfills all requirements but prompts wrong the verification code
		System.out.println("----------------------------------------");
		service.registerUser(u6);
		int verificationCode2 = scan.nextInt();
		service.verifyUser(u6, verificationCode2);
		
		System.out.println("----------------------------------------");

		// registration via google or or any other services you want to use
		UserService service2 = new UserManager(new AuthenticationManager(), new EmailManager(), new HibernateUserDao(),
				new RegisterViaGoogleManagerAdapter());
		service2.registerViaMail(u1);

	}

}
