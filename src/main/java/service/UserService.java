/*
 * Copyright (c) 2019 DCCS GmbH. All rights reserved.
 * Implemented 2019 by DCCS GmbH.
 */

package service;

import java.util.List;
import javax.inject.Inject;
import mapper.UserMapper;
import projection.UserProjection;
import repository.UserRepository;

/**
 * UserService
 *
 * <p>Class for manipulating User resources on the server
 */
public class UserService {
  @Inject private UserRepository userRepository_;

  public List<UserProjection> getUsers() {
    return UserMapper.asProjections(userRepository_.getUsers());
  }
}
