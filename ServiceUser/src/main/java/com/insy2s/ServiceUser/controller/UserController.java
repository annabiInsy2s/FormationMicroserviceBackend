package com.insy2s.ServiceUser.controller;

import com.insy2s.ServiceUser.config.AES256;
import com.insy2s.ServiceUser.dto.ResponseDto;
import com.insy2s.ServiceUser.model.User;
import com.insy2s.ServiceUser.repository.UserRepository;
import com.insy2s.ServiceUser.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
//open for all ports
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserServiceImpl userService;
    @Autowired
    @GetMapping("/")
    public List<User> getAllUser( )  {
        return userService.getAllUser();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getUserById(@PathVariable int id){
        ResponseDto result=userService.getUserById(id);
        return ResponseEntity.status(201).body(result);

    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id){
        userService.deleteUser(id);

    }
    @PutMapping ("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Integer id){
        return ResponseEntity.status(200).body( userService.updateUser( user ,  id));

    }
    @PostMapping("/")
    public ResponseEntity<ResponseDto> createUser(@RequestBody User user)
    {

        Optional<User> userSerched=userRepository.findUserByEmail(user.getEmail());
        if(userSerched.isEmpty()){
            String encryptedString = AES256.encrypt(user.getPassword());
            user.setPassword(encryptedString);
            ResponseDto userCreated=userService.createUser(user);


            return ResponseEntity.status(201).body(userCreated);
        }
        else{
            return ResponseEntity.status(302).body(null);

        }




    }


}
