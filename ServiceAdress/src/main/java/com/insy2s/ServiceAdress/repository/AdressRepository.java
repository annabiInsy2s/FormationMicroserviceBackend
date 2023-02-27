package com.insy2s.ServiceAdress.repository;

import com.insy2s.ServiceAdress.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdressRepository  extends JpaRepository<Address,Integer> {
    @Query("SELECT u FROM Address u WHERE u.city = ?1 and  u.Street =?2 and u.postCode=?3")
   Optional <Address> findAdressByCity(String  city, String street,int postCode);
}
