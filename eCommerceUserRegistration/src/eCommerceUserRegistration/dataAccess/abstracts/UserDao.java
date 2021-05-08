package eCommerceUserRegistration.dataAccess.abstracts;

import java.util.List;

import eCommerceUserRegistration.entities.concretes.Users;

public interface UserDao {

	 void registerUser(Users users);
	boolean emailCheck(Users users);
	boolean loginCheck(String email, String password);
	List<Users> getAll();
	
}
