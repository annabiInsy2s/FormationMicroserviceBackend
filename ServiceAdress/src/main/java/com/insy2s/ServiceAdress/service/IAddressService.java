package com.insy2s.ServiceAdress.service;

import com.insy2s.ServiceAdress.model.Address;

import java.util.List;
import java.util.Optional;

public interface IAddressService {

    Optional<Address> getAddressById(int id);
    Address createAddress(Address address);
    Address updateAddress(Address address ,int id);
 void deleteAddress (int id);
 List<Address> getAllAddress();





}
