package petto.pettobackend.mapper;

import org.mapstruct.*;
import petto.pettobackend.dto.adoptionsource.post.types.AdoptionPostDto;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.mapper.config.AdoptionPostMapperConfig;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.adoptionsource.post.types.AdoptionPost;
import petto.pettobackend.model.base.BaseEntity;

@Mapper(config = AdoptionPostMapperConfig.class)
public abstract class AdoptionPostMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToPost")
  @Mappings({
    @Mapping(target = "parentPost.id", source = "parentPostId"),
    @Mapping(target = "adopter.id", source = "adopterId")
  })
  public abstract AdoptionPost mapToAdoptionPost(AdoptionPostDto adoptionPostDto);

  @AfterMapping
  public void afterMapToAdoptionPost(
      AdoptionPostDto adoptionPostDto, @MappingTarget AdoptionPost adoptionPost) {
    if (adoptionPostDto.getAnimalId() == null) {
      adoptionPost.setAnimal(null);
    }
  }

  @InheritConfiguration(name = "mapToPostDto")
  @Mappings({
    @Mapping(target = "parentPostId", source = "parentPost.id"),
    @Mapping(target = "adopterId", source = "adopter.id")
  })
  public abstract AdoptionPostDto mapToAdoptionPostDto(AdoptionPost adoptionPost);

  @AfterMapping
  public void afterMapToAdoptionPostDto(
      AdoptionPost adoptionPost, @MappingTarget AdoptionPostDto adoptionPostDto) {
    if (adoptionPost.getAnimal() == null) {
      adoptionPostDto.setAnimalId(null);
    }
  }

  @Override
  public BaseEntity mapToEntity(BaseDto dto) {
    return mapToAdoptionPost((AdoptionPostDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseEntity entity) {
    return mapToAdoptionPostDto((AdoptionPost) entity);
  }
}
