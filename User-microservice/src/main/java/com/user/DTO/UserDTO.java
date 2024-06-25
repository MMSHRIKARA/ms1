package com.user.DTO;

import com.user.entity.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	 private Long id;
	    private String username;
	    private String contact;
	    private String email;
	    private String password;
	    
	   private String role;
	    


		

}
