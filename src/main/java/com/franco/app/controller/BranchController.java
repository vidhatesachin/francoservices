package com.franco.app.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.franco.app.dataobjects.Branch;
import com.franco.app.dataobjects.User;
import com.franco.app.exception.AuthenticationFailureException;
import com.franco.app.exception.ResourceConflictException;
import com.franco.app.repository.BranchRepository;
import com.franco.app.vo.LoginVO;


@RestController
public class BranchController {
	private final Logger logger = LoggerFactory.getLogger(BranchController.class);
	
	@Autowired
	private BranchRepository branchRepository;
	
	@GetMapping(path = "/allbranches")
	public ResponseEntity<List<Branch>> BranchList() {
		List<Branch> branches = this.branchRepository.getAllBranches();
		//users.forEach(user -> user.setPassword(null));
		return new ResponseEntity<List<Branch>>(branches, HttpStatus.OK);
	}

}
