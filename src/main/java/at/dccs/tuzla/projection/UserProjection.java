/*
 * Copyright (c) 2022 DCCS GmbH. All rights reserved.
 * Implemented 2022 by DCCS GmbH.
 */

package at.dccs.tuzla.projection;

/**
 * UserProjection
 *
 * <p>A Java object which represents User data sent from client
 */
public class UserProjection {
  private Integer id;
  private String firstName;
  private String lastName;
  private String departmentName;
  private String plantName;
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
