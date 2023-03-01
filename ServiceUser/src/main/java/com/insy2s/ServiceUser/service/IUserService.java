package com.insy2s.ServiceUser.service;

import com.insy2s.ServiceUser.dto.ResponseDto;
import com.insy2s.ServiceUser.model.User;

import java.util.List;

public interface IUserService {
    ResponseDto getUserById(int id);
    ResponseDto createUser(User user);
    User updateUser(User user ,int id);
    void deleteUser (int id);
    List<User> getAllUser();

}
