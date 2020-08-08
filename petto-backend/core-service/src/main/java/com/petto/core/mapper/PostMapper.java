package com.petto.core.mapper;

import com.petto.core.dto.adoptionsource.post.types.AdoptionPostDto;
import com.petto.core.dto.adoptionsource.post.types.LostAndFoundPostDto;
import com.petto.core.dto.adoptionsource.post.types.RandomlyFoundPostDto;
import com.petto.core.dto.base.BaseDto;
import com.petto.core.dto.post.PostDto;
import com.petto.core.mapper.config.PostMapperConfig;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.mapper.util.MappingUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import static com.petto.core.mapper.util.MappingUtil.*;

@Mapper(config = PostMapperConfig.class, uses = MappingUtil.class)
public abstract class PostMapper implements AbstractMapper {

  @Mappings({
    @Mapping(source = "fields", target = "animalId", qualifiedBy = AnimalId.class),
    @Mapping(source = "fields", target = "adopterId", qualifiedBy = AdopterId.class),
    @Mapping(source = "fields", target = "adoptionAddress", qualifiedBy = AdoptionAddress.class)
  })
  abstract AdoptionPostDto mapToAdoptionPostDto(PostDto postDto);

  @Mappings({
    @Mapping(source = "fields", target = "animalId", qualifiedBy = AnimalId.class),
    @Mapping(source = "fields", target = "recovererId", qualifiedBy = RecovererId.class),
    @Mapping(source = "fields", target = "lostAnimalAddress", qualifiedBy = LostAnimalAddress.class)
  })
  abstract LostAndFoundPostDto mapToLostAndFoundPostDto(PostDto postDto);

  @Mappings({
    @Mapping(source = "fields", target = "animalId", qualifiedBy = AnimalId.class),
    @Mapping(
        source = "fields",
        target = "randomlyFoundAnimalAddress",
        qualifiedBy = RandomlyFoundAnimalAddress.class)
  })
  abstract RandomlyFoundPostDto mapToRandomlyFoundPostDto(PostDto postDto);

  public BaseDto mapToCustomPostDto(PostDto postDto) {
    switch (postDto.getType()) {
      case ADOPTION_POST:
        return mapToAdoptionPostDto(postDto);
      case LOST_AND_FOUND_POST:
        return mapToLostAndFoundPostDto(postDto);
      case RANDOMLY_FOUND_POST:
        return mapToRandomlyFoundPostDto(postDto);
      default:
        return null;
    }
  }
}
