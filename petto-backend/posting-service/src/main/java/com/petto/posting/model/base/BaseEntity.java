package com.petto.posting.model.base;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;
}
