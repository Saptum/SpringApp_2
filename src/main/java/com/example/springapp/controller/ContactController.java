package com.example.springapp.controller;

import com.example.springapp.domain.Contact;
import com.example.springapp.dto.ContactDto;
import com.example.springapp.mapper.ContactMapper;
import com.example.springapp.service.ContactService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Contact Controller", description = "The Contact API")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ContactController {

    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @PostMapping("/contacts")
    public ResponseEntity<ContactDto> saveContact(@RequestBody ContactDto contactDto) {
        Contact contact = ContactMapper.INSTANCE.contactDtoToContact(contactDto);
        service.saveContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(contactDto);
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<ContactDto>> getContacts() {
        List<ContactDto> contactDtoList = ContactMapper
                .INSTANCE.contactToDtos(service.getContacts());
        return ResponseEntity.status(HttpStatus.OK).body(contactDtoList);
    }

    @GetMapping("/contactsByCountry/{country}")
    public ResponseEntity<List<ContactDto>> getContactsByCountry(@PathVariable String country) {
        List<ContactDto> contactDtoList = ContactMapper.INSTANCE.contactToDtos(service.getContactsByCountry(country));
        return ResponseEntity.status(HttpStatus.OK).body(contactDtoList);
    }

    @GetMapping("/contactsByCity/{city}")
    public ResponseEntity<List<ContactDto>> getContactsByCity(@PathVariable String city) {
        List<ContactDto> contactDtoList = ContactMapper.INSTANCE.contactToDtos(service.getContactsByCity(city));
        return ResponseEntity.status(HttpStatus.OK).body(contactDtoList);
    }

    @GetMapping("/contactById/{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable Integer id) {
        ContactDto contactDtoList = ContactMapper.INSTANCE.contactToDto(service.getContactById(id));
        return ResponseEntity.status(HttpStatus.OK).body(contactDtoList);
    }


    @PostMapping("/addContact")
    public Contact saveContact(@RequestBody Contact contact) {
        return service.saveContact(contact);
    }

    @PostMapping("/addContacts")
    public List<Contact> saveContact(@RequestBody List<Contact> contacts) {
        return service.saveContacts(contacts);
    }

    @PutMapping("/updateContact")
    public ResponseEntity<ContactDto> updateContact(@RequestBody Contact contact) {
        ContactDto contactDto = ContactMapper
                .INSTANCE.contactToDto(service.updateContact( contact));
        return ResponseEntity.status(HttpStatus.OK).body(contactDto);
    }

    @DeleteMapping("/deleteContact/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Integer id) {
        service.deleteContact(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Employee with id : " + id + " deleted");
    }

}
