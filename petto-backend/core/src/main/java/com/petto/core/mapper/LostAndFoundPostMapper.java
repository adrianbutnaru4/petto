package com.petto.core.mapper;

import com.petto.core.dto.adoptionsource.post.types.LostAndFoundPostDto;
import com.petto.core.dto.base.BaseDto;
import com.petto.core.mapper.config.LostAndFoundPostMapperConfig;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.model.adoptionsource.post.types.LostAndFoundPost;
import com.petto.core.model.base.BaseEntity;
import org.mapstruct.*;

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
