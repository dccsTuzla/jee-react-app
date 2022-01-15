/*
 * Copyright (c) 2022 DCCS GmbH. All rights reserved.
 * Implemented 2022 by DCCS GmbH.
 */

package at.dccs.tuzla.service;

import at.dccs.tuzla.mapper.UserMapper;
import at.dccs.tuzla.projection.UserProjection;
import at.dccs.tuzla.repository.UserRepository;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * UserService
 *
 * <p>Class for manipulating User resources on the server
 */
@Transactional
public class UserService {
  @Inject private UserRepository userRepository;

  public List<UserProjection> getUsers() {
    return UserMapper.asProjections(userRepository.getUsers());
  }
}
