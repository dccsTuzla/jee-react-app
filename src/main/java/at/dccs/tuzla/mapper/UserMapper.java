/*
 * Copyright (c) 2022 DCCS GmbH. All rights reserved.
 * Implemented 2022 by DCCS GmbH.
 */

package at.dccs.tuzla.mapper;

import at.dccs.tuzla.entity.UserEntity;
import at.dccs.tuzla.projection.UserProjection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UserMapper
 *
 * <p>A convenience class to convert between UserEntity and UserProjection
 */
public class UserMapper {
  private UserMapper() {}

  /**
   * Converts a UserEntity to UserProjection
   *
   * @param entity
   * @return
   */
  public static UserProjection asProjection(UserEntity entity) {
    UserProjection projection = new UserProjection();

    projection.setId(entity.getId());
    projection.setFirstName(entity.getFirstName());
    projection.setLastName(entity.getLastName());
    projection.setDepartmentName(entity.getDepartmentName());
    projection.setPlantName(entity.getPlantName());
    projection.setEmail(entity.getEmail());

    return projection;
  }

  /**
   * Converts a list of UserEntity objects to list of UserProjection objects
   *
   * @param entities
   * @return
   */
  public static List<UserProjection> asProjections(List<UserEntity> entities) {
    return entities.stream().map(UserMapper::asProjection).collect(Collectors.toList());
  }
}
