package com.insy2s.ServiceUser.dto;

import com.insy2s.ServiceUser.model.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Data
public class UserDto {
    private int id;


    private  String username;

    private int  addressId;
    private List<Role> roles = new ArrayList<>();
}
