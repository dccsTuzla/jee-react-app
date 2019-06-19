/*
 * Copyright (c) 2019 DCCS GmbH. All rights reserved.
 * Implemented 2019 by DCCS GmbH.
 */

package projection;

/**
 * UserProjection
 *
 * <p>A Java object which represents User data sent from client
 */
public class UserProjection {
  private Integer id_;
  private String firstName_;
  private String lastName_;
  private String departmentName_;
  private String plantName_;
  private String email_;

  public Integer getId() {
    return id_;
  }

  public void setId(Integer id) {
    this.id_ = id;
  }

  public String getFirstName() {
    return firstName_;
  }

  public void setFirstName(String firstName) {
    this.firstName_ = firstName;
  }

  public String getLastName() {
    return lastName_;
  }

  public void setLastName(String lastName) {
    this.lastName_ = lastName;
  }

  public String getDepartmentName() {
    return departmentName_;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName_ = departmentName;
  }

  public String getPlantName() {
    return plantName_;
  }

  public void setPlantName(String plantName) {
    this.plantName_ = plantName;
  }

  public String getEmail() {
    return email_;
  }

  public void setEmail(String email) {
    this.email_ = email;
  }
}
