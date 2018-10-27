package com.franco.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.franco.app.dataobjects.User;


@RepositoryRestResource
@CrossOrigin
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("FROM User where status = 'A' ")
	public List<User> getAllUsers();

	@Query("FROM User where status = 'A' and userrole.id=:roleId ")
	public List<User> getUserByRole(@Param("roleId") Long roleId);

	@Query("FROM User where status = 'A' and email=:email and password=:password ")
	public User findByEmailAndPassword(@Param("email") String email,@Param("password") String password);

	@Query("FROM User where status = 'A' and email=:email")
	public User findByEmail(@Param("email") String email);


}
