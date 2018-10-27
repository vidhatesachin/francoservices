package com.franco.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.franco.app.dataobjects.Userrole;


@RepositoryRestResource
@CrossOrigin
public interface UserroleRepository extends CrudRepository<Userrole, Long> {

}
