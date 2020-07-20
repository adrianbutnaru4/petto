package petto.pettobackend.mapper;

import org.mapstruct.*;
import petto.pettobackend.dto.adoptionsource.post.types.LostAndFoundPostDto;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.mapper.config.LostAndFoundPostMapperConfig;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.adoptionsource.post.types.LostAndFoundPost;
import petto.pettobackend.model.base.BaseEntity;

@Mapper(config = LostAndFoundPostMapperConfig.class)
public abstract class LostAndFoundPostMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToPost")
  @Mappings({
    @Mapping(target = "parentPost.id", source = "parentPostId"),
    @Mapping(target = "recoverer.id", source = "recovererId")
  })
  public abstract LostAndFoundPost mapToLostAndFoundPost(LostAndFoundPostDto lostAndFoundPostDto);

  @AfterMapping
  public void afterMapToLostAndFoundPost(
      LostAndFoundPostDto lostAndFoundPostDto, @MappingTarget LostAndFoundPost lostAndFoundPost) {
    if (lostAndFoundPostDto.getAnimalId() == null) {
      lostAndFoundPost.setAnimal(null);
    }
  }

  @InheritConfiguration(name = "mapToPostDto")
  @Mappings({
    @Mapping(target = "parentPostId", source = "parentPost.id"),
    @Mapping(target = "recovererId", source = "recoverer.id")
  })
  public abstract LostAndFoundPostDto mapToLostAndFoundPostDto(LostAndFoundPost lostAndFoundPost);

  @AfterMapping
  public void afterMapToLostAndFoundPostDto(
      LostAndFoundPost lostAndFoundPost, @MappingTarget LostAndFoundPostDto lostAndFoundPostDto) {
    if (lostAndFoundPost.getAnimal() == null) {
      lostAndFoundPostDto.setAnimalId(null);
    }
  }

  @Override
  public BaseEntity mapToEntity(BaseDto dto) {
    return mapToLostAndFoundPost((LostAndFoundPostDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseEntity entity) {
    return mapToLostAndFoundPostDto((LostAndFoundPost) entity);
  }
}
