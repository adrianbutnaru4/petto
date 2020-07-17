package petto.pettobackend.model.base;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class BaseDocument implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id private String id;
}
