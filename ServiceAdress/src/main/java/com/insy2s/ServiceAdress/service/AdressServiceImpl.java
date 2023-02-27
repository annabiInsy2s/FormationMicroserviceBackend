package com.insy2s.ServiceAdress.service;

import com.insy2s.ServiceAdress.model.Adress;
import com.insy2s.ServiceAdress.repository.AdressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdressServiceImpl implements  IAdressService{
    @Autowired
   private  AdressRepository adressRepository;
    @Override
    public Optional<Adress> getAdressById(int id)
    {
        return adressRepository.findById(id);
    }

    @Override
    public Adress createAdress(Adress adress) {
        return adressRepository.save(adress);
    }

    @Override
    public Adress updateAdress(Adress adress) {
        return null;
    }

    @Override
    public void deleteAddress(int id) {
        adressRepository.deleteById(id);

    }

    @Override
    public List<Adress> getAllAdress() {
        return adressRepository.findAll();
    }
}
