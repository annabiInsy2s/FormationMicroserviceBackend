package com.insy2s.ServiceAdress.service;

import com.insy2s.ServiceAdress.model.Adress;

import java.util.List;
import java.util.Optional;

public interface IAdressService {

    Optional<Adress> getAdressById(int id);
    Adress createAdress(Adress adress);
 Adress updateAdress(Adress adress);
 void deleteAddress (int id);
 List<Adress> getAllAdress();





}
