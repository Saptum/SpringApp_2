package com.example.springapp.mapper;

import com.example.springapp.domain.Contact;
import com.example.springapp.dto.ContactDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactMapper {

    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    ContactDto contactToDto (Contact contact);

    List<ContactDto> contactToDtos (List <Contact> contacts);

    Contact contactDtoToContact (ContactDto contactDto);
}
