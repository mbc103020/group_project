package com.groupproject.services;

import java.util.Date;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.groupproject.models.User;
import com.groupproject.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) { 
		this.userRepository= userRepository;
	}
	// register user:  hash their password
		public User registerUser(User user) { 
			String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setPassword(hashed);
			return userRepository.save(user);
		}

		//find user by email
		public User findByEmail(String email) { 
			return userRepository.findByEmail(email);
		}
		
//		//find user by name
//			public User findByName(String name) {
//				return userRepository.findByName(name);
//			}
		//find user by id
		public User findUserById(Long id) { 
			Optional<User> optional = userRepository.findById(id);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				return null;
			}
		}


		//authenticate user 
		public boolean authenticateUser(String email, String password) { 
			 // first find the user by email
		    User user = userRepository.findByEmail(email);
		    // if we can't find it by email, return false
		    if(user == null) {
		        return false;
		    } else {
		        // if the passwords match, return true, else, return false
		        if(BCrypt.checkpw(password, user.getPassword())) {
		            return true;
		        } else {
		            return false;
		        }
		    }
		}
		
		 //updates a book
	    public User updateUser(Long id, User theUser) {
	    	User user = this.findUserById(id);
	    	if( user != null ) {
				user.setEmail(theUser.getEmail());
				user.setGender(theUser.getGender());
				user.setDOB(theUser.getDOB());
				user.setCity(theUser.getCity());
				user.setState(theUser.getState());
				userRepository.save(user);
				return user;
			}else {
			
			return null;
		}
	    	
	    	
	    }
	    
//	    public User updateUser(Long id, String email, String gender, Date birthdate, String city, String state) {
//			Optional<User> optionalUser = userRepository.findById(id);
//			 if(optionalUser.isPresent()) {
//		            User user = optionalUser.get();
//		            user.setEmail(email);
//		            user.setGender(gender);
//		            user.setDOB(birthdate);
//		            user.setCity(city);
//		            user.setState(state);
//		            userRepository.save(user);
//		            return user;
//		     } 
//			 else {
//		            return null;
//		     }
//		}
}
