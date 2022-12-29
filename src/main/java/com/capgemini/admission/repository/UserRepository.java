package com.capgemini.admission.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.admission.dto.UserDTO;
import com.capgemini.admission.entity.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
//UserDTO findById(UserDTO userDTO);
}
