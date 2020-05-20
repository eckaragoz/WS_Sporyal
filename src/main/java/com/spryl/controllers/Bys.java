
package com.spryl.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.spryl.models.BranchVO;
import com.spryl.models.Response;
import com.spryl.models.UserVO;
import com.spryl.services.BranchServices;
import com.spryl.services.UsersProcessesServis;


@RestController
//@CrossOrigin(origins = {"http://10.128.126.75:9080","http://localhost:9080","http://localhost:4200","https://uygyonetim.sgk.intra","https://esgkmobil.sgk.gov.tr","http://10.128.126.75:9080","http://10.128.126.77:8080"}, 
//allowedHeaders = {"Access-Control-Allow-Headers", "Authorization", "Access-Control-Allow-Headers", "Origin", "Accept", "X-Requested-With", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers"})
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Bys {	
	
	@Autowired
	UsersProcessesServis userservice;
	
	@Autowired
	BranchServices branchservice;
	
	@GetMapping(value="/test", produces=MediaType.APPLICATION_JSON_VALUE)
	public String test(){		
		return "Test";
	}
	
	//**User Proceses****************************************************************************************************	
	@PostMapping(value="/UserInsert", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> UserInsert(@Valid  @RequestBody UserVO user){
		ResponseEntity<Response> response = new ResponseEntity<Response>(userservice.UserInsert(user),HttpStatus.OK);
		return response;	    
	}
	
	@PostMapping(value="/UserCancel", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> UserCancel(@Valid  @RequestHeader("id") int id){
		ResponseEntity<Response> response = new ResponseEntity<Response>(userservice.UserCancel(id),HttpStatus.OK);
		return response;	    
	}
	
	
	@PostMapping(value="/UserLoginCheck", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> UserLoginCheck(@Valid  @RequestHeader("username") String username, @RequestHeader("password") String password){
		ResponseEntity<Response> response = new ResponseEntity<Response>(userservice.UserLoginCheck(username, password),HttpStatus.OK);
		return response;	    
	}
	
	@PostMapping(value="/UserPasswordChange", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> UserPasswordChange(@Valid  @RequestHeader("password") String password, @RequestHeader("id") int id){
		ResponseEntity<Response> response = new ResponseEntity<Response>(userservice.UserPasswordChange(password, id),HttpStatus.OK);
		return response;	    
	}
	
	//**Branch Proceses****************************************************************************************************	
	@PostMapping(value="/BranchInsert", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> BranchInsert(@Valid  @RequestBody BranchVO branch){
		ResponseEntity<Response> response = new ResponseEntity<Response>(branchservice.BranchInsert(branch),HttpStatus.OK);
		return response;	    
	}
	
	@PostMapping(value="/BranchUpdate", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> BranchUpdate(@Valid  @RequestBody BranchVO branch){
		ResponseEntity<Response> response = new ResponseEntity<Response>(branchservice.BranchUpdate(branch),HttpStatus.OK);
		return response;	    
	}
	
	@PostMapping(value="/BranchCancel", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> BranchCancel(@Valid    @RequestHeader("id") int id){
		ResponseEntity<Response> response = new ResponseEntity<Response>(branchservice.BranchCancel(id),HttpStatus.OK);
		return response;	    
	}
	
	@GetMapping(value="/UserBranchList", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BranchVO>> UserBranchList(@Valid    @RequestHeader("userid") int userid){
		ResponseEntity<List<BranchVO>> userbranchlist = new ResponseEntity<List<BranchVO>>(branchservice.BranchUserList(userid),HttpStatus.OK);
		return userbranchlist;	    
	}
	//**********************************************************************************************************************
	
}
