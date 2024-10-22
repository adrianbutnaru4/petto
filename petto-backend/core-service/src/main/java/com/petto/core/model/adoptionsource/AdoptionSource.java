package com.petto.core.model.adoptionsource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.petto.core.model.base.BaseEntity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "adoption_sources")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdoptionSource extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private long id;
}
