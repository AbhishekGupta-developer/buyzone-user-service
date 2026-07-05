package com.buyzone.user_service.service;

import com.buyzone.user_service.dto.request.UserRequestDto;
import com.buyzone.user_service.dto.response.GenericResponseDto;
import com.buyzone.user_service.dto.response.UserResponseDto;
import com.buyzone.user_service.entity.User;
import com.buyzone.user_service.exception.UserNotFoundException;
import com.buyzone.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDto registerUser(UserRequestDto userRequestDto) {
        User user = mapUserRequestDtoToUser(new User(), userRequestDto);
        userRepository.save(user);
        return mapUserToUserResponseDto(user);
    }

    @Override
    public UserResponseDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User id: " + id + " doesn't exist"));
        return mapUserToUserResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserResponseDto> userResponseDtoList = new LinkedList<>();

        for(User user : userList) {
            userResponseDtoList.add(mapUserToUserResponseDto(user));
        }

        return userResponseDtoList;
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User id: " + id + " doesn't exist"));
        mapUserRequestDtoToUser(user, userRequestDto);
        userRepository.save(user);
        return mapUserToUserResponseDto(user);
    }

    @Override
    public GenericResponseDto removeUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User id: " + id + " doesn't exist"));

        String name = user.getName();
        userRepository.deleteById(id);

        GenericResponseDto genericResponseDto = new GenericResponseDto();
        genericResponseDto.setSuccess(true);
        genericResponseDto.setMessage("Successfully removed user: " + name);

        return genericResponseDto;
    }

    // helper method

    // map UserRequestDto to User
    private User mapUserRequestDtoToUser(User user, UserRequestDto userRequestDto) {
       user.setName(userRequestDto.getName());
       user.setEmail(userRequestDto.getEmail());
       user.setPassword(userRequestDto.getPassword());
       user.setPhone(userRequestDto.getPhone());
       user.setAddress(userRequestDto.getAddress());
       user.setGender(userRequestDto.getGender());

       return user;
    }

    // map User to UserResponseDto
    private UserResponseDto mapUserToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPhone(user.getPhone());
        userResponseDto.setAddress(user.getAddress());
        userResponseDto.setGender(user.getGender());

        return userResponseDto;
    }
}
