package com.example.springapp.controller;

import com.example.springapp.model.Contact;
import com.example.springapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactService service;

    @PostMapping("/addContact")
    public Contact saveContact(@RequestBody Contact contact) {
        return service.saveContact(contact);
    }

    @PostMapping("/addContacts")
    public List<Contact> saveContact(@RequestBody List<Contact> contacts) {
        return service.saveContacts(contacts);
    }

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return service.getContacts();
    }

    @GetMapping("/contactById/{id}")
    public Contact getContactById(@PathVariable int id) {
        return service.getContactById(id);
    }

    @GetMapping("/contactsByCountry/{country}")
    public List<Contact> getContactsByCountry(@PathVariable String country) {
        return service.getContactsByCountry(country);
    }

    @GetMapping("/contactsByCity/{city}")
    public List<Contact> getContactsByCity(@PathVariable String city) {
        return service.getContactsByCity(city);
    }

    @PutMapping("/updateContact")
    public Contact updateContact(@RequestBody Contact contact) {
        return service.updateContact(contact);
    }

    @DeleteMapping("/deleteContact/{id}")
    public String deleteContact(@PathVariable int id) {
        return service.deleteContact(id);
    }

}
