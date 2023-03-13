package com.insy2s.ServiceUser.service;

import com.insy2s.ServiceUser.dto.Address;
import com.insy2s.ServiceUser.dto.ResponseDto;
import com.insy2s.ServiceUser.model.User;
import com.insy2s.ServiceUser.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl  implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private APIClient apiClient;

    public ResponseDto getUserById(int userId) {

        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).get();
        ResponseDto userDto = mapToUser(user);

        Address address = apiClient.getAdressById(user.getAddressId());

        userDto.setAddress(address);

        return userDto;
    }

    private ResponseDto mapToUser(User user){
        ResponseDto userDto = new ResponseDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());

        return userDto;
    }




    @Override
    public User updateUser(User user, int id) {
        Optional<User> userSerched=userRepository.findByUsername(user.getUsername());
      if(userSerched.isEmpty())
             return null;
      else{
          userSerched.get().setUsername(user.getUsername());
          userSerched.get().setPassword(user.getPassword());
    return userRepository.save(userSerched.get());
}
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }
}
