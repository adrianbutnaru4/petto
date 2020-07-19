package petto.pettobackend.model.adoptionsource.shelter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import petto.pettobackend.model.adoptionsource.AdoptionSource;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shelters")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Shelter extends AdoptionSource {

  private String name;

  //  private List<Animal> animals;  // TODO: investigate how to tell when an animal is in a shelter

  private String address; // TODO: investigate appropriate map service to save shelter address
}
