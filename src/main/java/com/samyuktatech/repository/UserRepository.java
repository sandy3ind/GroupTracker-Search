package com.samyuktatech.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.samyuktatech.document.User;

public interface UserRepository extends CrudRepository<User, String> {

	List<User> findByNameContaining(String query);

}
