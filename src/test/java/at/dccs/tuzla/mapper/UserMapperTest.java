/*
 * Copyright (c) 2022 DCCS GmbH. All rights reserved.
 * Implemented 2022 by DCCS GmbH.
 */

package at.dccs.tuzla.mapper;

import static org.junit.Assert.assertEquals;

import at.dccs.tuzla.entity.UserEntity;
import at.dccs.tuzla.projection.UserProjection;
import org.junit.Test;

/** Test class: {@link UserMapper}. */
public class UserMapperTest {
  @Test
  public void assertThatMapperIsSuccessful() {
    // given
    UserEntity entity = new UserEntity();
    entity.setFirstName("Test");
    entity.setLastName("Test");

    // when
    UserProjection projection = UserMapper.asProjection(entity);

    // then
    assertEquals("Test", projection.getFirstName());
    assertEquals("Test", projection.getLastName());
  }
}
