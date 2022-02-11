package com.example.springapp.repository;

import com.example.springapp.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findAllByCountry(String country);

    List<Contact> findAllByCity(String city);
}
