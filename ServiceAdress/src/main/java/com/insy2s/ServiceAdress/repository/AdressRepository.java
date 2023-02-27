package com.insy2s.ServiceAdress.repository;

import com.insy2s.ServiceAdress.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository  extends JpaRepository<Adress,Integer> {
}
