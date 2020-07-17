package petto.pettobackend.model.animal;

import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.OneToOne;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import petto.pettobackend.model.base.BaseDocument;

// TODO: find ICD10 animal correspondent
@Data
@Document
public class AnimalHealthDetails extends BaseDocument {

  @OneToOne(mappedBy = "healthDetails", fetch = FetchType.LAZY)
  private Animal animal;
}
