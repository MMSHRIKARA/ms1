package com.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.repo.UserrRepoistory;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserrRepoistory repoistory;

    @Test
    public void testGetUser() {
        User user=this.buildTestingUser();
        when(repoistory.findAll()).thenReturn(List.of(user));
        List<User> userList=this.userService.getUser();
        
        assertEquals(1, userList.size());
        verify(this.repoistory).findAll();
    }
    
    @Test
    void testAddUser() {
    	User user=this.buildTestingUser();
    	this.userService.addUser(user);
    	verify(this.repoistory).save(user);
    }
    
    @Test
	public void testFindByIdUser() throws UserNotFoundException {
		User user=this.buildTestingUser();
		
//		when(repoistory.findById(1)).thenReturn(Optional.of(user));
//		Optional returnedUser=this.userService.getUserById(1);
//		assertEquals(user.getId(), ((User) returnedUser.get()).getId());
//		verify(this.repoistory).findById(1);  
    }
		
    private User buildTestingUser() {
    	User user=new User();
    	user.setId((long) 1);
    	user.setUsername("sheethal");
    	user.setContact("8073668718");
    	user.setEmail("sheethal@gmail.com");
    	user.setPassword("abc@123");
    	user.setRole("ADMIN");
    	return user;

    }
}

