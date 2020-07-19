package petto.pettobackend.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import petto.pettobackend.dto.adoptionsource.post.types.RandomlyFoundPostDto;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.mapper.config.RandomlyFoundPostMapperConfig;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.adoptionsource.post.types.RandomlyFoundPost;
import petto.pettobackend.model.base.BaseEntity;

@Mapper(config = RandomlyFoundPostMapperConfig.class)
public abstract class RandomlyFoundPostMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToPost")
  @Mappings({
    @Mapping(target = "parentPost.id", source = "parentPostId"),
  })
  public abstract RandomlyFoundPost mapToRandomlyFoundPost(
      RandomlyFoundPostDto randomlyFoundPostDto);

  @InheritConfiguration(name = "mapToPostDto")
  @Mappings({
    @Mapping(target = "parentPostId", source = "parentPost.id"),
  })
  public abstract RandomlyFoundPostDto mapToRandomlyFoundPostDto(
      RandomlyFoundPost randomlyFoundPost);

  @Override
  public BaseEntity mapToEntity(BaseDto dto) {
    return mapToRandomlyFoundPost((RandomlyFoundPostDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseEntity entity) {
    return mapToRandomlyFoundPostDto((RandomlyFoundPost) entity);
  }
}
