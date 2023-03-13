package com.insy2s.ServiceUser.auth;

import com.insy2s.ServiceUser.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String username;
    private String password;
    private int addressId;
    private List<Role> roles = new ArrayList<>();



}
