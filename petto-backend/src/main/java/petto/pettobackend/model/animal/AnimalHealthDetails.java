package petto.pettobackend.model.animal;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import petto.pettobackend.model.base.BaseDocument;

// TODO: find ICD10 animal correspondent
@Data
@Document
public class AnimalHealthDetails extends BaseDocument {

  private String animalId;
}
