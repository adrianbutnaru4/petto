package petto.pettobackend.model.adoptionsource.shelter;

import io.github.kaiso.relmongo.annotation.CascadeType;
import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.OneToMany;
import org.springframework.data.mongodb.core.mapping.Document;
import petto.pettobackend.model.adoptionsource.AdoptionSource;
import petto.pettobackend.model.animal.Animal;

import java.util.List;

@Document
public class Shelter extends AdoptionSource {

  private String name;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinProperty(name = "animals")
  private List<Animal> animals;

  private String address; // TODO: investigate appropriate map service to save shelter address
}
