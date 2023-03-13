package com.insy2s.ServiceUser.service;

import com.insy2s.ServiceUser.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    Optional<Role >createRole(Role role);
    List<Role> getAllRoles();
}
