package petto.pettobackend.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.dto.user.UserDto;
import petto.pettobackend.mapper.config.UserMapperConfig;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.base.BaseEntity;
import petto.pettobackend.model.user.User;

@Mapper(config = UserMapperConfig.class)
public abstract class UserMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseEntity")
  @Mappings({})
  public abstract User mapToUser(UserDto userDto);

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({})
  public abstract UserDto mapToUserDto(User user);

  @Override
  public BaseEntity mapToEntity(BaseDto dto) {
    return mapToUser((UserDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseEntity entity) {
    return mapToUserDto((User) entity);
  }
}
