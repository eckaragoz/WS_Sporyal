package com.spryl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spryl.models.UserVO;

@Repository
public interface UsersRepository extends JpaRepository<UserVO, Long> {
	
	@Query(nativeQuery = true, value = "SELECT [id] FROM [SPORYAL].[dbo].[USERS] WHERE username = ?1 AND password = ?2 and status = 1")
	int UserLoginCheck(String PUserName, String PPassword);
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE [SPORYAL].[dbo].[USERS] SET status = 0  WHERE id = ?1")
	int UserCancel(int PId);
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE [SPORYAL].[dbo].[USERS] SET password = ?1  WHERE id = ?2")
	int UserPasswordChange(String PPassword, int PId);

}
