package petto.pettobackend.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import petto.pettobackend.dto.UserDto;
import petto.pettobackend.model.User;

import java.util.stream.IntStream;

@Mapper
public interface UserMapper {

  UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "firstName", target = "firstName"),
    @Mapping(source = "lastName", target = "lastName"),
    @Mapping(source = "postDtos", target = "posts")
  })
  User toModel(UserDto userDto);

  @AfterMapping
  default void toModel(@MappingTarget User user, UserDto userDto) {
    IntStream.range(0, user.getPosts().size())
        .forEach(
            i ->
                user.getPosts()
                    .get(i)
                    .setAnimal(
                        AnimalMapper.MAPPER.toModel(userDto.getPostDtos().get(i).getAnimalDto())));
  }

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "firstName", target = "firstName"),
    @Mapping(source = "lastName", target = "lastName"),
    @Mapping(source = "posts", target = "postDtos")
  })
  UserDto toDto(User user);

  @AfterMapping
  default void toDto(User user, @MappingTarget UserDto userDto) {
    IntStream.range(0, userDto.getPostDtos().size())
        .forEach(
            i ->
                userDto
                    .getPostDtos()
                    .get(i)
                    .setAnimalDto(AnimalMapper.MAPPER.toDto(user.getPosts().get(i).getAnimal())));
  }
}
