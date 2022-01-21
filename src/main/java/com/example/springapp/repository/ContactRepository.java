package com.example.springapp.repository;

import com.example.springapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findAllByCountry(String country);

    List<Contact> findAllByCity(String city);
}
