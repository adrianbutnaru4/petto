package com.petto.core.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import com.petto.core.dto.base.BaseDto;
import com.petto.core.dto.user.UserDto;
import com.petto.core.mapper.config.UserMapperConfig;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.model.base.BaseEntity;
import com.petto.core.model.user.User;

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
