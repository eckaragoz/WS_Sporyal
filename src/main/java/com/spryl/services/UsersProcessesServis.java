package com.spryl.services;

import java.util.Base64;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spryl.dao.UsersDAO;
import com.spryl.models.Response;
import com.spryl.models.UserVO;

@Service
@Transactional
public class UsersProcessesServis {
	
	@Autowired
	UsersDAO userdao;
	
	public Response UserInsert(UserVO user)
	{
		UserVO usr = new UserVO();
		Response res = new Response();
		try
		{
		 user.setPassword(new String(Base64.getDecoder().decode(user.getPassword())));	
		 usr = userdao.UserInsert(user);
		 if (usr.getId() > 0){res.setResponseCode(1);res.setResponseMesssage("İşlem Başarılı");}
		 else{res.setResponseCode(0);res.setResponseMesssage("İşlem Başarısız");}			
		}catch (Exception e) {res.setResponseCode(0);res.setResponseMesssage("İşlem Hata:" + e.toString());	}
		return res;		
	}
	
	
	public Response UserLoginCheck(String PUserName, String PPassword)
	{
		Response res = new Response();			
		try
		{			
			res.setResponseCode(userdao.UserLoginCheck(PUserName, new String(Base64.getDecoder().decode(PPassword))));
			res.setResponseMesssage("İşlem Başarılı");	
		}catch (Exception e) {res.setResponseCode(0);res.setResponseMesssage("İşlem Hata:" + e.toString());	
		}
		return res;	
	}
	
	public Response UserCancel(int PId)
	{
		Response res = new Response();			
		try
		{			
			res.setResponseCode(userdao.UserCancel(PId));
			res.setResponseMesssage("İşlem Başarılı");	
		}catch (Exception e) {res.setResponseCode(0);res.setResponseMesssage("İşlem Hata:" + e.toString());	
		}
		return res;	
		
	}
	
	public Response UserPasswordChange(String PPassword, int PId)
	{
		Response res = new Response();			
		try
		{			
			res.setResponseCode(userdao.UserChangePassword(new String(Base64.getDecoder().decode(PPassword)), PId));
			res.setResponseMesssage("İşlem Başarılı");	
		}catch (Exception e) {res.setResponseCode(0);res.setResponseMesssage("İşlem Hata:" + e.toString());	
		}
		return res;	
	}

}
