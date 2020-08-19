package com.petto.core.mapper.util;

import org.mapstruct.Qualifier;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import java.util.Optional;

public class MappingUtil {

  private static final String ANIMAL_ID = "animalId";

  // Adoption Post
  private static final String ADOPTER_ID = "adopterId";
  private static final String ADOPTION_ADDRESS = "adoptionAddress";

  // Lost & Found Post
  private static final String RECOVERER_ID = "recovererId";
  private static final String LOST_ANIMAL_ADDRESS = "lostAnimalAddress";

  // Randomly Found Post
  private static final String RANDOMLY_FOUND_ANIMAL_ADDRESS = "randomlyFoundAnimalAddress";

  @Qualifier
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  public @interface AnimalId {}

  @Qualifier
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  public @interface AdopterId {}

  @Qualifier
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  public @interface AdoptionAddress {}

  @Qualifier
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  public @interface RecovererId {}

  @Qualifier
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  public @interface LostAnimalAddress {}

  @Qualifier
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  public @interface RandomlyFoundAnimalAddress {}

  @AnimalId
  public Long animalId(Map<String, Serializable> in) {
    return Optional.ofNullable((Number) in.get(ANIMAL_ID)).map(Number::longValue).orElse(null);
  }

  @AdopterId
  public Long adopterId(Map<String, Serializable> in) {
    return Optional.ofNullable((Number) in.get(ADOPTER_ID)).map(Number::longValue).orElse(null);
  }

  @AdoptionAddress
  public String adoptionAddress(Map<String, Serializable> in) {
    return (String) in.get(ADOPTION_ADDRESS);
  }

  @RecovererId
  public Long recovererId(Map<String, Serializable> in) {
    return Optional.ofNullable((Number) in.get(RECOVERER_ID)).map(Number::longValue).orElse(null);
  }

  @LostAnimalAddress
  public String lostAnimalAddress(Map<String, Serializable> in) {
    return (String) in.get(LOST_ANIMAL_ADDRESS);
  }

  @RandomlyFoundAnimalAddress
  public String randomlyFoundAnimalAddress(Map<String, Serializable> in) {
    return (String) in.get(RANDOMLY_FOUND_ANIMAL_ADDRESS);
  }
}
