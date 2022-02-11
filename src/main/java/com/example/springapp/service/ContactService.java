package com.example.springapp.service;

import com.example.springapp.domain.Contact;
import com.example.springapp.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private  final ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public Contact saveContact(Contact contact) {
        return repository.save(contact);
    }

    public List<Contact> saveContacts(List<Contact> contacts) {
        return repository.saveAll(contacts);
    }

    public List<Contact> getContacts() {
        return repository.findAll();
    }

    public Contact getContactById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Contact> getContactsByCountry(String country) {
        return repository.findAllByCountry(country);
    }

    public List<Contact> getContactsByCity(String city) {
        return repository.findAllByCity(city);
    }

    public Contact updateContact(Contact contact) {
        Contact updatedContact = repository.findById(contact.getId()).orElse(null);
        updatedContact.setPhone(contact.getPhone());
        updatedContact.setName(contact.getName());
        updatedContact.setCity(contact.getCity());
        updatedContact.setCountry(contact.getCountry());
        updatedContact.setEmail(contact.getEmail());
        return repository.save(updatedContact);
    }

    public String deleteContact(int id) {
        repository.deleteById(id);
        return "Contact " + id + " was deleted!";
    }
}
