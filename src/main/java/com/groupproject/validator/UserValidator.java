package com.groupproject.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.groupproject.models.User;
import com.groupproject.repositories.UserRepository;



@Component
public class UserValidator implements Validator{
	@Autowired 
	private UserRepository userRepository;
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		 User user = (User) target;
	     if (!user.getConfirmPassword().equals(user.getPassword())) {
	     errors.rejectValue("confirmPassword", "Match");
	     }   
	}
}
