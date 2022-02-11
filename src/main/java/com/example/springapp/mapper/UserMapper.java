package com.example.springapp.mapper;

import com.example.springapp.domain.User;
import com.example.springapp.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToDto(User user);

    List<UserDto> userToDtos (List<User> userList);

    User userDtoToUser (UserDto userDto);
}
