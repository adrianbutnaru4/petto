package petto.pettobackend.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import petto.pettobackend.dto.adoptionsource.post.types.AdoptionPostDto;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.mapper.config.AdoptionPostMapperConfig;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.adoptionsource.post.types.AdoptionPost;
import petto.pettobackend.model.base.BaseEntity;

@Mapper(config = AdoptionPostMapperConfig.class)
public abstract class AdoptionPostMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseEntity")
  @Mappings({})
  public abstract AdoptionPost mapToAdoptionPost(AdoptionPostDto adoptionPostDto);

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({})
  public abstract AdoptionPostDto mapToAdoptionPostDto(AdoptionPost adoptionPost);

  @Override
  public BaseEntity mapToEntity(BaseDto dto) {
    return mapToAdoptionPost((AdoptionPostDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseEntity entity) {
    return mapToAdoptionPostDto((AdoptionPost) entity);
  }
}
