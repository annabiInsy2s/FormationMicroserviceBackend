package com.insy2s.ServiceAdress.service;

import com.insy2s.ServiceAdress.model.Address;
import com.insy2s.ServiceAdress.repository.AdressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements  IAddressService{
    @Autowired
   private  AdressRepository adressRepository;
    @Override
    public Optional<Address> getAddressById(int id)
    {
        return adressRepository.findById(id);
    }

    @Override
    public Address createAddress(Address adress) {


        return adressRepository.save(adress);
    }

    @Override
    public Address updateAddress(Address adress ,int id) {
        Optional<Address> result=adressRepository.findById(id);
        if(result.isEmpty())
        {
            return null;
        }
        else{
            result.get().setCity(adress.getCity());
            result.get().setStreet(adress.getStreet());

            result.get().setPostCode(adress.getPostCode());

            return result.get();
    }}

    @Override
    public void deleteAddress(int id) {
        adressRepository.deleteById(id);

    }

    @Override
    public List<Address> getAllAddress() {
        return adressRepository.findAll();
    }
}
