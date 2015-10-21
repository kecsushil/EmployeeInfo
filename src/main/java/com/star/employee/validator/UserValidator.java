package com.star.employee.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.star.employee.VO.UserVo;


@Component
public class UserValidator implements Validator {

	public boolean supports(Class<?> candidate) {
		 return UserVo.class.isAssignableFrom(candidate);
	}

	public void validate(Object obj, Errors errors) {
		System.out.println("Inside Validator!!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required", "Field is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required", "Field is required.");
    
        UserVo userVo = (UserVo) obj;
       if(!userVo.getUsername().isEmpty()) { 
    	   
    	   if((!userVo.getUsername().isEmpty() && userVo.getUsername().length() < 6)) {
        	   errors.rejectValue("username", "short.username", "User Name length should be greater than 6.");
           }else { if(!isValidJavaIdentifier(userVo.getUsername())) {
    		   			errors.rejectValue("username", "invalid.username", "Please enter a valid user name. User Name must start with a character ([a-z],[A-Z]).");
    	   			}
           		}
       }
       
       
       if((!userVo.getPassword().isEmpty() && userVo.getPassword().length() < 6)) {
    	   errors.rejectValue("password", "short.password", "Password length should be greater than 6.");
       }
       
       
       
       
       
       
	}

	
	private static boolean isValidJavaIdentifier(String s) {
	    if (!Character.isJavaIdentifierStart(s.charAt(0))) {
	        return false;
	    }
	    for (int i = 1; i < s.length(); i++) {
	        if (!Character.isJavaIdentifierPart(s.charAt(i))) {
	            return false;
	        }
	    }
	    return true;
	}
	
	
	
	
}
