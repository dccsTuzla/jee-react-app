/*
 * Copyright (c) 2022 DCCS GmbH. All rights reserved.
 * Implemented 2022 by DCCS GmbH.
 */

package at.dccs.tuzla.entity;

import javax.persistence.*;

/**
 * UserEntity
 *
 * <p>A JPA entity which describes how Users are stored in a database
 */
@Entity
@Table(name = "T_USER_USER")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "USER_ID")
  private Integer id;

  @Column(name = "USER_FIRST_NAME")
  private String firstName;

  @Column(name = "USER_LAST_NAME")
  private String lastName;

  @Column(name = "USER_DEPARTMENT")
  private String departmentName;

  @Column(name = "USER_PLANT")
  private String plantName;

  @Column(name = "USER_EMAIL")
  private String email;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getPlantName() {
    return plantName;
  }

  public void setPlantName(String plantName) {
    this.plantName = plantName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
