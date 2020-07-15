package petto.pettobackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import petto.pettobackend.dto.user.UserDto;
import petto.pettobackend.mapper.generic.AbstractMapper;
import petto.pettobackend.model.user.User;

@Mapper
public interface UserMapper extends AbstractMapper<User, UserDto> {

  UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
}
