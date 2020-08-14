package com.petto.core.mapper;

import com.petto.core.dto.base.BaseDto;
import com.petto.core.dto.user.UserDto;
import com.petto.core.mapper.config.UserMapperConfig;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.model.base.BaseEntity;
import com.petto.core.model.user.User;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(config = UserMapperConfig.class)
public abstract class UserMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseEntity")
  @Mappings({})
  public abstract User mapToUser(UserDto userDto);

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({})
  public abstract UserDto mapToUserDto(User user);

  @Override
  public User mapToEntity(BaseDto dto) {
    return mapToUser((UserDto) dto);
  }

  @Override
  public UserDto mapToDto(BaseEntity entity) {
    return mapToUserDto((User) entity);
  }
}
