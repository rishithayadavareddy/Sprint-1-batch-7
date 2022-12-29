package com.capgemini.admission.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.capgemini.admission.dto.UserDTO;
import com.capgemini.admission.entity.User;
import com.capgemini.admission.repository.UserRepository;
import com.capgemini.admission.service.IUserService;
@Service
public class IUserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepopsitory;
	@Override
	public UserDTO addUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		userRepopsitory.save(user);
		return userDTO;
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		userRepopsitory.save(user);
		return userDTO;

	}

	@Override
	public boolean deleteUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		userRepopsitory.delete(user);

		return true;

	}

	

	@Override
	public List<UserDTO> getAllUsers() {
		// TODO Auto-generated method stub
		Iterable<User> list = userRepopsitory.findAll();
		List<UserDTO> dtos = new ArrayList<>();
		for (User user : list) {
			UserDTO dto = new UserDTO();
			BeanUtils.copyProperties(user, dto);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public UserDTO getUserById(int userId) {
	
		// TODO Auto-generated method stub
		Optional<User> user=userRepopsitory.findById(userId);
		if(user.isPresent()) {
			//convert the entity to DTO
			UserDTO dto=new UserDTO();
			BeanUtils.copyProperties(user.get(), dto);
			return dto;
			
		
	}	
		return null;
	}

}
