package com.capgemini.admission.service;

import java.util.List;

import com.capgemini.admission.dto.UserDTO;

public interface IUserService {
	 public UserDTO addUser(UserDTO userDTO);
	 public UserDTO updateUser(UserDTO userDTO);
	 public boolean deleteUser(UserDTO userDTO);
	 public UserDTO getUserById(int userId);
	 public List<UserDTO> getAllUsers();
}
