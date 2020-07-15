package petto.pettobackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public abstract class BaseDocument implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id private String id;
}
