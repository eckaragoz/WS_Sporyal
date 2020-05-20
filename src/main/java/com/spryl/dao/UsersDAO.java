package com.spryl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spryl.models.UserVO;
import com.spryl.repositories.UsersRepository;


@Service
public class UsersDAO {
	
	@Autowired
	UsersRepository usersrep;
	
	public UserVO UserInsert(UserVO user)
	{		
		return usersrep.save(user);
	}
	
	public int UserLoginCheck(String PUserName, String PPassword)
	{
		return usersrep.UserLoginCheck(PUserName, PPassword);
	}
	
	public int UserCancel(int PId)
	{
		return usersrep.UserCancel(PId);	
				
	}
	
	public int UserChangePassword(String PPassword, int PId)
	{
		return usersrep.UserPasswordChange(PPassword, PId);	
				
	}

}
