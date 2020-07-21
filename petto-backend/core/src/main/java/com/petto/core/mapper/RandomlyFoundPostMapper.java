package com.petto.core.mapper;

import com.petto.core.dto.adoptionsource.post.types.RandomlyFoundPostDto;
import com.petto.core.dto.base.BaseDto;
import com.petto.core.mapper.config.RandomlyFoundPostMapperConfig;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.model.adoptionsource.post.types.RandomlyFoundPost;
import com.petto.core.model.base.BaseEntity;
import org.mapstruct.*;

@Mapper(config = RandomlyFoundPostMapperConfig.class)
public abstract class RandomlyFoundPostMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToPost")
  @Mappings({
    @Mapping(target = "parentPost.id", source = "parentPostId"),
  })
  public abstract RandomlyFoundPost mapToRandomlyFoundPost(
      RandomlyFoundPostDto randomlyFoundPostDto);

  @AfterMapping
  public void afterMapToRandomlyFoundPost(
      RandomlyFoundPostDto randomlyFoundPostDto,
      @MappingTarget RandomlyFoundPost randomlyFoundPost) {
    if (randomlyFoundPostDto.getAnimalId() == null) {
      randomlyFoundPost.setAnimal(null);
    }
  }

  @InheritConfiguration(name = "mapToPostDto")
  @Mappings({
    @Mapping(target = "parentPostId", source = "parentPost.id"),
  })
  public abstract RandomlyFoundPostDto mapToRandomlyFoundPostDto(
      RandomlyFoundPost randomlyFoundPost);

  @AfterMapping
  public void afterMapToRandomlyFoundPostDto(
      RandomlyFoundPost randomlyFoundPost,
      @MappingTarget RandomlyFoundPostDto randomlyFoundPostDto) {
    if (randomlyFoundPost.getAnimal() == null) {
      randomlyFoundPostDto.setAnimalId(null);
    }
  }

  @Override
  public BaseEntity mapToEntity(BaseDto dto) {
    return mapToRandomlyFoundPost((RandomlyFoundPostDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseEntity entity) {
    return mapToRandomlyFoundPostDto((RandomlyFoundPost) entity);
  }
}
