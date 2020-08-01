package com.petto.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private long id;

  private String email;

  private String password;

  private String firstName;

  private String lastName;

  private String address; // TODO: investigate appropriate map service to save address
}
