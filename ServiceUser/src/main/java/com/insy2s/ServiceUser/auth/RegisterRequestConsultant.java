package com.insy2s.ServiceUser.auth;

import com.insy2s.ServiceUser.model.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RegisterRequestConsultant {
    private String username;
    private List<Role> roles = new ArrayList<>();
}
