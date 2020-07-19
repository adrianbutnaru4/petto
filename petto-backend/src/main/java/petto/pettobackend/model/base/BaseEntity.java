package petto.pettobackend.model.base;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id @GeneratedValue private long id;
}
