package petto.pettobackend.model.adoptionsource;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import petto.pettobackend.model.base.BaseDocument;

@Data
@Document(collection = "adoption_source")
public class AdoptionSource extends BaseDocument {}
