package petto.pettobackend.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import petto.pettobackend.dto.adoptionsource.post.types.AdoptionPostDto;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.mapper.config.AdoptionPostMapperConfig;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.adoptionsource.post.types.AdoptionPost;
import petto.pettobackend.model.base.BaseDocument;

@Mapper(config = AdoptionPostMapperConfig.class)
public abstract class AdoptionPostMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseDocument")
  @Mappings({})
  public abstract AdoptionPost mapToAdoptionPost(AdoptionPostDto adoptionPostDto);

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({})
  public abstract AdoptionPostDto mapToAdoptionPostDto(AdoptionPost adoptionPost);

  @Override
  public BaseDocument mapToDocument(BaseDto dto) {
    return mapToAdoptionPost((AdoptionPostDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseDocument document) {
    return mapToAdoptionPostDto((AdoptionPost) document);
  }
}
