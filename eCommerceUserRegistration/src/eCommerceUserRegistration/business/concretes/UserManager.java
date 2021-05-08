package eCommerceUserRegistration.business.concretes;
import eCommerceUserRegistration.business.abstracts.AuthenticationService;
import eCommerceUserRegistration.business.abstracts.EmailService;
import eCommerceUserRegistration.business.abstracts.UserService;
import eCommerceUserRegistration.core.abstracts.SignUpViaMailService;
import eCommerceUserRegistration.dataAccess.abstracts.UserDao;
import eCommerceUserRegistration.entities.concretes.Users;

public class UserManager implements UserService {

	private AuthenticationService authenticationService;
	private EmailService emailService;
	private UserDao userDao;
	private SignUpViaMailService signUpViaMailService;
	
	public UserManager(AuthenticationService authenticationService, EmailService emailService, UserDao userDao) {
		super();
		this.authenticationService = authenticationService;
		this.emailService = emailService;
		this.userDao = userDao;
		
		
	}
	public UserManager(AuthenticationService authenticationService, EmailService emailService, UserDao userDao,SignUpViaMailService signUpViaMailService) {
		super();
		this.authenticationService = authenticationService;
		this.emailService = emailService;
		this.userDao = userDao;
		this.signUpViaMailService=signUpViaMailService;
		
	}

	@Override
	public void registerUser(Users users) {
		if (!authenticationService.authUser(users)) {
			System.out.println("Registration is failed");

		}else if(!userDao.emailCheck(users)) {
			System.out.println("Dear User this E-mail address "+users.getEmail() +" already in use.");
			
		}
		else {
			
			userDao.registerUser(users);
//			emailService.sendEmail();
			System.out.println("Verification code has been sent to your Email address: "+users.getEmail()+"\n"+"Verification Code: "+emailService.sendVerificationCode());
		}
	}

	@Override
	public void logIn(String email,String password) {
		if (userDao.loginCheck(email, password)) {
			System.out.println("You have successfully logged in");
		}else {
			System.out.println("Username or Password is wrong!");
		}
		

	}

	@Override
	public void verifyUser(Users users,int verificationCode ) {
		int code=emailService.sendVerificationCode();
		if (code==verificationCode) {
			System.out.println("The user "+users.getFirstName().toUpperCase()+" "+users.getLastName().toUpperCase()+" has been verified.");
		}else {
			System.out.println("The verification code is wrong!");
		}
	
		
	}
	@Override
	public void registerViaMail(Users users) {
		signUpViaMailService.signUp(users);
		
	}
}



