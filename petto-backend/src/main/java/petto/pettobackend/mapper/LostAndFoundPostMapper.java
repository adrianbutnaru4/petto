package petto.pettobackend.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import petto.pettobackend.dto.adoptionsource.post.types.LostAndFoundPostDto;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.mapper.config.AdoptionSourceMapperConfig;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.adoptionsource.post.types.LostAndFoundPost;
import petto.pettobackend.model.base.BaseEntity;

@Mapper(config = AdoptionSourceMapperConfig.class)
public abstract class LostAndFoundPostMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseEntity")
  @Mappings({})
  public abstract LostAndFoundPost mapToLostAndFoundPost(LostAndFoundPostDto lostAndFoundPostDto);

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({})
  public abstract LostAndFoundPostDto mapToLostAndFoundPostDto(LostAndFoundPost lostAndFoundPost);

  @Override
  public BaseEntity mapToEntity(BaseDto dto) {
    return mapToLostAndFoundPost((LostAndFoundPostDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseEntity entity) {
    return mapToLostAndFoundPostDto((LostAndFoundPost) entity);
  }
}
