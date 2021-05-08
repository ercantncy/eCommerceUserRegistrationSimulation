package eCommerceUserRegistration.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;


import eCommerceUserRegistration.dataAccess.abstracts.UserDao;
import eCommerceUserRegistration.entities.concretes.Users;

public class HibernateUserDao implements  UserDao{

	List<Users> userList= new ArrayList<>();
	
	@Override
	public void registerUser(Users users) {
		userList.add(users);
		System.out.println(users.getFirstName().toUpperCase()+" "+users.getLastName().toUpperCase()+" has been registered successfully.");
	}


	
	@Override
	public List<Users> getAll() {
		for (Users user : userList) {
			System.out.println(user.getFirstName().toUpperCase());
		}
		System.out.println("----------------");
		return this.userList;
		
	}


	
	@Override
	public boolean emailCheck(Users users) {
		for (Users user : userList) {
			if (user.getEmail()==users.getEmail()) {
				return false;
			}
			
		}
		return true;
	}



	@Override
	public boolean loginCheck(String email, String password) {
		for (Users users : userList) {
			if (users.getEmail()==email && users.getPassword()==password) {
				return true;
			}
		}
		return false;
	}



	

}
