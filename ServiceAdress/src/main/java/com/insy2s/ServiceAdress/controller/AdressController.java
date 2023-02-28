package com.insy2s.ServiceAdress.controller;

import com.insy2s.ServiceAdress.model.Address;
import com.insy2s.ServiceAdress.repository.AdressRepository;
import com.insy2s.ServiceAdress.service.AddressServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/address")
//open for all ports
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class AdressController {
    @Autowired
    private final AddressServiceImpl addressService;
    @Autowired
    private final AdressRepository addressRepository;
    @GetMapping("/")
    public List<Address> getAllAddress( )  {
        return addressService.getAllAddress();
    }
    @GetMapping("/{id}")
    public Address getAdresseById(@PathVariable int id){
        Optional<Address>  adresseGetById=addressService.getAddressById(id);
        return adresseGetById.get();

    }
    @DeleteMapping("/{id}")
    public void deleteAdresseById(@PathVariable int id){
        addressService.deleteAddress(id);

    }
    @PutMapping ("/{id}")
    public ResponseEntity<Address> updateAdresse(@RequestBody Address adresse,@PathVariable Integer id){
        return ResponseEntity.status(200).body( addressService.updateAddress( adresse ,  id));

    }
    @PostMapping("/")
    public ResponseEntity<Address> createAddress(@RequestBody Address address)
    {
        Optional <Address> adressSerch=addressRepository.findAdressByCity(address.getCity(),address.getStreet(),address.getPostCode());
        if(adressSerch.isEmpty())
        {
            Address adressCreated=addressService.createAddress(address);
            return ResponseEntity.status(201).body(adressCreated);

        }
        else {
            return ResponseEntity.status(204).body(address);

        }

    }
}
