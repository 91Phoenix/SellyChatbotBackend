package com.reply.hackaton.repository;

import org.springframework.data.repository.CrudRepository;
import com.reply.hackaton.model.User;

public interface UserRepository extends  CrudRepository<User, String>{

}
