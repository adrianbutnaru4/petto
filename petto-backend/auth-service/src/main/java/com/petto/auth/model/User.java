package com.petto.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(
    name = "auth_users",
    uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column @NotEmpty private String lastName;

  @Column @NotEmpty private String firstName;

  @Email
  @Column(nullable = false)
  private String email;

  @JsonIgnore private String password;
}
