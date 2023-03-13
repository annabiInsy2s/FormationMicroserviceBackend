package com.insy2s.ServiceUser.service;

import com.insy2s.ServiceUser.model.Role;
import com.insy2s.ServiceUser.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Optional<Role> createRole(Role role) {
        return Optional.of(roleRepository.save(role));
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
