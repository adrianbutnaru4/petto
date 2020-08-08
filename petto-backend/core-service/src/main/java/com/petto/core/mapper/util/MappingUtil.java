package com.petto.core.mapper.util;

import org.mapstruct.Qualifier;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

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
  public Integer animalId(Map<String, Serializable> in) {
    return (Integer) in.get(ANIMAL_ID);
  }

  @AdopterId
  public Integer adopterId(Map<String, Serializable> in) {
    return (Integer) in.get(ADOPTER_ID);
  }

  @AdoptionAddress
  public String adoptionAddress(Map<String, Serializable> in) {
    return (String) in.get(ADOPTION_ADDRESS);
  }

  @RecovererId
  public Integer recovererId(Map<String, Serializable> in) {
    return (Integer) in.get(RECOVERER_ID);
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
