package com.franco.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.franco.app.dataobjects.Branch;
import com.franco.app.dataobjects.User;


@RepositoryRestResource
@CrossOrigin
public interface BranchRepository extends CrudRepository<Branch, Long> {


	@Query("FROM Branch where status = 'A' ")
	public List<Branch> getAllBranches();

	//public List<Branch> getAllBranches();

}
