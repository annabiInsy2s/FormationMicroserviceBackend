package com.insy2s.ServiceUser.service;

import com.insy2s.ServiceUser.dto.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "AddressService", url = "http://localhost:8083/api/address")
public interface APIClient {
    @GetMapping(value = "/{id}")
    Address getAdressById(@PathVariable int addressId);
}
