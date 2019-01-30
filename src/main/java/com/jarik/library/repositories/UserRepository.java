package com.jarik.library.repositories;

import com.jarik.library.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {List<User> findByName(String name);}
