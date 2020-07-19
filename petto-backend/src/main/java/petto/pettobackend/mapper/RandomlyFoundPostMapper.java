package petto.pettobackend.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import petto.pettobackend.dto.adoptionsource.post.types.RandomlyFoundPostDto;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.mapper.config.AdoptionSourceMapperConfig;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.adoptionsource.post.types.RandomlyFoundPost;
import petto.pettobackend.model.base.BaseEntity;

@Mapper(config = AdoptionSourceMapperConfig.class)
public abstract class RandomlyFoundPostMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseEntity")
  @Mappings({})
  public abstract RandomlyFoundPost mapToRandomlyFoundPost(
      RandomlyFoundPostDto randomlyFoundPostDto);

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({})
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
