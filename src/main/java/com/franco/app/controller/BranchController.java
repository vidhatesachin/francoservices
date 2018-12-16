package com.franco.app.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.franco.app.dataobjects.Branch;
import com.franco.app.exception.ResourceConflictException;
import com.franco.app.repository.BranchRepository;



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
	
	@GetMapping(path = "branches/{branchId}")
	public ResponseEntity<Branch> branch(@PathVariable("branchId") String branchId) {
		Branch branch = this.branchRepository.findOne(Long.parseLong(branchId));
		return new ResponseEntity<Branch>(branch, HttpStatus.OK);
	}
	
	@PostMapping("/addBranch")
	public ResponseEntity<Branch> addBranch(@RequestBody Branch branch) throws IOException {
		logger.info("savebranch() ..... Start");
	
		branch.setStatus('A');
		Branch savedBranch = this.branchRepository.save(branch);
		logger.info("saveBranch() ..... End");
		return new ResponseEntity<Branch>(savedBranch, HttpStatus.OK);
	}
	
	@PutMapping("/updateBranch")
	public ResponseEntity<Branch> updateBranch(@RequestBody Branch branch) throws IOException {
		logger.info("updateuser() ..... Start");
		Branch existingbranch = this.branchRepository.findById(branch.getId());
		if(existingbranch!=null && existingbranch.getId()!=branch.getId()) {
			throw new ResourceConflictException("User with same email already exist");
		}
		Branch savedBranch = this.branchRepository.save(branch);
		logger.info("updateBranch() ..... End");
		return new ResponseEntity<Branch>(savedBranch, HttpStatus.OK);
	}

	@DeleteMapping(path = "deleteBranch/{branchId}")
	public ResponseEntity<HttpStatus> deletebranch(@PathVariable("branchId") String branchId) {
		Branch branch = this.branchRepository.findOne(Long.parseLong(branchId));
		branch.setStatus('I');
		Branch savedBranch = this.branchRepository.save(branch);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}
	
	
	

}
