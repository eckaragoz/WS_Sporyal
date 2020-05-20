package com.spryl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spryl.models.BranchVO;
import com.spryl.repositories.BranchRepository;

@Service
public class BranchDAO {
	
	@Autowired
	BranchRepository branchrep;
	
	public BranchVO BranchInsert(BranchVO branch)
	{
		return branchrep.save(branch);
	}
	
	public int BranchUpdate(BranchVO branch)
	{
		return branchrep.update(branch.getUsersid().getId(), branch.getName(), branch.getExperience(), branch.isLicense(), branch.getDate(), 1, branch.getId());
	} 
	
	public List<BranchVO> ListUserBranch(int PUserId)
	{
		return branchrep.findallbyUserId(PUserId);
	}
	
	public int BranchCancel(int PId)
	{
		return branchrep.branchcancel(PId);
	}

}
