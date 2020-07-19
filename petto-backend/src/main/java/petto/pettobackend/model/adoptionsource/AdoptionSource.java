package petto.pettobackend.model.adoptionsource;

import lombok.Data;
import petto.pettobackend.model.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "adoption_sources")
@Data
public class AdoptionSource extends BaseEntity {}
