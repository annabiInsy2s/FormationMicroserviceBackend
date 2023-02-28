package com.insy2s.ServiceUser.service;

import com.insy2s.ServiceUser.dto.Address;
import com.insy2s.ServiceUser.dto.ResponseDto;
import com.insy2s.ServiceUser.dto.UserDto;
import com.insy2s.ServiceUser.model.User;
import com.insy2s.ServiceUser.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        UserDto userDto = mapToUser(user);
        Address address = apiClient.getAdressById(user.getAddressId());
        responseDto.setUser(userDto);
        responseDto.setAddress(address);

        return responseDto;
    }

    private UserDto mapToUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());

        return userDto;
    }


    @Override
    public User createUser(User user) {
            return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, int id) {
        Optional<User> userSerched=userRepository.findUserByEmail(user.getEmail());
      if(userSerched.isEmpty())
             return null;
      else{
          userSerched.get().setEmail(user.getEmail());
          userSerched.get().setName(user.getName());
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
