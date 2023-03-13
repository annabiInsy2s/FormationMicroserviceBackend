package com.insy2s.ServiceUser.auth;


import com.insy2s.ServiceUser.config.JwtService;
import com.insy2s.ServiceUser.dto.UserDto;
import com.insy2s.ServiceUser.model.Role;
import com.insy2s.ServiceUser.model.User;
import com.insy2s.ServiceUser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserDto register(RegisterRequest request) {
        User user = new User();
               user.setUsername(request.getUsername());
                user.setAddressId(request.getAddressId());
                user.setPassword(passwordEncoder.encode(request.getPassword()));
                user.setRoles( request.getRoles());
       User userSaved= userRepository.save(user);
        UserDto  userDto=new UserDto();
        userDto.setId(userSaved.getId());
        userDto.setUsername(userSaved.getUsername());
        userDto.setRoles((List<Role>) userSaved.getRoles());


        return userDto;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken( user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse RegisterConsulant(RegisterRequestConsultant request) {
        Optional<User> userSerched=userRepository.findByUsername(request.getUsername());
        if(userSerched.isEmpty()){
            User user=new User();
            user.setUsername(request.getUsername());
            user.setRoles(request.getRoles());
            User userSaved=userRepository.save(user);
            var jwtToken = jwtService.generateToken( userSaved);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();}


        else {
            return null;}

    }
}
