package com.spryl.repositories;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spryl.models.BranchVO;


@Repository
public interface BranchRepository extends JpaRepository<BranchVO, Long> {
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE [SPORYAL].[dbo].[BRANCH] SET [usersid] = ?1, [name] = ?2, [experience] = ?3, [license] = ?4, [date] = ?5, [status] = ?6 WHERE id = ?7")
	public int update(int PUserId, String PName, int Pexperience, boolean Plicense, Date PDate, int PStatus, int PId);
	
	@Query(nativeQuery = true, value = "SELECT [id], [usersid], [name], [experience], [license], [date], [status] FROM [SPORYAL].[dbo].[BRANCH] WHERE usersid = ?1")
	public List<BranchVO> findallbyUserId(int PUserId);
	
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE [SPORYAL].[dbo].[BRANCH] SET [status] = 0 WHERE id = ?1")
	public int branchcancel(int PId);

}
