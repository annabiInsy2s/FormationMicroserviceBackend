package com.insy2s.ServiceUser.auth;

import com.insy2s.ServiceUser.dto.UserConsultantDto;
import com.insy2s.ServiceUser.dto.UserDto;
import com.insy2s.ServiceUser.model.User;
import com.insy2s.ServiceUser.repository.UserRepository;
import com.insy2s.ServiceUser.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
@Autowired
private UserRepository userRepository;
    private final AuthenticationService service;
    @Autowired
    private EmailService emailService;
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegisterRequest request){
        return ResponseEntity.status(201).body(service.register(request));
    }
    @PostMapping("/registerConsultant")
    public ResponseEntity<String> register(@RequestBody RegisterRequestConsultant request){
        Optional<User> userSeched=userRepository.findByUsername(request.getUsername());
        if (userSeched.isEmpty()){
            AuthenticationResponse  tokenObecjt=service.RegisterConsulant(request);
            String token= tokenObecjt.getToken();
            String status= emailService.sendSimpleMail(token,request.getUsername());
            return ResponseEntity.status(201).body(status);
        }
        else return ResponseEntity.status(203).body("User found ");

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }

}
