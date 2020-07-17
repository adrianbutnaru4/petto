package petto.pettobackend.mapper;

import org.mapstruct.*;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.dto.user.UserDto;
import petto.pettobackend.mapper.config.UserMapperConfig;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.base.BaseDocument;
import petto.pettobackend.model.user.User;

import java.util.stream.IntStream;

@Mapper(config = UserMapperConfig.class)
public abstract class UserMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseDocument")
  @Mappings({})
  public abstract User mapToUser(UserDto userDto);

  @InheritConfiguration(name = "mapToBaseDto")
  public abstract UserDto mapToUserDto(User user);

  @Override
  public BaseDocument mapToDocument(BaseDto dto) {
    return mapToUser((UserDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseDocument document) {
    return mapToUserDto((User) document);
  }

  // TODO: change implementation
  @AfterMapping
  public void afterMapToDto(User user, @MappingTarget UserDto userDto) {
    IntStream.range(0, userDto.getPosts().size())
        .boxed()
        .forEach(
            i -> {
              userDto.getPosts().get(i).setPosterId(user.getPosts().get(i).getPoster().getId());
              userDto
                  .getPosts()
                  .get(i)
                  .getAnimal()
                  .setPostId(user.getPosts().get(i).getAnimal().getPost().getId());
            });
  }
}
