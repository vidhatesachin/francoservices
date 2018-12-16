package com.franco.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.franco.app.dataobjects.Branch;
import com.franco.app.dataobjects.User;


@RepositoryRestResource
@CrossOrigin
public interface BranchRepository extends CrudRepository<Branch, Long> {


	@Query("FROM Branch where status = 'A' ")
	public List<Branch> getAllBranches();
	
	@Query("FROM Branch where status = 'A' and id=:id")
	public Branch findById(@Param("id") Long id);

	//public List<Branch> getAllBranches();

}
