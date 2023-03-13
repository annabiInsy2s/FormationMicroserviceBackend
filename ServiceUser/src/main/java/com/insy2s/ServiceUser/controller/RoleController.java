package com.insy2s.ServiceUser.controller;

import com.insy2s.ServiceUser.model.Role;
import com.insy2s.ServiceUser.model.User;
import com.insy2s.ServiceUser.service.IRoleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
//open for all ports
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class RoleController {
    @Autowired
    IRoleServiceImpl iRoleService;
    @GetMapping("/")
    @PreAuthorize("")
    public List<Role> getAllUser( )  {
        return iRoleService.getAllRoles();
    }
    @PostMapping("/")
    public ResponseEntity<Role> createRole(@RequestBody Role role )  {
        return  ResponseEntity.status(201).body(iRoleService.createRole(role).get());
    }
}
