package com.spryl.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spryl.dao.BranchDAO;
import com.spryl.models.BranchVO;
import com.spryl.models.Response;


@Service
@Transactional
public class BranchServices {
	
	@Autowired
	BranchDAO branchdao;
	
	
	public Response BranchInsert(BranchVO branchvo)
	{
		BranchVO branch = new BranchVO();
		Response res = new Response();
		try
		{		
		 branch = branchdao.BranchInsert(branchvo);
		 if (branch.getId() > 0){res.setResponseCode(1);res.setResponseMesssage("İşlem Başarılı");}
		 else{res.setResponseCode(0);res.setResponseMesssage("İşlem Başarısız");}			
		}catch (Exception e) {res.setResponseCode(0);res.setResponseMesssage("İşlem Hata:" + e.toString());	}
		return res;		
	}
	
	
	public Response BranchUpdate(BranchVO branchvo)
	{		
		Response res = new Response();
		int KayitId = 0;
		try
		{		
		 KayitId = branchdao.BranchUpdate(branchvo);
		 if (KayitId > 0){res.setResponseCode(1);res.setResponseMesssage("İşlem Başarılı");}
		 else{res.setResponseCode(0);res.setResponseMesssage("İşlem Başarısız");}			
		}catch (Exception e) {res.setResponseCode(0);res.setResponseMesssage("İşlem Hata:" + e.toString());	}
		return res;		
	}
	
	public Response BranchCancel(int PId)
	{		
		Response res = new Response();
		int KayitId = 0;
		try
		{		
		 KayitId = branchdao.BranchCancel(PId);
		 if (KayitId > 0){res.setResponseCode(1);res.setResponseMesssage("İşlem Başarılı");}
		 else{res.setResponseCode(0);res.setResponseMesssage("İşlem Başarısız");}			
		}catch (Exception e) {res.setResponseCode(0);res.setResponseMesssage("İşlem Hata:" + e.toString());	}
		return res;		
	}
	
	
	public List<BranchVO> BranchUserList(int PUserId)
	{		
		Response res = new Response();		
		List<BranchVO>  BranchUserList = new ArrayList<BranchVO>();
		try
		{		
		  BranchUserList = branchdao.ListUserBranch(PUserId);				
		}catch (Exception e) {res.setResponseCode(0);res.setResponseMesssage("İşlem Hata:" + e.toString());	}
		return BranchUserList;		
	}
	
	

}
